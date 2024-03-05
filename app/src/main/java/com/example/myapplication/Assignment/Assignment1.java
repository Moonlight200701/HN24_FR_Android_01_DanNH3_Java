package com.example.myapplication.Assignment;

import java.util.Scanner;

public class Assignment1 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the average grade: ");
        int averageGrade = scanner.nextInt();
        if(averageGrade >= 5){
            System.out.println("Congrats, You passed mate");
        }else{
            System.out.println("Bad news, You failed mate");
        }
    }
}
