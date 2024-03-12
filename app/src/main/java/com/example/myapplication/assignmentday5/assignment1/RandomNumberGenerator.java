package com.example.myapplication.assignmentday5.assignment1;

import java.util.Random;

class RandomNumberGenerator implements Runnable {
    private int number;

    public synchronized void printRandomNumber() {
        System.out.println("This is your random number:");
        Random random = new Random();
        int randomNumber = random.nextInt(20) + 1;
        number = randomNumber;
        System.out.println(randomNumber);
    }

    public synchronized void printSquareNumber() {
        System.out.println("This is the square of your random number:");
        double squareNumber = Math.pow(number, 2);
        System.out.println(squareNumber);
    }

    @Override
    public void run() {
        while (true) {
            printRandomNumber();
            try {
                Thread.sleep(2000); // Dừng 2 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Thread thread1 = new Thread(randomNumberGenerator);
        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000); // Dừng 1 giây
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                randomNumberGenerator.printSquareNumber();
            }
        });

        thread1.start();
        thread2.start();
    }
}
