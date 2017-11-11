package com.teamnani.bookeep.presentacio;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
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
        HorizontalScrollView starred = (HorizontalScrollView) findViewById(R.id.scrollStarred);
        LinearLayout starred2 = new LinearLayout(this);
        starred2.setOrientation(LinearLayout.HORIZONTAL);
        ArrayList<Llibre> llibresStarred = ctrlPresentacio.obtenirNous();
        for(int i=0; i<llibresStarred.size(); ++i){
            System.out.println(Environment.getExternalStorageDirectory()+"/Download/"+llibresStarred.get(i).obtenirPortada());
            File fitxer = new File(Environment.getExternalStorageDirectory()+"/Download/exemple.jpg");
            if(fitxer.exists()){
                System.out.println("Existeix!");
                Bitmap imgBitmap = BitmapFactory.decodeFile(fitxer.getAbsolutePath());
                ImageButton actual = new ImageButton(this);
                actual.setImageBitmap(Bitmap.createScaledBitmap(imgBitmap, 200, 300, false));
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                if(i==0){
                    Resources r = getResources();
                    float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25, r.getDisplayMetrics());
                    lp.setMargins((int) px, 0, 0, 0);
                }
                else if(i==(llibresStarred.size()-1)){
                    Resources r = getResources();
                    float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25, r.getDisplayMetrics());
                    lp.setMargins(25, 0, (int) px, 0);
                }
                else {
                    lp.setMargins(25, 0, 0, 0);
                }
                actual.setLayoutParams(lp);
                starred2.addView(actual);
            }
        }
        starred.addView(starred2);
    }
}
