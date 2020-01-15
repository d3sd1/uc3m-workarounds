<?php
require('kernel/core.php');
if(USER_LOGGED_IN)
{
	$core->session_destroy('yumiUserEmail');
	if($core->session_isSet('yumiAdminUserLocked'))
	{
		$core->session_destroy('yumiAdminUserLocked');
	}
	header('Location: '.URL.'?logout=success');
}
else
{
	header('Location: '.URL.'?logout=error');
}