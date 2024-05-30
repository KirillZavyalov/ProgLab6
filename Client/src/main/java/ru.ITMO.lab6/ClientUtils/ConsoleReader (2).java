package ru.ITMO.lab6.Client.ClientUtils;

import ru.ITMO.lab6.Client.Exceptions.IncorrectArgumentException;
import ru.ITMO.lab6.Client.Network.NetworkInteraction;
import ru.ITMO.lab6.Common.HumanBeing;
import ru.ITMO.lab6.Common.Request;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;

public class ConsoleReader {

    static NetworkInteraction networkInteraction;

    public ConsoleReader(NetworkInteraction networkInteraction) {
        ConsoleReader.networkInteraction = networkInteraction;
    }

    static HashSet<File> scriptSet = new HashSet<>();

    public static void clearScriptSet() {
        scriptSet.clear();
    }


    public void startReading(InputStream input) {

        Scanner scanner = new Scanner(input);

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().trim();
            String[] commandBits = command.split(" ");

            if (!command.isEmpty()) {
                if (command.equals("exit")) {
                    System.exit(1);
                }

                HumanBeing humanBeing;
                String key;
                try {
                    if (command.contains("add") || command.contains("update") ||
                            command.contains("add_if_min") || command.contains("remove_lower")) {
                        humanBeing = HumanBuilder.createHuman(System.in);
                        Request request = new Request(command, humanBeing, commandBits[0]);
                        NetworkInteraction.sendRequest(request);
                    } else if (command.contains("execute_script")) {
                        if (commandBits.length == 2) {
                            startReadingScript(new File(commandBits[1]));
                        }
                    } else {
                        humanBeing = new HumanBeing();
                        Request request = new Request(command, humanBeing, commandBits[0]);
                        NetworkInteraction.sendRequest(request);
                    }
                } catch (IOException e) {

                    System.out.println("Сервер не отвечает");

                    while (true) {
                        try {
                            networkInteraction.initialize();
                            break;
                        } catch (IOException ioe) {
                            System.out.println("Повторная попытка через 5 секунд...");
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException ex) {
                            }
                        }
                    }


                }

            }
        }
    }

    public static void startReadingScript(File file) {
        System.out.println("---  Начало чтения скрипта " + file.getName() + "---");

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно прочитать файл");
            scriptSet.clear();
            return;
        }

        if (!scriptSet.add(file)) {
            System.out.println("Рекурсия при чтении скрипта. Выполнение скрипта остановлено");
            scriptSet.clear();
            return;
        }

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().trim();

            String[] commandBits = command.split(" ");

            HumanBeing humanBeing = new HumanBeing();
            String key = null;

            try {
                if (!commandBits[0].trim().equals("")) {
                    if (commandBits[0].equals("add")) {
                        humanBeing = HumanBuilder.createHumansc(scanner);
                        Request request = new Request(command, humanBeing, commandBits[0]);
                        NetworkInteraction.sendRequest(request);
                    } else if (commandBits[0].equals("update") && commandBits.length==2) {
                        if (Validator.isInt(commandBits[1])) {
                            humanBeing = HumanBuilder.createHumansc(scanner);
                            Request request = new Request(command, humanBeing, commandBits[0]);
                            NetworkInteraction.sendRequest(request);
                        } else {
                            throw new IncorrectArgumentException(command);
                        }
                    } else if (commandBits[0].equals("add_if_min")) {
                        humanBeing = HumanBuilder.createHumansc(scanner);
                        Request request = new Request(command, humanBeing, commandBits[0]);
                        NetworkInteraction.sendRequest(request);
                    } else if (commandBits[0].equals("remove_lower")) {
                        humanBeing = HumanBuilder.createHumansc(scanner);
                        Request request = new Request(command, humanBeing, commandBits[0]);
                    } else if (commandBits[0].equals("execute_script")) {
                        if (commandBits.length == 2) {
                            ConsoleReader.startReadingScript(new File(commandBits[1]));
                        }
                    } else {
                        humanBeing = new HumanBeing();
                        Request request = new Request(command, humanBeing, commandBits[0]);
                        NetworkInteraction.sendRequest(request);
                    }
                }

            } catch (IOException | IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("--- Конец чтения скрипта " + file.getName() + " ---");
        scriptSet.clear();
    }

}
