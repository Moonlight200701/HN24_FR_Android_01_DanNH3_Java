package com.example.myapplication.Assignment;

import java.util.Scanner;

public class Assignment6 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number of your choice: ");
        int number = scanner.nextInt();
        int sum = 0;
        for(int i = 1; i<= number - 1; i++){
            sum+=i;
        }
        System.out.println("The sum of the numbers from 1 to approximate n is: " + sum);
    }
}
