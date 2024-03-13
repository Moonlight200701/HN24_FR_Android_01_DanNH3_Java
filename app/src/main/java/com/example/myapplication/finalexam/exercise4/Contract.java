package com.example.myapplication.finalexam.exercise4;

public class Contract {
    private String name;
    private String phoneNumber;

    public Contract(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void display() {
        System.out.println("Name = " + name + " phoneNumber = " + phoneNumber);
    }
}
