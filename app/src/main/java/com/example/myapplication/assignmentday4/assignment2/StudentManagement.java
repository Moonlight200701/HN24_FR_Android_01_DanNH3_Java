package com.example.myapplication.assignmentday4.assignment2;

import java.util.HashMap;

public class StudentManagement {
    HashMap<Integer, Students> studentList = new HashMap<>();

    public void addStudent(Students student) {
        try {
            studentList.put(student.getRollNo(), student);
        }catch (Exception e){
            System.out.println("RollNo already exists!");
        }
    }

    public void printStudent(int rollNo) {
        if (studentList.containsKey(rollNo)) {
            System.out.println(studentList.get(rollNo));
        } else {
            System.out.println("No student with roll number: " + rollNo);
        }
    }

    public void  printAllStudents() {
        if(studentList.isEmpty()){
            System.out.println("No student here!");
        }
        for (Students student : studentList.values()) {
            System.out.println(student.toString());
        }
    }
}
