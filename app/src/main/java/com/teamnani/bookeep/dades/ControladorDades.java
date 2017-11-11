package com.teamnani.bookeep.dades;

import com.teamnani.bookeep.domini.ControladorDomini;

import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * Created by oriolclosa on 11/11/17.
 */

public class ControladorDades {

    public ControladorDades(){
    }

    public ArrayList<ArrayList<String>> obtenirLlibresMesLlegitsAPI(String s){
        ArrayList<ArrayList<String>> books =  new ArrayList<>();
        new GoogleAPIBook(books).execute(s);
        for (int i = 0; i < books.size(); ++i){
            System.out.println(i);
            for (int j = 0; j < books.get(i).size(); ++j){
                System.out.println(books.get(i).get(j));
            }
        }
        return books;
    }

    public String[][] obtenirRevistesMesLlegidesAPI(String s){
        return null;
    }

    public String[][] obtenirLlibresMesRecentsAPI(String s){
        return null;
    }

    public String[][] obtenirRevistesMesRecentsAPI(String s){
        return null;
    }
}
