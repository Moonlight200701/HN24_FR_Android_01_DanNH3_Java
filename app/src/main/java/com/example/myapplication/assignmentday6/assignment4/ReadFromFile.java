package com.example.myapplication.assignmentday6.assignment4;

import com.example.myapplication.assignmentday6.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(Constants.FILE_PATH + "assignment4\\employee.txt");
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            fr.close();

    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
