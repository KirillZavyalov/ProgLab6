package ru.ITMO.lab6.ClientUtils;

import ru.ITMO.lab6.Exceptions.IncorrectArgumentException;
import ru.ITMO.lab6.Mood;


public class Validator {

    public static void idValidator(String arg) throws IncorrectArgumentException {
        int id;
        try{id = Integer.parseInt(arg);} catch (Exception e) {throw new IncorrectArgumentException(arg);}
    }

    public static boolean isInt(String arg){
        int id;
        try{id = Integer.parseInt(arg);} catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void coordinateOnXValidator(String arg) throws IncorrectArgumentException {
        float x;
        try{
            x = Float.parseFloat(arg);
            if (x > -477){
                throw new IncorrectArgumentException(arg);
            }
        } catch (Exception e) {throw new IncorrectArgumentException(arg);}
    }

    public static void coordinateOnYValidator(String arg) throws IncorrectArgumentException {
        double id;
        try{id = Double.parseDouble(arg);} catch (Exception e) {throw new IncorrectArgumentException(arg);}
    }

    public static void realHeroValidator(String arg) throws IncorrectArgumentException {
        if ( !(arg.equals("Да") || arg.equals("да") || arg.equals("Нет") || arg.equals("нет")) ){
            throw new IncorrectArgumentException(arg);
        }
    }

    public static void toothPickValidator(String arg) throws IncorrectArgumentException {
        if ( !(arg.equals("Да") || arg.equals("да") || arg.equals("Нет") || arg.equals("нет") || arg.equals("")) ){
            throw new IncorrectArgumentException(arg);
        }
    }

    public static void impactSpeedValidator(String arg) throws IncorrectArgumentException {
        Long id;
        if (!arg.equals("")){
            try{id = Long.parseLong(arg);} catch (Exception e) {throw new IncorrectArgumentException(arg);}
        }
    }

    public static void minutesOfWaitingValidator(String arg) throws IncorrectArgumentException {
        Long id;
        try{id = Long.parseLong(arg);} catch (Exception e) {throw new IncorrectArgumentException(arg);}
    }

    public static void moodValidator(String arg) throws IncorrectArgumentException {
        if (!arg.equals("")) {
            try {
                Mood.valueOf(arg);
            } catch (Exception e) {
                throw new IncorrectArgumentException(arg);
            }
        }
    }

    public static void carCoolValidator(String arg) throws IncorrectArgumentException {
        if (!arg.equals("")) {
            if (!(arg.equals("Да") || arg.equals("да") || arg.equals("Нет") || arg.equals("нет"))) {
                throw new IncorrectArgumentException(arg);
            }
        }
    }

    public static void argumentNotEmpty(String arg) throws IncorrectArgumentException {
        if (arg.isEmpty() || arg.trim().isEmpty()) {
            throw new IncorrectArgumentException(arg);
        }
    }
}
