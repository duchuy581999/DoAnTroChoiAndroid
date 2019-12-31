package com.example.bestchoose;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ManHinhTroChoi extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private TextView noi_dung, phuong_an_a, phuong_an_b, phuong_an_c, phuong_an_d, cau_hoi_so, diem;
    private int stt, mdiem, color;
    private Thread thread = new Thread();
    private ArrayList<CauHoiArray> cauHoiArrays = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_tro_choi);

        noi_dung = findViewById(R.id.tvNoiDung);
        phuong_an_a = findViewById(R.id.tvCauA);
        phuong_an_b = findViewById(R.id.tvCauB);
        phuong_an_c = findViewById(R.id.tvCauC);
        phuong_an_d = findViewById(R.id.tvCauD);
        cau_hoi_so = findViewById(R.id.tvCauHoiSo);
        diem = findViewById(R.id.tvSoDiem);
        if(getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }
        getSupportLoaderManager().restartLoader(0,null,this);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new CauHoiLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try{
            JSONObject json = new JSONObject(data);
            JSONArray itemsArrays = json.getJSONArray("data");
            for (int i = 0; i < itemsArrays.length(); i++) {
                JSONObject jsonObject = itemsArrays.getJSONObject(i);
                String id = jsonObject.getString("id");
                String noi_dung = jsonObject.getString("noi_dung");
                String phuong_an_a = jsonObject.getString("phuong_an_a");
                String phuong_an_b = jsonObject.getString("phuong_an_b");
                String phuong_an_c = jsonObject.getString("phuong_an_c");
                String phuong_an_d = jsonObject.getString("phuong_an_d");
                String dap_an = jsonObject.getString("dap_an");
                cauHoiArrays.add(new CauHoiArray(Integer.valueOf(id), noi_dung, phuong_an_a, phuong_an_b, phuong_an_c, phuong_an_d, dap_an));
            }
            noi_dung.setText(String.valueOf(cauHoiArrays.get(0).getNoi_dung()));
            phuong_an_a.setText(String.valueOf(cauHoiArrays.get(0).getPhuong_an_a()));
            phuong_an_b.setText(String.valueOf(cauHoiArrays.get(0).getPhuong_an_b()));
            phuong_an_c.setText(String.valueOf(cauHoiArrays.get(0).getPhuong_an_c()));
            phuong_an_d.setText(String.valueOf(cauHoiArrays.get(0).getPhuong_an_d()));


        }catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }


    public void ChonA(View view) {
        String da = CauHoiArray.dap_an_a;
        color = ContextCompat.getColor ( this, R.color.ColorFalse );
        view.setBackgroundColor(color);
        Chon(view,da);
    }

    public void ChonB(View view) {
        String da = CauHoiArray.dap_an_b;
        color = ContextCompat.getColor ( this, R.color.ColorFalse );
        view.setBackgroundColor(color);
        Chon(view,da);
    }

    public void ChonC(View view) {
        String da = CauHoiArray.dap_an_c;
        color = ContextCompat.getColor ( this, R.color.ColorFalse );
        view.setBackgroundColor(color);
        Chon(view,da);
    }

    public void ChonD(View view) {
        String da = CauHoiArray.dap_an_d;
        color = ContextCompat.getColor ( this, R.color.ColorFalse );
        view.setBackgroundColor(color);
        Chon(view,da);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Diem", mdiem);
        outState.putInt("Stt", stt);
    }

    public void Chon(View view, String da){
        String s = String.valueOf(cauHoiArrays.get(0).getDap_an());
        try {
            thread.sleep(1000);
            if (s.equals(da)) {
                TraLoiDung(view);
            } else TraLoiSai(view);
        }catch (InterruptedException e ){
            e.printStackTrace();
        }

    }

    public void TraLoiDung(View view){
        stt = Integer.parseInt(cau_hoi_so.getText().toString());
        mdiem = Integer.parseInt(diem.getText().toString());
        mdiem = mdiem + 100;
        stt = stt + 1;
        cau_hoi_so.setText(""+stt);
        diem.setText(""+mdiem);
        color = ContextCompat.getColor ( this, R.color.ColorTrue );
        view.setBackgroundColor(color);
    }

    public void TraLoiSai(View view){
        Toast.makeText(this,"sai roi",Toast.LENGTH_SHORT).show();

    }

    public void TroGiup5050(View view){
        String s = String.valueOf(cauHoiArrays.get(0).getDap_an());
        int i = 0;
        while (i < 3)
        {
            if(!(CauHoiArray.dap_an_a.equals(s))){
                phuong_an_a.setVisibility(View.INVISIBLE);
                i++;
            }
            if (!(CauHoiArray.dap_an_b.equals(s)) && i != 2){
                phuong_an_b.setVisibility(View.INVISIBLE);
                i++;
            }else break;
            if ((!CauHoiArray.dap_an_c.equals(s)) && i != 2){
                phuong_an_c.setVisibility(View.INVISIBLE);
                i++;
            }else break;
            if ((!CauHoiArray.dap_an_d.equals(s)) && i != 2){
                phuong_an_d.setVisibility(View.INVISIBLE);
                i++;
            }else break;
        }

    }
}
