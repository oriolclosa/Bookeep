package com.teamnani.bookeep.presentacio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bookeep.teamnani.bookeep.R;
import com.teamnani.bookeep.domini.Llibre;

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
            starred2.addView(llibresStarred.get(i).obtenirPortada());
        }
        starred.addView(starred2);
    }
}
