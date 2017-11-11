package com.teamnani.bookeep.domini;

import java.util.ArrayList;

/**
 * Created by joe on 11/11/17.
 */

public class Autor {
    private String nom;
    private float puntuacio;
    private int comentaris;

    public Autor(String n, float pun, int com) {
        this.nom = n;
        this.comentaris = com;
        this.puntuacio = pun;
    }
}
