package ru.ITMO.lab6.Commands;

import ru.ITMO.lab6.Collection.CollectionManager;
import ru.ITMO.lab6.Request;

public class ShowCommand implements Command {
    @Override
    public String execute(Request request) throws Exception {
        return CollectionManager.show();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n";
    }
}