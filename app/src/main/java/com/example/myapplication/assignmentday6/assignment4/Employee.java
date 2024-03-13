package com.example.myapplication.assignmentday6.assignment4;

public class Employee {
    private String employeeId;
    private String name;
    private int age;
    private float salary;

    public Employee(String employeeId, String name, int age, float salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return employeeId + " " + name + " " + age + " " + salary + "\n";
    }
}
