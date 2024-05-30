package ru.ITMO.lab6.Exceptions;

public class IncorrectArgumentException extends Exception{

    public IncorrectArgumentException(String argument){
        super("Некорректный ввод аргумента: " + "{"+argument+"}");
    }

}
