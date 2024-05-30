package ru.ITMO.lab6;

import java.io.Serializable;

public class Request implements Serializable {

    static final Long serialVersionUID = 12345L;


    private String message;
    private HumanBeing humanBeing;
    private String key;

    public Request(String message, HumanBeing humanBeing, String key) {
        this.message = message;
        this.humanBeing = humanBeing;
        this.key = key;
    }

    public Request() {
    }

    public String getMessage() {
        return message;
    }

    public HumanBeing getHumanBeing() {
        return humanBeing;
    }

    public String getKey() {
        return key;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHumanBeing(HumanBeing humanBeing) {
        this.humanBeing = humanBeing;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
