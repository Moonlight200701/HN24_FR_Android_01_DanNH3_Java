package com.example.myapplication.finalexam.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Integer> divisors = new ArrayList<>();
        int number, balance, size, temp1;
        int sum = 0;
        do {
            System.out.print("Input a number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid number mate, try again");
                System.out.print("Input a number: ");
                scanner.nextLine();
            }
            number = scanner.nextInt();
            scanner.nextLine();
        } while (number < 2);
        temp1 = number;
        //Question a
        System.out.println("Question a: ");
        while (temp1 > 0) {
            balance = temp1 % 10;
            sum += balance;
            temp1 /= 10;
        }
        System.out.println("Sum of the digits in the number: " + sum);

        //Question b
        System.out.println("Question b: ");
        List<Integer> listNumbers = numberAnalysis(number);
        size = listNumbers.size();
        for (int i = 0; i < size - 1; i++) {
            System.out.print(listNumbers.get(i) + " x ");
        }
        System.out.print(listNumbers.get(size - 1) + " " + "\n");

        //Question c
        System.out.println("Question c: ");
        for(int j = 1; j<= number; j++){
            if(number % j == 0){
                divisors.add(j);
            }
        }
        System.out.println("Divisors of the number: " + divisors);

        //Question d
        List<Integer> primeDivisors = new ArrayList<>();
        System.out.println("Question d: ");
        for(int k = 1; k<= number;k++){
            if(number % k == 0){
                if(isPrime(k)){
                    primeDivisors.add(k);
                }
            }
        }
        System.out.println("Prime Divisors of the number: " + primeDivisors);
    }

    public static List<Integer> numberAnalysis(int n) {
        int i = 2;
        List<Integer> listNumbers = new ArrayList<Integer>();
        // phân tích
        while (n > 1) {
            if (n % i == 0) {
                n = n / i;
                listNumbers.add(i);
            } else {
                i++;
            }
        }

        if (listNumbers.isEmpty()) {
            listNumbers.add(n);
        }
        return listNumbers;
    }

    public static boolean isPrime(int number){
        if (number <= 1){
            return false;
        }
        for(int i = 2; i<= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
