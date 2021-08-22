/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoandk
 */
public class DBContext {

    Connection connection;

//    public DBContext() {
//
//         String database = "slotmachine";
//        try {
//            String url = "jdbc:mysql://localhost:3306/" + database + "";
//            String user = "hoandk20";
//            String pass = "anhhoan20";
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(url, user, pass);
//        } catch (Exception ex) {
//            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    String database = "sql5430309";
    String user = "sql5430309";
    String pass = "bPHkmvxcVB";
    String port = "3306";
    String host = "sql5.freesqldatabase.com";

    public DBContext() {
        try {
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "";

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
