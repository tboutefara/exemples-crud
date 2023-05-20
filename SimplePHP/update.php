<!DOCTYPE html>
<!--
Copyright 2023 Tarek Boutefara <t_boutefara@esi.dz>.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
-->
<?php
include('loader.php');
$client = NULL;

if(isset($_POST["id"])){
    $client = DAOClient::getClientById($_POST["id"]);
}
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        if($client != NULL){
        ?>
        <form action="/app/control/updatecontroller.php" method="post">
            Last Name : <input type="text" name="last_name" value="<?= $client->last_name ?>"/><br/>
            First Name : <input type="text" name="first_name" value="<?= $client->first_name ?>"/><br/>
            Phone Number : <input type="text" name="phone_number" value="<?= $client->phone_number ?>"/><br/>
            Adresse : <input type="text" name="adresse" value="<?= $client->adresse ?>"/><br/>
            Adresse : <input type="hidden" name="id" value="<?= $client->id ?>"/><br/>
            <input type="submit" name="submit" value="Mettre à jour Client"/><br/>
        </form>
        <?php
        }else{
            echo 'Requete incorrect! <br/> <a href="index.php">Accueil</a>';
        }
        ?>
    </body>
</html>
