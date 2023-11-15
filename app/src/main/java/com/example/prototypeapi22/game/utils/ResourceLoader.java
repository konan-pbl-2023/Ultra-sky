package com.example.prototypeapi22.game.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class ResourceLoader {

    private final Resources res;

    public ResourceLoader(Resources res) {
        this.res = res;
    }

    public InputStream openFile(String path) {
        try {
            return res.getAssets().open(path);
        } catch (IOException e) {
            Log.e("ResourceLoader", "Exception Occurred!", e.fillInStackTrace());
        }
        return null;
    }

    public Bitmap getResource(int id) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        return BitmapFactory.decodeResource(res, id, options);
    }
}
