package com.teamnani.bookeep.presentacio;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bookeep.teamnani.bookeep.R;
import com.teamnani.bookeep.domini.Llibre;
import com.teamnani.bookeep.domini.Resenya;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BookActivity extends AppCompatActivity {

    private ControladorPresentacio ctrlPresentacio;
    private ArrayList<Resenya> resenyes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        ctrlPresentacio = ControladorPresentacio.getInstance();

        Button afegir = (Button) findViewById(R.id.commentButton);
        afegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctrlPresentacio.ferComentari(getTitle().toString(), "joe", (new Timestamp(System.currentTimeMillis())).toString(), ((RatingBar) findViewById(R.id.ratingText)).getRating(), ((EditText) findViewById(R.id.comentariText)).getText().toString());

            }
        });

        Intent llibre = getIntent();

        setTitle(llibre.getStringExtra("titol"));

        TextView llibAutor = (TextView) findViewById(R.id.autorText);
        String autors = llibre.getStringExtra("autor");
        if(autors.length()>4) {
            autors = autors.substring(2, autors.length()-1);
            List<String> autors2 = new ArrayList<String>(Arrays.asList(autors.split("\",\"")));
            autors = "";
            for(int i=0; i<autors2.size(); ++i){
                autors += ", " + autors2.get(i);
            }
            if(autors.length()>2) {
                autors = autors.substring(2, autors.length() - 1);
            }
        }
        if(autors.equals("")){
            llibAutor.setVisibility(View.INVISIBLE);
        }
        llibAutor.setText(autors);

        TextView llibAny = (TextView) findViewById(R.id.anyText);
        String any = llibre.getStringExtra("any");
        if(any.length()>4){
            any = any.substring(0, 4);
        }
        if(any.equals("")){
            llibAny.setVisibility(View.INVISIBLE);
        }
        llibAny.setText(any);

        TextView llibEditorial = (TextView) findViewById(R.id.editorialText);
        if(llibre.getStringExtra("editorial").equals("")){
            llibEditorial.setVisibility(View.INVISIBLE);
        }
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

        TextView llibISBN = (TextView) findViewById(R.id.isbnText);
        if(llibre.getStringExtra("ISBN").equals("")){
            llibISBN.setVisibility(View.INVISIBLE);
        }
        llibISBN.setText(llibre.getStringExtra("ISBN"));

        TextView llibProg = (TextView) findViewById(R.id.progressText);
        llibProg.setText(llibre.getStringExtra("puntuacio"));

        ProgressBar llibProg2 = (ProgressBar) findViewById(R.id.progressBar);
        llibProg2.setProgress((int) Float.parseFloat(llibre.getStringExtra("puntuacio")));

        TextView llibText = (TextView) findViewById(R.id.textText);
        String text = llibre.getStringExtra("descripcio");
        if(text.length()>250){
            text = text.substring(0, 250);
            text += "...";
        }
        if(text.equals("")){
            llibText.setVisibility(View.INVISIBLE);
        }
        llibText.setText(text);

        resenyes = ctrlPresentacio.obtenirResenyesLlibre(llibre.getStringExtra("titol"));

        afegirComentaris(resenyes, R.id.comentarisArea);
    }

    private void afegirComentaris(ArrayList<Resenya> res, int ident){
        LinearLayout starred2 = (LinearLayout) findViewById(ident);
        starred2.setOrientation(LinearLayout.HORIZONTAL);
        for(int i=0; i<res.size(); ++i){
            TextView titolText = new TextView(this);
            titolText.setText(res.get(i).obtenirNick());
            titolText.setTextSize((float) 16);
            titolText.setTypeface(titolText.getTypeface(), Typeface.BOLD);
            starred2.addView(titolText);
            titolText.setText(res.get(i).obtenirData());
            titolText.setTextSize((float) 14);
            starred2.addView(titolText);
            RatingBar estrelletes = new RatingBar(this);
            estrelletes.setNumStars(5);
            estrelletes.setIsIndicator(true);
            estrelletes.setStepSize((float) 0.1);
            starred2.addView(estrelletes);
            titolText.setText(res.get(i).obtenirComentari());
            titolText.setTextSize((float) 16);
            starred2.addView(titolText);
        }
    }
}
