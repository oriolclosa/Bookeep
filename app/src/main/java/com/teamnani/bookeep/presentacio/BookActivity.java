package com.teamnani.bookeep.presentacio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.bookeep.teamnani.bookeep.R;
import com.teamnani.bookeep.domini.Llibre;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent llibre = getIntent();
        String titol = llibre.getStringExtra("titol");
        System.out.println(titol);
    }
}
