package ru.ITMO.lab6.ClientUtils;

import ru.ITMO.lab6.Request;

public interface Command {

    String name = "Command";
    String decription = "Desc";

    public void execute(Request request) throws Exception;

    public String getName();

    public String getDescription();

}
