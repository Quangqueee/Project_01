package model;

import java.util.ArrayList;

public class KhachHang {
    private String ten;
    private String SDT;
    private String CCCD;
    private ArrayList<String> LichSuDatPhong;

    public KhachHang(String ten, String SDT, String CCCD) {
        this.ten = ten;
        this.SDT = SDT;
        this.CCCD = CCCD;
        this.LichSuDatPhong = new ArrayList<>();
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public ArrayList<String> getLichSuDatPhong() {
        return LichSuDatPhong;
    }

    public void ThemPhongDaThue(String phong) {
        LichSuDatPhong.add(phong);
    }

}