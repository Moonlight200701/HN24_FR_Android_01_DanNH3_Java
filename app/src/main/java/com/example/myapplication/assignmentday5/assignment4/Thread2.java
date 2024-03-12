package com.example.myapplication.assignmentday5.assignment4;

import java.util.ArrayList;
import java.util.Random;

public class Thread2 extends Thread {
    private ArrayList<Character> list2;
    @Override
    public void run() {
        int count = 0;
        super.run();
        list2 = new ArrayList<>();
        while (count <= 10) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Random random = new Random();
            char randomChar = (char) ('a' + random.nextInt(26));
            System.out.println("Your random char: " + randomChar);
            list2.add(randomChar);
            System.out.println("Current list: " + list2);
            count++;
        }
        System.out.println("---------------------------------------");
        System.out.println("The final list2 after 10 times: " + list2);
        System.out.println("---------------------------------------");
    }
}
