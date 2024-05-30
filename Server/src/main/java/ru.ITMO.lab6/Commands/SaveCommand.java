package ru.ITMO.lab6.Commands;

import ru.ITMO.lab6.Request;
import ru.ITMO.lab6.ServerUtils.JSONConverter;

public class SaveCommand implements Command {
    @Override
    public String execute(Request request) throws Exception {
        JSONConverter.doStuff();
        return ("Коллекция сохранена");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "save : сохранить коллекцию в файл\n";
    }
}
