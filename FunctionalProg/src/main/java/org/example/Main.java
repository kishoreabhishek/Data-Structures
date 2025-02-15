package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {

        BiFunction<Integer,Integer,Integer> mysum = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        };
        BiFunction<Integer,Integer,Integer> mysum2 = (x,y)-> x+y;
        List<Integer> li = List.of(1,2,3,45);
        System.out.println(li.stream().reduce(0,mysum2::apply));
        raiseAnyPower(li,x->x*x*x);
//        Comparator.comparing()

    }
    static void raiseAnyPower(List<Integer> numbs,Function<Integer,Integer> fn){
       numbs.stream().map(fn).forEach(System.out::println);
    }
}
