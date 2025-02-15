package org.example;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    private static HashMap<Integer,Double> memo;
    public static void main(String[] args) {
        memo = new HashMap<>();
        memo.put(1,1.0);
        memo.put(2,1.0);
        System.out.println(Fibonacci(50));
    }
    public static Double Fibonacci(Integer x){
        Double i = memo.get(x);
        if(i==null){
            i = Fibonacci(x - 1) + Fibonacci(x - 2);
            memo.put(x, i);
        }
        return i;
    }

}