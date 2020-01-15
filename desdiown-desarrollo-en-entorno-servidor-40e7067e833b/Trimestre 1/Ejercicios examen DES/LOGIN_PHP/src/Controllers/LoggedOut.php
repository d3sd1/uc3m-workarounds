<?php

namespace Controllers;

class LoggedOut
{

    public function loginform()
    {
        include "views/login_form.php";
    }

    public function loginSuccess()
    {
        include "views/login_success.php";
    }

    public function loginError()
    {
        include "views/login_error.php";
    }
}
