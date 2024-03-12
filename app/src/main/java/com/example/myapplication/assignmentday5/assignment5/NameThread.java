package com.example.myapplication.assignmentday5.assignment5;

import java.util.List;

public class NameThread extends Thread {
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