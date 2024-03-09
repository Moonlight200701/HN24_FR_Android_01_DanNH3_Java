package com.example.myapplication.AssignmentDay4.Assignment2;

public class Students {
    private int rollNo = 0;

    private String name;

    private String sex;

    private int age;

    private String email;

    private String address;

    public int getRollNo() {
        return rollNo;
    }

    public Students(int rollNo, String name, String sex, int age, String email, String address) {
        this.rollNo = rollNo++;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Students{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
