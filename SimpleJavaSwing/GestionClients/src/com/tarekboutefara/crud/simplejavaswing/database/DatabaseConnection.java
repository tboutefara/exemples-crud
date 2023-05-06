/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarekboutefara.crud.simplejavaswing.database;

import com.tarekboutefara.crud.simplejavaswing.main.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class DatabaseConnection {

    private static Connection connection;
    
    public static Connection getConnection() throws SQLException{
        if(connection == null){
            connection = DriverManager.getConnection(Main.CONFIG.getProperty("connection_url"));
        }
        return connection;
    }
    
}
