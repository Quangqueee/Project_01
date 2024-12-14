package model;

public class DichVu {
    private String TenDichVu;
    private int Gia;

    public DichVu(String TenDichVu, int Gia) {
        this.TenDichVu = TenDichVu;
        this.Gia = Gia;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public void setTenDichVu(String TenDichVu) {
        this.TenDichVu = TenDichVu;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        this.Gia = gia;
    }
}
