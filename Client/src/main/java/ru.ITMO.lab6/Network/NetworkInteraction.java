package ru.ITMO.lab6.Network;


import ru.ITMO.lab6.Request;

import java.io.*;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class NetworkInteraction {

    String host;
    int port;

    private static SocketChannel socket;

    public NetworkInteraction() {
    }

    public void initialize(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        try {
            InetSocketAddress address = new InetSocketAddress(host, port);
            socket = SocketChannel.open();
            socket.connect(address);
            socket.configureBlocking(false);
        } catch (RuntimeException | ConnectException e) {
            System.out.println(host + " " + port + " - не удалось подключиться");
            throw new IOException();
        }
    }

    public void close(){
        try {
            socket.close();
        } catch (IOException e) { }
    }

    public void initialize() throws IOException {
        try {
            InetSocketAddress address = new InetSocketAddress(host, port);
            socket = SocketChannel.open();
            socket.connect(address);
            socket.configureBlocking(false);
            System.out.println("Подключено");
        } catch (RuntimeException | ConnectException e) {
            System.out.println(host + " " + port + " - не удалось подключиться");
            throw new IOException();
        }
    }

//    public void sendRequest(Request request) throws IOException {
//        OutputStream outputStream = socket.getOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        objectOutputStream.writeObject(request);
//
//        objectOutputStream.flush();
//    }

    public static void sendRequest(Request request) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(request);
        objectOutputStream.close();
        ByteBuffer buffer = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());

        while (buffer.hasRemaining()) {
            socket.write(buffer);
        }

        try {
            Request request_server = getAnswer();
            System.out.println("Ответ: \n" + request_server.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка при чтении ответа");
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Request getAnswer() throws IOException, InterruptedException, ClassNotFoundException {

        Thread.sleep(500);
        ArrayList<ByteBuffer> bufferList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ByteBuffer buffer = ByteBuffer.allocate(8192);
            socket.read(buffer);
            if (buffer.limit() == buffer.position() || bufferList.isEmpty()) {
                bufferList.add(buffer);
            } else {
                break;
            }
        }

        ByteBuffer bigBuffer = ByteBuffer.allocate(bufferList.size() * 8192);
        for (ByteBuffer byteBuffer : bufferList) {
            bigBuffer.put(byteBuffer.array());
        }

        ByteArrayInputStream bi = new ByteArrayInputStream(bigBuffer.array());
        ObjectInputStream oi = new ObjectInputStream(bi);

        return (Request) oi.readObject();
    }


}
