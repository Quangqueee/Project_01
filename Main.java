import service.QuanLyKhachHang;
import service.QuanLyNhanVien;
import service.QuanLyPhong;
import service.QuanLyDichVu;
import service.ThanhToan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QuanLyKhachHang QuanLyKhachHang = new QuanLyKhachHang();
        QuanLyPhong QuanLyPhong = new QuanLyPhong();
        QuanLyDichVu QuanLyDichVu = new QuanLyDichVu();
        QuanLyNhanVien QuanLyNhanVien = new QuanLyNhanVien();
        ThanhToan ThanhToan = new ThanhToan();

        while (true) {
            System.out.println("\n|----------------------------|");
            System.out.println("| He Thong Quan Ly Khach San |");
            System.out.println("|----------------------------|");
            System.out.println("| 1. Quan Ly Khach Hang      |");
            System.out.println("| 2. Quan Ly Phong           |");
            System.out.println("| 3. Quan Ly Dich Vu         |");
            System.out.println("| 4. Dat Phong               |");
            System.out.println("| 5. Thanh Toan              |");
            System.out.println("| 6. Quan Ly Nhan Vien       |");
            System.out.println("| 7. Thoat                   |");
            System.out.println("|----------------------------|");
            System.out.print("Chon Chuc Nang: ");
            int chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    QuanLyKhachHang.MenuQuanLyKhachHang();
                    break;

                case 2:
                    QuanLyPhong.MenuQuanLyPhong();
                    break;

                case 3:
                    QuanLyDichVu.MenuQuanLyDichVu();
                    break;

                case 4:
                    QuanLyPhong.DatPhong(QuanLyKhachHang);
                    break;

                case 5:
                    ThanhToan.MenuThanhToan(QuanLyKhachHang, QuanLyPhong, QuanLyDichVu);
                    break;

                case 6:
                    QuanLyNhanVien.MenuQuanLyNhanVien();
                    break;
                case 7:
                    System.out.println("Thoat Chuong Trinh.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Chuc Nang Khong Hop Le. Vui Long Chon Lai.");
            }
        }
    }
}
