package model;

public class QuanLy extends NhanVien {
    public QuanLy(String ten, int tuoi, String que, String ngaysinh,
            String cccd, String sdt, double hsl) {
        super(ten, tuoi, que, ngaysinh, cccd, sdt, hsl);
    }

    @Override
    public double TinhLuong(double NgayCong) {
        return NgayCong * hsl * 2000;
    }
}
