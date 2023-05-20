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
$clients = array();
if (isset($_POST["id"])) {
    $clients = array(DAOClient::getClientById($_POST["id"]));
} else if (isset($_POST["name"])) {
    $clients = DAOClient::getClientsByName($_POST["name"]);
} else {
    $clients = DAOClient::getAllClients();
}
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <form action="index.php" method="post">
            <input type="submit" value="Afficher tous les Clients"/>
        </form><br/>
        <form action="index.php" method="post">
            <input type="text" name="id" />
            <input type="submit" value="Recherche par Id"/>
        </form><br/>
        <form action="index.php" method="post">
            <input type="text" name="name" />
            <input type="submit" value="Recherche par Nom"/>
        </form><br/>
        <table>
        <?php
        foreach ($clients as $client) {
            echo '<tr>';
            echo '<td>'.$client->id . '</td><td>'
            . $client->last_name . '</td><td>'
            . $client->first_name . '</td><td>'
            . $client->phone_number . '</td><td>'
            . $client->adresse . '</td><td>'
            . updateForm($client->id) . '</td>';
            echo "</tr>\n";
        }
        ?>
        </table>
    </body>
</html>
