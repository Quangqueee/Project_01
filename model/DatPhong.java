package model;

import java.util.Date;

public class DatPhong {
    private Phong Phong;
    private KhachHang KhachHang;
    private Date NgayDat;
    private Date NgayTra;

    public DatPhong(Phong phong, KhachHang KhachHang, Date NgayDat, Date NgayTra) {
        this.Phong = phong;
        this.KhachHang = KhachHang;
        this.NgayDat = NgayDat;
        this.NgayTra = NgayTra;
    }


    public Phong getPhong() {
        return Phong;
    }

    public void setPhong(Phong phong) {
        this.Phong = phong;
    }

    public KhachHang getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(KhachHang KhachHang) {
        this.KhachHang = KhachHang;
    }

    public Date getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }
}
