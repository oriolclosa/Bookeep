package com.teamnani.bookeep.presentacio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bookeep.teamnani.bookeep.R;
import com.teamnani.bookeep.domini.Llibre;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent llibre = getIntent();

        setTitle(llibre.getStringExtra("titol"));

        TextView llibTitol = (TextView) findViewById(R.id.autorText);
        llibTitol.setText("Autor: " + llibre.getStringExtra("autor"));
        TextView llibAny = (TextView) findViewById(R.id.anyText);
        llibAny.setText("Any: " + llibre.getStringExtra("any"));
        TextView llibEditorial = (TextView) findViewById(R.id.editorialText);
        llibEditorial.setText("Editorial: " + llibre.getStringExtra("editorial"));
    }
}
