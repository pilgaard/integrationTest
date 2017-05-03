/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.integrationtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emil
 */
public class DbConn {

    private Connection conn;
    private Statement stmt;
    private String host = "localhost";
    private int portnr = 3306;
    private String database = "fire";
    private String username = "fire";
    private String password = "root";

    public DbConn() {
    }

    public void makeConn() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://" + host + ":" + portnr + "/" + database;
        conn = DriverManager.getConnection(url, username, password);
    }

    public int getPhone(String name) {
        int number = 0;
        try {
            if (conn == null) {

                makeConn();

            }
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("call getPhone(\"" + name + "\");");
            
            // iterate through the java resultset
            if (rs.next()) {
                number = rs.getInt("cell_number");
            }
            stmt.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;
    }
}
