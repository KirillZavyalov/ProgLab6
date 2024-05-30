package ru.ITMO.lab6.Commands;

import ru.ITMO.lab6.Collection.CollectionManager;
import ru.ITMO.lab6.Request;
import ru.ITMO.lab6.ServerUtils.IdManager;

public class ClearCommand implements Command {

    @Override
    public String execute(Request request) throws Exception {
        CollectionManager.clear();
        IdManager.getIdSet().clear();
        return "Коллекция очищена";
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "clear : очистить коллекцию\n";
    }
}