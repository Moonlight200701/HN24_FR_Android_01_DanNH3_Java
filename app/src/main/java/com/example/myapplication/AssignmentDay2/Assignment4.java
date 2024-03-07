package com.example.myapplication.AssignmentDay2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Nguoi {
    protected String hoTen;
    protected String ngheNghiep;
    protected int tuoi;
    protected int soCMND;

    public Nguoi(String hoTen, String ngheNghiep, int tuoi, int soCMND) {
        this.hoTen = hoTen;
        this.ngheNghiep = ngheNghiep;
        this.tuoi = tuoi;
        this.soCMND = soCMND;
    }

    @Override
    public String toString() {
        return "Nguoi{" +
                "hoTen='" + hoTen + '\'' +
                ", ngheNghiep='" + ngheNghiep + '\'' +
                ", tuoi=" + tuoi +
                ", soCMND='" + soCMND + '\'' +
                '}';
    }
}

class HoDan{
    protected int soThanhVien;
    protected int soNha;
    protected List<Nguoi>thanhVienTrongNha;

    public HoDan(int soThanhVien, int soNha, List<Nguoi>thanhVienTrongNha) {
        this.soThanhVien = soThanhVien;
        this.soNha = soNha;
        this.thanhVienTrongNha = thanhVienTrongNha;
    }

    @Override
    public String toString() {
        return "HoDan{" +
                "soThanhVien=" + soThanhVien +
                ", soNha=" + soNha +
                ", thanhVienTrongNha=" + thanhVienTrongNha +
                '}';
    }
}

class KhuPho {
    List<HoDan> cacHoDan;
    public KhuPho(){
        cacHoDan = new ArrayList<>();
    }
    void themCacHoDan(HoDan hoDan){
        cacHoDan.add(hoDan);
    }
    public void hienThiThongTin(){
        for(HoDan hoDan : cacHoDan){
            System.out.println(hoDan.toString());
        }
    }
}

class Main4 {
    public static void main(String[] args) {
        KhuPho khuPho = new KhuPho();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số lượng hộ dân: ");
        int n = scanner.nextInt();
        scanner.nextLine(); //Xuong dong
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin cho hộ dân thứ " + (i + 1) + ":");
            System.out.println("Số nhà: ");
            int soNha = scanner.nextInt();

            System.out.println("Số thành viên: ");
            int soThanhVien = scanner.nextInt();
            scanner.nextLine();

            List<Nguoi> thanhVien = new ArrayList<>();

            for (int j = 0; j < soThanhVien; j++) {
                System.out.println("Nhập thông tin cho thành viên thứ " + (j + 1) + ":");
                System.out.println("Họ tên: ");
                String hoTen = scanner.next();
                scanner.nextLine();

                System.out.println("Tuổi: ");
                int tuoi = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Nghề nghiệp: ");
                String ngheNghiep = scanner.next();
                scanner.nextLine();

                System.out.println("Số CMND: ");
                int soCMND = scanner.nextInt();
                thanhVien.add(new Nguoi(hoTen, ngheNghiep,tuoi, soCMND));
            }

            HoDan hoDan = new HoDan(soThanhVien, soNha, thanhVien);
            khuPho.themCacHoDan(hoDan);
        }

        // Hiển thị thông tin của các hộ trong khu phố
        khuPho.hienThiThongTin();
    }
}

