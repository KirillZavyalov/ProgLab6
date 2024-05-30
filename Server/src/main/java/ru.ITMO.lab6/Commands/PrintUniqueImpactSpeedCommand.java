package ru.ITMO.lab6.Commands;

import ru.ITMO.lab6.Collection.CollectionManager;
import ru.ITMO.lab6.HumanBeing;
import ru.ITMO.lab6.Request;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class PrintUniqueImpactSpeedCommand implements Command {
    @Override
    public String execute(Request request) throws Exception {
        LinkedHashSet<HumanBeing> hs = CollectionManager.getHashSet();
        HashSet<Long> nhs = new HashSet();

        for (HumanBeing hb: hs) {
            nhs.add(hb.getImpactSpeed());
        }

        return ("Уникальные значения поля impactSpeed всех элементов в коллекции: "+ nhs);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "print_unique_impact_speed : вывести уникальные значения поля impactSpeed всех элементов в коллекции\n";
    }
}
