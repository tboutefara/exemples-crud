/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarekboutefara.crud.simplejavaswing.main;

import com.tarekboutefara.crud.simplejavaswing.gui.MainFrame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
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
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        try {
            CONFIG.loadFromXML(new FileInputStream(new File(CONFIG_FILE)));
        } catch (IOException ex) {
            try {
                CONFIG = saveDefaultValues();
            } catch (IOException ex1) {
                System.out.println("La configuration n'a pas pu être créée");
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
        
        p.storeToXML(new FileOutputStream(new File("CONFIG_FILE")), 
                "Configuration par défaut");
        return p;
    }

    public static void exit() {
        System.exit(0);
    }
    
}
