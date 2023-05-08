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

import com.tarekboutefara.crud.simplejavaswing.main.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A singleton warapper around the database connection object.
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class DatabaseConnection {

    private static Connection connection;
    
    /**
     * Get the database connection object.
     * On the first interrogation, the connection is initialized.
     * @return The database connection.
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException{
        if(connection == null){
            connection = DriverManager.getConnection(Main.CONFIG.getProperty("connection_url"));
        }
        return connection;
    }
    
}
