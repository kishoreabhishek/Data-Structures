package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        obj.contains(1);
        obj.contains(3);
        obj.add(2);
        obj.contains(2);
        obj.remove(2);
        obj.contains(2);
    }
}