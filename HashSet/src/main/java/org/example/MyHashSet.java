package org.example;

import java.util.LinkedList;

public class MyHashSet {
    LinkedList<Integer>[] b = new LinkedList[1001];
    public MyHashSet() {
        for (int i=0;i<b.length;i++){
            this.b[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        Integer bucket = key%1001;
        if (!contains(key)){
            b[bucket].add(key);
        }
    }

    public void remove(int key) {
        Integer bucket = key%1001;
        if(contains(key)){
            LinkedList<Integer> l = b[bucket];
            l.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        Integer bucket = key%1001;
        boolean res = false;
        if (this.b[bucket].contains(key)){
            res= true;
        }

        return res;
    }
}


