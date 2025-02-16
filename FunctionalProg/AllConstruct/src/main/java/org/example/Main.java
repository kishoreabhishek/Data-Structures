package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {

    static HashMap<String,List<List<String>>> memo = new HashMap<>();
    public static void main(String[] args) {

        System.out.println(allConstruct("abcdef",new String[]{"ab","abc","cd","def","abcd","ef","c"}));
        System.out.println(allConstruct("purple",
                new String[]{"purp","p","ur","le","purpl"}));
        System.out.println(allConstruct("skateboard",
                new String[]{"bo","rd","ate","t","ska","sk","boar"}));
        System.out.println(allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaz",
                new String[]{"a","aa","aaa","aaaa","aaaaa"}));
    }
    static List<List<String>> allConstruct(String target, String[] words){
        if(memo.containsKey(target)) {
//            return new ArrayList<>(memo.get(target));
            return memo.get(target);
        };
        if(target.isEmpty()) {
            List<String> s = new ArrayList<>();
            List<List<String>> l = new ArrayList<>();
            s.add("");
            l.add(s);
            return l;
        }
        List<List<String>> res = new ArrayList<>();
        List<String> wl =Arrays.stream(words).filter(target::startsWith).toList();
        if(wl.isEmpty()){
            List<List<String>> l = new ArrayList<>();
            l.add(null);
//            memo.put(target,new ArrayList<>(l));
            memo.put(target,l);
            return l;
        }

        for(String w:wl){
            String ttar = target.substring(w.length());
            List<List<String>> tres = allConstruct(ttar,words);
            for(List<String> ls:tres){
                if(ls!=null){
                    List<String> ltemp = new ArrayList<>(ls);
                    ltemp.add(w);
                    res.add(ltemp);
                }
            }
        }
        if(res.isEmpty()){
            res.add(null);
        }
        memo.put(target,res);
        return res;
    }
}