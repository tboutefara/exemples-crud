/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarekboutefara.crud.simplejavaswing.database;

import com.tarekboutefara.crud.simplejavaswing.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class DAOUser {
    
    public static User authenticate(String username, String password) throws SQLException{
        
        String query = "Select * from Utilisateur Where nom_utilisateur = ?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        
        ps.setString(1, username);
        
        User u = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            if(rs.getString("mot_de_passe").equals(password)){
                u = new User(rs.getInt("id"),
                        rs.getString("nom_utilisateur"),
                        rs.getString("type_utilisateur"));
            }
        }
        
        return u;
        
    }
    
}
