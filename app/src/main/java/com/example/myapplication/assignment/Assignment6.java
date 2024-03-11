package com.example.myapplication.assignment;

import java.util.Scanner;

public class Assignment6 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number of your choice: ");
        int number = scanner.nextInt();
        if(number < 0){
            System.out.println("Bruh");
            return;
        }
        int sum = 0;
        for(int i = 1; i<= number - 1; i++){
            sum+=i;
        }
        System.out.println("The sum of the numbers from 1 to approximate n is: " + sum);
    }
}
