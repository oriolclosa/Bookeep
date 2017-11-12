package com.teamnani.bookeep.dades;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Muniategui on 11/11/2017.
 */

public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();
    private static final String BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes?";
    private static final String QUERY_PARM = "q";
    private static final String MAX_RESULTS = "maxResults";
    private static final String PRINT_TYPE = "printType";
    private static final String ORDER_BY = "orderBy";

    static String getBookInfo(String queryString, String bomag, String relnew){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String bookJSONString = null;

            Uri buildUri = Uri.parse(BOOK_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARM, queryString)
                    .appendQueryParameter(MAX_RESULTS, "6")
                    .appendQueryParameter(PRINT_TYPE, bomag)
                    .appendQueryParameter(ORDER_BY, relnew)
                    .build();

        System.out.println(buildUri.toString());

        try {
            URL requestURL = new URL(buildUri.toString());

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null){
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }
            if (buffer.length() == 0){
                return null;
            }
            bookJSONString = buffer.toString();

        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }finally{
            if (urlConnection!=null){
                urlConnection.disconnect();
            }
            if (reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            //Log.d(LOG_TAG, bookJSONString);
            return bookJSONString;
        }
    }


}









