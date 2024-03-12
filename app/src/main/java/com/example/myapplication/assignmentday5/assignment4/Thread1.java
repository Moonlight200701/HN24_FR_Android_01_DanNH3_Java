package com.example.myapplication.assignmentday5.assignment4;

import java.util.ArrayList;
import java.util.Random;

public class Thread1 extends Thread {
    private ArrayList<Integer> list1;

    @Override
    public void run() {
        super.run();
        int count = 0;
        list1 = new ArrayList<>();
        while (count <= 10) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 0;
            list1.add(randomNumber);
            System.out.println("This is your random number: " + randomNumber);
            System.out.println("Current list: " + list1); //for testing
            count++;
        }
        System.out.println("-----------------------------------------");
        System.out.println("The final list1 after 10 times: " + list1);
        System.out.println("-----------------------------------------");

    }
}
