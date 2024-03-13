package com.example.myapplication.assignmentday6.assignment3;

import com.example.myapplication.assignmentday6.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Map<String, Double> studentData = new HashMap<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(Constants.FILE_PATH + "assignment3\\student.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    String studentId = parts[0];
                    double gpa = Double.parseDouble(parts[2]);
                    studentData.put(studentId, gpa);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("StudentId: ");
            String studentId = scanner.nextLine();

            if (studentData.containsKey(studentId)) {
                double gpa = studentData.get(studentId);
                System.out.println("Gpa of student with the id " + studentId + ": " + gpa);
            } else {
                System.out.println("Student not found" + studentId);
            }
        }
    }
