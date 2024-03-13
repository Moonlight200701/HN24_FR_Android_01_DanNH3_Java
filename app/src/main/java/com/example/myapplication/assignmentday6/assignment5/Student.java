package com.example.myapplication.assignmentday6.assignment5;

public class Student {
    private String studentId;

    private String name;
    private int age;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    private String address;
    private float gpa;

    @Override
    public String toString() {
        return studentId + " " + name + " " + age + " " + address + " " + gpa + "\n";
    }

    public Student(String studentId, String name, int age, String address, float gpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }
}
