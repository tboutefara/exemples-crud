/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarekboutefara.crud.simplejavaswing.main;

import com.tarekboutefara.crud.simplejavaswing.database.DAOClient;
import com.tarekboutefara.crud.simplejavaswing.gui.MainFrame;
import com.tarekboutefara.crud.simplejavaswing.model.Client;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Main {
    
    public final static String CONFIG_FILE = "config.xml";
    public static Properties CONFIG = new Properties();
    
    public static final int OK = 0;
    public static final int DATABASE_ERROR = 1;
    public static final int MISSING_DATA = 2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Logger.getLogger("Main").info("Starting...");
      
        try {
            CONFIG.loadFromXML(new FileInputStream(new File(CONFIG_FILE)));
        } catch (IOException ex) {
            try {
                CONFIG = saveDefaultValues();
            } catch (IOException ex1) {
                Logger.getLogger("Main").info("La configuration n'a pas pu être créée");
                System.exit(0);
            }
        }
        
        (new MainFrame()).setVisible(true);
    }
    
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

    public static void exit() {
        Logger.getLogger("Main").info("Closing app");
        System.exit(0);
    }

    public static int saveClient(Client c) {
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

    public static int updateClient(Client c) {
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

    
}
