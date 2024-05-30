package ru.ITMO.lab6.Client.ClientUtils;

import ru.ITMO.lab6.Common.Request;

public interface Command {

    String name = "Command";
    String decription = "Desc";

    public void execute(Request request) throws Exception;

    public String getName();

    public String getDescription();

}
