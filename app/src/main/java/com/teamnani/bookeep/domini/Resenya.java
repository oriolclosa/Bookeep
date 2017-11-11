package com.teamnani.bookeep.domini;

/**
 * Created by joe on 11/11/17.
 */

public class Resenya {
    private String nick;
    private String data;
    private float puntuacio;
    private String comentari;

    public Resenya(String n, String d, float p, String c) {
        this.nick = n;
        this.data = d;
        this.puntuacio = p;
        this.comentari = c;
    }

    public String obtenirNick() {
        return this.nick;
    }

    public String obtenirData() {
        return this.data;
    }

    public float obtenirPuntuacio() {
        return  this.puntuacio;
    }

    public String obtenirComentari() {
        return this.comentari;
    }
}
