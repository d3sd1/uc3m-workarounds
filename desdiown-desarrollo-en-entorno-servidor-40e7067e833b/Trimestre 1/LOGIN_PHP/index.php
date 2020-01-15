<?php

require 'init.php';

use Controllers\LoggedIn;
use Controllers\LoggedOut;
use Services\Database;
use Utils\Constants;

$action = (isset($_REQUEST[Constants::PAR_ACTION]) ? $_REQUEST[Constants::PAR_ACTION]:"");
/* Revisar si el usuario está conectado */
if (isset($_SESSION[Constants::SESS_LOGIN]))
{
    $cont = new LoggedIn();
    if($action == Constants::VAL_ACTION_LOGOUT)
    {
        session_destroy();
        $cont->logout();
    }
    else
    {
        $cont->index();
    }
}
else /* Usuario desconectado */
{
    $cont = new LoggedOut();
    /* Si la acción es conectar, procesar la petición y cargar la vista correspondiente. Si no, mostrar el formulario de conexión */
    if($action == Constants::VAL_ACTION_LOGIN)
    {
        $username = (isset($_REQUEST[Constants::PAR_LOGIN_USER]) ? $_REQUEST[Constants::PAR_LOGIN_USER]:"");
        $password = (isset($_REQUEST[Constants::PAR_LOGIN_PASSWORD]) ? $_REQUEST[Constants::PAR_LOGIN_PASSWORD]:"");
        $db = new Database();
        
        /* Validar la conexión, y mostrar la vista correspondiente */
        if($db->login($username,$password))
        {
            $_SESSION[Constants::SESS_LOGIN] = $username;
            $cont->loginSuccess();
        }
        else
        {
            $cont->loginError();
        }
    }
    else
    {
        $cont->loginform();
    }
}