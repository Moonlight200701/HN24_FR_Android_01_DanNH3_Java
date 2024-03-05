package com.example.myapplication.Assignment;

import java.util.Scanner;

public class Assignment8 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the first number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Input the second number: ");
        int secondNumber = scanner.nextInt();
        while(firstNumber != secondNumber) {
            if (firstNumber > secondNumber) {
                firstNumber = firstNumber - secondNumber;
            } else {
                firstNumber = secondNumber - firstNumber;
            }
        }
        System.out.println("Greatest Common Divisor of the two input number is:" + firstNumber);
    }
}
