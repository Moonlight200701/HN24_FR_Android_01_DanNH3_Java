package com.example.myapplication.assignmentday4.assignment2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudent, rollNo = 0;
        String choice;
        StudentManagement studentManagement = new StudentManagement();
        while (true) {
            System.out.println("1. Input a number of students");
            System.out.println("2. Print student's infos");
            System.out.println("3. Search for a student");
            System.out.println("4, End the session");
            System.out.println("Note: RollNo of the student always starts from 0");
            System.out.println("------------------------------------------------");

            choice = scanner.next();
            switch (choice) {
                case "1":
                    System.out.println("Input the number of student please");
                    while (true) {
                        if (scanner.hasNextInt()) {
                            numberOfStudent = scanner.nextInt();
                            break;
                        } else {
                            System.out.println("Not a number, try again");
                            scanner.nextLine();
                        }
                    }
                    for (int i = 0; i <= numberOfStudent - 1; i++) {
                        System.out.println("Input the student number: " + (i + 1));
//                        System.out.println("RollNo: ");
//                        int rollNo;
//                        while (true) {
//                            if (scanner.hasNextInt()) {
//                                rollNo = scanner.nextInt();
//                                break;
//                            } else {
//                                System.out.println("That's not a number, try again");
//                                scanner.nextLine();
//                            }
//                        }
                        System.out.println("Name: ");
                        String name = scanner.next();
                        scanner.nextLine();
                        System.out.println("Sex: ");
                        String sex = scanner.next().toLowerCase();
                        //check if the input is male or female, if not, make the user input again
                        while (!sex.equals("male") && !sex.equals("female")) {
                            System.out.println("Not a gender try again");
                            System.out.print("Sex: ");
                            sex = scanner.nextLine().toLowerCase();
                        }
                        scanner.nextLine();
                        System.out.println("Age: ");
                        int age;
                        //check if the age input is a number or not
                        while (true) {
                            if (scanner.hasNextInt()) {
                                age = scanner.nextInt();
                                break;
                            } else {
                                System.out.println("That's not a number, try again");
                                scanner.nextLine();
                            }
                        }
                        System.out.println("Email: ");
                        String email;
                        while (true) {
                            email = scanner.next();
                            if (email.contains("@gmail.com")) {
                                scanner.nextLine();
                                break;
                            } else {
                                System.out.println("Not a valid email, try again");
                                scanner.nextLine();
                            }
                        }
                        System.out.println("Address: ");
                        String address = scanner.nextLine();
                        //rollNo++ to prevent duplicate keys in maps which may cause an exception that cause the system to crash
                        Students student = new Students(rollNo++, name, sex, age, email, address);
                        studentManagement.addStudent(student);
                        System.out.println("Add student " + (i + 1) + " successfully");
                    }
                    break;
                case "2":
                    studentManagement.printAllStudents();
                    break;
                case "3":
                    System.out.println("Input rollNo");
                    int rollNoOfStudent = scanner.nextInt();
                    scanner.nextLine();
                    studentManagement.printStudent(rollNoOfStudent);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Not an option");
            }
        }
    }
}