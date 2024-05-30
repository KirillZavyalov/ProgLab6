package ru.ITMO.lab6;

import java.io.Serializable;

public class Car implements Serializable {
    private String name; //Поле не может быть null
    private Boolean cool; //Поле может быть null

    public Car(String name, Boolean cool) {
        this.name = name;
        this.cool = cool;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", cool=" + cool +
                '}';
    }

    public String getName() {
        return name;
    }

    public Boolean getCool() {
        return cool;
    }
}
