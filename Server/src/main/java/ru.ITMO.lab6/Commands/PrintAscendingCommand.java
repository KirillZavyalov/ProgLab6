package ru.ITMO.lab6.Commands;

import ru.ITMO.lab6.Collection.CollectionManager;
import ru.ITMO.lab6.Request;

public class PrintAscendingCommand implements Command {

    @Override
    public String execute(Request request) throws Exception {
        return CollectionManager.printAscending().toString();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "print_ascending : вывести элементы коллекции в порядке возрастания\n";
    }
}
