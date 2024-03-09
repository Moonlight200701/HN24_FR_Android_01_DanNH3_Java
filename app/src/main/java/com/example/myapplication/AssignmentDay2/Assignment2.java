package com.example.myapplication.AssignmentDay2;


class KhachHang {
    protected int soLuong;
    protected double donGia;

    public KhachHang(int soLuong, double donGia) {
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

     double tinhToanChiPhi() {
        return soLuong * donGia;
    }
}

class KhachHangBinhThuong extends KhachHang {
    public KhachHangBinhThuong(int soLuong, double donGia) {
        super(soLuong, donGia);
    }

    @Override
    double tinhToanChiPhi() {
        double total = super.tinhToanChiPhi();
        return total + total * 0.1; // VAT 10%
    }
}

class KhachHangThanThiet extends KhachHang{
    private int years;

    public KhachHangThanThiet(int soLuong, double donGia, int nam) {
        super(soLuong, donGia);
        this.years = nam;
    }

    @Override
    double tinhToanChiPhi() {
        double giamGia = Math.min(years * 0.05, 0.5);
        double tongTien = super.tinhToanChiPhi() * (1 - giamGia);
        return tongTien + tongTien * 0.1; // VAT 10%
    }
}

class KhachHangDacBiet extends KhachHang {
    public KhachHangDacBiet(int soLuong, double donGia) {
        super(soLuong, donGia);
    }

    @Override
    double tinhToanChiPhi() {
        double tongTien = super.tinhToanChiPhi() * 0.5;
        return tongTien + tongTien * 0.1; // VAT 10%
    }
}

class Main2 {
    public static void main(String[] args) {
        KhachHang khachHang1 = new KhachHangBinhThuong(10,1000);
        double giaKhach1PhaiTra = khachHang1.tinhToanChiPhi();
        KhachHang khachHang2 = new KhachHangThanThiet(10,1000, 2);
        double giaKhach2PhaiTra = khachHang2.tinhToanChiPhi();
        KhachHang khachHang3 = new KhachHangDacBiet(10,1000);
        double giaKhach3PhaiTra = khachHang3.tinhToanChiPhi();
        System.out.println("" +
                "Giá khách hàng bình thường phải trả: " + giaKhach1PhaiTra +"\n" +
                "Giá khách hàng thân thiết phải trả:" + giaKhach2PhaiTra + "\n"+
                "Giá khách hàng đặc biệt phải trả: " + giaKhach3PhaiTra + "\n"+
                "TỔng số tiền công ty thu được là " + giaKhach1PhaiTra+ "*x +" + giaKhach2PhaiTra + "*y +" + giaKhach3PhaiTra + "*z");
    }
}
