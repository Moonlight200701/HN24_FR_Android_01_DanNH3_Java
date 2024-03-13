package com.example.myapplication.assignmentday6.assignment5;

import com.example.myapplication.assignmentday6.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class StudentManagement {
    private static final String fileName = Constants.FILE_PATH + "assigment5\\student.txt";

    private static final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        loadStudent();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Add Student");
            System.out.println("2. Update student based on student Id");
            System.out.println("3. Delete student based on student Id");
            System.out.println("4. Order students by name");
            System.out.println("5. Order students by gpa");
            System.out.println("6. Display all students info");
            System.out.println("0. Exit");
            System.out.print("You must choose, Mr Sparrow: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    updateStudent(scanner);
                    break;
                case 3:
                    deleteStudent(scanner);
                    break;
                case 4:
                    orderStudentByName();
                    break;
                case 5:
                    orderStudentByGPA();
                    break;
                case 6:
                    displayStudentsInfo();
                    break;
                case 0:
                    System.out.println("System shut down.");
                    break;
                default:
                    System.out.println("That's not a choice.");
            }
        } while (choice != 0);
    }

    private static void loadStudent() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String studentId = parts[0];
                String studentName = parts[1];
                int studentAge = Integer.parseInt(parts[2]);
                String studentAddress = parts[3];
                float studentGPA = Float.parseFloat(parts[4]);
                Student student = new Student(studentId, studentName, studentAge, studentAddress, studentGPA);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addStudent(Scanner scanner) {
        String studentName, studentAddress;
        System.out.println("Student Id: ");
        String studentId = scanner.nextLine();

        System.out.println("Student Name: ");
        do{
            studentName = scanner.nextLine();

            if (studentName.contains(" ")) {
                System.out.println("Space detected, try again");
            }
        }while (studentName.contains(" "));

        int studentAge;
        do {
            System.out.print("Student Age: ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid age, try again");
                scanner.next();
            }
            studentAge = scanner.nextInt();
            scanner.nextLine();

            if (studentAge <= 0) {
                System.out.println("Age must be larger than 0");
            }
        } while (studentAge <= 0);

        System.out.println("Student Address: ");
        do{
            studentAddress = scanner.nextLine();

            if (studentAddress.contains(" ")) {
                System.out.println("Space detected, try again");
            }
        }while (studentAddress.contains(" "));

        float studentGPA;
        do {
            System.out.println("Student GPA");
            while (!scanner.hasNextFloat()) {
                System.out.println("GPA must be positive, try again ");
                scanner.next();
            }
            studentGPA = scanner.nextFloat();
            scanner.nextLine();

            if (studentGPA <= 0) {
                System.out.println("GPA must be larger than 0, try again ");
            }
        } while (studentGPA <= 0);

        Student student = new Student(studentId, studentName, studentAge, studentAddress, studentGPA);
        students.add(student);
        saveStudentToFile(student);
        System.out.println("Thêm sinh viên thành công.");
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Which studentId you want to update? ");
        String studentIdNeedsUpdate = scanner.nextLine();
        Student studentNeedsToUpdate = findStudent(studentIdNeedsUpdate);
        if (studentNeedsToUpdate != null) {
            System.out.println("New Info of this student: ");
            System.out.print("Student Name: ");
            studentNeedsToUpdate.setName(scanner.nextLine());
            System.out.print("Student Age: ");
            studentNeedsToUpdate.setAge(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Student Address: ");
            studentNeedsToUpdate.setAddress(scanner.nextLine());
            System.out.print("Student GPA ");
            studentNeedsToUpdate.setGpa(scanner.nextFloat());
            scanner.nextLine();

            ghiLaiFile();
            System.out.println("Update student successfully");
        } else {
            System.out.println("Student whose id is " + studentIdNeedsUpdate + "doesn't exist");
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Which studentId you want to delete? ");
        String studentIdNeedsDelete = scanner.nextLine();
        Student studentNeedsToDelete = findStudent(studentIdNeedsDelete);
        if (studentNeedsToDelete != null) {
            students.remove(studentNeedsToDelete);
            ghiLaiFile();
            System.out.println("Delete student successfully.");
        } else {
            System.out.println("Student whose id is " + studentIdNeedsDelete + "doesn't exist");
        }
    }

    private static void orderStudentByName() {
        Collections.sort(students, Comparator.comparing(Student::getName));
        displayStudentsInfo();
    }

    private static void orderStudentByGPA() {
        Collections.sort(students, Comparator.comparingDouble(Student::getGpa).reversed());
        displayStudentsInfo();
    }

    private static void displayStudentsInfo() {
        System.out.println("------Student Info------");
        for (Student student: students) {
            System.out.println(student);
        }
    }

    private static Student findStudent(String maSV) {
        for (Student student : students) {
            if (student.getStudentId().equals(maSV)) {
                return student;
            }
        }
        return null;
    }

    private static void saveStudentToFile(Student student) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(student.getStudentId() + " " + student.getName() + " " + student.getAge() + " " + student.getAddress() + " " + student.getGpa() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ghiLaiFile() {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student student : students) {
                writer.write(student.getStudentId() + " " + student.getName() + " " + student.getAge() + " " + student.getAddress() + " " + student.getGpa() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}