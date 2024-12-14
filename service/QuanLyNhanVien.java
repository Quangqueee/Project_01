package service;

import model.NhanVien;
import model.NhanVienThuong;
import model.QuanLy;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyNhanVien {
    private ArrayList<NhanVien> DanhSachNhanVien = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public QuanLyNhanVien() {
        DanhSachNhanVien = new ArrayList<>();

        DanhSachNhanVien.add(new NhanVienThuong(
                "Nguyen Van A", 24, "Ha Noi", "21-10-2000",
                "123456789012", "0912345678", 2.5, "Tap Vu"));

        DanhSachNhanVien.add(new NhanVienThuong(
                "Tran Thi B", 25, "Hai Phong", "15-08-1998",
                "098765432109", "0918765432", 2.0, "Ke Toan"));

        DanhSachNhanVien.add(new QuanLy(
                "Le Van L", 35, "Bac Giang", "12-05-1988",
                "112233445566", "0909123456", 3.5));

        DanhSachNhanVien.add(new NhanVienThuong(
                "Le Thi D", 28, "Ha Tay", "25-12-1996",
                "223344556677", "0912987654", 2.8, "Le Tan"));

        DanhSachNhanVien.add(new QuanLy(
                "Hoang Van E", 40, "Quang Ninh", "10-11-1983",
                "334455667788", "0909988776", 4.0));
    }

    public void ThemNhanVien() {
        System.out.println("Chon loai nhan vien:");
        System.out.println("1. Nhan vien thuong");
        System.out.println("2. Quan ly");
        System.out.print("Lua chon: ");
        int chon = sc.nextInt();
        sc.nextLine();

        String ten;
        while (true) {
            System.out.print("Nhap ten: ");
            ten = sc.nextLine();
            if (ten.matches("[a-zA-Z\\s]{1,50}")) {
                break;
            } else {
                System.out.println(
                        "Ten khong hop le! Vui long nhap lai (Chi chua chu va khoang trang, toi da 50 ky tu).");
            }
        }

        System.out.print("Nhap tuoi: ");
        int tuoi = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhap que quan: ");
        String que = sc.nextLine();

        String ngaysinh;
        while (true) {
            System.out.print("Nhap ngay sinh (DD/MM/YY): ");
            ngaysinh = sc.nextLine();
            if (ngaysinh.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            } else {
                System.out.println("Ngay sinh khong hop le! Vui long nhap lai.");
            }
        }

        String cccd;
        while (true) {
            System.out.print("Nhap so CCCD: ");
            cccd = sc.nextLine();
            if (cccd.matches("\\d{12}")) {
                break;
            } else {
                System.out.println("CCCD khong hop le! Vui long nhap lai.");
            }
        }

        String sdt;
        while (true) {
            System.out.print("Nhap so dien thoai: ");
            sdt = sc.nextLine();
            if (sdt.matches("0\\d{9}")) {
                break;
            } else {
                System.out.println("So dien thoai khong hop le! Vui long nhap lai.");
            }
        }

        System.out.print("Nhap he so luong: ");
        double hsl = sc.nextDouble();
        sc.nextLine();

        if (chon == 1) {
            System.out.print("Nhap bo phan lam viec: ");
            String bplv = sc.nextLine();
            DanhSachNhanVien.add(new NhanVienThuong(ten, tuoi, que, ngaysinh, cccd, sdt, hsl, bplv));
        } else if (chon == 2) {
            DanhSachNhanVien.add(new QuanLy(ten, tuoi, que, ngaysinh, cccd, sdt, hsl));
        }

        System.out.println("Them nhan vien thanh cong.");
    }

    public void HienThiNhanVien() {
        if (DanhSachNhanVien.isEmpty()) {
            System.out.println("Danh sach nhan vien trong.");
            return;
        }

        System.out.printf("%-5s %-20s %-5s %-15s %-12s %-11s %-15s %-10s %-20s\n",
                "STT", "Ten", "Tuoi", "Que Quan", "CCCD", "SDT", "Ngay Sinh", "HSL", "Bo Phan");

        System.out.println(
                "------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < DanhSachNhanVien.size(); i++) {
            NhanVien nv = DanhSachNhanVien.get(i);
            System.out.printf("%-5d %-20s %-5d %-15s %-12s %-11s %-15s %-10.1f %-20s\n",
                    i + 1,
                    nv.getTen(),
                    nv.getTuoi(),
                    nv.getQue(),
                    nv.getCCCD(),
                    nv.getSDT(),
                    nv.getNgaysinh(),
                    nv.getHsl(),
                    (nv instanceof NhanVienThuong) ? ((NhanVienThuong) nv).getBplv() : "Quan ly");
        }
    }

    public void TinhLuong() {
        System.out.print("Nhap ten hoac CCCD nhan vien: ");
        String key = sc.nextLine();

        ArrayList<NhanVien> KetQua = TimKiemNhanVien(key);

        if (KetQua.isEmpty()) {
            System.out.println("Khong tim thay nhan vien.");
            return;
        }

        NhanVien nv;
        if (KetQua.size() == 1) {
            nv = KetQua.get(0);
        } else {
            nv = ChonNhanVien(KetQua);
            if (nv == null) {
                System.out.println("Lua chon khong hop le.");
                return;
            }
        }

        System.out.print("Nhap so ngay cong: ");
        double NgayCong = sc.nextDouble();
        sc.nextLine(); 

        int luong = (int) nv.TinhLuong(NgayCong);
        System.out.printf("Luong cua %s: %d VND\n", nv.getTen(), luong);

    }

    public ArrayList<NhanVien> TimKiemNhanVien(String TuKhoa) {
        ArrayList<NhanVien> KetQua = new ArrayList<>();

        for (NhanVien nhanVien : DanhSachNhanVien) {
            if (nhanVien.getTen().toLowerCase().contains(TuKhoa.toLowerCase()) ||
                    nhanVien.getCCCD().contains(TuKhoa) ||
                    nhanVien.getSDT().contains(TuKhoa)) {
                KetQua.add(nhanVien);
            }
        }
        return KetQua;
    }

    // Hàm hiển thị danh sách kết quả tìm kiếm để chọn nhân viên cụ thể
    private NhanVien ChonNhanVien(ArrayList<NhanVien> KetQua) {
        if (KetQua.isEmpty()) {
            System.out.println("Khong tim thay nhan vien.");
            return null;
        }

        if (KetQua.size() == 1) {
            return KetQua.get(0); // Nếu chỉ có một kết quả, trả về trực tiếp
        }

        // Hiển thị danh sách nhân viên tìm thấy
        System.out.println("Co nhieu nhan vien khop voi tu khoa. Vui long chon:");
        for (int i = 0; i < KetQua.size(); i++) {
            NhanVien nv = KetQua.get(i);
            System.out.printf("%d. %s - CCCD: %s - SDT: %s\n",
                    i + 1, nv.getTen(), nv.getCCCD(), nv.getSDT());
        }

        System.out.print("Nhap STT nhan vien can chon: ");
        int chon = sc.nextInt();
        sc.nextLine();

        if (chon < 1 || chon > KetQua.size()) {
            System.out.println("Lua chon khong hop le.");
            return null;
        }

        return KetQua.get(chon - 1);
    }

    public void SuaNhanVien() {
        System.out.print("Nhap ten hoac CCCD nhan vien can sua: ");
        String key = sc.nextLine();
        ArrayList<NhanVien> KetQua = TimKiemNhanVien(key);

        NhanVien nv = ChonNhanVien(KetQua);
        if (nv == null) {
            return;
        }

        // Nhập và kiểm tra tên mới
        String tenMoi;
        while (true) {
            System.out.print("Nhap ten moi: ");
            tenMoi = sc.nextLine();
            if (tenMoi.matches("[a-zA-Z\\s]{1,50}")) {
                break;
            } else {
                System.out.println("Ten khong hop le. Vui long nhap lai.");
            }
        }
        nv.setTen(tenMoi);

        // Nhập và kiểm tra tuổi mới
        int tuoiMoi;
        while (true) {
            try {
                System.out.print("Nhap tuoi moi: ");
                tuoiMoi = Integer.parseInt(sc.nextLine()); // Chuyen chuoi sang kieu so nguyen
                if (tuoiMoi > 0 && tuoiMoi <= 100) {
                    break;
                } else {
                    System.out.println("Tuoi khong hop le. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen hop le.");
            }
        }
        nv.setTuoi(tuoiMoi);

        // Nhập quê quán mới
        System.out.print("Nhap que quan moi: ");
        String queMoi = sc.nextLine();
        nv.setQue(queMoi);

        // Nhập và kiểm tra số điện thoại mới
        String sdtMoi;
        while (true) {
            System.out.print("Nhap so dien thoai moi: ");
            sdtMoi = sc.nextLine();
            if (sdtMoi.matches("0\\d{9}")) {
                break;
            } else {
                System.out.println("So dien thoai khong hop le. Vui long nhap lai.");
            }
        }
        nv.setSDT(sdtMoi);

        // Nhập và kiểm tra CCCD mới
        String cccdMoi;
        while (true) {
            System.out.print("Nhap so CCCD moi: ");
            cccdMoi = sc.nextLine();
            if (cccdMoi.matches("\\d{12}")) {
                break;
            } else {
                System.out.println("So CCCD khong hop le. Vui long nhap lai.");
            }
        }
        nv.setCCCD(cccdMoi);

        double hslMoi;
        while (true) {
            try {
                System.out.print("Nhap he so luong moi: ");
                hslMoi = Double.parseDouble(sc.nextLine());
                if (hslMoi > 0) {
                    break;
                } else {
                    System.out.println("He so luong phai lon hon 0. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so thuc hop le.");
            }
        }
        nv.setHsl(hslMoi);

        if (nv instanceof NhanVienThuong) {
            System.out.print("Nhap bo phan lam viec moi: ");
            String boPhanMoi = sc.nextLine();
            ((NhanVienThuong) nv).setBplv(boPhanMoi);
        }

        System.out.println("Cap nhat thong tin thanh cong.");
    }

    public void XoaNhanVien() {
        System.out.print("Nhap ten hoac CCCD nhan vien can xoa: ");
        String key = sc.nextLine();
        ArrayList<NhanVien> KetQua = TimKiemNhanVien(key);

        NhanVien nv = ChonNhanVien(KetQua);
        if (nv == null) {
            return;
        }

        DanhSachNhanVien.remove(nv);
        System.out.println("Xoa nhan vien thanh cong.");
    }

    public void MenuQuanLyNhanVien() {
        while (true) {
            System.out.println("\n|------------------------|");
            System.out.println("| Quan ly nhan vien      |");
            System.out.println("|------------------------|");
            System.out.println("| 1. Them nhan vien      |");
            System.out.println("| 2. Hien thi danh sach  |");
            System.out.println("| 3. Tinh luong nhan vien|");
            System.out.println("| 4. Xoa nhan vien       |");
            System.out.println("| 5. Sua nhan vien       |");
            System.out.println("| 6. Quay lai            |");
            System.out.println("|------------------------|");
            System.out.print("Chon chuc nang: ");
            int chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    ThemNhanVien();
                    break;
                case 2:
                    HienThiNhanVien();
                    break;
                case 3:
                    TinhLuong();
                    break;
                case 4:
                    XoaNhanVien();
                    break;
                case 5:
                    SuaNhanVien();
                    break;
                case 6:
                    System.out.println("Quay lai menu chinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

}
