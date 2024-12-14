package model;

public abstract class NhanVien {
    protected String ten;
    protected int tuoi;
    protected String que;
    protected String ngaysinh;
    protected String cccd;
    protected String sdt;
    protected double hsl;

    public NhanVien(String ten, int tuoi, String que, String ngaysinh, String cccd, String sdt, double hsl) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.que = que;
        this.ngaysinh = ngaysinh;
        this.cccd = cccd;
        this.sdt = sdt;
        this.hsl = hsl;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String queQuan) {
        this.que = queQuan;
    }

    public String getCCCD() {
        return cccd;
    }

    public void setCCCD(String cccd) {
        this.cccd = cccd;
    }

    public String getSDT() {
        return sdt;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaySinh) {
        this.ngaysinh = ngaySinh;
    }

    public double getHsl() {
        return hsl;
    }

    public void setHsl(double hsl) {
        this.hsl = hsl;
    }

    public abstract double TinhLuong(double NgayCong);

    @Override
    public String toString() {
        return "Nhan vien: " + ten + ", Tuoi: " + tuoi + ", Que quan: " + que +
                ", Ngay sinh: " + ngaysinh + ", CCCD: " + cccd + ", SDT: " + sdt +
                ", He so luong: " + hsl;
    }
}
