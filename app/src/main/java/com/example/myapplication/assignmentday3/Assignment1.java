package com.example.myapplication.assignmentday3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Nhập số thực thứ 1");
            double soThuc1 = scanner.nextDouble();
            System.out.println("Nhập số thức thứ 2");
            double soThuc2 = scanner.nextDouble();

            chia2So(soThuc1, soThuc2);
        } catch (InputMismatchException e) {
            System.out.println("Đó không phải là số");
        }
    }

    public static void chia2So(double soThuc1, double soThuc2) {
        try {
            if (soThuc2 == 0) {
                throw new ArithmeticException();
            }
            double thuong = soThuc1 / soThuc2;
            System.out.println(thuong);
        } catch (ArithmeticException e) {
            System.out.println("Thật sự à? Thật sự chia cho 0 đây à?");
        }
    }
}

