package com.example.bestchoose;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class CauHoiLoader extends AsyncTaskLoader<String> {
    private static final String BASE_URL_CAU_HOI = "http://10.0.2.2:8000/api/cau-hoi/";
    public CauHoiLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public String loadInBackground() {
        String id = ChonLinhVuc.ChonLinhVuc;
        return NetworksUltils.getJSONData(id,BASE_URL_CAU_HOI ,"GET");
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
