package com.example.myapplication.AssignmentDay4.Assignment3;

class NhanVien {
    static int nextId = 1;
    int nhanVienId;
    String ten;
    String gioiTinh;
    String ngayThangNamSinh;
    String dienThoai;
    String trinhDoChuyenMon;

    public NhanVien(String ten, String gioiTinh, String ngayThangNamSinh, String dienThoai, String trinhDoChuyenMon) {
        this.nhanVienId = nextId++;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngayThangNamSinh = ngayThangNamSinh;
        this.dienThoai = dienThoai;
        this.trinhDoChuyenMon = trinhDoChuyenMon;
    }
}


