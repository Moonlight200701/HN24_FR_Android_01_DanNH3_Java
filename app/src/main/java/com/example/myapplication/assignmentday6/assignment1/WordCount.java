package com.example.myapplication.assignmentday6.assignment1;

import com.example.myapplication.assignmentday6.Constants;

import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        File file = new File(Constants.FILE_PATH + "assignment1\\test.txt");
        HashSet<String> words = new HashSet<>();
        try  {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] wordArray = line.toLowerCase().split("\\s+");
                words.addAll(Arrays.asList(wordArray));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Number of words in the given file: " + words.size());
    }
}
