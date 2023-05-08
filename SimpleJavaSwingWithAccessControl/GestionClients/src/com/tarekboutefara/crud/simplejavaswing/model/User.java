/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarekboutefara.crud.simplejavaswing.model;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class User {
    
    int id;
    String username;
    String userType;

    public User() {
    }

    public User(int id, String username, String userType) {
        this.id = id;
        this.username = username;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    
}
