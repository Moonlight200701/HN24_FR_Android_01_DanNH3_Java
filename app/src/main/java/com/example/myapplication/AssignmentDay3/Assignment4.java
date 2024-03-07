package com.example.myapplication.AssignmentDay3;

import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 1 string");
        String xauBatKy = scanner.nextLine();
        try{
            int abc = Integer.parseInt(xauBatKy);
        }catch (Exception e){
            System.out.println("ai cho ép từ string sang số?");
        }
    }
}
