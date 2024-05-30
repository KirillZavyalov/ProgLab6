package ru.ITMO.lab6.Commands;


import ru.ITMO.lab6.Collection.CollectionManager;
import ru.ITMO.lab6.Request;

public class AddCommand implements Command {

    @Override
    public String execute(Request request) throws Exception {
        CollectionManager.add(request.getHumanBeing());
        return  "Объект успешно добавлен в коллекцию";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "add {element} : добавить новый элемент в коллекцию\n";
    }
}
