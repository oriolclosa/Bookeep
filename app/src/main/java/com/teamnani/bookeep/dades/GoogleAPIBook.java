package com.teamnani.bookeep.dades;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class GoogleAPIBook extends AsyncTask<String, Void, String> {
    private ArrayList<ArrayList<String>> books;

    public GoogleAPIBook(){
        books = new ArrayList<>();
    }

    @Override
    protected String doInBackground(String...strings){
        //System.out.println(NetworkUtils.getBookInfo(strings[0]));
        String s = NetworkUtils.getBookInfo(strings[0], strings[1], strings[2]);
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
                    String ISBN = null;
                    String description =null;
                    if (book.has("volumeInfo")) {
                        JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                        if (volumeInfo.has("title")) {
                            title = volumeInfo.getString("title");
                            System.out.println(title);
                        }
                        if (volumeInfo.has("authors")) {
                            authors = volumeInfo.getString("authors");
                        }
                        if (volumeInfo.has("publishedDate")) {
                            year = volumeInfo.getString("publishedDate");
                        }
                        if (volumeInfo.has("publisher")) {
                            publisher = volumeInfo.getString("publisher");
                        }
                        if (volumeInfo.has("imageLinks")) {
                            JSONObject imageLink = volumeInfo.getJSONObject("imageLinks");
                            if (imageLink.has("smallThumbnail")) {
                                photo = imageLink.getString("smallThumbnail");
                            }
                        }
                        if (volumeInfo.has("industryIdentifiers")){
                            JSONArray industryIdentifiers = volumeInfo.getJSONArray("industryIdentifiers");
                            if (industryIdentifiers.getJSONObject(0).has("type"))
                                ISBN = industryIdentifiers.getJSONObject(0).getString("identifier");
                        }
                        System.out.println(ISBN);
                        if(volumeInfo.has("description")){
                            description = volumeInfo.getString("description");
                        }
                    }



                    /*if (title != null && authors != null) {
                        mTitleText.setText(title);
                        mAuthorText.setText(authors);
                        return;
                    }*/
                    //debuguing
                    ArrayList<String> atributes = new ArrayList<>(Arrays.asList(title, authors, year, publisher, photo,ISBN, description));
                    books.add(atributes);
                    System.out.println(books.size());
                }
            }

        }catch (Exception e){
        }
        return s;
    }

    public ArrayList<ArrayList<String>> obtenirBooks(){
        System.out.println("Hola1");
        return books;
    }

}
//