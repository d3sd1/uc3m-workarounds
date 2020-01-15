<?php
$thisPageLogout=true;
require('admin.php');
if(ADMIN_LOGGED_IN)
{
	$core->session_destroy('yumiAdminUser');
        if($core->session_isSet('yumiAdminUserLocked'))
	{
		$core->session_destroy('yumiAdminUserLocked');
	}
        $db->query('INSERT INTO admin_logs (type,ip,user,timestamp) VALUES ("LOGOUT_SUCCESS",INET_ATON(\''.USER_IP.'\'),"'.ADMIN_NAME.'","'.time().'")');
	header('Location: '.URL.'/login?logout='.(isset($_GET['ref']) ? @$_GET['ref']:'success'));
}
else
{
	header('Location: '.URL.'/login?logout=error');
}