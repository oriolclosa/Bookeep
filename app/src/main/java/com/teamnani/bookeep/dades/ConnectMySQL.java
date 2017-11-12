package com.teamnani.bookeep.dades;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Oriol on 12/11/2017.
 */

public class ConnectMySQL {

    private static List<String> st_ct;

    public ConnectMySQL() {
    }

    public List<String> getDades(){
        st_ct = new ArrayList<>();
        try{
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement("select nick from user");
            ResultSet Rs = stmt.executeQuery();
            while(Rs.next()){
                st_ct.add(Rs.getString(1));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return st_ct;
    }

    public void setComment(String titol, String nick, String data, float punt, String com) {
        try{
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into coments values('"+nick+"','"+data+"','"+punt+"','"+com+"')");
            stmt.executeUpdate("insert into llibre values('"+titol+"','"+nick+"','"+data+"')");
            con.close();
            System.out.println("FUNCIONA");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://lhcp1043.webapps.net:3306/ly1tsanb_bookeep", "ly1tsanb_bookeep", "Bookeep!*");

    }

    public ArrayList<ArrayList<String>> obteComentarisLlibre(String titol) {
        ArrayList<ArrayList<String>> coments = new ArrayList<>();
        try{
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from coments c, llibre l where l.nick = c.nick and l.time " +
                    "= c.time and l.title = '" +titol+ "'");
            ResultSet Rs = stmt.executeQuery();
            while(Rs.next()){
                ArrayList<String> atributes = new ArrayList<>(Arrays.asList(Rs.getString("nick"), Rs.getString("time"), Rs.getString("rate"), Rs.getString("coment")));
                coments.add(atributes);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return coments;
    }
}
