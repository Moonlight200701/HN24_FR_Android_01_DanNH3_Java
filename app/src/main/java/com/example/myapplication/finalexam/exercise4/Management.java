package com.example.myapplication.finalexam.exercise4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Management {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Contract> contactList = new ArrayList<>();

    public static boolean checkPhone(String phone) {
        for (Contract contract : contactList) {
            if (phone.equals(contract.getPhoneNumber()))
                return true;
        }
        return false;
    }

    public static void addContact() {
        String name = "", phone = "";
        System.out.println("Name: ");
        name = scanner.nextLine();
        System.out.println("Phone: ");
        phone = scanner.nextLine();
        if (!checkPhone(phone)) {
            contactList.add(new Contract(name, phone));
            System.out.println("Contact added successfully!");
        } else
            System.out.println("Contact existed, can not add!");
    }

    public static void displayContact() {
        if (contactList.isEmpty()) {
            System.out.println("Not found information");
        } else {
            Collections.sort(contactList, Comparator.comparing(Contract::getName));
            System.out.println("Contact List:");
            for (Contract contract : contactList) {
                contract.display();
            }
        }
    }

    public static void updateContact() {
        String name = "", phone = "";
        if (contactList.isEmpty()) {
            System.out.println("Not found information");
        } else {
            System.out.println("Name: ");
            name = scanner.nextLine();
            Contract contactToUpdate = null;
            for (Contract contact : contactList) {
                if (contact.getName().equals(name)) {
                    contactToUpdate = contact;
                    break;
                }
            }
            if (contactToUpdate == null) {
                System.out.println("Contact not found!");
            } else {
                System.out.println("Phone: ");
                phone = scanner.nextLine();
                if (!checkPhone(phone)) {
                    contactList.add(new Contract(name, phone));
                    System.out.println("Contact updated successfully!");
                } else
                    System.out.println("Number existed, can not update!");
            }
        }
    }

    public static void findContact() {
        if (contactList.isEmpty()) {
            System.out.println("Not found information");
        } else {
            System.out.println("Find after key words: ");
            String keyWord = scanner.nextLine();
            for (Contract contract : contactList) {
                if (contract.getName().contains(keyWord)) {
                    contract.display();
                }
            }
        }
    }

    public static void main(String[] args) {
        String choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Contract");
            System.out.println("2. Display Contract");
            System.out.println("3. Update Contract");
            System.out.println("4. Find Contract");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    displayContact();
                    break;
                case "3":
                    updateContact();
                    break;
                case "4":
                    findContact();
                    break;
                case "5":
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option! Please choose again.");
                    break;
            }
        } while (!choice.equals("5"));
    }
}
