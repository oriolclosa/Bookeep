package com.teamnani.bookeep.presentacio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bookeep.teamnani.bookeep.R;
import com.teamnani.bookeep.domini.Llibre;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ControladorPresentacio ctrlPresentacio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctrlPresentacio = new ControladorPresentacio();
        setContentView(R.layout.activity_main);
        LinearLayout starred = (LinearLayout) findViewById(R.id.starredLayout);
        LinearLayout starred2 = new LinearLayout(this);
        starred2.setOrientation(LinearLayout.HORIZONTAL);
        ArrayList<Llibre> llibresStarred = ctrlPresentacio.obtenirNous();
        for(int i=0; i<llibresStarred.size(); ++i){
            System.out.println(Environment.getExternalStorageDirectory()+"/Download/"+llibresStarred.get(i).obtenirPortada());
            File fitxer = new File(Environment.getExternalStorageDirectory()+"/Download/exemple.jpg");
            if(fitxer.exists()){
                System.out.println("Existeix!");
                Bitmap imgBitmap = BitmapFactory.decodeFile(fitxer.getAbsolutePath());
                ImageView actual = new ImageView(this);
                actual.setImageBitmap(imgBitmap);
                actual.requestLayout();
                actual.getLayoutParams().height = 50;
                starred2.addView(actual);
            }
        }
        starred.addView(starred2);
    }
}
