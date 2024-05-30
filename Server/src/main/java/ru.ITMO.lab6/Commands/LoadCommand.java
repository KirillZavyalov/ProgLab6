package ru.ITMO.lab6.Commands;

import ru.ITMO.lab6.Request;
import ru.ITMO.lab6.ServerUtils.ToPOJO;

import java.io.IOException;

public class LoadCommand implements Command {

    @Override
    public String execute(Request request) throws Exception {
        try {
            ToPOJO.readJSON();
            return ("Save file loaded");
        } catch (IOException e){
            return "Ошибка при загрузке файла";
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "load : загрузить коллекцию из файла\n";
    }
}
