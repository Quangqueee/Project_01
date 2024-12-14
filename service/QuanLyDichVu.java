package service;

import model.DichVu;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyDichVu {
    private ArrayList<DichVu> DanhSachDichVu;

    public ArrayList<DichVu> getDanhSachDichVu() {
        return DanhSachDichVu;
    }

    public QuanLyDichVu() {
        DanhSachDichVu = new ArrayList<>();
        DanhSachDichVu.add(new DichVu("An sang", 100000));
        DanhSachDichVu.add(new DichVu("Dua don", 200000));
        DanhSachDichVu.add(new DichVu("Giat ui", 50000));
        DanhSachDichVu.add(new DichVu("Spa", 300000));
    }

    public void HienThiDichVu() {
        if (DanhSachDichVu.isEmpty()) {
            System.out.println("Danh sach dich vu trong.");
            return;
        }
        System.out.println("Danh sach dich vu:");
        int i = 1;
        for (DichVu dv : DanhSachDichVu) {
            System.out.println(i++ + ": " + dv.getTenDichVu() + " - Gia tien: " + dv.getGia());
        }
    }

    public ArrayList<DichVu> TimKiemDichVu(String TenDichVu) {
        ArrayList<DichVu> KetQua = new ArrayList<>();
        for (DichVu dv : DanhSachDichVu) {
            if (dv.getTenDichVu().toLowerCase().contains(TenDichVu.toLowerCase())) {
                KetQua.add(dv);
            }
        }
        return KetQua;
    }

    public void ThemDichVu() {
        Scanner sc = new Scanner(System.in);
        String TenDichVu;

        // Kiểm tra tên dịch vụ
        while (true) {
            System.out.print("Nhap ten dich vu: ");
            TenDichVu = sc.nextLine().trim();
            if (TenDichVu.matches("[a-zA-Z\\s]{1,50}")) {
                break;
            } else {
                System.out.println("Ten dich vu khong hop le. Vui long nhap lai.");
            }
        }

        int gia;
        while (true) {
            System.out.print("Nhap gia dich vu: ");
            try {
                gia = Integer.parseInt(sc.nextLine().trim());
                if (gia > 0) {
                    break;
                } else {
                    System.out.println("Gia phai la so duong. Vui long nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Gia khong hop le. Vui long nhap lai.");
            }
        }

        DanhSachDichVu.add(new DichVu(TenDichVu, gia));
        System.out.println("Them dich vu thanh cong.");
    }

    public void XoaDichVu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten dich vu can xoa: ");
        String key = sc.nextLine();

        ArrayList<DichVu> KetQua = TimKiemDichVu(key);
        if (KetQua.isEmpty()) {
            System.out.println("Khong tim thay dich vu nao.");
            return;
        }

        System.out.println("Chon dich vu muon xoa:");
        for (int i = 0; i < KetQua.size(); i++) {
            DichVu dv = KetQua.get(i);
            System.out.println((i + 1) + ". " + dv.getTenDichVu() + " - Gia: " + dv.getGia());
        }

        System.out.print("Nhap so thu tu dich vu can xoa: ");
        int chon = sc.nextInt();
        sc.nextLine();

        if (chon < 1 || chon > KetQua.size()) {
            System.out.println("Lua chon khong hop le.");
            return;
        }

        DichVu dv = KetQua.get(chon - 1);
        DanhSachDichVu.remove(dv);
        System.out.println("Xoa dich vu thanh cong.");
    }

    public void SuaDichVu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten dich vu can sua: ");
        String key = sc.nextLine();

        ArrayList<DichVu> KetQua = TimKiemDichVu(key);
        if (KetQua.isEmpty()) {
            System.out.println("Khong tim thay dich vu nao.");
            return;
        }

        System.out.println("Chon dich vu muon sua:");
        for (int i = 0; i < KetQua.size(); i++) {
            DichVu dv = KetQua.get(i);
            System.out.println((i + 1) + ". " + dv.getTenDichVu() + " - Gia: " + dv.getGia());
        }

        System.out.print("Nhap so thu tu dich vu can sua: ");
        int chon = sc.nextInt();
        sc.nextLine(); 

        if (chon < 1 || chon > KetQua.size()) {
            System.out.println("Lua chon khong hop le.");
            return;
        }

        DichVu dv = KetQua.get(chon - 1);

        System.out.print("Nhap ten dich vu moi: ");
        String TenMoi = sc.nextLine();

        System.out.print("Nhap gia dich vu moi: ");
        int GiaMoi = sc.nextInt();
        sc.nextLine(); 

        dv.setTenDichVu(TenMoi);
        dv.setGia(GiaMoi);

        System.out.println("Cap nhat dich vu thanh cong.");
    }

    public void MenuQuanLyDichVu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n|----------------------|");
            System.out.println("| Quan ly dich vu      |");
            System.out.println("|----------------------|");
            System.out.println("| 1. Hien thi dich vu  |");
            System.out.println("| 2. Them dich vu      |");
            System.out.println("| 3. Xoa dich vu       |");
            System.out.println("| 4. Sua dich vu       |");
            System.out.println("| 5. Quay lai          |");
            System.out.println("|----------------------|");
            System.out.print("Chon chuc nang: ");
            int chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    HienThiDichVu();
                    break;
                case 2:
                    ThemDichVu();
                    break;
                case 3:
                    XoaDichVu();
                    break;
                case 4:
                    SuaDichVu();
                    break;
                case 5:
                    System.out.println("Quay lai menu chinh.");
                    return;
                default:
                    System.out.println("Chuc nang khong hop le.");
            }
        }
    }
}
