package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    static HashMap<String,Boolean> memo = new HashMap<>();
    public static void main(String[] args) {

        System.out.println(canConstruct("enterapotentpot",
                new String[]{"a","p","ent","enter","ot","o","t"}));
    }

    static Boolean canConstruct(String target,String[] words){
        Boolean ccons = false;
        if(memo.containsKey(target)) return memo.get(target);
        if(target.isEmpty()) return true;
        List<String> res=Arrays.stream(words)
                .filter(target::startsWith)
                .toList();
        for(String s:res){
            String ntarget = target.substring(s.length());
            ccons = canConstruct(ntarget,words);
            memo.put(ntarget,ccons);
            if (ccons) return ccons;
        }
        memo.put(target,false);
        return ccons;
    }
}