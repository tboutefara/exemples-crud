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

if (isset($_POST["id"])) {
    $client = DAOClient::getClientById($_POST["id"]);
}
?>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="node_modules/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
        <title>Modifier Client <?= $client->id ?></title>
    </head>
    <body class="container">
        <?php
        if ($client != NULL) {
            ?>
            <form action="/app/control/updatecontroller.php" method="post">
                <div class="row">
                    <div class="input-group offset-3">
                        <div class="col-6 m-1">Last Name :
                            <input type="text" class="form-control" name="last_name" value="<?= $client->last_name ?>"/>
                        </div>
                        <div class="col-6 m-1">First Name :
                            <input type="text" class="form-control" name="first_name" value="<?= $client->first_name ?>"/>
                        </div>
                        <div class="col-6 m-1">Phone Number :
                            <input type="text" class="form-control" name="phone_number" value="<?= $client->phone_number ?>"/>
                        </div>

                        <div class="col-6 m-1">Adresse : 
                            <input type="text" class="form-control" name="adresse" value="<?= $client->adresse ?>"/>
                        </div>
                        <input type="hidden" name="id" value="<?= $client->id ?>"/>
                        <div class="col-6 m-1">
                            <input type="submit" class="btn btn-primary w-100" name="submit" value="Mettre à jour Client"/>
                        </div>
                    </div>
                </div>
            </form>
            <?php
        } else {
            echo 'Requete incorrect! <br/> <a href="index.php">Accueil</a>';
        }
        ?>
    </body>
</html>
