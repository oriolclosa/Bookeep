package com.teamnani.bookeep.domini;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.util.AndroidException;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bookeep.teamnani.bookeep.R;
import com.teamnani.bookeep.dades.ControladorDades;
import com.teamnani.bookeep.presentacio.ControladorPresentacio;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by oriolclosa on 11/11/17.
 */

public class ControladorDomini extends AppCompatActivity {
    private ControladorPresentacio ctrlPresentacio;
    private ControladorDades ctrlDades;

    public ControladorDomini(ControladorPresentacio pCtrlPresentacio){
        ctrlPresentacio = pCtrlPresentacio;
        ctrlDades = new ControladorDades();
    }

    public ArrayList<Llibre> obtenirNous() {
        File imgFile = new  File("../../../res/imatges/exemple.jpg");
        ImageView imgView = new ImageView(this);

        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imgView.setImageBitmap(myBitmap);
        }

        ArrayList<Llibre> t = new ArrayList<>();
        t.add(new Llibre("Aquest es el titol", 1997, "La meva editorial", imgView, (float) 3.2,4));
        return t;
    }
}
