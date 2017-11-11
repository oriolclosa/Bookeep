package com.teamnani.bookeep.presentacio;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bookeep.teamnani.bookeep.R;
import com.teamnani.bookeep.domini.Llibre;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ControladorPresentacio ctrlPresentacio;
    private ArrayList<Llibre> tots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctrlPresentacio = new ControladorPresentacio();
        setContentView(R.layout.activity_main);

        setTitle("Daily recomendations");

        tots = new ArrayList<>();

        //Llibres starreds
        HorizontalScrollView starred = (HorizontalScrollView) findViewById(R.id.scrollStarred);
        LinearLayout starred2 = new LinearLayout(this);
        starred2.setOrientation(LinearLayout.HORIZONTAL);
        ArrayList<Llibre> llibresStarred = ctrlPresentacio.obtenirLlegitsLlibres();
        for(int i=0; i<llibresStarred.size(); ++i){
            File fitxer = new File(Environment.getExternalStorageDirectory()+"/Download/"+llibresStarred.get(i).obtenirPortada());
            if(fitxer.exists()){
                Bitmap imgBitmap = BitmapFactory.decodeFile(fitxer.getAbsolutePath());
                ImageButton actual = new ImageButton(this);
                actual.setImageBitmap(Bitmap.createScaledBitmap(imgBitmap, 200, 300, false));
                actual.setBackground(null);
                actual.setPadding(0, 0, 0, 0);
                actual.setId(tots.size());
                tots.add(llibresStarred.get(i));
                actual.setOnClickListener(this);
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

        //Revistes starreds
        starred = (HorizontalScrollView) findViewById(R.id.scrollStarredMag);
        starred2 = new LinearLayout(this);
        starred2.setOrientation(LinearLayout.HORIZONTAL);
        llibresStarred = ctrlPresentacio.obtenirLlegidesRevistes();
        for(int i=0; i<llibresStarred.size(); ++i){
            File fitxer = new File(Environment.getExternalStorageDirectory()+"/Download/"+llibresStarred.get(i).obtenirPortada());
            if(fitxer.exists()){
                Bitmap imgBitmap = BitmapFactory.decodeFile(fitxer.getAbsolutePath());
                ImageButton actual = new ImageButton(this);
                actual.setImageBitmap(Bitmap.createScaledBitmap(imgBitmap, 200, 300, false));
                actual.setBackground(null);
                actual.setPadding(0, 0, 0, 0);
                actual.setId(tots.size());
                tots.add(llibresStarred.get(i));
                actual.setOnClickListener(this);
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

        //Llibres recents
        starred = (HorizontalScrollView) findViewById(R.id.scrollLatest);
        starred2 = new LinearLayout(this);
        starred2.setOrientation(LinearLayout.HORIZONTAL);
        llibresStarred = ctrlPresentacio.obtenirÚltimsLlibres();
        for(int i=0; i<llibresStarred.size(); ++i){
            File fitxer = new File(Environment.getExternalStorageDirectory()+"/Download/"+llibresStarred.get(i).obtenirPortada());
            if(fitxer.exists()){
                Bitmap imgBitmap = BitmapFactory.decodeFile(fitxer.getAbsolutePath());
                ImageButton actual = new ImageButton(this);
                actual.setImageBitmap(Bitmap.createScaledBitmap(imgBitmap, 200, 300, false));
                actual.setBackground(null);
                actual.setPadding(0, 0, 0, 0);
                actual.setId(tots.size());
                tots.add(llibresStarred.get(i));
                actual.setOnClickListener(this);
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

        //Revistes recents
        starred = (HorizontalScrollView) findViewById(R.id.scrollLatestMag);
        starred2 = new LinearLayout(this);
        starred2.setOrientation(LinearLayout.HORIZONTAL);
        llibresStarred = ctrlPresentacio.obtenirÚltimesRevistes();
        for(int i=0; i<llibresStarred.size(); ++i){
            File fitxer = new File(Environment.getExternalStorageDirectory()+"/Download/"+llibresStarred.get(i).obtenirPortada());
            if(fitxer.exists()){
                Bitmap imgBitmap = BitmapFactory.decodeFile(fitxer.getAbsolutePath());
                ImageButton actual = new ImageButton(this);
                actual.setImageBitmap(Bitmap.createScaledBitmap(imgBitmap, 200, 300, false));
                actual.setBackground(null);
                actual.setPadding(0, 0, 0, 0);
                actual.setId(tots.size());
                tots.add(llibresStarred.get(i));
                actual.setOnClickListener(this);
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

        System.out.println(tots.size());
    }

    @Override
    public void onClick(View v){
        Intent llibre = new Intent(this, BookActivity.class);
        Llibre passar = tots.get(v.getId());
        llibre.putExtra("titol", passar.obtenirTitol());
        llibre.putExtra("autor", passar.obtenirAutor());
        llibre.putExtra("any", String.valueOf(passar.obtenirAny()));
        llibre.putExtra("editorial", passar.obtenirEditorial());
        llibre.putExtra("portada", passar.obtenirPortada());
        llibre.putExtra("puntuacio", passar.obtenirPuntuacio());
        llibre.putExtra("comentaris", passar.obtenirComentaris());
        startActivity(llibre);
    }
}
