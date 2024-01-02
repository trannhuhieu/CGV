package com.example.cgv.muc.phim.adapter;

public class PHIM {
    private int id;
    private String ten, thoigian, noidung, kiemduyet, theloai, ngonngu;


    public PHIM(int id, String ten, String thoigian, String noidung, String kiemduyet, String theloai, String ngonngu) {
        this.id = id;
        this.ten = ten;
        this.thoigian = thoigian;
        this.noidung = noidung;
        this.kiemduyet = kiemduyet;
        this.theloai = theloai;
        this.ngonngu = ngonngu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getKiemduyet() {
        return kiemduyet;
    }

    public void setKiemduyet(String kiemduyet) {
        this.kiemduyet = kiemduyet;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getNgonngu() {
        return ngonngu;
    }

    public void setNgonngu(String ngonngu) {
        this.ngonngu = ngonngu;
    }
}
