package ru.ITMO.lab6.Commands;

import ru.ITMO.lab6.Collection.CollectionManager;
import ru.ITMO.lab6.HumanBeing;
import ru.ITMO.lab6.Request;

import java.util.ArrayList;

public class ContainsSoundtrackCommand implements Command {

    @Override
    public String execute(Request request) throws Exception {
        String[] args = request.getMessage().split(" ");
        String name = args[1];
        ArrayList<HumanBeing> list = (ArrayList<HumanBeing>) CollectionManager.getHumansBySoundtrack(name);
        if (list.isEmpty()){
            return ("Элементы с таким саундтреком не найдены");
        }
        else {
            return list.toString();
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "filter_contains_soundtrack_name soundtrackName : вывести элементы, значение поля soundtrackName которых содержит заданную подстроку\n";
    }
}
