package com.teamnani.bookeep.presentacio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bookeep.teamnani.bookeep.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout starred = (LinearLayout) findViewById(R.id.starredLayout);
        LinearLayout starred2 = new LinearLayout(this);
        starred2.setOrientation(LinearLayout.HORIZONTAL);
        TextView prova = new TextView(this);
        prova.setText("Prova");
        starred2.addView(prova);
        starred.addView(starred2);
    }
}
