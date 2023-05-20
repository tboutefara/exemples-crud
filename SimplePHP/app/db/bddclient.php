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

class DAOClient {
    
    public static function addClient($c){
        
        $connexion = Connexion::getConnexion();
        
        $query = "Insert into Client Values (Null, "
                . ":last_name, "
                . ":first_name, "
                . ":phone_number, "
                . ":adresse)";
        
        $statement = $connexion->prepare($query);
        $statement->bindValue(':last_name', $c->last_name);
        $statement->bindValue(':first_name', $c->first_name);
        $statement->bindValue(':phone_number', $c->phone_number);
        $statement->bindValue(':adresse', $c->adresse);
        
        $statement->execute();
        
    }
    
    public static function updateClient($c){
        
        $connexion = Connexion::getConnexion();
        
        $query = "Update Client set "
                . "nom = :last_name, "
                . "prenom = :first_name, "
                . "nTel = :phone_number, "
                . "adresse = :adresse "
                . "Where id = :id";
        
        $statement = $connexion->prepare($query);
        $statement->bindValue(':id', $c->id);
        $statement->bindValue(':last_name', $c->last_name);
        $statement->bindValue(':first_name', $c->first_name);
        $statement->bindValue(':phone_number', $c->phone_number);
        $statement->bindValue(':adresse', $c->adresse);
        
        $statement->execute();
        
    }
    
    
    public static function getAllClients(){
        
        $connexion = Connexion::getConnexion();
        
        $query = "Select * from Client";
        $statement = $connexion->prepare($query);
        $result = $statement->execute();
        
        $clients = array();
        $index = 0;
        while($row = $result->fetchArray(SQLITE3_ASSOC)){
            $c = new Client(
                   $row["id"],
                   $row["nom"],
                   $row["prenom"],
                   $row["nTel"],
                   $row["adresse"]
                );
            
            $clients[$index] = $c;
            $index++;
        }
        
        return $clients;
        
    }
    
    public static function getClientById($id){
        
        $connexion = Connexion::getConnexion();
        
        $query = "Select * from Client Where id = :id";
        $statement = $connexion->prepare($query);
        $statement->bindValue(':id', $id);
        
        $result = $statement->execute();
        
        $client = NULL;

        while($row = $result->fetchArray(SQLITE3_ASSOC)){
            $client = new Client(
                   $row["id"],
                   $row["nom"],
                   $row["prenom"],
                   $row["nTel"],
                   $row["adresse"]
                );
        }
        
        return $client;
        
    }
    
    public static function getClientsByName($name){
        
        $connexion = Connexion::getConnexion();
        
        $query = "Select * from Client "
                . "Where nom like :last_name or "
                . "prenom like :first_name";
        
        $statement = $connexion->prepare($query);
        $statement->bindValue(':last_name', '%'.$name.'%');
        $statement->bindValue(':first_name', '%'.$name.'%');
        $result = $statement->execute();
        
        $clients = array();
        $index = 0;

        while($row = $result->fetchArray(SQLITE3_ASSOC)){
            $c = new Client(
                   $row["id"],
                   $row["nom"],
                   $row["prenom"],
                   $row["nTel"],
                   $row["adresse"]
                );
            
            $clients[$index] = $c;
            $index++;
        }
        
        return $clients;
    }
    
}

