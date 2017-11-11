package com.teamnani.bookeep.dades;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class GoogleAPIBook {
    private ArrayList<ArrayList<String>> books;

    public GoogleAPIBook(){
        books = new ArrayList<>();
    }

    protected void execute(String...strings) {
        String s = NetworkUtils.getBookInfo(strings[0]);
        try{
            JSONObject jsonObject = new JSONObject(s);
            if(jsonObject.has("items")) {
                JSONArray itemsArray = jsonObject.getJSONArray("items");
                System.out.println(itemsArray.length());

                for (int i = 0; i < itemsArray.length(); i++) {
                    JSONObject book = itemsArray.getJSONObject(i);
                    String title = null;
                    String authors = null;
                    String year = null;
                    String publisher = null;
                    String photo = null;
                    if (book.has("volumeInfo")) {
                        JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                        if (volumeInfo.has("title")) {
                            title = volumeInfo.getString("title");
                            System.out.println(title);
                        }
                        if (volumeInfo.has("authors")) {
                            authors = volumeInfo.getString("authors");
                        }
                        if (volumeInfo.has("publisherDate")) {
                            year = volumeInfo.getString("publishedDate");
                        }
                        if (volumeInfo.has("publisher")) {
                            publisher = volumeInfo.getString("publisher");
                        }
                        if (volumeInfo.has("imageLinks")) {
                            JSONObject imageLink = volumeInfo.getJSONObject("imageLinks");
                            if (volumeInfo.has("smallThumbnail")) {
                                photo = imageLink.getString("smallThumbnail");
                            }
                        }
                    }
                    System.out.println("Hola2");



                    /*if (title != null && authors != null) {
                        mTitleText.setText(title);
                        mAuthorText.setText(authors);
                        return;
                    }*/
                    //debuguing
                    ArrayList<String> atributes = new ArrayList<>(Arrays.asList(title, authors, year, publisher, photo));
                    books.add(atributes);
                    System.out.println(books.size());
                }
            }
            System.out.println("HIIIIIIIIIIIIE");

        }catch (Exception e){
            System.out.println("HIIOOOLLLLLO");
        }
        System.out.println("HIIOOOOOOOOOOO");
    }

    public ArrayList<ArrayList<String>> obtenirBooks(){
        System.out.println("OBTINGUT LLIBRES");
        return books;
    }

}
