/* 
 * Copyright 2023 Tarek Boutefara <t_boutefara@esi.dz>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tarekboutefara.crud.simplejavaswing.database;

import com.tarekboutefara.crud.simplejavaswing.model.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class allows the interrogation of the Client database table.
 * It implements the generic methods :
 * <ul>
 *      <li>Insert a new Client.</li>
 *      <li>Update an existing Client.</li>
 *      <li>Get all Clients (a list of Clients is returned).</li>
 *      <li>Search a Client by id (one object is returned).</li>
 *      <li>Search a Client by name (first or last name) (a list of Clients is returned).</li>
 * </ul>
 * 
 * The class is designed to not throw exceptions except for SQLException. That means
 * if no Client with the given id is found a "null" is returned and no exception is thrown.
 * The insertion and update methods return a boolean. These methods except that the
 * insertion and update can't affect more than one row.
 * 
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class DAOClient {
    
    /**
     * This method add a new Client to the database and update his "id".
     * The given Client does not need to have an "id"; the "id" field will be
     * updated by retriving the generated key in the database.
     * 
     * @param c The Client to insert.
     * @return True if the Client has been added to the database.
     * @throws SQLException 
     */
    public static boolean saveClient(Client c) throws SQLException{
        
        String query = "Insert into Client Values (NULL, ?, ?, ?, ?, ?)";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        
        ps.setString(1, c.getLastName());
        ps.setString(2, c.getFirstName());
        ps.setString(3, c.getPhoneNumber());
        ps.setString(4, c.getAdresse());
        ps.setInt(5, c.getCreatedBy());
        
        int affectedRows = ps.executeUpdate();
        Logger.getLogger("DAOClient").info("Database interrogation (save client)");
        
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if(generatedKeys.next()){
            c.setId(generatedKeys.getInt(1));
        }
        
        return affectedRows == 1;
        
    }
    
    /**
     * This method update an existant Client.
     * The object passed as reference must have an "id". Otherwise, the update
     * will fail and the value False will be returned.
     * 
     * @param c The Client to update.
     * @return True is the Client row is updated successfully.
     * @throws SQLException 
     */
    public static boolean updateClient(Client c) throws SQLException{
        
        String query = "Update Client set "
                + "nom = ?, "
                + "prenom = ?,"
                + "nTel = ?,"
                + "adresse = ?, "
                + "cree_par = ? "
                + "Where id = ?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        
        ps.setString(1, c.getLastName());
        ps.setString(2, c.getFirstName());
        ps.setString(3, c.getPhoneNumber());
        ps.setString(4, c.getAdresse());
        ps.setInt(5, c.getCreatedBy());
        ps.setInt(6, c.getId());
        
        int affectedRows = ps.executeUpdate();
        Logger.getLogger("DAOClient").info("Database interrogation (update client)");
        
        return affectedRows == 1;
        
    }
    
    /**
     * Get all the Clients in the database.
     * @return A list of Clients.
     * @throws SQLException 
     */
    public static List<Client> allClients() throws SQLException{
        
        String query = "Select * from Client";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        
        List<Client> list = new ArrayList<>();
        
        ResultSet rs = ps.executeQuery();
        Logger.getLogger("DAOClient").info("Database interrogation (all Clients)");
        
        while(rs.next()){
            Client c = new Client(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("nTel"),
                    rs.getString("adresse"),
                    rs.getByte("cree_par")
            );
            list.add(c);
        }
        
        return list;
        
    }
    
    public static List<Client> allClientsFilteredByUser(int userId) throws SQLException{
        
        String query = "Select * from Client Where cree_par = ?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        
        List<Client> list = new ArrayList<>();
        
        ps.setInt(1, userId);
        
        ResultSet rs = ps.executeQuery();
        Logger.getLogger("DAOClient").info("Database interrogation (all Clients)");
        
        while(rs.next()){
            Client c = new Client(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("nTel"),
                    rs.getString("adresse"),
                    rs.getByte("cree_par")
            );
            list.add(c);
        }
        
        return list;
        
    }
    
    /**
     * Serach a Client by Id.
     * If no Client is found, a null is returned.
     * 
     * @param id The id to search by.
     * @return The Client with the given "id".
     * @throws SQLException 
     */
    public static Client getById(int id) throws SQLException{
        
        String query = "Select * from Client Where id = ?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        
        ps.setInt(1, id);
        
        Client c = null;
        
        ResultSet rs = ps.executeQuery();
        Logger.getLogger("DAOClient").log(Level.INFO, "Database interrogation (Client with id = {0})", id);
        while(rs.next()){
            c = new Client(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("nTel"),
                    rs.getString("adresse"),
                    rs.getInt("cree_par")
            );
        }
        
        return c;
        
    }
    
    public static Client getByIdFilteredByUser(int id, int userId) throws SQLException{
        
        String query = "Select * from Client Where id = ? and cree_par = ?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        
        ps.setInt(1, id);
        ps.setInt(2, userId);
        
        Client c = null;
        
        ResultSet rs = ps.executeQuery();
        Logger.getLogger("DAOClient").log(Level.INFO, "Database interrogation (Client with id = {0})", id);
        while(rs.next()){
            c = new Client(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("nTel"),
                    rs.getString("adresse"),
                    rs.getInt("cree_par")
            );
        }
        
        return c;
        
    }
    
    /**
     * Search Clients with name (first or last).
     * The method return always a list. If no match is found, an empty list
     * is returned (not null).
     * 
     * @param name The name (a string) to search by.
     * @return The list of Clients that have "name" in their first or last name.
     * @throws SQLException 
     */
    public static List<Client> getByName(String name) throws SQLException{
        
        String query = "Select * from Client Where nom like ? or prenom like ?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        
        ps.setString(1, '%' + name + '%');
        ps.setString(2, '%' + name + '%');
        
        List<Client> list = new ArrayList<>();
        
        ResultSet rs = ps.executeQuery();
        Logger.getLogger("DAOClient").log(Level.INFO, "Database interrogation (Client with name = {0})", name);
        
        while(rs.next()){
            Client c = new Client(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("nTel"),
                    rs.getString("adresse"),
                    rs.getInt("cree_par")
            );
            list.add(c);
        }
        
        return list;
        
    }
    
    public static List<Client> getByNameFilteredByUser(String name, int userId) throws SQLException{
        
        String query = "Select * from Client Where (nom like ? or prenom like ?) and cree_par = ?";
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(query);
        
        ps.setString(1, '%' + name + '%');
        ps.setString(2, '%' + name + '%');
        ps.setInt(3, userId);
        
        List<Client> list = new ArrayList<>();
        
        ResultSet rs = ps.executeQuery();
        Logger.getLogger("DAOClient").log(Level.INFO, "Database interrogation (Client with name = {0})", name);
        
        while(rs.next()){
            Client c = new Client(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("nTel"),
                    rs.getString("adresse"),
                    rs.getInt("cree_par")
            );
            list.add(c);
        }
        
        return list;
        
    }
    
}
