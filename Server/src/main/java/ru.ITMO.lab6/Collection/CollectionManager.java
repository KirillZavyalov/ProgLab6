package ru.ITMO.lab6.Collection;


import ru.ITMO.lab6.HumanBeing;
import ru.ITMO.lab6.Request;
import ru.ITMO.lab6.ServerUtils.IdManager;
import ru.ITMO.lab6.ServerUtils.WaitTimeComparator;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CollectionManager {

    private static LinkedHashSet<HumanBeing> hashSet = new LinkedHashSet<>();
    private static LocalDate creationDate = LocalDate.now();



    public CollectionManager(){
        hashSet = new LinkedHashSet<>();
        creationDate = LocalDate.now();
    }



    /*
    public static void add(HumanBeing humanBeing){
        humanBeing.setId(IdManager.getNewId());
        hashSet.add(humanBeing);
    }
     */

    public static ArrayList<HumanBeing> printAscending(){
        //WaitTimeComparator waitTimeComparator = new WaitTimeComparator();
        ArrayList<HumanBeing> array = new ArrayList<>(hashSet);
        array = (ArrayList<HumanBeing>) array.stream()
                .sorted()
                .collect(Collectors.toList());
        //Collections.sort(array, waitTimeComparator);
        //LinkedHashSet<HumanBeing> result = new LinkedHashSet<>(array);
        return array;
    }

    public static void add(InputStream is){
//        hb.setId(IdManager.getNewId());
//        hashSet.add(hb);
    }

    public static void add(HumanBeing hb){
        hb.setId(IdManager.getNewId());
        hashSet.add(hb);
    }

    public static boolean addIfMin(Request request){
       HumanBeing hb = request.getHumanBeing();
        WaitTimeComparator wTC = new WaitTimeComparator();

        for (HumanBeing o: hashSet){
            if (wTC.compare(hb, o) >= 0){
                return false;
            }
        }

        hb.setId(IdManager.getNewId());
        hashSet.add(hb);
           return true;
    }

    public static void add(InputStream is, int id){
//        hb.setId(id);
//        hashSet.add(hb);
    }

    public static void addElement(HumanBeing hb){
        System.out.println(hb);
        hashSet.add(hb);
    }

    public static void clear(){
        hashSet.clear();
    }

    public static void addsc(Scanner sc){
//        HumanBeing hb = new HumanBuilder().createHumansc(sc);
//        hb.setId(IdManager.getNewId());
//        hashSet.add(hb);
    }

    public static void removeLover(HumanBeing humanBeing){

        WaitTimeComparator comparator = new WaitTimeComparator();
        List<HumanBeing> resultList = hashSet.stream()
                .filter(element -> comparator.compare(element, humanBeing) < 0)
                .collect(Collectors.toList());

        resultList.forEach(System.out::println);


    }

    public static void removeLoversc(Scanner sc){
//        WaitTimeComparator wTC = new WaitTimeComparator();
//        HumanBeing hb = new HumanBuilder().createHumansc(sc);
//        ArrayList<HumanBeing> arr = new ArrayList<>();
//        for (HumanBeing o: hashSet){
//            if (wTC.compare(hb, o) > 0){
//                arr.add(o);
//            }
//        }
//        for (HumanBeing h: arr){
//            CollectionManager.remove(h);
//        }
    }

    public static boolean addIfMinsc(Scanner sc){
//        WaitTimeComparator wTC = new WaitTimeComparator();
//        HumanBeing hb = new HumanBuilder().createHumansc(sc);
//        for (HumanBeing o: hashSet){
//            if (wTC.compare(hb, o) >= 0){
//                return false;
//            }
//        }
//
//        hb.setId(IdManager.getNewId());
//        hashSet.add(hb);
        return true;

    }

    public static void addsc(Scanner sc, int id){
//        HumanBeing hb = new HumanBuilder().createHumansc(sc);
//        hb.setId(id);
//        hashSet.add(hb);
    }

    public static String getInfo(){
        return ("Тип коллекции: " + hashSet.getClass() + "\n" +
                "Дата создания: " + creationDate + "\n" +
                "Количество элементов: " + hashSet.size());
    }

    public static void remove(HumanBeing humanBeing){
        IdManager.removeId(humanBeing.getId());
        hashSet.remove(humanBeing);
    }

    public static HumanBeing getHumanById(int id){
       for (HumanBeing hb: hashSet){
           if (hb.getId() == id){
               return hb;
           }
       }
       return null;
    }

    public static List getHumansBySoundtrack(String name){
        ArrayList<HumanBeing> humanList = new ArrayList<>();
        for (HumanBeing hb: hashSet){
            if (hb.getSoundtrackName().equals(name)){
                humanList.add(hb);
            }
        }

        List<HumanBeing> result = hashSet.stream()
                .filter(hb -> hb.getSoundtrackName().equals(name))
                .collect(Collectors.toList());
        return result;
    }

    public static String show(){
        return (hashSet.toString());
    }

    public static LinkedHashSet<HumanBeing> getHashSet() {
        return hashSet;
    }

    public static void setHashSet(LinkedHashSet<HumanBeing> hashSet) {
        CollectionManager.hashSet = hashSet;
    }
}
