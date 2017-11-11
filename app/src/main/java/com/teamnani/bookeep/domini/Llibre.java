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
    private ImageView portada;
    private float puntuacio;
    private int comentaris;

    public Llibre(String t, int a, String e, ImageView p, float pun, int com) {
        this.titol = t;
        this.any = a;
        this.editorial = e;
        this.portada = p;
        this.comentaris = com;
        this.puntuacio = pun;
    }

}
