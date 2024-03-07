package com.example.myapplication.AssignmentDay3;

public class Assignment5 {
    public static void main(String[] args) {
        String motStringBatKy = null;
        try{
            System.out.println(motStringBatKy.length());
        }catch (NullPointerException nullPointerException){
            System.out.println("String làm gì có gì !!!!");
        }
    }
}
