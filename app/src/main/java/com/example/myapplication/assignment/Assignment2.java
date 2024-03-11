package com.example.myapplication.assignment;

import java.util.Scanner;

public class Assignment2 {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number a");
        int a = scanner.nextInt();
        System.out.println("Input the number b");
        int b = scanner.nextInt();
        if(a < b){
            System.out.println("a is the larger number");
        }else{
            System.out.println("b is the larger number");
        }
    }
}
