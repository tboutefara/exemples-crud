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
<html>
    <head>
        <meta charset="UTF-8">
        <link href="node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="node_modules/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
        <title>Ajouter un nouveau Client</title>
    </head>
    <body class="container">
        <form action="/app/control/addcontroller.php" method="post">
            <div class="input-group row">
                <div class="m-1">Last Name :
                    <input type="text" class="form-control" name="last_name" />
                </div>
                <div class="m-1">First Name :
                    <input type="text" class="form-control" name="first_name" />
                </div>
                <div class="m-1">Phone Number :
                    <input type="text" class="form-control" name="phone_number" />
                </div>

                <div class="m-1">Adresse : 
                    <input type="text" class="form-control" name="adresse" />
                </div>
                <div class="m-1">
                    <input type="submit" class="btn btn-primary w-100" name="submit" value="Ajouter Client"/>
                </div>
            </div>
        </form>
    </body>
</html>
