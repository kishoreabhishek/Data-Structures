package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {
    static HashMap<Integer,Boolean> memo;
    public static void main(String[] args) {
        memo = new HashMap<>();
        System.out.println(canSum(300,new Integer[]{7,14}));
    }

    public static boolean canSum(Integer target, Integer[] inarray){
        boolean res;
        if(memo.containsKey(target) )
            return memo.get(target);
        Integer[] iarr =  Arrays.stream(inarray)
                .filter(x->target>=x)
                .map(x->target-x)
                .toArray(Integer[]::new);

        if(iarr.length==0) {
            memo.put(target,false);
            return false;
        }
        res = Arrays.stream(iarr).anyMatch(x->x==0);
        if (res) {
            memo.put(target,res);
            return res;
        }
        for(Integer i: iarr){
            res = canSum(i,inarray);
            memo.put(i,res);
            if(res) return true;
        }
        return res;
    }

}