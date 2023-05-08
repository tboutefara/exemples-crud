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
package com.tarekboutefara.crud.simplejavaswing.main;

import com.tarekboutefara.crud.simplejavaswing.database.DAOClient;
import com.tarekboutefara.crud.simplejavaswing.database.DAOUser;
import com.tarekboutefara.crud.simplejavaswing.gui.AuthenticationFrame;
import com.tarekboutefara.crud.simplejavaswing.gui.MainFrame;
import com.tarekboutefara.crud.simplejavaswing.model.Client;
import com.tarekboutefara.crud.simplejavaswing.model.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Main class and the main controller for this application.
 * Given the size of this application, there was no need to create a
 * separate controller. This class ensure the orchestration between
 * the View classes (JFrames) and the database interrogations (DAOClient).
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Main {
    
    /**
     * The default configuration file.
     */
    public final static String CONFIG_FILE = "config.xml";
    
    /**
     * The default configuration object.
     */
    public static Properties CONFIG = new Properties();
    
    /**
     * Response message : OK.
     * Returned if the database interrogation was successful.
     */
    public static final int OK = 0;
    
    /**
     * Error message : DATABASE ERROR.
     * Returned of the database interrogation failed.
     */
    public static final int DATABASE_ERROR = 1;
    
    /**
     * Error message : MISSING DATA.
     * Returned of the data introduced by the user are incomplete
     * (some required data are missing).
     */
    public static final int MISSING_DATA = 2;
    
    public static final int CREDENTIELS_INCORRECT = 3;
    
    private static User user;

    /**
     * The app launcher.
     * @param args the command line arguments (no arguments are required).
     */
    public static void main(String[] args) {
        
        Logger.getLogger("Main").info("Starting...");
      
        try {
            CONFIG.loadFromXML(new FileInputStream(new File(CONFIG_FILE)));
        } catch (IOException ex) {
            try {
                Logger.getLogger("Main").info("La configuration par défaut "
                        + "n'a pas pu être récupérée, elle va être créée");
                CONFIG = saveDefaultValues();
            } catch (IOException ex1) {
                Logger.getLogger("Main").info("La configuration n'a pas pu être créée");
                System.exit(0);
            }
        }
        
        (new AuthenticationFrame()).setVisible(true);
    }
    
    /**
     * This methods creates the default configuration.
     * @return A Properties object with default values.
     * @throws IOException 
     */
    public static Properties saveDefaultValues() throws IOException{
        Properties p = new Properties();
        
        p.setProperty("driver", "");
        p.setProperty("connection_url", "jdbc:sqlite:bdd.db");
        p.setProperty("user", "");
        p.setProperty("password", "");
        
        p.storeToXML(new FileOutputStream(new File(CONFIG_FILE)), 
                "Configuration par défaut");
        return p;
    }

    /**
     * Exit the application.
     */
    public static void exit() {
        Logger.getLogger("Main").info("Closing app");
        System.exit(0);
    }

    /**
     * The conroller method to save a new Client. 
     * @param c The client to save.
     * @return The resulting code.
     */
    public static int saveClient(Client c) {
        Logger.getLogger("Main").info("Saving Client");
        if(c.getFirstName().equals("") || c.getLastName().equals(""))
            return MISSING_DATA;
        
        try {
            if(DAOClient.saveClient(c))
                return OK;
            else
                return DATABASE_ERROR;
            
        } catch (SQLException ex) {
            Logger.getLogger("Main").log(Level.SEVERE, null, ex);
            return DATABASE_ERROR;
        }
    }

    /**
     * The conroller method to update an existing Client.
     * @param c The Client to update.
     * @return The resulting code.
     */
    public static int updateClient(Client c) {
        Logger.getLogger("Main").log(Level.INFO, "Updating client (id = {0})", c.getId());
        if(c.getFirstName().equals("") || c.getLastName().equals(""))
            return MISSING_DATA;
        
        try {
            if(DAOClient.updateClient(c))
                return OK;
            else
                return DATABASE_ERROR;
            
        } catch (SQLException ex) {
            Logger.getLogger("Main").log(Level.SEVERE, null, ex);
            return DATABASE_ERROR;
        }
    }

    /**
     * The conroller method to retreive all Clients.
     * @return The list of all Clients.
     */
    public static List<Client> getAllClients() {
        Logger.getLogger("Main").info("Retreiving all Clients.");
        try {
            if(user.getUserType().equals("admin"))
                return DAOClient.allClients();
            else
                return DAOClient.allClientsFilteredByUser(user.getId());
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * The conroller method to retreive a Client by "id".
     * The Client will be wrapped in a list.
     * @param id The id of the Client to retreive.
     * @return A list that contains a unique Client if found.
     */
    public static List<Client> searchByIdAsList(int id) {
        Logger.getLogger("Main").log(Level.INFO, "Seraching client (id = {0})", id);
        List<Client> list = new ArrayList<>();
        try {
            Client c = null;
            if(user.getUserType().equals("admin"))
                c = DAOClient.getById(id);
            else
                c = DAOClient.getByIdFilteredByUser(id, user.getId());
            if(c != null)
                list.add(c);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * The conroller method to retreive Clients with  "name" in their first or last name.
     * @param name The name to search with.
     * @return A list of Clients that respect the search criteria.
     */
    public static List<Client> searchByName(String name) {
        Logger.getLogger("Main").log(Level.INFO, "Seraching client (name = {0})", name);
        try {
            if(user.getUserType().equals("admin"))
                return DAOClient.getByName(name);
            else
                return DAOClient.getByNameFilteredByUser(name, user.getId());
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * The conroller method to retreive a Client by "id".
     * The Client will be returned as an object..
     * @param id The id of the Client to retreive.
     * @return A Client if found.
     */
    public static Client SearchById(int id) {
        Logger.getLogger("Main").log(Level.INFO, "Seraching client (id = {0})", id);
        Client c = null;
        try {
            if(user.getUserType().equals("admin"))
                c = DAOClient.getById(id);
            else
                c = DAOClient.getByIdFilteredByUser(id, user.getId());
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public static int connect(String username, String password) {
        try {
            User u = DAOUser.authenticate(username, password);
            if(u == null){
                return CREDENTIELS_INCORRECT;
            }else{
                Main.user = u;
                (new MainFrame()).setVisible(true);
                return OK;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return DATABASE_ERROR;
        }
    }
    
    public static User getCurrentUser(){
        return user;
    }
    
}
