package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static HashMap<Integer, List<Integer>> memo;
    public static void main(String[] args) {
        memo = new HashMap<>();
        System.out.println(howSum(8,new Integer[]{3,5,2},0));
    }

    public static List<Integer> howSum(Integer target, Integer[] inarray,Integer edge){
        List<Integer> res ;
        if(memo.containsKey(target) )
            return memo.get(target);
        Integer[] iarr =  Arrays.stream(inarray)
                .filter(x->target>=x)
                .toArray(Integer[]::new);

        if(iarr.length==0) {
            memo.put(target,null);
            return null;
        }
        Optional<Integer> ans =  Arrays.stream(iarr).filter(x->target-x==0).findFirst();
        if (ans.isPresent()) {
            res = new ArrayList<>();
            res.add(ans.get());
            if(edge>0)
                res.add(edge);
            memo.put(target,res);
            return res;
        }
        for(Integer i: iarr){
            res = howSum(target-i,inarray,i);
            memo.put(target-i,res);
            if (res!=null) {
                if (edge!=0)
                    res.add(edge);
                return res;
            }

        }
        memo.put(target,null);
        return null;
    }

}