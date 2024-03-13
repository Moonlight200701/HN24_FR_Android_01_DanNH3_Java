package com.example.myapplication.assignmentday6.assignment2;

import com.example.myapplication.assignmentday6.Constants;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of customers: ");
        ArrayList<StringBuilder> listOfCustomers = new ArrayList<>();
        int numberOfCustomers;
        while(!scanner.hasNextInt()){
            System.out.println("That's not a number, try again");
            System.out.println("Input the number of customers");
            scanner.nextLine();
        }
        numberOfCustomers = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i <= numberOfCustomers - 1; i++) {
            System.out.println("Customer Id: ");
            String customerId = scanner.nextLine();

            System.out.println("Customer Name: ");
            String customerName = scanner.next();

            System.out.println("Customer Phone Number: ");
            String phoneNumber = scanner.next();
            while(!phoneNumber.matches("\\d+")) {
                System.out.println("That's not a valid phone number, try again");
                System.out.println("Customer Phone Number: ");
                phoneNumber = scanner.next();
            }
            scanner.nextLine();
            StringBuilder customerInfo = new StringBuilder(customerId + " " + customerName + " " + phoneNumber + "\n");
            listOfCustomers.add(customerInfo);
            System.out.println(customerInfo);
        }
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(Constants.FILE_PATH + "assignment2\\khachhang.txt"));
            for (StringBuilder customer : listOfCustomers) {
                buffer.write(customer.toString());
            }
            buffer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

