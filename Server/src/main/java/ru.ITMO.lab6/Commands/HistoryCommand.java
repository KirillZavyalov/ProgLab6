package ru.ITMO.lab6.Commands;

import ru.ITMO.lab6.Request;
import ru.ITMO.lab6.ServerUtils.CommandManager;

public class HistoryCommand implements Command {

    @Override
    public String execute(Request request) throws Exception {
        return (CommandManager.getAdq().toString());
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "history : вывести последние 13 команд (без их аргументов)\n";
    }
}
