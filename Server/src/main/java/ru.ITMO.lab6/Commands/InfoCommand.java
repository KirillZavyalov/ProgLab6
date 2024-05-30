package ru.ITMO.lab6.Commands;

import ru.ITMO.lab6.Collection.CollectionManager;
import ru.ITMO.lab6.Request;

public class InfoCommand implements Command {

    @Override
    public String execute(Request request) throws Exception {
        return (CollectionManager.getInfo());
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n";
    }
}
