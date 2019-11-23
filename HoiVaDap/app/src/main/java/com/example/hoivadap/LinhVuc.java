package com.example.hoivadap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doandidong.R;

public class LinhVuc extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linh_vuc);
    }


    public void xu_ly_chon_LS_DL(View view) {
        Intent intent = new Intent (this,ManHinhTroChoi.class);
        startActivity(intent);
    }
}
