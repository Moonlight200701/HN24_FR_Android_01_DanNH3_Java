package com.example.myapplication.assignmentday4.assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();
    private static final String ngayThangNam = "^\\d{2}/\\d{2}/\\d{4}$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Muốn làm gì? (thêm/hiển thị/cập nhật/tìm kiếm/thoát): ");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "thêm":
                    themNhanVien(scanner);
                    break;
                case "hiển thị":
                    hienThiNhanVien();
                    break;
                case "cập nhật":
                    capNhatNhanVien(scanner);
                    break;
                case "tìm kiếm":
                    timNhanVien(scanner);
                    break;
                case "thoát":
                    return;
                default:
                    System.out.println("Hành động không hợp lệ , chọn 1 trong các lựa chọn: thêm/hiển thị/cập nhật/tìm kiếm/thoát.");
                    break;
            }
        }
    }

    private static void themNhanVien(Scanner scanner) {
        System.out.println("Nhập tên nhân viên ");
        String ten = scanner.nextLine();

        System.out.println("Giới tính (nam/nữ): ");
        String gioiTinh = scanner.nextLine().toLowerCase();
        while (!gioiTinh.equals("nam") && !gioiTinh.equals("nữ")) {
            System.out.println("Sai giới tính, nhập lại.");
            System.out.println("Giới tính (nam/nữ): ");
            gioiTinh = scanner.nextLine().toLowerCase();
        }

        System.out.println("Ngày tháng năm sinh");
        String ngayThangNamSinh;
        while (true) {
            ngayThangNamSinh = scanner.next();
            if(ngayThangNamSinh.length()==10 && ngayThangNamSinh.matches(ngayThangNam)){
                scanner.nextLine();
                break;
            }
            System.out.println("Không hợp lệ, hãy nhập như sau: dd/mm/yyyy.");
            System.out.println("Ngày tháng năm sinh: ");

        }

        System.out.println("Nhập số điện thoại");
        String soDienThoai = scanner.nextLine();

        System.out.println("Trình độ chuyên môn (Trung cấp/Cao đẳng/Đại học): ");
        String trinhDoChuyenMon = scanner.nextLine().toLowerCase();
        while (!trinhDoChuyenMon.equals("trung cấp") && !trinhDoChuyenMon.equals("cao đẳng") && !trinhDoChuyenMon.equals("đại học")) {
            System.out.println("Không hợp lệ. Chọn 1 trong 3: 'Trung cấp', 'Cao đẳng', hoặc 'Đại học'.");
            System.out.println("Trình độ chuyên môn (Trung cấp/Cao đẳng/Đại học): ");
            trinhDoChuyenMon = scanner.nextLine().toLowerCase();
        }

        NhanVien newNhanVien = new NhanVien(ten, gioiTinh, ngayThangNamSinh, soDienThoai, trinhDoChuyenMon);
        danhSachNhanVien.add(newNhanVien);
        System.out.println("Thêm nhân viên thành công");
    }

    private static void hienThiNhanVien() {
        if (danhSachNhanVien.isEmpty()) {
            System.out.println("Không tìm thấy thông tin");
        } else {
            for (NhanVien nhanVien : danhSachNhanVien) {
                hienThiThongTinNhanVien(nhanVien);
            }
        }
    }

    private static void capNhatNhanVien(Scanner scanner) {
        System.out.print("Nhập Id Nhân viên muốn update ");
        int idDaNhap = scanner.nextInt();
        scanner.nextLine();

        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien.nhanVienId == idDaNhap) {
                System.out.println("Thông tin hiện tại: ");
                hienThiThongTinNhanVien(nhanVien);

                System.out.println("Thông tin mới: ");

                System.out.print("Tên: ");
                String ten = scanner.nextLine();

                System.out.print("Giới tính (Nam/Nữ): ");
                String gioiTinh = scanner.nextLine().toLowerCase();
                while (!gioiTinh.equals("nam") && !gioiTinh.equals("nữ")) {
                    System.out.println("Sai giới tính, nhập lại.");
                    System.out.print("Giới tính (Nam/Nữ): ");
                    gioiTinh = scanner.nextLine().toLowerCase();
                }

                System.out.print("Ngày tháng năm sinh: ");
                String ngayThangNam = scanner.nextLine();
                while (ngayThangNam.length() != 10) {
                    System.out.println("Không hợp lệ, hãy nhập như sau: dd/mm/yyyy.");
                    System.out.print("Ngày tháng năm sinh:");
                    ngayThangNam = scanner.nextLine();
                }

                System.out.print("Số điện thoại: ");
                String dienThoai = scanner.nextLine();

                System.out.print("Trình độ chuyên môn (Trung cấp/Cao đẳng/Đại học): ");
                String trinhDoChuyenMon = scanner.nextLine().toLowerCase();
                while (!trinhDoChuyenMon.equals("trung cấp") && !trinhDoChuyenMon.equals("cao đẳng") && !trinhDoChuyenMon.equals("đại học")) {
                    System.out.println("Không hợp lệ. Chọn 1 trong 3: 'Trung cấp', 'Cao đẳng', hoặc 'Đại học'.");
                    System.out.print("Trình độ chuyên môn (Trung cấp/Cao đẳng/Đại học): ");
                    trinhDoChuyenMon = scanner.nextLine().toLowerCase();
                }

                nhanVien.ten = ten;
                nhanVien.gioiTinh = gioiTinh;
                nhanVien.ngayThangNamSinh = ngayThangNam;
                nhanVien.dienThoai = dienThoai;
                nhanVien.trinhDoChuyenMon = trinhDoChuyenMon;

                System.out.println("Cập nhật thông tin thành công. ");
                System.out.println("Thông tin mới: ");
                hienThiThongTinNhanVien(nhanVien);

                return;
            }
        }
    }

    private static void timNhanVien(Scanner scanner) {
        if (danhSachNhanVien.isEmpty()) {
            System.out.println("Không tìm thấy nhân viên");
        } else {
            System.out.print("Nhập Id nhân viên muốn tìm");
            String idDaNhap = scanner.nextLine().toLowerCase();
            while(idDaNhap.equals("")){
                System.out.println("Hãy nhập thông tin ");
                System.out.println("Nhập id nhân viên muốn tìm");
                idDaNhap = scanner.nextLine().toLowerCase();
            }

            boolean timThay = false;
            for (NhanVien nhanVien : danhSachNhanVien) {
                if (String.valueOf(nhanVien.nhanVienId).equals(idDaNhap) || nhanVien.ten.toLowerCase().contains(idDaNhap)) {
                    timThay = true;
                    hienThiThongTinNhanVien(nhanVien);
                }
            }

            if (!timThay) {
                System.out.println("Không tìm thấy nhân viên");
            }
        }
    }

    private static void hienThiThongTinNhanVien(NhanVien nhanVien) {
        System.out.println("Id nhân viên: " + nhanVien.nhanVienId);
        System.out.println("Tên: " + nhanVien.ten);
        System.out.println("Giới tính: " + nhanVien.gioiTinh);
        System.out.println("Ngày tháng năm sinh: " + nhanVien.ngayThangNamSinh);
        System.out.println("Số điện thoại: " + nhanVien.dienThoai);
        System.out.println("Trình độ chuyên môn: " + nhanVien.trinhDoChuyenMon);
        System.out.println("-----------");
    }
}

