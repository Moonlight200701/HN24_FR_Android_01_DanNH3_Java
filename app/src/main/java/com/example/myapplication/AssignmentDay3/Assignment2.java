package com.example.myapplication.AssignmentDay3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        List<Integer> mangSo = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng");
        int soPhanTu =  scanner.nextInt();
        try{
            System.out.println("Nhập phần tử của mảng");
            for(int i = 0; i<=soPhanTu-1; i++){
                int value = scanner.nextInt();
                if(value == 100){
                    throw new Exception();
                }
                mangSo.add(value);
            }
        }catch (Exception e) {
            System.out.println("Các phần tử đã nhập");
            for (Integer so:mangSo
                 ) {
                System.out.println(so);
            }
        }
        System.out.println(mangSo);
    }
    }
