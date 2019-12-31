package com.example.bestchoose;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.HashMap;

public class NguoiChoiLoader extends AsyncTaskLoader<String> {
    private final int page;
    private final int limit;
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    public NguoiChoiLoader(@NonNull Context context, int page, int limit) {
        super(context);
        this.page = page;
        this.limit = limit;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        HashMap<String, String> queryparams = new HashMap<>();
        queryparams.put("page",Integer.toString(page));
        queryparams.put("limit",Integer.toString(limit));
        String json = "";
        try {
            json = NetworksUltils.getJSONData("nguoichoi", "GET",queryparams);
        }
        catch (Exception ex)
        {
            return null;
        }
        return json;
    }
}
