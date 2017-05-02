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
    public String navn = "emil";

    private static DbConn instance;

    public static DbConn getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new DbConn();
        }
        return instance;
    }

    public void makeConn() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + host + ":" + portnr + "/" + database;
        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("call getPhone(\"" + navn + "\");");

        // iterate through the java resultset
        while (rs.next()) {
            int number = rs.getInt("cell_number");

            System.out.println("number = " + number);
        }
        stmt.close();
    }
}
