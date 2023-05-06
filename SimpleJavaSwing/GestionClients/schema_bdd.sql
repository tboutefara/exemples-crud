/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Tarek Boutefara <t_boutefara@esi.dz>
 * Created: 6 mai 2023
 */

Create Table Client (
    id Integer Primary Key AutoIncrement,
    nom Char(50),
    prenom Char(50),
    nTel Char(13),
    adresse Char(200)
);
