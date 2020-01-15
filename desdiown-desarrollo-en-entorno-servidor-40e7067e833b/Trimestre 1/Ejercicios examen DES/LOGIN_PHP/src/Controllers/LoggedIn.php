<?php

namespace Controllers;

class LoggedIn {
    public function index(){       
        include "views/logged_in.php";
    }
    public function logout(){       
        include "views/logout.php";
    }
}
