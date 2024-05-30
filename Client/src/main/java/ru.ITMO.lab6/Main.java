package ru.ITMO.lab6;


import ru.ITMO.lab6.ClientUtils.ConsoleReader;
import ru.ITMO.lab6.Network.NetworkInteraction;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String hostname = "localhost";
        if (args.length != 1) {
            System.out.println("Введи порт");
            System.exit(0);
        }

        String sport = args[0];

        System.out.println("Порт " + sport);
        int port = Integer.parseInt(sport);

        NetworkInteraction networkInteraction = new NetworkInteraction();

        while (true) {
            try {
                networkInteraction.initialize(hostname, port);
                break;
            } catch (IOException e) {
                System.out.println("Повторная попытка через 5 секунд...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                }
            }
        }

        System.out.println("Подключено");

        ConsoleReader consoleReader = new ConsoleReader(networkInteraction);
        consoleReader.startReading(System.in);


    }
}