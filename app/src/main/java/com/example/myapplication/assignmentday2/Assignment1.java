package com.example.myapplication.assignmentday2;

abstract class NhanVien {
    protected String hoTen;
    protected String ngaySinh;
    protected int luong;

    NhanVien(String hoTen, String ngaySinh) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }

    abstract double tinhLuong();
}

class NhanVienSanXuat extends NhanVien {
    private int soSanPham;

    NhanVienSanXuat(String hoTen, String ngaySinh, int soSanPham) {
        super(hoTen, ngaySinh);
        this.soSanPham = soSanPham;
    }

    @Override
    double tinhLuong() {
        return this.luong + this.soSanPham * 5000;
    }
}

class NhanVienVanPhong extends NhanVien {
    private int soNgayLamViec;

    NhanVienVanPhong(String hoTen, String ngaySinh, int soNgayLamViec) {
        super(hoTen, ngaySinh);
        this.soNgayLamViec = soNgayLamViec;
    }

    @Override
    double tinhLuong() {
        return this.soNgayLamViec * 100000;
    }
}

class Main{
    public static void main(String[] args) {
        NhanVien nv1 = new NhanVienSanXuat("Nguyen Hoang Dan", "20/07/2001",100);
        System.out.println(nv1.tinhLuong());
        NhanVien nv2 = new NhanVienVanPhong("Nguyen Hoang Bien", "20/09/2001", 30);
        System.out.println(nv2.tinhLuong());
    }
}
