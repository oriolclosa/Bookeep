package com.teamnani.bookeep.domini;

import android.widget.ImageView;

/**
 * Created by joe on 11/11/17.
 */

public class Usuari {
    private String nom;
    private String nick;
    private String contrasenya;
    private String correu;
    private ImageView imatge;
    private int llibresLlegits;

    public Usuari(String no, String ni, String con, String cor, ImageView i, int ll) {
        this.nom = no;
        this.nick = ni;
        this.contrasenya = con;
        this.correu = cor;
        this.imatge = i;
        this.llibresLlegits = ll;
    }
}
