package com.example.myapplication.assignmentday6.assignment4;

import com.example.myapplication.assignmentday6.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadFromObject {
    public static void main(String[] args) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constants.FILE_PATH+"assignment4\\employee.bin"));
            List<Object> list = (List<Object>) ois.readObject();
            for (Object obj: list ) {
                System.out.println(obj);
            }
                ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
