package com.example.myapplication.assignmentday5.assignment5;

import java.util.ArrayList;
import java.util.List;

class NameThread extends Thread {
    private final Object lock;
    private final List<String> names;

    public NameThread(Object lock, List<String> names) {
        this.lock = lock;
        this.names = names;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (lock) {
                if (i < names.size()) {
                    System.out.println("Name: " + names.get(i));
                }
                lock.notify(); // notify HometownThread
                try {
                    if (i < names.size() - 1) {
                        lock.wait(); // wait for HometownThread to print
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class HometownThread extends Thread {
    private final Object lock;
    private final List<String> hometowns;

    public HometownThread(Object lock, List<String> hometowns) {
        this.lock = lock;
        this.hometowns = hometowns;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (lock) {
                if (i < hometowns.size()) {
                    System.out.println("Hometown: " + hometowns.get(i));
                }
                lock.notify(); // notify NameThread
                try {
                    if (i < hometowns.size() - 1) {
                        lock.wait(); // wait for NameThread to print
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

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
        HometownThread hometownThread = new HometownThread(lock, homeTowns);

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


