package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTrie {
    Node rootNode = null;
    public static class Node{
        private char key;
        public boolean isLeaf;
        private List<Node> children = null;
        public Node(char key){
            this.key = key;
            this.children = new ArrayList<>();

        }
    }
    public MyTrie(){
        char ch=0;
        this.rootNode = new Node(ch);
    }
    public Node AddNode(Node pn,char c){
        for (Node cn:pn.children){
            if(cn.key == c){
                return cn;
            }
        }
        Node nc = new Node(c);
        pn.children.add(nc);

        return nc;
    }
    public void buildTrie(String w){
        char[] ch = w.toCharArray();
        Node n = this.rootNode;
        for(char c:ch){
            n = AddNode(n,c);
        }
        n.isLeaf=true;

    }
    public Node searchNode(Node n,char ch){
        if(n==null){
            n = this.rootNode;
        }
        for (Node c:n.children){
            if(c.key == ch){
                return c;
            }

        }
        return null;
    }

}
