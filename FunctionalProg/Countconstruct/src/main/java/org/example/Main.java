package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static HashMap<String,Integer> memo = new HashMap<>();
    public static void main(String[] args) {

        System.out.println(countConstruct("purple",new String[]{"purp","p","ur","le","purpl"}));
        System.out.println(countConstruct("enterapotentpot",
                new String[]{"a","p","ent","enter","ot","o","t"}));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e","ee","eee","eeee","eeeee","eeeeee"}));
    }
    static Integer countConstruct(String target,String[] words){
        if (target.isEmpty()) return 1;
        if(memo.containsKey(target)) return memo.get(target);
        AtomicInteger cnt= new AtomicInteger();
        List<String> res= Arrays.stream(words).filter(target::startsWith).toList();
        res.forEach(r->{
            String ntar = target.substring(r.length());
            cnt.set(cnt.get() + countConstruct(ntar, words));

        });
        memo.put(target,cnt.get());
        return cnt.get();
    }
}

