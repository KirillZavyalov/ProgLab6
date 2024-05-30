package ru.ITMO.lab6.Commands;


import ru.ITMO.lab6.Request;
import ru.ITMO.lab6.ServerUtils.CommandManager;

import java.util.stream.Collectors;

public class HelpCommand implements Command {

    @Override
    public String execute(Request request) throws Exception {
        String result = CommandManager.getCommandList().values().stream()
                .map(Command::getDescription)
                .collect(Collectors.joining(""));
        return result;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "help : вывести справку по доступным командам\n";
    }
}
