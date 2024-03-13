package com.example.myapplication.finalexam.exercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Integer> listOfNumbers = new ArrayList<>();
        int numberOfNumbers, insertNumber;
        System.out.println("Input a number of numbers of your wish: ");
        while(!scanner.hasNextInt()){
            System.out.println("That's not a number, try again");
            System.out.println("Input a number of numbers of your wish: ");
            scanner.nextLine();
        }
        numberOfNumbers = scanner.nextInt();
        scanner.nextLine();

        for(int i = 1; i<= numberOfNumbers; i++){
            int number;
            System.out.println("Input the " + i +" number");
            checkValidNumber(scanner);
            number = scanner.nextInt();
            listOfNumbers.add(number);
        }
        Collections.sort(listOfNumbers);
        System.out.println("List of number from the smallest to the largest"+ listOfNumbers);

        System.out.println("Input the number you want to insert");
        checkValidNumber(scanner);
        insertNumber = scanner.nextInt();
        scanner.nextLine();

        listOfNumbers.add(insertNumber);
        Collections.sort(listOfNumbers);

        System.out.println("List of number after insert a number: " + listOfNumbers);
    }

    public static void checkValidNumber(Scanner scanner){
        while(!scanner.hasNextInt()){
            System.out.println("That's not a number, try again");
            scanner.nextLine();
        }
    }
}


