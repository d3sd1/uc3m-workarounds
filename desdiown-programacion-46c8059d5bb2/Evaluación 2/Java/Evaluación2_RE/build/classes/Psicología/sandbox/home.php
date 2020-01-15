<?php
require('kernel/core.php');
if(!USER_LOGGED_IN)
{
    header('Location: '.URL);
}
echo 'Usuario conectado: '.$core->session_getValue('yumiUserEmail').'<br>IP:'.$db->query('SELECT INET_NTOA(lastIp) FROM users WHERE email="'.$core->session_getValue('yumiUserEmail').'"')->fetch_row()[0].'<br><a href="'.URL.'/logout">Desconectar</a>';