package com.teamnani.bookeep.presentacio;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bookeep.teamnani.bookeep.R;
import com.teamnani.bookeep.domini.Llibre;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent llibre = getIntent();

        setTitle(llibre.getStringExtra("titol"));

        TextView llibAutor = (TextView) findViewById(R.id.autorText);
        String autors = llibre.getStringExtra("autor");
        if(autors.length()>4) {
            autors = autors.substring(2, autors.length()-2);
            List<String> autors2 = new ArrayList<String>(Arrays.asList(autors.split(",")));
            autors = "";
            for(int i=0; i<autors2.size(); ++i){
                autors += ", " + autors2.get(i);
            }
            if(autors.length()>2) {
                autors = autors.substring(2, autors.length() - 1);
            }
        }
        llibAutor.setText(autors);
        TextView llibAny = (TextView) findViewById(R.id.anyText);
        llibAny.setText(llibre.getStringExtra("any"));
        TextView llibEditorial = (TextView) findViewById(R.id.editorialText);
        llibEditorial.setText(llibre.getStringExtra("editorial"));


        String path = llibre.getStringExtra("portada");
        Bitmap imgBitmap = null;
        Imatges internet = new Imatges(imgBitmap);
        System.out.println(path);
        try {
            imgBitmap = internet.execute(path).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ImageView actual = (ImageView) findViewById(R.id.llibreImage);
        actual.setImageBitmap(Bitmap.createScaledBitmap(imgBitmap, 1000, 1500, false));
        actual.setBackground(null);
        actual.setPadding(0, 0, 0, 0);

        TextView llibProg = (TextView) findViewById(R.id.progressText);
        llibProg.setText("7.56");

        ProgressBar llibProg2 = (ProgressBar) findViewById(R.id.progressBar);
        llibProg2.setProgress(76);
    }
}
