package com.example.myapplication.assignmentday5.assignment5;

import java.util.List;

public class HomeTownThread extends Thread {
    private final Object lock;
    private final List<String> hometowns;

    public HomeTownThread(Object lock, List<String> hometowns) {
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
