package com.teamnani.bookeep.domini;

import android.content.Context;
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

import static java.lang.Integer.parseInt;

/**
 * Created by oriolclosa on 11/11/17.
 */

public class ControladorDomini {
    private ControladorPresentacio ctrlPresentacio;
    private ControladorDades ctrlDades;

    public ControladorDomini(ControladorPresentacio pCtrlPresentacio){
        ctrlPresentacio = pCtrlPresentacio;
        ctrlDades = new ControladorDades();
    }

    public ArrayList<Llibre> obtenirNous() {
        ArrayList<Llibre> t = new ArrayList<>();
        t.add(new Llibre("Aquest es el titol", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        return t;
    }

    public ArrayList<Resenya> obtenirResenyesAutor(String s) {
        ArrayList<Resenya> r = new ArrayList<>(); //obtenirResenyesAutorDades(String s);
        return r;
    }

    public ArrayList<Resenya> obtenirResenyesLlibre(String s) {
        ArrayList<Resenya> r = new ArrayList<>(); //obtenirResenyesLlibreDades(String s);
        return r;
    }

    public ArrayList<Llibre> obtenirLlibresMesLlegits() {
        ArrayList<ArrayList<String> > r = new ArrayList<ArrayList<String> >(); //obtenirLlibresMesLlegitsAPI()
        ArrayList<Llibre> ll = new ArrayList<>();
        for (int i = 0; i < r.size(); ++i) {
            Llibre l = new Llibre(r.get(i).get(0), parseInt(r.get(i).get(1)), r.get(i).get(2), r.get(i).get(3), 0, 0);
            //Faltan funcions per calcular pun i com en funcio del nom del llibre
            ll.add(l);
        }
        return ll;
    }

    //mes llegits
    //mes recents
    //revistes mes llegides
    //revista mes recent


}
