package com.teamnani.bookeep.dades;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class GoogleAPIBook extends AsyncTask<String, Void, String> {
    private ArrayList<ArrayList<String>> books;

    public GoogleAPIBook (ArrayList<ArrayList<String>> books){
        this.books = books;
    }


    @Override
    protected String doInBackground(String...strings){
        //System.out.println(NetworkUtils.getBookInfo(strings[0]));
        return NetworkUtils.getBookInfo(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try{
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject book = itemsArray.getJSONObject(i);
                String title = null;
                String authors = null;
                String year = null;
                String publisher = null;
                String photo = null;
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                try{
                    JSONObject imageLink = volumeInfo.getJSONObject("imageLink");
                    try{
                        photo = imageLink.getString("smallThumbnail");

                    } catch (Exception e) {
                    }
                }catch (Exception e){
                }
                try {
                    title = volumeInfo.getString("title");
                } catch (Exception e) {
                }
                try{
                    authors = volumeInfo.getString("authors");
                } catch (Exception e) {
                }
                try{
                    year = volumeInfo.getString("publishedDate");
                } catch (Exception e) {
                }
                try{
                    publisher = volumeInfo.getString("publisher");
                } catch (Exception e) {
                }


                /*if (title != null && authors != null) {
                    mTitleText.setText(title);
                    mAuthorText.setText(authors);
                    return;
                }*/
                //debuguing
                ArrayList<String> atributes = new ArrayList<>(Arrays.asList(title, authors, year, publisher, photo));
                books.add(atributes);
            }

        }catch (Exception e){
        e.printStackTrace();
        }
    }

}
