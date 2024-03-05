package com.example.myapplication.Assignment;

import java.util.Scanner;

public class Assignment5 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number: ");
        int number = scanner.nextInt();
        int fact = 1;
        for(int i = 1;i<=number;i++){
            fact*=i;
        }
        System.out.println("Factorial of the Input number:" + fact);

    }
}
