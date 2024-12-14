package model;

public class NhanVienThuong extends NhanVien {
    private String bplv; 

    public NhanVienThuong(String ten, int tuoi, String que, String ngaysinh,
            String cccd, String sdt, double hsl, String bplv) {
        super(ten, tuoi, que, ngaysinh, cccd, sdt, hsl);
        this.bplv = bplv;
    }

    public String getBplv() {
        return bplv;
    }

    public void setBplv(String bplv) {
        this.bplv = bplv;
    }

    @Override
    public double TinhLuong(double NgayCong) {
        return getHsl() * 1000 * NgayCong;
    }


    @Override
    public String toString() {
        return super.toString() + ", Bo phan: " + bplv;
    }
}
