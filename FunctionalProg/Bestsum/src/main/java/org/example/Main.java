package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static HashMap<Integer, List<Integer>> memo;
    public static void main(String[] args) {
        memo = new HashMap<>();
        System.out.println(howSum(100,new Integer[]{1,2,5}));
    }

    public static List<Integer> howSum(Integer target, Integer[] inarray){
        List<Integer> res ;
        List<Integer> tempres = new ArrayList<>();
        int temp = Integer.MAX_VALUE;
        if(memo.containsKey(target) ) {
            List<Integer> t = memo.get(target);
            if(t!=null)
                return new ArrayList<>(t);
            else
                return null;
        }
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
            List<Integer> tres = new ArrayList<>();
            tres.addAll(res);
            memo.put(target,tres);
            return res;
        }
        for(Integer i: iarr){
            Integer k = target-i;
            res = howSum(k,inarray);
            if (res!=null) {
                if(target-k>0) res.add(target-k);
                if(res.size()<temp){
                    tempres.clear();
                    tempres.addAll(res);
                    temp = res.size();
                }

            }

        }
        if(tempres != null && tempres.size()>0){
            List<Integer> c = new ArrayList<>();
            c.addAll(tempres);
            memo.put(target,c);
            return tempres;
        }
        memo.put(target,null);
        return null;
    }

}