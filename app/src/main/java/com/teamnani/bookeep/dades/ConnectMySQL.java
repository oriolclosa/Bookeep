package com.teamnani.bookeep.dades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            stmt.executeUpdate("insert into Coments values('"+nick+"','"+data+"','"+punt+"','"+com+"')");
            stmt.executeUpdate("insert into Llibre values('"+titol+"','"+nick+"','"+data+"')");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://lhcp1043.webapps.net:3306/ly1tsanb_bookeep", "ly1tsanb_bookeep", "Bookeep!*");

    }

}
