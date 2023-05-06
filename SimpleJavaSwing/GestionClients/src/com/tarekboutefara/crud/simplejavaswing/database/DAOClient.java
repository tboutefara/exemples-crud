/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarekboutefara.crud.simplejavaswing.database;

import com.tarekboutefara.crud.simplejavaswing.model.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class DAOClient {
    
    public static boolean saveClient(Client c) throws SQLException{
        
        String query = "Insert into Client Values (NULL, ?, ?, ?, ?)";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        Logger.getLogger("DAOClient").info("[" + query + "] prepared");
        
        ps.setString(1, c.getLastName());
        ps.setString(2, c.getFirstName());
        ps.setString(3, c.getPhoneNumber());
        ps.setString(4, c.getAdresse());
        
        int affectedRows = ps.executeUpdate();
        Logger.getLogger("DAOClient").info("[" + query + "] run");
        
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            c.setId(generatedKeys.getInt(1));
        }
        
        return affectedRows == 1;
        
    }
    
    public static boolean updateClient(Client c) throws SQLException{
        
        String query = "Update Client Values set "
                + "nom = ?, "
                + "prenom = ?,"
                + "nTel = ?,"
                + "adresse = ? "
                + "Where id = ?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        Logger.getLogger("DAOClient").info("[" + query + "] prepared");
        
        ps.setString(1, c.getLastName());
        ps.setString(2, c.getFirstName());
        ps.setString(3, c.getPhoneNumber());
        ps.setString(4, c.getAdresse());
        ps.setInt(5, c.getId());
        
        int affectedRows = ps.executeUpdate();
        Logger.getLogger("DAOClient").info("[" + query + "] run");
        
        return affectedRows == 1;
        
    }
    
    public static List<Client> allClients() throws SQLException{
        
        String query = "Select * from Client";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        
        List<Client> list = new ArrayList<>();
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Client c = new Client(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("nTel"),
                    rs.getString("adresse")
            );
            list.add(c);
        }
        
        return list;
        
    }
    
    public static Client getById(int id) throws SQLException{
        
        String query = "Select * from Client Where id = ?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        
        ps.setInt(1, id);
        
        Client c = null;
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            c = new Client(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("nTel"),
                    rs.getString("adresse")
            );
        }
        
        return c;
        
    }
    
    public static List<Client> getByName(String name) throws SQLException{
        
        String query = "Select * from Client Where nom like ? or prenom like ?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        
        ps.setString(1, '%' + name + '%');
        ps.setString(2, '%' + name + '%');
        
        List<Client> list = new ArrayList<>();
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Client c = new Client(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("nTel"),
                    rs.getString("adresse")
            );
            list.add(c);
        }
        
        return list;
        
    }
    
}
