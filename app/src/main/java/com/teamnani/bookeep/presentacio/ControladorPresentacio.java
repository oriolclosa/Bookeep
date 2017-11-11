package com.teamnani.bookeep.presentacio;

import com.teamnani.bookeep.domini.ControladorDomini;
import com.teamnani.bookeep.domini.Llibre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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

    private int obtenirDia(){
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public ArrayList<Llibre> obtenirÚltimsLlibres(){
        return ctrlDomini.obtenirLlibresMesRecents(topics.get((obtenirDia()-1)));
    }

    public ArrayList<Llibre> obtenirÚltimesRevistes(){
        return ctrlDomini.obtenirRevistesMesRecents(topics.get((obtenirDia()-1)));
    }

    public ArrayList<Llibre> obtenirLlegitsLlibres(){
        return ctrlDomini.obtenirLlibresMesLlegits(topics.get((obtenirDia()-1)));
    }

    public ArrayList<Llibre> obtenirLlegidesRevistes(){
        return ctrlDomini.obtenirLlibresMesLlegits(topics.get((obtenirDia()-1)));
    }

    public ArrayList<Llibre> obtenirNous(){
        return ctrlDomini.obtenirNous();
    }
}
