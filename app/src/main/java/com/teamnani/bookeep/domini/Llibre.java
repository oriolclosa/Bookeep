package com.teamnani.bookeep.domini;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by joe on 11/11/17.
 */

public class Llibre {
    private String titol;
    private int any;
    private String editorial;
    private String portada;
    private float puntuacio;
    private int comentaris;

    public Llibre(String t, int a, String e, String p, float pun, int com) {
        this.titol = t;
        this.any = a;
        this.editorial = e;
        this.portada = p;
        this.comentaris = com;
        this.puntuacio = pun;
    }

    public String obtenirTitol() {
        return this.titol;
    }

    public int obtenirAny() {
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
}
