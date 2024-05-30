package ru.ITMO.lab6.ClientUtils;


import ru.ITMO.lab6.Request;

import java.io.File;

public class ExecuteScriptCommand implements Command {
    @Override
    public void execute(Request request) throws Exception {
        String[] tokens = request.getMessage().split(" ");
        System.out.println("--- Начало чтения скрипта ---");
        ConsoleReader.startReadingScript(new File(tokens[1]));
        System.out.println("--- Конец чтения скрипта ---");
        ConsoleReader.clearScriptSet();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n";
    }
}
