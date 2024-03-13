package com.example.myapplication.assignmentday6.assignment5;

import com.example.myapplication.assignmentday6.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class StudentManagement {
    private static final String fileName = Constants.FILE_PATH + "assigment5\\student.txt";

    private static final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        loadStudent();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Add Student");
            System.out.println("2. Update student based on student Id");
            System.out.println("3. Delete student based on student Id");
            System.out.println("4. Order students by name");
            System.out.println("5. Order students by gpa");
            System.out.println("6. Display all students info");
            System.out.println("0. Exit");
            System.out.print("You must choose, Mr Sparrow: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc và loại bỏ dòng mới
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    updateStudent(scanner);
                    break;
                case 3:
                    deleteStudent(scanner);
                    break;
                case 4:
                    orderStudentByName();
                    break;
                case 5:
                    orderStudentByGPA();
                    break;
                case 6:
                    displayStudentsInfo();
                    break;
                case 0:
                    System.out.println("System shut down.");
                    break;
                default:
                    System.out.println("That's not a choice.");
            }
        } while (choice != 0);
    }

    private static void loadStudent() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String studentId = parts[0];
                String studentName = parts[1];
                int studentAge = Integer.parseInt(parts[2]);
                String studentAddress = parts[3];
                float studentGPA = Float.parseFloat(parts[4]);
                Student student = new Student(studentId, studentName, studentAge, studentAddress, studentGPA);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addStudent(Scanner scanner) {
        String studentName, studentAddress;
        System.out.println("Nhập mã sinh viên: ");
        String studentId = scanner.nextLine();

        System.out.println("Nhập họ tên (không có dấu cách): ");
        do{
            studentName = scanner.nextLine();

            if (studentName.contains(" ")) {
                System.out.println("Chuỗi không được chứa dấu cách. Vui lòng nhập lại.");
            }
        }while (studentName.contains(" "));

        int tuoi;
        do {
            System.out.print("Nhập tuổi: ");
            while (!scanner.hasNextInt()) { // Kiểm tra xem nhập vào có phải là số không
                System.out.println("Vui lòng nhập tuổi là một số nguyên.");
                scanner.next(); // Đọc và bỏ qua giá trị không hợp lệ
            }
            tuoi = scanner.nextInt();
            scanner.nextLine(); // Đọc và loại bỏ dòng mới

            if (tuoi <= 0) {
                System.out.println("Tuổi phải lớn hơn 0. Vui lòng nhập lại.");
            }
        } while (tuoi <= 0);

        System.out.println("Nhập địa chỉ (không có dấu cách): ");
        do{
            studentAddress = scanner.nextLine();

            if (studentAddress.contains(" ")) {
                System.out.println("Chuỗi không được chứa dấu cách. Vui lòng nhập lại.");
            }
        }while (studentAddress.contains(" "));

        float diemTB;
        do {
            System.out.println("Nhập điểm trung bình: ");
            while (!scanner.hasNextFloat()) { // Kiểm tra xem nhập vào có phải là số không
                System.out.println("Vui lòng nhập điểm trung bình là một số dương.");
                scanner.next(); // Đọc và bỏ qua giá trị không hợp lệ
            }
            diemTB = scanner.nextFloat();
            scanner.nextLine(); // Đọc và loại bỏ dòng mới

            if (diemTB <= 0) {
                System.out.println("Tuổi phải lớn hơn 0. Vui lòng nhập lại.");
            }
        } while (diemTB <= 0);

        Student student = new Student(studentId, studentName, tuoi, studentAddress, diemTB);
        students.add(student);
        ghiSinhVienVaoFile(student);
        System.out.println("Thêm sinh viên thành công.");
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần sửa: ");
        String maSVCanSua = scanner.nextLine();
        Student studentNeedsToUpdate = timSinhVienTheoMa(maSVCanSua);
        if (studentNeedsToUpdate != null) {
            System.out.println("Nhập thông tin mới của sinh viên:");
            System.out.print("Họ tên: ");
            studentNeedsToUpdate.setName(scanner.nextLine());
            System.out.print("Tuổi: ");
            studentNeedsToUpdate.setAge(scanner.nextInt());
            scanner.nextLine(); // Đọc và loại bỏ dòng mới
            System.out.print("Địa chỉ: ");
            studentNeedsToUpdate.setAddress(scanner.nextLine());
            System.out.print("Điểm trung bình: ");
            studentNeedsToUpdate.setGpa(scanner.nextFloat());
            scanner.nextLine(); // Đọc và loại bỏ dòng mới

            ghiLaiFile();
            System.out.println("Sửa sinh viên thành công.");
        } else {
            System.out.println("Không tìm thấy sinh viên có mã " + maSVCanSua);
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String maSVCanXoa = scanner.nextLine();
        Student studentNeedsToDelete = timSinhVienTheoMa(maSVCanXoa);
        if (studentNeedsToDelete != null) {
            students.remove(studentNeedsToDelete);
            ghiLaiFile();
            System.out.println("Xóa sinh viên thành công.");
        } else {
            System.out.println("Không tìm thấy sinh viên có mã " + maSVCanXoa);
        }
    }

    private static void orderStudentByName() {
        Collections.sort(students, Comparator.comparing(Student::getName));
        displayStudentsInfo();
    }

    private static void orderStudentByGPA() {
        Collections.sort(students, Comparator.comparingDouble(Student::getGpa).reversed());
        displayStudentsInfo();
    }

    private static void displayStudentsInfo() {
        System.out.println("------Student Info------");
        for (Student student: students) {
            System.out.println(student);
        }
    }

    private static Student timSinhVienTheoMa(String maSV) {
        for (Student student : students) {
            if (student.getStudentId().equals(maSV)) {
                return student;
            }
        }
        return null;
    }

    private static void ghiSinhVienVaoFile(Student student) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(student.getStudentId() + " " + student.getName() + " " + student.getAge() + " " + student.getAddress() + " " + student.getGpa() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ghiLaiFile() {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student student : students) {
                writer.write(student.getStudentId() + " " + student.getName() + " " + student.getAge() + " " + student.getAddress() + " " + student.getGpa() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}