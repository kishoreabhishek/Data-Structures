package org.example;

import java.math.BigDecimal;
import java.util.HashMap;

public class Main {
    static HashMap<String,Double> memo;
    public static void main(String[] args) {
        memo = new HashMap<>();
        memo.put("1,1",1.0);
        memo.put("1,0",0.0);
        memo.put("0,1",0.0);
        System.out.println(BigDecimal.valueOf(GridTraveller(18,18)).toPlainString());
    }
    public static Double GridTraveller(Integer r, Integer c){
        Double re = memo.get(r+","+c);
        if (re == null){
            if(r==0 || c==0) {
                re = 0.0;
            }
            else {
                re = GridTraveller(r-1,c)+GridTraveller(r,c-1);
            }
            memo.put(r+","+c,re);
            memo.put(c+","+r,re);
        }
        return re;
    }
}