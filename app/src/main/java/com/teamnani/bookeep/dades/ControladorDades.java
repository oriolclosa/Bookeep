package com.teamnani.bookeep.dades;

import com.teamnani.bookeep.domini.ControladorDomini;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * Created by oriolclosa on 11/11/17.
 */

public class ControladorDades {

    public ControladorDades(){
    }

    public ArrayList<ArrayList<String>> obtenirLlibresMesLlegitsAPI(String s){
        GoogleAPIBook api = new GoogleAPIBook();
        System.out.println("ANEM A EXEC");
        api.execute(s);
        System.out.println("HEM EXEC");
        ArrayList<ArrayList<String>> books = api.obtenirBooks();
        System.out.println("dieeeeee");
        /*for (int i = 0; i < books.size(); ++i){
            System.out.println(i);
            for (int j = 0; j < books.get(i).size(); ++j){
                System.out.println(books.get(i).get(j));
            }
        }*/
        return books;
    }

    public ArrayList<ArrayList<String>> obtenirRevistesMesLlegidesAPI(String s){
        return null;
    }

    public ArrayList<ArrayList<String>> obtenirLlibresMesRecentsAPI(String s){
        return null;
    }

    public ArrayList<ArrayList<String>> obtenirRevistesMesRecentsAPI(String s){
        return null;
    }
}
