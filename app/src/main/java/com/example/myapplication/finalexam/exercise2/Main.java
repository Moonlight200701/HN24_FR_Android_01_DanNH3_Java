package com.example.myapplication.finalexam.exercise2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> primeNumbers = new ArrayList<>();
        List<Integer> palindromeNumbers = new ArrayList<>();
        List<Integer> primeDigitsNumbers = new ArrayList<>();
        List<Integer> sumOfDigitIsPrime = new ArrayList<>();

        for(int i = 10000; i< 10000000; i++){
            numbers.add(i);
        }
        //Question a
        System.out.println("------------------------------");
        System.out.println("Question a: ");
        for (int number: numbers) {
            if(isPrime(number)){
                primeNumbers.add(number);
            }
        }
        System.out.println(primeNumbers);
        System.out.println("-------------------------------");

        //Quesion b
        System.out.println("-------------------------------");
        System.out.println("Question b: ");
        for (int number: numbers){
            if(validPalindrome(number)){
                palindromeNumbers.add(number);
            }
        }
        System.out.println(palindromeNumbers);

        //Question c
        System.out.println("--------------------------------");
        System.out.println("Question c: ");
        for(int number: numbers){
            if(isTheDigitsPrime(number)){
                primeDigitsNumbers.add(number);
            }
        }
        System.out.println(primeDigitsNumbers);
        System.out.println("----------------------------------");

        //Question d
        System.out.println("--------------------------------");
        System.out.println("Quetion d: ");
        for (int number: numbers){
            if(isTheSumDigitsPrime(number)){
                sumOfDigitIsPrime.add(number);
            }
        }
        System.out.println(sumOfDigitIsPrime);
        System.out.println("----------------------------------");

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
    public static boolean validPalindrome(int number){
        String numberStr = String.valueOf(number);

        //Compare the String with the reversed String
        return numberStr.equals(new StringBuilder(numberStr).reverse().toString());
    }

    public static boolean isTheSumDigitsPrime(int number) {
        int temp, balance;
        int sum = 0;
        temp = number;
        while (temp > 0) {
            balance = temp % 10;
            sum += balance;
            temp /= 10;
        }
        if(isPrime(sum)){
            return true;
        }else return false;
    }

    public static boolean isTheDigitsPrime(int number){
        int temp = number;

        while(temp > 0){
            int digit;
            digit = temp % 10;
            if(!isPrime(digit)){
                return false;
            }
            temp /=10;
        }
        return true;
    }
}
