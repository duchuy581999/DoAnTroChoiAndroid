package com.example.bestchoose;

public class CauHoiArray {
    private Integer id;
    private String noi_dung;
    private String phuong_an_a;
    private String phuong_an_b;
    private String phuong_an_c;
    private String phuong_an_d;
    private String dap_an;
    public  static String dap_an_a = "A";
    public  static String dap_an_b = "B";
    public  static String dap_an_c = "C";
    public  static String dap_an_d = "D";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
    }

    public String getPhuong_an_a() {
        return phuong_an_a;
    }

    public void setPhuong_an_a(String phuong_an_a) {
        this.phuong_an_a = phuong_an_a;
    }

    public String getPhuong_an_b() {
        return phuong_an_b;
    }

    public void setPhuong_an_b(String phuong_an_b) {
        this.phuong_an_b = phuong_an_b;
    }

    public String getPhuong_an_c() {
        return phuong_an_c;
    }

    public void setPhuong_an_c(String phuong_an_c) {
        this.phuong_an_c = phuong_an_c;
    }

    public String getPhuong_an_d() {
        return phuong_an_d;
    }

    public void setPhuong_an_d(String phuong_an_d) {
        this.phuong_an_d = phuong_an_d;
    }

    public String getDap_an() {
        return dap_an;
    }

    public void setDap_an(String dap_an) {
        this.dap_an = dap_an;
    }

    public CauHoiArray(Integer id, String noi_dung, String phuong_an_a,String phuong_an_b,String phuong_an_c, String phuong_an_d,String dap_an){
        this.id = id;
        this.noi_dung = noi_dung;
        this.phuong_an_a = phuong_an_a;
        this.phuong_an_b = phuong_an_b;
        this.phuong_an_c = phuong_an_c;
        this.phuong_an_d = phuong_an_d;
        this.dap_an = dap_an;
    }
}