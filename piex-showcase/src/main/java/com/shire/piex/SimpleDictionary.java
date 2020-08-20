package com.shire.piex;

/* File: SimpleDictionary.java
 * Author: Wayne Snyder
 * Date: 8/25/2020
 * Purpose: This is the basic template for HW04 B.4 for CS 112, Summer II, 2020
 */

import java.util.Dictionary;

public class SimpleDictionary implements Dictionary {

    // basic definition of the Node class; this is an "inner class" inside class SymbolTable

    private class Node {                 // Node class for LLs
        String key;
        int value;
        Node next;

        public Node(String k, int v, Node p) {
            key = k; value = v; next = p;
        }
    }

    // pointer to list of bindings for symbol table

    private Node head = null;

    // length of linked list; will be updated whenever adding or deleting a node

    private int size = 0;


    // Your code here, implementing methods in Dictionary interface



    // Recursive toString() method

    public String toString() {
        return toStringHelper(head);
    }

    private String toStringHelper(Node p) {
        if(p == null)
            return "";
        else if(p.next == null)
            return ("(" + p.key + "," + p.value + ")");
        else
            return "(" + p.key + "," + p.value + ") : " + toStringHelper(p.next);
    }


    public static void main(String[] args) {


        Dictionary S = new SimpleDictionary();

        // Insert 3 (key,value) pairs and test basic methods

        S.insert("e",3);
        S.insert("c",1);
        S.insert("b",1);

        System.out.println("\nTest 01: Should print out:\n(b,1) : (c,1) : (e,3)");
        System.out.println(S);

        System.out.println("\nTest 02: Should print out:\n3");
        System.out.println(S.size());

        System.out.println("\nTest 03: Should print out:\nfalse");
        System.out.println(S.isEmpty());

        System.out.println("\nTest 04: Should print out:\n1");
        String testKey = "c";
        System.out.println(S.lookup(testKey));

        System.out.println("\nTest 05: Should print out:\n" + Integer.MIN_VALUE);
        testKey = "d";

        System.out.println(S.lookup(testKey));


        System.out.println("\nTest 06: Should print out:\n(b,1) : (c,1) : (e,3) : (s,4)");
        S.insert("s",4);
        System.out.println(S);

        System.out.println("\nTest 07: Should print out:\ntrue");
        System.out.println(S.contains("c"));

        System.out.println("\nTest 08: Should print out:\nfalse");
        System.out.println(S.contains("a"));

        System.out.println("\nTest 09: Should print out:\ntrue");
        System.out.println(S.contains("e"));

        S.insert("y",3);
        S.insert("q",2);
        S.insert("k",5);


        S.delete("q");
        S.delete("e");
        S.delete("c");
        S.delete("s");
        S.delete("y");
        S.delete("k");

        System.out.println("\nTest 10: Should print out:\n(b,1)");
        System.out.println(S);

        System.out.println("\nTest 11: Should print out:\n0");
        S.delete("b");
        System.out.println(S.size());

        System.out.println("\nTest 12: Should print out:\nnull");
        System.out.println(S.min());

        System.out.println("\nTest 13: Should print out:\nnull");
        System.out.println(S.max());


        int chicago = 1;
        int phoenix = 2;
        int houston = 3;
        int seattle = 4;

        Dictionary T = new SimpleDictionary();
        T.insert("09:00:00",chicago);
        T.insert("09:00:03",phoenix);
        T.insert("09:00:13",houston);
        T.insert("09:00:59",chicago);
        T.insert("09:36:14",seattle);
        T.insert("09:37:44",phoenix);
        T.insert("09:10:25",seattle);
        T.insert("09:14:25",phoenix);
        T.insert("09:19:32",chicago);
        T.insert("09:19:46",chicago);
        T.insert("09:21:05",chicago);
        T.insert("09:22:43",seattle);
        T.insert("09:01:10",houston);
        T.insert("09:03:13",chicago);
        T.insert("09:10:11",seattle);
        T.insert("09:25:52",chicago);
        T.insert("09:22:54",seattle);
        T.insert("09:35:21",chicago);

        System.out.println("\nTest 14: Should print out:\n(09:00:00,1) : (09:00:03,2) : (09:00:13,3) : (09:00:59,1) : (09:01:10,3) : (09:03:13,1) : (09:10:11,44) : (09:10:25,4) : (09:14:25,2) : (09:19:32,1) : (09:19:46,1) : (09:21:05,1) : (09:22:43,4) : (09:22:54,4) : (09:25:52,1) : (09:35:21,1) : (09:36:14,4) : (09:37:44,2)");
        System.out.println("\n" + T);

        System.out.println("\nTest 15: Should print out:\n09:00:00");
        System.out.println(T.min());

        System.out.println("\nTest 16: Should print out:\n09:37:44");
        System.out.println(T.max());


        System.out.println("\nTest 17: Should print out:\n18");
        System.out.println(T.size());


        System.out.println("\nTest 18: Should print out:\n09:00:03");
        T.deleteMin();
        System.out.println(T.min());


        System.out.println("\nTest 19: Should print out:\n09:36:14");
        T.deleteMax();
        System.out.println(T.max());


        System.out.println("\nTest 20: Should print out:\n16");
        System.out.println(T.size());


    }
}

