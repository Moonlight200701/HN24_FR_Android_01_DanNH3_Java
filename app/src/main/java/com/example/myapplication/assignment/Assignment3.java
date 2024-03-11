package com.example.myapplication.assignment;

import java.util.Scanner;

public class Assignment3 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number a: ");
        int a = scanner.nextInt();
        System.out.println("Input the number b: ");
        int b = scanner.nextInt();
        System.out.println("Input the operator: ");
        String operator = scanner.next();
        switch(operator) {
            case "+":
                System.out.println("The sum of the 2 numbers: "+ (a+b));
                break;
            case "-":
                System.out.println("The difference of the 2 numbers: "+ (a-b));
                break;
            case "*":
                System.out.println("The product of the 2 numbers: " + (a*b));
                break;
            case "/":
                System.out.println("The Quotient of the 2 numbers: " + (a/b));
                break;
            default:
                System.out.println("That's not a valid input");
        }

    }
}
