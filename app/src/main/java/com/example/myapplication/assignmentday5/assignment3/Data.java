package com.example.myapplication.assignmentday5.assignment3;

import java.util.Random;

public class Data implements Runnable{
    private static int total;

    public synchronized void numberGenerator(){
        if(total > 100 || total < -100) return;
        System.out.println("Thread 1 - Generated number from -100 to 0: ");
        Random random = new Random();
        int randomNumber = random.nextInt(101) * -1;
        total += randomNumber;
        System.out.println(randomNumber);
    }

    public synchronized void numberGenerator2(){
        if(total > 100 || total < -100) return;
        System.out.println("Thread 2 - Generated number from 0 to 100: ");
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 0;
        total += randomNumber;
        System.out.println(randomNumber);
    }
    @Override
    public void run() {
        while(total <= 100 && total >= -100){
            numberGenerator();
            System.out.println("Current total: " + total);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Data aNumber = new Data();
        Thread thread1 = new Thread(aNumber);
        Thread thread2 = new Thread(()->{
            while(total<=100 && total >= -100){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                aNumber.numberGenerator2();
                System.out.println("Current total: " + total);
            }
        });
        thread1.start();
        thread2.start();

    }

}
