package com.example.myapplication.assignmentday6.assignment4;

import com.example.myapplication.assignmentday6.Constants;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) {
//        ArrayList<String> listOfInfos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        try {
            FileWriter writer = new FileWriter(Constants.FILE_PATH + "assignment4\\employee.txt");
            for (int i = 1; i <= 3; i++) {
                System.out.println("Employee Id: ");
                String employeeId = scanner.nextLine();

                System.out.println("Employee Name: ");
                String employeeName = scanner.nextLine();
                while(!employeeName.matches(".*[A-Z][a-z]*.*")){
                    System.out.println("That's not a valid name, try again");
                    System.out.println("Employee Name: ");
                    employeeName = scanner.nextLine();
                }

                System.out.println("Employee age: ");
                int employeeAge;
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number, try again");
                    System.out.println("Employee age: ");
                    scanner.nextLine();
                }
                employeeAge = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Employee Salary: ");
                int employeeSalary;
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number, try again");
                    System.out.println("Employee Salary: ");
                    scanner.nextLine();
                }
                employeeSalary = scanner.nextInt();
                scanner.nextLine();

                Employee employee = new Employee(employeeId, employeeName, employeeAge, employeeSalary);
                writer.write(employee.toString());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
