package com.teamnani.bookeep.presentacio;

import com.teamnani.bookeep.domini.ControladorDomini;
import com.teamnani.bookeep.domini.Llibre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by oriolclosa on 11/11/17.
 */

public class ControladorPresentacio {
    private ControladorDomini ctrlDomini;
    private List<String> topics = Arrays.asList("asimov", "jo nesbo", "rowling", "king", "austen", "terror", "dramatic", "history", "doctor", "twain", "conan", "catalonia", "agatha", "tolkien", "verne", "dickens", "biography", "dogs", "technology", "gardens", "magic", "world", "water", "black", "blood", "higgins", "computer", "mobile", "train", "general", "war");

    public ControladorPresentacio(){
        ctrlDomini = new ControladorDomini(this);
    }

    public ArrayList<Llibre> obtenirNous(){
        return ctrlDomini.obtenirNous();
    }
}
