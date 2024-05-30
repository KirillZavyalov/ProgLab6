package ru.ITMO.lab6.Client.Exceptions;

public class ExitException extends Exception{
    public ExitException(String argument){
        super("Произведен выход из файла. Данные не сохранены");
    }
}
