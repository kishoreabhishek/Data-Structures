package org.example;

import java.util.*;

public class Main {
    public static HashMap<Integer,HashMap<String,Integer>> livessaved = new HashMap<>();
    public static void main(String[] args) {
        livessaved.put(0,new HashMap<>());
        livessaved.get(0).put("c1",0);
        livessaved.get(0).put("c2",0);
        livessaved.get(0).put("c3",0);
        livessaved.put(1,new HashMap<>());
        livessaved.get(1).put("c1",45);
        livessaved.get(1).put("c2",20);
        livessaved.get(1).put("c3",50);
        livessaved.put(2,new HashMap<>());
        livessaved.get(2).put("c1",70);
        livessaved.get(2).put("c2",45);
        livessaved.get(2).put("c3",70);
        livessaved.put(3,new HashMap<>());
        livessaved.get(3).put("c1",90);
        livessaved.get(3).put("c2",75);
        livessaved.get(3).put("c3",80);
        livessaved.put(4,new HashMap<>());
        livessaved.get(4).put("c1",105);
        livessaved.get(4).put("c2",110);
        livessaved.get(4).put("c3",100);
        livessaved.put(5,new HashMap<>());
        livessaved.get(5).put("c1",120);
        livessaved.get(5).put("c2",150);
        livessaved.get(5).put("c3",130);
        String mlivessaved = maxHealthCare(Arrays.asList("c1","c2","c3"),5);
        System.out.println(mlivessaved);
    }

    public static String maxHealthCare(List<String> countries,int target){
        String tres;
        int tmaxlife=0;
        int tlife=0;
        String edge="";
        if(countries.size() == 1){
           return livessaved.get(target).get(countries.get(0)) + "," + target + "-"+ countries.get(0) + "|";
        }
        for(int i=0;i<=target;i++){
            for(String c:countries){
                List<String> tcountries = new ArrayList<>(countries);
                tcountries.remove(c);
                tres = maxHealthCare(tcountries,target-i);
                tlife = Integer.parseInt(tres.split(",")[0])+ livessaved.get(i).get(c);
                if(tlife>tmaxlife){
                    tmaxlife = tlife;
                    edge = tres.split(",")[1]+i+"-" + c + "|";
                }
            }
        }
        return tmaxlife+","+edge;
    }
}