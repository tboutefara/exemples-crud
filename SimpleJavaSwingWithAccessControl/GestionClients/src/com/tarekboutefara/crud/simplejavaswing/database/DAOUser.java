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

import com.tarekboutefara.crud.simplejavaswing.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This aclass allows the interrogation of the User table in the database.
 * Given the goal of this example which is a simple demonstration of RBAC, 
 * this class offer only the authentication method.
 * 
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class DAOUser {
    
    /**
     * Authenticate a user given his useername and password.
     * @param username The user's username.
     * @param password The user's password.
     * @return The authenticated user, null if no user with the specified username and password if found.
     * @throws SQLException Rised if a database related exception occurs.
     */
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
