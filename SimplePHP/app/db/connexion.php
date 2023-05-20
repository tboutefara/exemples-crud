<?php

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

class Connexion {
    
    private static $connexion;
    
    function getConnexion(){
        if(!isset(self::$connexion)){
           self::$connexion = new SQLite3($_SERVER["DOCUMENT_ROOT"] . '/bdd.db', SQLITE3_OPEN_READWRITE);
        }
        return self::$connexion;
    }
    
}

