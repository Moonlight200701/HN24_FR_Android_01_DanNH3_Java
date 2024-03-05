package com.example.myapplication.Assignment;

import java.util.Scanner;

public class Assignment9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number: ");
        int number = scanner.nextInt();
        if (checkIfPrimeNumber(number)) {
            System.out.println("Your number is Prime!");
        } else {
            System.out.println("No your number is not Prime!");
        }
    }

    public static boolean checkIfPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

