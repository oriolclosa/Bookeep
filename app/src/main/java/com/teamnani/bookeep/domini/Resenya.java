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

    public float getPuntuacio() {
        return  this.puntuacio;
    }
}
