package com.example.bestchoose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ManHinhChinh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chinh);
    }

    public void xuly_bangxephang(View view) {
        Intent intent = new Intent(this,BangXepHang.class);
        startActivity(intent);
    }

    public void xuly_lichsuchoi(View view) {
        Intent intent = new Intent(this,LichSuChoi.class);
        startActivity(intent);
    }

    public void xuly_taikhoan(View view) {
        Intent intent = new Intent(this,QuanLyTaiKhoan.class);
        startActivity(intent);
    }

    public void xuly_muacredit(View view) {
        Intent intent = new Intent(this,MuaCredit.class);
        startActivity(intent);
    }

    public void xuly_choimoi(View view) {
        Intent intent = new Intent(this,ChonLinhVuc.class);
        startActivity(intent);
    }

}
