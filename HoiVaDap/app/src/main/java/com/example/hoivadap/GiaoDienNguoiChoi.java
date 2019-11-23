package com.example.hoivadap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doandidong.R;

public class GiaoDienNguoiChoi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giao_dien_nguoi_choi);
    }

    public void xuly_quan_ly_tk(View view) {
        Intent intent = new Intent(this, QuanLyTK.class);
        startActivity(intent);
    }

    public void xuly_bang_xep_hang(View view) {
        Intent intent = new Intent(this, BangXepHang.class);
        startActivity(intent);
    }

    public void xuly_lich_su_choi(View view) {
        Intent intent = new Intent(this, LichSuChoi.class);
        startActivity(intent);
    }

    public void xu_ly_mua_credit(View view) {
        Intent intent = new Intent (this,GoiCredit.class);
        startActivity(intent);
    }

    public void xuly_tro_choi(View view) {
        Intent intent = new Intent (this,LinhVuc.class);
        startActivity(intent);
    }
}
