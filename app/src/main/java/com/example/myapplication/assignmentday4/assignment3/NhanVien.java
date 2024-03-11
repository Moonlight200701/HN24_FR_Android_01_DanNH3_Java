package com.example.myapplication.assignmentday4.assignment3;

class NhanVien {
    static int Id = 1;
    int nhanVienId;
    String ten;
    String gioiTinh;
    String ngayThangNamSinh;
    String dienThoai;
    String trinhDoChuyenMon;

    public NhanVien(String ten, String gioiTinh, String ngayThangNamSinh, String dienThoai, String trinhDoChuyenMon) {
        this.nhanVienId = Id++;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngayThangNamSinh = ngayThangNamSinh;
        this.dienThoai = dienThoai;
        this.trinhDoChuyenMon = trinhDoChuyenMon;
    }
}


