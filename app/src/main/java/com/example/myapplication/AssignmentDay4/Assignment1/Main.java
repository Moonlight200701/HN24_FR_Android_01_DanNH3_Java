package com.example.myapplication.AssignmentDay4.Assignment1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList color = new ArrayList<>();
        ArrayList color2 = new ArrayList<>();

        color.add("red");
        color.add("yellow");
        color.add("orange");

        color2.add("blue");
        color2.add("violet");
        color2.add("purple");

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();

        list.addAll(color);
        list2.addAll(color2);

        list.addAll(list2);
        list2.clear();

        System.out.println(list);

        for(int i = 0; i<= list.size()-1; i++){
            list.set(i,list.get(i).toUpperCase());
        }
        System.out.println(list);

        list.subList(3,6).clear();

        System.out.println(list);

        Collections.reverse(list);

        System.out.println(list);
    }
}
