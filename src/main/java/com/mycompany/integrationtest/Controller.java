/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.integrationtest;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emil
 */
public class Controller {

    private User person;
    private DbConn dbConn;

    public Controller(User p) {
        dbConn = new DbConn();
        person = p;
    }

    public void checkPhone() {
        int phone = dbConn.getPhone(person.getName());
        person.setPhone(phone);
        System.out.println(person.toString()+"'s phone is " + person.getPhone());
    }
}
