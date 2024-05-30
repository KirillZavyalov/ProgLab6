package ru.ITMO.lab6.Commands;

import ru.ITMO.lab6.Collection.CollectionManager;
import ru.ITMO.lab6.Exceptions.IncorrectArgumentException;
import ru.ITMO.lab6.Request;
import ru.ITMO.lab6.ServerUtils.IdManager;
import ru.ITMO.lab6.ServerUtils.Validator;

public class RemoveByIdCommand implements Command {
    @Override
    public String execute(Request request) throws Exception {
        String[] args = request.getMessage().split(" ");
        String id;
        int intId = -1;
        if (args.length == 2) {
            id = args[1];
            try {
                Validator.idValidator(id);
                intId = Integer.parseInt(id);
            } catch (IncorrectArgumentException e) {
                return (e.getMessage());
            }
            if (IdManager.containsId(intId)){
                System.out.println(IdManager.getIdSet());
                System.out.println(intId + "found");
                CollectionManager.remove(CollectionManager.getHumanById(intId));
            } else{
                return "Элемент с таким id отсутствует";
            }
        } else {
            return "Неверное количество аргументов";
        }
        return "Операция успешно выполнена";

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "remove_by_id id : удалить элемент из коллекции по его id\n";
    }
}
