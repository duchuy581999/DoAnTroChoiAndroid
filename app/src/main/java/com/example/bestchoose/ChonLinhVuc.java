package com.example.bestchoose;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChonLinhVuc extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private TextView btnLinhVuc1, btnLinhVuc2, btnLinhVuc3, btnLinhVuc4;
    public static String ChonLinhVuc;
    private ArrayList<LinhVucArray> linhVucArrays = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_linh_vuc);

        btnLinhVuc1 = findViewById(R.id.btn_linhvuc1);
        btnLinhVuc2 = findViewById(R.id.btn_linhvuc2);
        btnLinhVuc3 = findViewById(R.id.btn_linhvuc3);
        btnLinhVuc4 = findViewById(R.id.btn_linhvuc4);

        if(getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }
        getSupportLoaderManager().restartLoader(0,null,this);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new LinhVucLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try{
            JSONObject json = new JSONObject(data);
            JSONArray itemsArrays = json.getJSONArray("linh_vuc");
            for (int i = 0; i < itemsArrays.length(); i++){
                JSONObject jsonObject = itemsArrays.getJSONObject(i);
                String id = jsonObject.getString("id");
                String ten = jsonObject.getString("Ten_linh_vuc");
                linhVucArrays.add( new LinhVucArray(Integer.valueOf(id),ten));
            }
            btnLinhVuc1.setText(String.valueOf(linhVucArrays.get(0).getTenLinhVuc()));
            btnLinhVuc2.setText(String.valueOf(linhVucArrays.get(1).getTenLinhVuc()));
            btnLinhVuc3.setText(String.valueOf(linhVucArrays.get(2).getTenLinhVuc()));
            btnLinhVuc4.setText(String.valueOf(linhVucArrays.get(3).getTenLinhVuc()));

        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    public void ChonLinhVuc1(View view) {
        ChonLinhVuc = String.valueOf(linhVucArrays.get(0).getId());
        startActivity(new Intent(this, ManHinhTroChoi.class));
    }

    public void ChonLinhVuc2(View view) {
        ChonLinhVuc = String.valueOf(linhVucArrays.get(1).getId());
        startActivity(new Intent(this, ManHinhTroChoi.class));
    }

    public void ChonLinhVuc3(View view) {
        ChonLinhVuc = String.valueOf(linhVucArrays.get(2).getId());
        startActivity(new Intent(this, ManHinhTroChoi.class));
    }

    public void ChonLinhVuc4(View view) {
        ChonLinhVuc = String.valueOf(linhVucArrays.get(3).getId());
        startActivity(new Intent(this, ManHinhTroChoi.class));
    }
}
