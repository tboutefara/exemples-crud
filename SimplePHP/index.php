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
        <link href="node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="node_modules/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
        <title></title>
    </head>
    <body class="container">
        <div class="row">
            <div class="col-12">
            <form action="index.php" method="post">
                <input type="submit" class="btn btn-primary w-50 m-1" value="Afficher tous les Clients"/>
            </form>
            <a class="btn btn-primary w-50 m-1" href="add.php">Ajouter un Client</a>
            </div>
        </div>
        <div class="row">
            <form action="index.php" method="post">
            <div class="input-group cols-12">
                <input type="text" class="form-control w-50 m-1" name="id" />
                <input type="submit" class="btn btn-primary w-25 m-1" value="Recherche par Id"/>
            </div>
            </form>
        </div>
        <div class="row">
            <form action="index.php" method="post">
            <div class="input-group cols-12">
                <input type="text" class="form-control w-50 m-1" name="name" />
                <input type="submit" class="btn btn-primary w-25 m-1" value="Recherche par Nom"/>
            </div>
            </form>
        </div>
            <table class="table m-2">
                <tr>
                    <th>Code</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>N° Téléphone</th>
                    <th>Adresse</th>
                    <th>Actions</th>
                </tr>
                <?php
                foreach ($clients as $client) {
                    echo '<tr>';
                    echo '<td>' . $client->id . '</td><td>'
                    . $client->last_name . '</td><td>'
                    . $client->first_name . '</td><td>'
                    . $client->phone_number . '</td><td>'
                    . $client->adresse . '</td><td>'
                    . updateForm($client->id) . '</td>';
                    echo "</tr>\n";
                }
                ?>
            </table>
            </div>
        </div>
    </body>
</html>
