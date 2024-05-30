package ru.ITMO.lab6.Commands;

import ru.ITMO.lab6.Collection.CollectionManager;
import ru.ITMO.lab6.Request;

public class AddIfMinCommand implements Command {
    @Override
    public String execute(Request request) throws Exception {
        if (CollectionManager.addIfMin(request)){
            return ("Объект добавлен в коллекцию.");
        } else {
            return ("Объект не является наименьшим в коллекции. Объект не добавлен.");
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n";
    }
}
