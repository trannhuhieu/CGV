package com.example.cgv.muc.login.vecuatoi;

public class VE {
    String tenphim, ngaydat, bd, kt, ghe, tong, thoigiandat;

    public VE(String tenphim, String ngaydat, String bd, String kt, String ghe, String tong, String thoigiandat) {
        this.tenphim = tenphim;
        this.ngaydat = ngaydat;
        this.bd = bd;
        this.kt = kt;
        this.ghe = ghe;
        this.tong = tong;
        this.thoigiandat = thoigiandat;
    }


    public String getTenphim() {
        return tenphim;
    }

    public void setTenphim(String tenphim) {
        this.tenphim = tenphim;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getKt() {
        return kt;
    }

    public void setKt(String kt) {
        this.kt = kt;
    }

    public String getGhe() {
        return ghe;
    }

    public void setGhe(String ghe) {
        this.ghe = ghe;
    }

    public String getTong() {
        return tong;
    }

    public void setTong(String tong) {
        this.tong = tong;
    }

    public String getThoigiandat() {
        return thoigiandat;
    }

    public void setThoigiandat(String thoigiandat) {
        this.thoigiandat = thoigiandat;
    }
}
