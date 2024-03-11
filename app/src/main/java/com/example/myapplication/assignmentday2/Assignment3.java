package com.example.myapplication.assignmentday2;

class PhongKhachSan{
    protected int soDem;
    protected int phiDichVu;

    public PhongKhachSan(int soDem, int phiDichVu) {
        this.soDem = soDem;
        this.phiDichVu = phiDichVu;
    }
    double tinhDoanhThu(){
        return 0;
    }
}

class PhongDeluxe extends PhongKhachSan {

    public PhongDeluxe(int soDem, int phiDichVu) {
        super(soDem, phiDichVu);
    }
    double tinhDoanhThu(){
        return (soDem * 750000 + phiDichVu) * 1.05;
    }
}

class PhongPremium extends PhongKhachSan {

    public PhongPremium(int soDem, int phiDichVu) {
        super(soDem, phiDichVu);
    }
    double tinhDoanhThu(){
        return (soDem * 500000 + phiDichVu) * 1.05;
    }
}

class PhongBusiness extends PhongKhachSan {

    public PhongBusiness(int soDem, int phiDichVu) {
        super(soDem, phiDichVu);
    }
    double tinhDoanhThu(){
        return soDem * 30000;
    }
}

class Main3 {
    public static void main(String[] args) {
        PhongKhachSan phong1thang1 = new PhongDeluxe(6,30000);
        PhongKhachSan phong1thang2 = new PhongDeluxe(5,30000);
        PhongKhachSan phong2thang1 = new PhongPremium(10,20000);
        PhongKhachSan phong2thang2 = new PhongPremium(4,20000);
        PhongKhachSan phong3thang1 = new PhongBusiness(8,30000);
        PhongKhachSan phong3thang2 = new PhongBusiness(7,30000);

        System.out.println("Doanh thu phòng Deluxe tháng 1" + phong1thang1.tinhDoanhThu() + ", Doanh thu phòng Deluxe tháng 2: "+phong1thang2.tinhDoanhThu());
        System.out.println("Doanh thu phòng Premium tháng 1" + phong2thang1.tinhDoanhThu() + ", Doanh thu phòng Premium tháng 2: "+phong2thang2.tinhDoanhThu());
        System.out.println("Doanh thu phòng Business tháng 1" + phong3thang1.tinhDoanhThu() + ", Doanh thu phòng Business tháng 2: "+phong3thang2.tinhDoanhThu());

        if(phong1thang2.tinhDoanhThu() >= phong1thang1.tinhDoanhThu()*1.25){
            System.out.println("Phòng Deluxe có doanh thu vượt trội");
        }
        if(phong2thang2.tinhDoanhThu() >= phong2thang1.tinhDoanhThu()*1.25){
            System.out.println("Phòng Premium có doanh thu vượt trội");
        }
        if(phong3thang2.tinhDoanhThu() >= phong3thang1.tinhDoanhThu()*1.25){
            System.out.println("Phòng Business có doanh thu vượt trội");
        }

    }
}
