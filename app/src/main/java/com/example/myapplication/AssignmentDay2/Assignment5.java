package com.example.myapplication.AssignmentDay2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class HocSinh{
    protected String hoTen;
    protected int tuoi;
    protected String queQuan;
    protected String lop;

    public HocSinh(String hoTen, int tuoi, String queQuan, String lop) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
        this.lop = lop;
    }
}
class Main5{
    public static void main(String[] args) {
        List<HocSinh> danhSachHocSinhMoi = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập n học sinh mới");
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i<=n; i++ ){
            System.out.println("Nhập thông tin cho học sinh thứ " + (i + 1) + ":");
            System.out.println("Lớp: ");
            String lop = scanner.next();
            scanner.nextLine();

            System.out.println("Họ tên: ");
            String hoTen = scanner.next();
            scanner.nextLine();

            System.out.println("Tuổi: ");
            int tuoi = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Quê quán: ");
            String queQuan = scanner.next();
            scanner.nextLine();

            danhSachHocSinhMoi.add(new HocSinh(hoTen,tuoi,queQuan,lop));
        }
        //Hiển thị học sinh 20 tuổi
        for(HocSinh hocSinh : danhSachHocSinhMoi){
            if(hocSinh.tuoi == 20){
                System.out.println(hocSinh.hoTen);
            }
        }

        //Hiển thị học sinh 23 tuổi va que HN
        for (HocSinh hocsinh : danhSachHocSinhMoi){
            if(hocsinh.tuoi == 23 && hocsinh.queQuan.equals("Hà Nội")){
                System.out.println(hocsinh.hoTen);
            }
        }
    }
}

