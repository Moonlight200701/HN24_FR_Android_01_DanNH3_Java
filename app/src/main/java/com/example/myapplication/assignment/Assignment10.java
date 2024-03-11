package com.example.myapplication.assignment;

import java.util.Scanner;

public class Assignment10 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the year number: ");
        int year = scanner.nextInt();
        if(year % 400 == 0) {
            System.out.println("It's a Leap year");
        }else if(year % 4 == 0 && year % 100 != 0){
            System.out.println("It's a Leap year");
        }else{
            System.out.println("No, it's not a Leap year");
        }
    }
}
