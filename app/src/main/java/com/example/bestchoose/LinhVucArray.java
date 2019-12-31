package com.example.bestchoose;

public class LinhVucArray {
    private Integer id;
    private String tenLinhVuc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenLinhVuc() {
        return tenLinhVuc;
    }

    public void setTenLinhVuc(String tenLinhVuc) {
        this.tenLinhVuc = tenLinhVuc;
    }

    public LinhVucArray(Integer id, String TenLV){
        this.id = id;
        this.tenLinhVuc = TenLV;
    }
}

