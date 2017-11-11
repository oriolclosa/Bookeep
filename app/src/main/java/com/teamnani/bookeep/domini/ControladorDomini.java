package com.teamnani.bookeep.domini;

import android.support.v7.app.AppCompatActivity;
import android.util.AndroidException;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.teamnani.bookeep.dades.ControladorDades;
import com.teamnani.bookeep.presentacio.ControladorPresentacio;

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
        ArrayList<Llibre> t = new ArrayList<>();
        t.add(new Llibre("Aquest es el titol", 1997, "La meva editorial", new ImageView(this), (float) 3.2,4));
        return t;
    }
}
