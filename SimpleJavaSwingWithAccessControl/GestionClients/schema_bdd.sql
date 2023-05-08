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
/**
 * Author:  Tarek Boutefara <t_boutefara@esi.dz>
 * Created: 6 mai 2023
 */

Create Table Utilisateur (
    id Integer Primary Key AutoIncrement,
    nom_utilisateur Char(100),
    mot_de_passe Char(100),
    type_utilisateur Char(100)
);

/*
 * Quelques utilisateurs par défaut.
 * L'application ne va pas offrir la possibilité de créer ou de modifier
 * les utilisateurs.
 */ 
Insert into Utilisateur Values (NULL, 'admin', '123456', 'admin');
Insert into Utilisateur Values (NULL, 'user1', '123456', 'user');
Insert into Utilisateur Values (NULL, 'user2', '123456', 'user');

Create Table Client (
    id Integer Primary Key AutoIncrement,
    nom Char(50),
    prenom Char(50),
    nTel Char(13),
    adresse Char(200),
    cree_par Integer id References Utilisateur(id)
);
