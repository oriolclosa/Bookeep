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


public class ControladorDomini {
    private ControladorPresentacio ctrlPresentacio;
    private ControladorDades ctrlDades;

    public ControladorDomini(ControladorPresentacio pCtrlPresentacio){
        ctrlPresentacio = pCtrlPresentacio;
        ctrlDades = new ControladorDades();
    }

    public ArrayList<Llibre> obtenirNous() {
        ArrayList<Llibre> t = new ArrayList<>();
        t.add(new Llibre("Aquest es el titol",  "Aquest es l'autor", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol",  "Aquest es l'autor", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol",  "Aquest es l'autor", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol",  "Aquest es l'autor", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol",  "Aquest es l'autor", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol",  "Aquest es l'autor", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol",  "Aquest es l'autor", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol",  "Aquest es l'autor", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol",  "Aquest es l'autor", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
        t.add(new Llibre("Aquest es el titol",  "Aquest es l'autor", 1997, "La meva editorial", "exemple.jpg", (float) 3.2,4));
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

    public ArrayList<Llibre> obtenirLlibresMesLlegits(String query) {
        ArrayList<ArrayList<String> > r = ctrlDades.obtenirLlibresMesLlegitsAPI(query);
        ArrayList<Llibre> ll = new ArrayList<>();
        for (int i = 0; i < r.size(); ++i) {
            if (r.get(i).get(1) == null) r.get(i).set(1, "");
            if (r.get(i).get(2) == null) r.get(i).set(2, "-1");
            if (r.get(i).get(3) == null) r.get(i).set(3, "");
            if (r.get(i).get(4) == null) r.get(i).set(4, "");
            Llibre l = new Llibre(r.get(i).get(0), r.get(i).get(1), parseInt(r.get(i).get(2)), r.get(i).get(3), r.get(i).get(4), 0, 0);
            //Faltan funcions per calcular pun i com en funcio del nom del llibre
            ll.add(l);
        }
        return ll;
    }

    public ArrayList<Llibre> obtenirRevistesMesLlegides(String query) {
        ArrayList<ArrayList<String> > r = new ArrayList<ArrayList<String> >(); //obtenirRevistesMesLlegidesAPI()
        ArrayList<Llibre> ll = new ArrayList<>();
        for (int i = 0; i < r.size(); ++i) {
            if (r.get(i).get(1) == null) r.get(i).set(1, "");
            if (r.get(i).get(2) == null) r.get(i).set(2, "-1");
            if (r.get(i).get(3) == null) r.get(i).set(3, "");
            if (r.get(i).get(4) == null) r.get(i).set(4, "");
            Llibre l = new Llibre(r.get(i).get(0), r.get(i).get(1), parseInt(r.get(i).get(2)), r.get(i).get(3), r.get(i).get(4), 0, 0);
            //Faltan funcions per calcular pun i com en funcio del nom del llibre
            ll.add(l);
        }
        return ll;
    }

    public ArrayList<Llibre> obtenirLlibresMesRecents(String query) {
        ArrayList<ArrayList<String> > r = new ArrayList<>(); //obtenirLlibresMesRecentsAPI()
        ArrayList<Llibre> ll = new ArrayList<>();
        for (int i = 0; i < r.size(); ++i) {
            if (r.get(i).get(1) == null) r.get(i).set(1, "");
            if (r.get(i).get(2) == null) r.get(i).set(2, "-1");
            if (r.get(i).get(3) == null) r.get(i).set(3, "");
            if (r.get(i).get(4) == null) r.get(i).set(4, "");
            Llibre l = new Llibre(r.get(i).get(0), r.get(i).get(1), parseInt(r.get(i).get(2)), r.get(i).get(3), r.get(i).get(4), 0, 0);
            //Faltan funcions per calcular pun i com en funcio del nom del llibre
            ll.add(l);
        }
        return ll;
    }


    public ArrayList<Llibre> obtenirRevistesMesRecents(String query) {
        ArrayList<ArrayList<String> > r = new ArrayList<>(); //obtenirRevistesMesRecentsAPI()
        ArrayList<Llibre> ll = new ArrayList<>();
        for (int i = 0; i < r.size(); ++i) {
            if (r.get(i).get(1) == null) r.get(i).set(1, "");
            if (r.get(i).get(2) == null) r.get(i).set(2, "-1");
            if (r.get(i).get(3) == null) r.get(i).set(3, "");
            if (r.get(i).get(4) == null) r.get(i).set(4, "");
            Llibre l = new Llibre(r.get(i).get(0), r.get(i).get(1), parseInt(r.get(i).get(2)), r.get(i).get(3), r.get(i).get(4), 0, 0);
            //Faltan funcions per calcular pun i com en funcio del nom del llibre
            ll.add(l);
        }
        return ll;
    }
}
