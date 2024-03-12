package com.example.myapplication.assignmentday5.assignment2;

class CharacterGenerator implements Runnable {
    private final Object lock;
    private char currentChar;

    public CharacterGenerator(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 20000) {
            synchronized (lock) {
                currentChar = (char) ('a' + Math.random() * 26);
                System.out.println("Thread 1 - Random Character generated:  " + currentChar);
                try {
                    lock.notify(); // Notify Thread 2
                    lock.wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public char getCurrentChar() {
        return currentChar;
    }
}

class CharacterConverter implements Runnable {
    private final Object lock;
    private final CharacterGenerator characterGenerator;

    public CharacterConverter(Object lock, CharacterGenerator characterGenerator) {
        this.lock = lock;
        this.characterGenerator = characterGenerator;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 20000) {
            synchronized (lock) {
                try {
                    lock.wait(); //wait for notification from thread 1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                char currentChar = characterGenerator.getCurrentChar();
                char uppercaseChar = Character.toUpperCase(currentChar);
                System.out.println("Thread 2 - Uppercase of that Character " + uppercaseChar);
                try {
                    lock.notify(); //notify thread 1
                    lock.wait(1000); // stop for 1s
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
        CharacterGenerator characterGenerator = new CharacterGenerator(lock);
        Thread thread1 = new Thread(characterGenerator);
        Thread thread2 = new Thread(new CharacterConverter(lock, characterGenerator));

        thread1.start();
        thread2.start();
    }
}
