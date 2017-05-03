/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.integrationtest;

/**
 *
 * @author Emil
 */
public class User {
    private String name;
    private int phone;
    private String town;

    public User(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
