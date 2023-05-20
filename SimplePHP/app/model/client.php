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

// The methods are auto-generated using netbeans, hence the naming is very
// similar to Java.

class Client {
    
    public $id;
    public $last_name;
    public $first_name;
    public $phone_number;
    public $adresse;
    
    function __construct($id, $last_name, $first_name, $phone_number, $adresse) {
        $this->id = $id;
        $this->last_name = $last_name;
        $this->first_name = $first_name;
        $this->phone_number = $phone_number;
        $this->adresse = $adresse;
    }

    function getId() {
        return $this->id;
    }

    function getLast_name() {
        return $this->last_name;
    }

    function getFirst_name() {
        return $this->first_name;
    }

    function getPhone_number() {
        return $this->phone_number;
    }

    function getAdresse() {
        return $this->adresse;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setLast_name($last_name) {
        $this->last_name = $last_name;
    }

    function setFirst_name($first_name) {
        $this->first_name = $first_name;
    }

    function setPhone_number($phone_number) {
        $this->phone_number = $phone_number;
    }

    function setAdresse($adresse) {
        $this->adresse = $adresse;
    }


}
