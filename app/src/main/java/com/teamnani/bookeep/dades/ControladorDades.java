package com.teamnani.bookeep.dades;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ControladorDades {

    public ControladorDades(){
        createFiles();
    }

    public ArrayList<ArrayList<String>> obtenirLlibresMesLlegitsAPI(String s){
        GoogleAPIBook api = new GoogleAPIBook();
        try {
            api.execute(s, "books", "relevance").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ArrayList<ArrayList<String>> books = api.obtenirBooks();
        /*for (int i = 0; i < books.size(); ++i){
            System.out.println(i);
            for (int j = 0; j < books.get(i).size(); ++j){
                System.out.println(books.get(i).get(j));
            }
        }*/
        return books;
    }

    public ArrayList<ArrayList<String>> obtenirRevistesMesLlegidesAPI(String s){
        GoogleAPIBook api = new GoogleAPIBook();
        try {
            api.execute(s, "magazines", "relevance").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ArrayList<ArrayList<String>> books = api.obtenirBooks();
        /*for (int i = 0; i < books.size(); ++i){
            System.out.println(i);
            for (int j = 0; j < books.get(i).size(); ++j){
                System.out.println(books.get(i).get(j));
            }
        }*/
        return books;
    }

    public ArrayList<ArrayList<String>> obtenirLlibresMesRecentsAPI(String s){
        GoogleAPIBook api = new GoogleAPIBook();
        try {
            api.execute(s, "books", "newest").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ArrayList<ArrayList<String>> books = api.obtenirBooks();
        /*for (int i = 0; i < books.size(); ++i){
            System.out.println(i);
            for (int j = 0; j < books.get(i).size(); ++j){
                System.out.println(books.get(i).get(j));
            }
        }*/
        return books;
    }

    public ArrayList<ArrayList<String>> obtenirRevistesMesRecentsAPI(String s){
        GoogleAPIBook api = new GoogleAPIBook();
        try {
            api.execute(s, "magazines", "newest").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ArrayList<ArrayList<String>> books = api.obtenirBooks();
        /*for (int i = 0; i < books.size(); ++i){
            System.out.println(i);
            for (int j = 0; j < books.get(i).size(); ++j){
                System.out.println(books.get(i).get(j));
            }
        }*/
        return books;
    }

    public ArrayList<ArrayList<String>> llibrePerAutors(String s){
        GoogleAPIBook api = new GoogleAPIBook();
        try {

            api.execute("inauthor:"+s, "llibres", "relevant").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ArrayList<ArrayList<String>> books = api.obtenirBooks();
        /*for (int i = 0; i < books.size(); ++i){
            System.out.println(i);
            for (int j = 0; j < books.get(i).size(); ++j){
                System.out.println(books.get(i).get(j));
            }
        }*/
        return books;
    }

    private void createFiles(){
        System.out.println("lalallala");
        File folder = new File("/dades");
        if(!folder.exists()){
            folder.mkdir();
            System.out.println("noexisita");
        }
        else System.out.println("exisita");

        File fileAutors = new File("/dades/autors.txt");
        File fileLlibres = new File("/dades/llibres.txt");

    }


}
