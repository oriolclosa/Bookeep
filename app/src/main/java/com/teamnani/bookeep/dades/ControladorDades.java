package com.teamnani.bookeep.dades;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ControladorDades {

    public ControladorDades(){
        createFiles();
        testFiles();
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
        try {

        }
        catch (Exception e){

        }
        File fileAutors = new File("autors.txt");
        if(fileAutors.exists()) System.out.println("existia avans de crear");
        try{
            fileAutors.createNewFile();
        }
        catch(Exception e){}
        if(fileAutors.exists()) System.out.println("existia despres");
        if(!fileAutors.exists()) System.out.println("something is wrong");
        File fileLlibres = new File("llibres.txt");


    }
    private void testFiles(){
        File archivo = new File("autors.txt");
        try {
        FileWriter escriure = new FileWriter(archivo);
        }
        catch (Exception e){
            System.out.println("ORIOL TENIA YO RAO PENDEJO");
        }

    }


}
