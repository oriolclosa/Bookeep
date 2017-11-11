package com.teamnani.bookeep.presentacio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by oriolclosa on 12/11/17.
 */

public class Imatges extends AsyncTask<String, Void, Bitmap> {

    private Bitmap imatge;

    public Imatges(Bitmap imatge2){
        imatge = imatge2;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            // Log exception
            return null;
        }
    }

    public Bitmap obtenirBitMap(){
        return this.imatge;
    }
}
