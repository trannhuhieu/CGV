package com.example.cgv.muc.tintuc.Adapter;

public class TINTUC {
    int imgTin;
    String textTieude, textNoidung;

    public TINTUC(int imgTin, String textTieude, String textNoidung) {
        this.imgTin = imgTin;
        this.textTieude = textTieude;
        this.textNoidung = textNoidung;
    }

    public int getImgTin() {
        return imgTin;
    }

    public void setImgTin(int imgTin) {
        this.imgTin = imgTin;
    }

    public String getTextTieude() {
        return textTieude;
    }

    public void setTextTieude(String textTieude) {
        this.textTieude = textTieude;
    }

    public String getTextNoidung() {
        return textNoidung;
    }

    public void setTextNoidung(String textNoidung) {
        this.textNoidung = textNoidung;
    }
}
