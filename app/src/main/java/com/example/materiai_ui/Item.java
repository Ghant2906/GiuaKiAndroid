package com.example.materiai_ui;

public class Item {
    private int Hinh;
    private String tieuDe, moTa, gia, cong, tru;

    public Item(int hinh, String tieuDe, String moTa, String gia, String cong, String tru) {
        Hinh = hinh;
        this.tieuDe = tieuDe;
        this.moTa = moTa;
        this.gia = gia;
        this.cong = cong;
        this.tru = tru;
    }

    public String getCong() {
        return cong;
    }

    public void setCong(String cong) {
        this.cong = cong;
    }

    public String getTru() {
        return tru;
    }

    public void setTru(String tru) {
        this.tru = tru;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
