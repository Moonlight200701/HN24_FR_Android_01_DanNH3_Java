package com.example.myapplication.assignmentday6.assignment4;

import com.example.myapplication.assignmentday6.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteToObject {
    public static void main(String[] args) {
        ArrayList<String> employees = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(Constants.FILE_PATH + "assignment4\\employee.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String [] parts = line.split(" ");
                String employeeId = parts[0];
                String employeeName = parts[1];
                String employeeAge = parts[2];
                String employeeSalary = parts[3];
                Employee employee = new Employee(employeeId, employeeName, Integer.parseInt(employeeAge), Float.parseFloat(employeeSalary));
                employees.add(employee.toString());
                try{
                    ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream(Constants.FILE_PATH + "assignment4\\employee.bin"));
                    oops.writeObject(employees);
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
            br.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
