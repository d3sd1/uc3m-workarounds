<?php

namespace Services;

use Utils\Constants;
use Utils\Config;

class Database
{

    const SQL_SELECT_LOGIN_PHP = "SELECT password FROM login_php WHERE nombre=?";
    const SQL_UPDATE_LOGIN_PHP = "UPDATE login_php SET fecha_login=? WHERE nombre=?";
    const SQL_INSERT_LOGIN_PHP = "INSERT INTO login_php (nombre,password,fecha_login) VALUES (?,?,?)";
    const SQL_SELECT_USERS = "SELECT * FROM users WHERE nombre=?";
    const SQL_INSERT_USERS = "INSERT INTO users (nombre,activo,FECHA_ACTIVACION) VALUES (?,1,?)";
    const SQL_UPDATE_USERS = "UPDATE users SET activo=1 AND FECHA_ACTIVACION=? WHERE nombre=?";

    private function setUserActive($con, $username)
    {
        $return = false;
        /* Revisar si existe y está activo en la tabla USERS */
        $stmt3 = $con->prepare(Database::SQL_SELECT_USERS);
        $stmt3->bind_param("s", $username);
        $stmt3->execute();
        $res3 = $stmt3->get_result();
        $foundUser = $res3->fetch_assoc();
        
        $dateFormat = new \DateTime();
        $activeDate = $dateFormat->format(Constants::DATE_FORMAT);
        
        if(count($foundUser) != 0)
        {
            /* Actualizar user y poner activo=1 */
            $stmt4 = $con->prepare(Database::SQL_UPDATE_USERS);
            $stmt4->bind_param("ss", $activeDate, $username);
            $stmt4->execute();
        }
        else
        {
            /* Insertar user y poner activo=1 */
            $stmt4 = $con->prepare(Database::SQL_INSERT_USERS);
            $stmt4->bind_param("ss", $username, $activeDate);
            $stmt4->execute();
        }
        if($stmt4->affected_rows > 0)
        {
            $con->commit();
            $return = true;
        }
        else
        {
            $con->rollback();
            $return = false;
        }
        $stmt4->close();
        $res3->free();
        $stmt3->close();
        return $return;
    }
    private function setUserLoginDate($con, $username)
    {
        $return = false;
        $stmt2 = $con->prepare(Database::SQL_UPDATE_LOGIN_PHP);
        $dateFormat = new \DateTime();
        $loginDate = $dateFormat->format(Constants::DATE_FORMAT);

        $stmt2->bind_param("ss", $loginDate, $username);
        $stmt2->execute();
        if($stmt2->affected_rows === 0)
        {
            $return = false;
        }
        else
        {
            $return = $this->setUserActive();
        }
        $stmt2->close();
        return $return;
    }
    private function insertLoginPhpUser($con,$username,$password)
    {
        $return = false;
        $stmt2 = $con->prepare(Database::SQL_INSERT_LOGIN_PHP);
        $dateFormat = new \DateTime();
        $loginDate = $dateFormat->format(Constants::DATE_FORMAT);

        $stmt2->bind_param("sss", $username, $password, $loginDate);
        $stmt2->execute();
        if($stmt2->affected_rows === 0)
        {
            $return = false;
        }
        else
        {
            $return = $this->setUserActive($con,$username);
        }
        $stmt2->close();
        return $return;
    }
    public function login($username, $password)
    {
        $return = false;
        
        $con = new \mysqli(Config::DB_HOST, Config::DB_USER, Config::DB_PASS, Config::DB_NAME);
        if ($con->connect_error)
        {
            echo "Error en la conexión: " . $con->connect_error;
        }
        $con->autocommit(FALSE);
        $stmt = $con->prepare(Database::SQL_SELECT_LOGIN_PHP);
        $stmt->bind_param("s", $username);
        $stmt->execute();
        $res = $stmt->get_result();
        $foundLoginPHP = $res->fetch_assoc();
        /* Revisar si el usuario está en la base de datos. */
        if (count($foundLoginPHP) != 0 && $foundLoginPHP["password"] == $password)
        {
            /* Actualizar fecha */
            $return = $this->setUserLoginDate($con, $username);
        }
        else
        {
            /* Insertar user y marcarlo como activo */
            if($this->insertLoginPhpUser($con,$username,$password))
            {
                $con->commit();
                $return = true;
            }
            else
            {
                $con->rollback();
                $return = false;
            }
        }
        $res->free();
        $stmt->close();
        $con->close();
        return $return;
    }

}
