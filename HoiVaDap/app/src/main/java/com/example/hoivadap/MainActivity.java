package com.example.hoivadap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.doandidong.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dangnhap(View view) {
        Intent intent = new Intent(this,GiaoDienNguoiChoi.class);
        startActivity(intent);
    }

    public void xuly_quen_mk(View view) {
        Intent intent = new Intent(this, QuenMK.class);
        startActivity(intent);
    }

    public void xuly_tao_tk_moi(View view) {
        Intent intent = new Intent(this, DangKy.class);
        startActivity(intent);
    }
}
