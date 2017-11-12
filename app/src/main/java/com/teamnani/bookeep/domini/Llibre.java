package com.teamnani.bookeep.domini;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by joe on 11/11/17.
 */

public class Llibre {
    private String titol;
    private String autor;
    private String any;
    private String editorial;
    private String portada;
    private float puntuacio;
    private int comentaris;
    private String ISBN;
    private String text;

    public Llibre(String t, String aut, String a, String e, String p, float pun, int com, String I, String txt) {
        this.titol = t;
        this.autor = aut;
        this.any = a;
        this.editorial = e;
        this.portada = p;
        this.comentaris = com;
        this.puntuacio = pun;
        this.ISBN = I;
        this.text = txt;
    }

    public String obtenirTitol() {
        return this.titol;
    }

    public String obtenirAutor() {
        return this.autor;
    }

    public String obtenirAny() {
        return this.any;
    }

    public String obtenirEditorial() {
        return this.editorial;
    }

    public String obtenirPortada() {
        return this.portada;
    }

    public float obtenirPuntuacio() {
        return this.puntuacio;
    }

    public int obtenirComentaris() {
        return this.comentaris;
    }

    public String obtenirISBN() {
        return this.ISBN;
    }

    public String obtenirText() {
        return this.text;
    }
}
