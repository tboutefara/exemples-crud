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
        <title></title>
    </head>
    <body>
        <?php
        // put your code here
        ?>
        <form action="/app/control/addcontroller.php" method="post">
            Last Name : <input type="text" name="last_name" /><br/>
            First Name : <input type="text" name="first_name" /><br/>
            Phone Number : <input type="text" name="phone_number" /><br/>
            Adresse : <input type="text" name="adresse" /><br/>
            <input type="submit" name="submit" value="Ajouter Client"/><br/>
        </form>
    </body>
</html>
