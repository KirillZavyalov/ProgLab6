package ru.ITMO.lab6.Commands;

import ru.ITMO.lab6.Collection.CollectionManager;
import ru.ITMO.lab6.Request;

public class RemoveLowerCommand implements Command {
    @Override
    public String execute(Request request) throws Exception {
        CollectionManager.removeLover(request.getHumanBeing());
        return "Операция выполнена";
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n";
    }
}
