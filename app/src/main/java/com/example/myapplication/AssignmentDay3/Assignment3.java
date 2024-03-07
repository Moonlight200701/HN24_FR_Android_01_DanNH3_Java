package com.example.myapplication.AssignmentDay3;

import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        int[] daySo = new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập phần tử cho mảng");
        for (int i = 0; i <= daySo.length - 1; i++) {
            System.out.println("Nhập phần tử thứ " + (i + 1) + "\n");
            daySo[i] = scanner.nextInt();
        }

        System.out.println("Nhập vị trí phần tử muốn hiển thị");
        try {
            int viTriPhanTuTrongMang = scanner.nextInt();
            System.out.println(daySo[viTriPhanTuTrongMang]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nằm ngoài mảng rồi bạn ơi!!!");
        }
    }
}
