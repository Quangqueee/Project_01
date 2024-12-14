package model;

public class Phong {
    private String SoPhong;
    private String LoaiPhong;
    private String TrangThai;

    public Phong(String SoPhong, String LoaiPhong, String TrangThai) {
        this.SoPhong = SoPhong;
        this.LoaiPhong = LoaiPhong;
        this.TrangThai = TrangThai;
    }


    public String getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(String SoPhong) {
        this.SoPhong = SoPhong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
}
