package com.teamnani.bookeep.presentacio;

import com.teamnani.bookeep.domini.ControladorDomini;
import com.teamnani.bookeep.domini.Llibre;

import java.util.ArrayList;

/**
 * Created by oriolclosa on 11/11/17.
 */

public class ControladorPresentacio {
    private ControladorDomini ctrlDomini;

    public ControladorPresentacio(){
        ctrlDomini = new ControladorDomini(this);
    }

    public ArrayList<Llibre> obtenirNous(){
        return ctrlDomini.obtenirNous();
    }
}
