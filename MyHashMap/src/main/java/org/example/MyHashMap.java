package org.example;

import java.util.LinkedList;

public class MyHashMap {
    private LinkedList<HashMembers>[] Bucket;
    private static class HashMembers{
        public int key;
        public int val;

        public  HashMembers(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    public MyHashMap() {
        this. Bucket = new LinkedList[1001];
        for(int i=0;i<Bucket.length;i++){
            this.Bucket[i] = new LinkedList<>();

        }
    }

    public void put(int key, int value) {
        int bindex = key%1001;
        LinkedList<HashMembers> b = this.Bucket[bindex];
        boolean bfound = false;
        for (int i = 0; i < b.size(); i++) {
            HashMembers m = b.get(i);
            if(m!=null && m.key == key) {
                m.val = value;
                bfound = true;
            }

        }
        if (!bfound){
            HashMembers m = new HashMembers(key,value);
            b.add(m);
        }
    }



    public int get(int key) {
        int bindex = key%1001;
        LinkedList<HashMembers> b = this.Bucket[bindex];
        int res = -1;
        for (int i = 0; i < b.size(); i++) {
            HashMembers m =b.get(i);
            if(m!=null && m.key == key){
                res = m.val;
                break;
            }
        }
        return res;
    }

    public void remove(int key) {
        int bindex = key%1001;
        LinkedList<HashMembers> b = this.Bucket[bindex];
        HashMembers mtoberemoved = null;
        for (int i = 0; i < b.size(); i++) {
            HashMembers m = b.get(i);
            if(m!=null && m.key == key) {
                mtoberemoved = m;
                break;
            }

        }
        if (mtoberemoved!=null){
            b.remove(mtoberemoved);
        }
    }
}
