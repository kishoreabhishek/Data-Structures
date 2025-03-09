package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    static List<Stack<Integer>> axes;
    public static void main(String[] args) {
        axes = new ArrayList<>();
        axes.add(new Stack<>());
        axes.add(new Stack<>());
        axes.add(new Stack<>());
        int noOfDiscs = 15;
        for(int i=noOfDiscs;i>=1;i--){
            axes.get(0).push(i);
        }
        createHanoi(0,2,noOfDiscs);
        System.out.println(axes.get(2));

    }
    public static void createHanoi(int startindex,int targetindex,int noOfDiscs){
        if(noOfDiscs == 1) {
            int td = axes.get(startindex).pop();
            if(!axes.get(targetindex).isEmpty() && axes.get(targetindex).peek()<td){
                throw new RuntimeException();
            }
            axes.get(targetindex).push(td);
        }
        else{
            int ttarget = Arrays.stream(new int[]{0,1,2}).filter(x->x!=startindex && x!= targetindex).findFirst().getAsInt();
            createHanoi(startindex,ttarget,noOfDiscs-1);
            int d = axes.get(startindex).pop();
            if(!axes.get(targetindex).isEmpty() && axes.get(targetindex).peek()< d){
                throw new RuntimeException();
            }
            axes.get(targetindex).push(d);
            createHanoi(ttarget,targetindex,noOfDiscs-1);
        }

    }
}