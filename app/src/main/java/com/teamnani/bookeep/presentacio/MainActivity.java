package com.teamnani.bookeep.presentacio;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Environment;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.bookeep.teamnani.bookeep.R;
import com.teamnani.bookeep.domini.Llibre;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ControladorPresentacio ctrlPresentacio;
    private ArrayList<Llibre> tots;

    private void carregarLlibres(ArrayList<Llibre> rebuts, int ident){
        HorizontalScrollView starred = (HorizontalScrollView) findViewById(ident);
        LinearLayout starred2 = new LinearLayout(this);
        starred2.setOrientation(LinearLayout.HORIZONTAL);
        ArrayList<Llibre> llibresStarred = rebuts;
        for(int i=0; i<llibresStarred.size(); ++i){
            String path = llibresStarred.get(i).obtenirPortada();
            Bitmap imgBitmap = null;
            Imatges internet = new Imatges(imgBitmap);
            try {
                imgBitmap = internet.execute(path).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
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
        starred.addView(starred2);
    }

    private LinearLayout carregarLlibresCercats(ArrayList<Llibre> rebuts){
        LinearLayout starred2 = new LinearLayout(this);
        starred2.setId(R.id.contingut);
        starred2.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        Resources r2 = getResources();
        float px2 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25, r2.getDisplayMetrics());
        float px3 = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, r2.getDisplayMetrics());
        lp2.setMargins((int) px2, (int) px3, (int) px2, (int) px3);
        starred2.setLayoutParams(lp2);
        ArrayList<Llibre> llibresStarred = rebuts;
        for(int i=0; i<llibresStarred.size(); ++i){
            LinearLayout starred3 = new LinearLayout(this);
            starred3.setOrientation(LinearLayout.HORIZONTAL);
            String path = llibresStarred.get(i).obtenirPortada();
            Bitmap imgBitmap = null;
            System.out.println(path);
            Imatges internet = new Imatges(imgBitmap);
            try {
                imgBitmap = internet.execute(path).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            ImageButton actual = new ImageButton(this);
            actual.setImageBitmap(Bitmap.createScaledBitmap(imgBitmap, 300, 450, false));
            actual.setBackground(null);
            actual.setPadding(0, 0, 0, 0);
            actual.setId(tots.size());
            tots.add(llibresStarred.get(i));
            actual.setOnClickListener(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            Resources r = getResources();
            float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25, r.getDisplayMetrics());
            lp.setMargins(0, 0, (int) px, (int) px);
            actual.setLayoutParams(lp);
            LinearLayout starred4 = new LinearLayout(this);
            starred4.setOrientation(LinearLayout.VERTICAL);
            starred3.addView(actual);
            TextView titolText = new TextView(this);
            titolText.setText(llibresStarred.get(i).obtenirTitol());
            titolText.setTextSize((float) 16);
            titolText.setTypeface(titolText.getTypeface(), Typeface.BOLD);
            starred4.addView(titolText);
            TextView autorText = new TextView(this);

            String autors = llibresStarred.get(i).obtenirAutor();
            if(autors.length()>4) {
                autors = autors.substring(2, autors.length()-1);
                List<String> autors2 = new ArrayList<String>(Arrays.asList(autors.split("\",\"")));
                autors = "";
                for(int k=0; k<autors2.size(); ++k){
                    autors += ", " + autors2.get(k);
                }
                if(autors.length()>2) {
                    autors = autors.substring(2, autors.length() - 1);
                }
            }
            if(autors.equals("")){
                autorText.setVisibility(View.INVISIBLE);
            }
            autorText.setText(autors);

            autorText.setTextSize((float) 14);
            starred4.addView(autorText);
            starred4.setGravity(Gravity.RIGHT);
            starred3.addView(starred4);
            starred2.addView(starred3);
        }
        return starred2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctrlPresentacio = ControladorPresentacio.getInstance();
        setContentView(R.layout.activity_main);

        setTitle("Bookeep");

        tots = new ArrayList<>();

        final Switch cerca = (Switch) findViewById(R.id.switchAutor);
        cerca.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                TextView cerca2 = (TextView) findViewById(R.id.textBy);
                if(cerca.isChecked()){
                    cerca2.setText("by author");
                }
                else{
                    cerca2.setText("by title");
                }
            }
        });

        Button cercar = (Button) findViewById(R.id.buttonCercar);
        cercar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarLlibres();
            }
        });

        Button cancel = (Button) findViewById(R.id.buttonCancelar);
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        carregarLlibres(ctrlPresentacio.obtenirLlegitsLlibres(), R.id.scrollStarred);
        carregarLlibres(ctrlPresentacio.obtenirLlegidesRevistes(), R.id.scrollStarredMag);
        carregarLlibres(ctrlPresentacio.obtenirÚltimsLlibres(), R.id.scrollLatest);
        carregarLlibres(ctrlPresentacio.obtenirÚltimesRevistes(), R.id.scrollLatestMag);
    }

    private void mostrarLlibres(){
        tots = new ArrayList<>();
        LinearLayout cont = (LinearLayout) findViewById(R.id.contingut);
        ViewGroup contPar = (ViewGroup) cont.getParent();
        contPar.removeView(cont);
        EditText cerca = (EditText) findViewById(R.id.editText);
        String cerca2 = cerca.getText().toString();
        ArrayList<Llibre> llista;

        setTitle("Search results for " + cerca2);

        final Switch cerca3 = (Switch) findViewById(R.id.switchAutor);
        if(cerca3.isChecked()){
            llista = ctrlPresentacio.obtenirCercaAutor(cerca2);
            ((EditText) findViewById(R.id.editText)).setHint("Autor");
        }
        else{
            llista = ctrlPresentacio.obtenirCercaTitol(cerca2);
            ((EditText) findViewById(R.id.editText)).setHint("Title");
        }

        contPar.addView(carregarLlibresCercats(llista));
    }

    @Override
    public void onClick(View v){
        Intent llibre = new Intent(this, BookActivity.class);
        Llibre passar = tots.get(v.getId());
        llibre.putExtra("titol", passar.obtenirTitol());
        llibre.putExtra("autor", passar.obtenirAutor());
        llibre.putExtra("any", passar.obtenirAny());
        llibre.putExtra("editorial", passar.obtenirEditorial());
        llibre.putExtra("portada", passar.obtenirPortada());
        llibre.putExtra("puntuacio", String.valueOf(passar.obtenirPuntuacio()));
        llibre.putExtra("comentaris", passar.obtenirComentaris());
        llibre.putExtra("ISBN", passar.obtenirISBN());
        llibre.putExtra("descripcio", passar.obtenirText());
        startActivity(llibre);
    }
}
