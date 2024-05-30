package ru.ITMO.lab6.Commands;

import ru.ITMO.lab6.Request;
public class ExitCommand implements Command {

    @Override
    public String execute(Request request) throws Exception {
        System.out.println("Выход из программы без сохранения в файл");
        System.exit(0);
        return "";
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "exit : завершить программу (без сохранения в файл)\n";
    }
}
