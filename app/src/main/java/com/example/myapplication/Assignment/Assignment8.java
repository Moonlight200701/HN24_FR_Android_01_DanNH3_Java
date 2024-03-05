package com.example.myapplication.Assignment;

import java.util.Scanner;

public class Assignment8 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the first number: ");
        int firstnumber = scanner.nextInt();
        System.out.println("Input the second number: ");
        int secondnumber = scanner.nextInt();
        while(firstnumber != secondnumber) {
            if (firstnumber > secondnumber) {
                firstnumber = firstnumber - secondnumber;
            } else {
                firstnumber = secondnumber - firstnumber;
            }
        }
        System.out.println("Greatest Common Divisor of the two input number is:" + firstnumber);
    }
}
