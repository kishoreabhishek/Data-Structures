package org.example;

import java.util.HashMap;

public class Main {
    public static HashMap<String,HashMap<Integer,Integer>> pfTable;
    public static void main(String[] args) {
        pfTable = new HashMap<>();
        pfTable.put("J",new HashMap<>());
        pfTable.put("P",new HashMap<>());
        HashMap<Integer,Integer> j = pfTable.get("J");
        pfTable.put("D",new HashMap<>());
        j.put(1,12);
        j.put(2,27);
        j.put(3,33);
        j.put(4,36);
        j.put(5,38);
        j.put(0,0);
        HashMap<Integer,Integer> p = pfTable.get("P");
        p.put(1,16);
        p.put(2,18);
        p.put(3,20);
        p.put(4,22);
        p.put(5,24);
        p.put(0,0);
        HashMap<Integer,Integer> d = pfTable.get("D");
        d.put(1,8);
        d.put(2,16);
        d.put(3,24);
        d.put(4,32);
        d.put(5,40);
        d.put(0,0);
        int r = maxProfit(5,"");
        System.out.println(r);
    }

    public static Integer maxProfit(Integer target,String fruitsused){
        int tmaxprofit =0;
        int tprofit=0;
        if(fruitsused.length()==2){
            System.out.println("fruitsused" + " " + fruitsused);
            for(String s:new String[]{"J","P","D"}){
                if(!fruitsused.contains(s)){
                    return pfTable.get(s).get(target);
                }
            }

        }
        for(int i=1;i<=target;i++){
            for(String s:new String[]{"J","P","D"}){
                if(!fruitsused.contains(s)){
                    if(i==5) {
                        tprofit = pfTable.get(s).get(i);
                    }
                    else {
                        int ttarget = target - i;
                        if (ttarget >= 0) {
                            tprofit= maxProfit(ttarget, fruitsused + s);
                            tprofit = tprofit + pfTable.get(s).get(i);

                        }
                    }
                    if (tprofit > tmaxprofit) {
                        tmaxprofit = tprofit;
                    }
                }
            }

        }
        return tmaxprofit;
    }
}