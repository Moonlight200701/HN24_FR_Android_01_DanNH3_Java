package com.example.myapplication.Assignment;

import java.util.Scanner;

public class Assignment7 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number: ");
        int number = scanner.nextInt();
        int sumOfEven = 0;
        for(int i = 0; i<=number;i++){
            if(i%2==0){
                sumOfEven+=i;
            }
        }
        System.out.println("The sum of the even numbers that is smaller or equal to the input number: " + sumOfEven);
    }
}
