package com.example.myapplication.assignmentday5.assignment5;

import java.util.ArrayList;
import java.util.List;





public class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        List<String> names = new ArrayList<>();
        names.add("Nguyen Van Huan");
        names.add("Nguyen Linh Duc");
        names.add("Nguyen Van Tan");
        names.add("Vu Viet Tung");
        names.add("Tran Trung Nghia");

        List<String> homeTowns = new ArrayList<>();
        homeTowns.add("Ha Noi");
        homeTowns.add("Hung Yen");
        homeTowns.add("Khanh Hoa");
        homeTowns.add("Ha Tinh");
        homeTowns.add("Quang Ninh");

        NameThread nameThread = new NameThread(lock, names);
        HomeTownThread hometownThread = new HomeTownThread(lock, homeTowns);

        nameThread.start();
        hometownThread.start();

        try {
            nameThread.join();
            hometownThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads have completed.");
    }
}


