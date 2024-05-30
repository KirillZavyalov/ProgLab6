package ru.ITMO.lab6.ClientUtils;


import ru.ITMO.lab6.Car;
import ru.ITMO.lab6.Coordinates;
import ru.ITMO.lab6.HumanBeing;
import ru.ITMO.lab6.Exceptions.*;
import ru.ITMO.lab6.Mood;


import java.io.InputStream;
import java.util.Scanner;

public class HumanBuilder {

    static Scanner scanner;

    /*public HumanBuilder(InputStream is){
        System.out.println(is);
        scanner = new Scanner(is);
    }*/

    static public HumanBeing createHuman(InputStream is) {
        scanner = new Scanner(is);

        String name, soundtrackName;
        Coordinates coordinates;
        float x;
        double y;
        boolean realHero;
        Boolean hasToothpick;
        Long impactSpeed;
        Long minutesOfWaiting;
        Mood mood;
        Car car;
        String carName;
        Boolean carCool;


        String input;

        //Получение имени
        while (true) {
            try {
                System.out.print("Введите имя человека: ");
                input = scanner.nextLine();
                Validator.argumentNotEmpty(input);
                name = input;
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Блок получения составляющих класса координат

        //Получение x
        while (true) {
            try {
                System.out.print("Введите x: ");
                input = scanner.nextLine();
                Validator.coordinateOnXValidator(input);
                x = Float.parseFloat(input);
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение y
        while (true) {
            try {
                System.out.print("Введите y: ");
                input = scanner.nextLine();
                Validator.coordinateOnYValidator(input);
                y = Double.parseDouble(input);
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Составляющие координат получены. Конец блока

        //Получение realHero
        while (true) {
            try {
                System.out.print("Этот человек настоящий герой? (Да/Нет): ");
                input = scanner.nextLine();
                Validator.realHeroValidator(input);
                if (input.equals("Да") || input.equals("да")){
                    realHero = true;
                } else {realHero = false;}
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение hasToothPick
        while (true) {
            try {
                System.out.print("У человека есть зубочистка? (Да/Нет): ");
                input = scanner.nextLine();
                Validator.toothPickValidator(input);
                if (input.equals("Да") || input.equals("да")){
                    hasToothpick = true;
                }
                if (input.equals("Нет") || input.equals("нет")){
                    hasToothpick = false;
                }
                else {hasToothpick = null;}
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение impactSpeed
        while (true) {
            try {
                System.out.print("Введите силу удара: ");
                input = scanner.nextLine();
                Validator.impactSpeedValidator(input);
                if (input == ""){
                    impactSpeed = null;
                } else {impactSpeed = Long.parseLong(input);}
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение саундтрека
        while (true) {
            try {
                System.out.print("Введите название саундтрека: ");
                input = scanner.nextLine();
                Validator.argumentNotEmpty(input);
                soundtrackName = input;
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение времени ожидания
        while (true) {
            try {
                System.out.print("Введите время ожидания: ");
                input = scanner.nextLine();
                Validator.minutesOfWaitingValidator(input);
                minutesOfWaiting = Long.parseLong(input);
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение mood
        while (true) {
            try {
                System.out.print("Введите настроение:\n\tSADNESS,\n" +
                        "    SORROW,\n" +
                        "    GLOOM,\n" +
                        "    CALM,\n" +
                        "    RAGE\n");
                input = scanner.nextLine();
                Validator.moodValidator(input);
                if(!input.equals("")) {
                    mood = Mood.valueOf(input);
                } else {mood = null;}
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Блок сбора значений Car

        //Получение названия машины
        while (true) {
            try {
                System.out.print("Введите марку машины: ");
                input = scanner.nextLine();
                Validator.argumentNotEmpty(input);
                carName = input;
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение крутости
        while (true) {
            try {
                System.out.print("Это крутая машина? (Да/Нет): ");
                input = scanner.nextLine();
                Validator.carCoolValidator(input);
                if (input.equals("Да") || input.equals("да")){
                    carCool = true;
                }
                if (input.equals("Нет") || input.equals("нет")){
                    carCool = false;
                }
                else {carCool = null;}
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        HumanBeing newHuman = new HumanBeing(name,
                new Coordinates(x,y),
                realHero,
                hasToothpick,
                impactSpeed,
                soundtrackName,
                minutesOfWaiting,
                mood, new
                Car(carName, carCool));

        return newHuman;
    }

    static public HumanBeing createHumansc(Scanner is) {

        Scanner scanner = is;

        String name, soundtrackName;
        Coordinates coordinates;
        float x;
        double y;
        boolean realHero;
        Boolean hasToothpick;
        Long impactSpeed;
        Long minutesOfWaiting;
        Mood mood;
        Car car;
        String carName;
        Boolean carCool;


        String input;

        //Получение имени
        while (true) {
            try {
                input = scanner.nextLine();
                Validator.argumentNotEmpty(input);
                name = input;
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Блок получения составляющих класса координат

        //Получение x
        while (true) {
            try {
                input = scanner.nextLine();                Validator.coordinateOnXValidator(input);
                x = Float.parseFloat(input);
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение y
        while (true) {
            try {
                input = scanner.nextLine();                Validator.coordinateOnYValidator(input);
                y = Double.parseDouble(input);
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Составляющие координат получены. Конец блока

        //Получение realHero
        while (true) {
            try {
                input = scanner.nextLine();                Validator.realHeroValidator(input);
                if (input.equals("Да") || input.equals("да")){
                    realHero = true;
                } else {realHero = false;}
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение hasToothPick
        while (true) {
            try {
                input = scanner.nextLine();                Validator.toothPickValidator(input);
                if (input.equals("Да") || input.equals("да")){
                    hasToothpick = true;
                }
                if (input.equals("Нет") || input.equals("нет")){
                    hasToothpick = false;
                }
                else {hasToothpick = null;}
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение impactSpeed
        while (true) {
            try {
                input = scanner.nextLine();                Validator.impactSpeedValidator(input);
                if (input == ""){
                    impactSpeed = null;
                } else {impactSpeed = Long.parseLong(input);}
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение саундтрека
        while (true) {
            try {
                input = scanner.nextLine();                Validator.argumentNotEmpty(input);
                soundtrackName = input;
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение времени ожидания
        while (true) {
            try {
                input = scanner.nextLine();                Validator.minutesOfWaitingValidator(input);
                minutesOfWaiting = Long.parseLong(input);
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение mood
        while (true) {
            try {

                input = scanner.nextLine();                Validator.moodValidator(input);
                if(!input.equals("")) {
                    mood = Mood.valueOf(input);
                } else {mood = null;}
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Блок сбора значений Car

        //Получение названия машины
        while (true) {
            try {
                input = scanner.nextLine();                Validator.argumentNotEmpty(input);
                carName = input;
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //Получение крутости
        while (true) {
            try {
                input = scanner.nextLine();                Validator.carCoolValidator(input);
                if (input.equals("Да") || input.equals("да")){
                    carCool = true;
                }
                if (input.equals("Нет") || input.equals("нет")){
                    carCool = false;
                }
                else {carCool = null;}
                break;
            } catch (IncorrectArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        HumanBeing newHuman = new HumanBeing(name,
                new Coordinates(x,y),
                realHero,
                hasToothpick,
                impactSpeed,
                soundtrackName,
                minutesOfWaiting,
                mood, new
                Car(carName, carCool));

        return newHuman;
    }
}
