<?php
require('admin.php');
if(!isset($_POST['g-recaptcha-response']) or @$_POST['g-recaptcha-response'] == null)
{
	echo 'ERROR_CAPTCHA|'.$lang['login.attempt.captchanull'];
	die();
}
$captchaResponse = json_decode(file_get_contents('https://www.google.com/recaptcha/api/siteverify?secret='.$config['recaptcha.secretkey'].'&response='.$_POST['g-recaptcha-response'].'&remoteip='.USER_IP), true);
if(!$captchaResponse['success'])
{
	echo 'ERROR_CAPTCHA|'.$lang['login.attempt.captchanull'];
	die();
}
if($db->query('SELECT id FROM admin_attempts WHERE type="login" AND ip=INET_ATON(\''.USER_IP.'\')')->num_rows == 0)
{
	$db->query('INSERT INTO admin_attempts (attempts,ip,timestampExpires,type) VALUES (0,INET_ATON(\''.USER_IP.'\'),'.(time()+$config['admin.loginattempts.interval']).',"login")') or die($db->error);
}
else
{
	$preAttempts = $db->query('SELECT attempts,timestampExpires FROM admin_attempts WHERE type="login" AND ip=INET_ATON(\''.USER_IP.'\')')->fetch_row();
	if($preAttempts[1] < time())
	{
		$db->query('UPDATE admin_attempts SET attempts=0 WHERE type="login" AND ip=INET_ATON(\''.USER_IP.'\')') or die($db->error);
	}
	elseif($preAttempts[0] > $config['admin.login.maxattempts'])
	{
		echo 'ERROR_BOT|GET_FUCKED';
		die();
	}
}
$attemtps = $db->query('SELECT attempts FROM admin_attempts WHERE type="login" AND ip=INET_ATON(\''.USER_IP.'\')')->fetch_row()[0];
if(!isset($_POST['loginAdminUser']) or @$_POST['loginAdminUser'] == null)
{
	$db->query('INSERT INTO admin_logs (type,ip,user,timestamp) VALUES ("LOGIN_FAILED",INET_ATON(\''.USER_IP.'\'),"'.$_POST['loginAdminUser'].'","'.time().'")') or die($db->error);
	$db->query('UPDATE admin_attempts SET attempts=attempts+1 WHERE ip=INET_ATON(\''.USER_IP.'\') AND type="login"') or die($db->error);
	echo 'ERROR_USER|'.$attemtps;
	die();
}
if($db->query('SELECT id FROM admin_users WHERE user="'.$_POST['loginAdminUser'].'"')->num_rows == 0)
{
	$db->query('INSERT INTO admin_logs (type,ip,user,timestamp) VALUES ("LOGIN_FAILED",INET_ATON(\''.USER_IP.'\'),"'.$_POST['loginAdminUser'].'","'.time().'")') or die($db->error);
	$db->query('UPDATE admin_attempts SET attempts=attempts+1 WHERE ip=INET_ATON(\''.USER_IP.'\') AND type="login"') or die($db->error);
	echo 'ERROR_USER|'.$attemtps;
	die();
}
if(!isset($_POST['loginAdminPass']) or @$_POST['loginAdminPass'] == null)
{
	$db->query('INSERT INTO admin_logs (type,ip,user,timestamp) VALUES ("LOGIN_FAILED",INET_ATON(\''.USER_IP.'\'),"'.$_POST['loginAdminUser'].'","'.time().'")');
	$db->query('UPDATE admin_attempts SET attempts=attempts+1 WHERE ip=INET_ATON(\''.USER_IP.'\') AND type="login"') or die($db->error);
	echo 'ERROR_PWD|'.$attemtps;
	die();
}
if($db->query('SELECT id FROM admin_users WHERE user="'.$_POST['loginAdminUser'].'" AND pwd="'.md5($core->crypt($_POST['loginAdminPass'])).'"')->num_rows == 0)
{
	$db->query('INSERT INTO admin_logs (type,ip,user,timestamp) VALUES ("LOGIN_FAILED",INET_ATON(\''.USER_IP.'\'),"'.$_POST['loginAdminUser'].'","'.time().'")');
	$db->query('UPDATE admin_attempts SET attempts=attempts+1 WHERE ip=INET_ATON(\''.USER_IP.'\') AND type="login"') or die($db->error);
	echo 'ERROR_PWD|'.$attemtps;
	die();
}
if($db->query('SELECT accEnabled FROM admin_users WHERE user="'.$_POST['loginAdminUser'].'" AND pwd="'.md5($core->crypt($_POST['loginAdminPass'])).'"')->fetch_row()[0] == false)
{
	$db->query('INSERT INTO admin_logs (type,ip,user,timestamp) VALUES ("LOGIN_FAILED_ACCDISABLED",INET_ATON(\''.USER_IP.'\'),"'.$_POST['loginAdminUser'].'","'.time().'")');
	$db->query('UPDATE admin_attempts SET attempts=attempts+1 WHERE ip=INET_ATON(\''.USER_IP.'\') AND type="login"') or die($db->error);
	echo 'ERROR_DISABLED|'.$attemtps;
	die();
}
$geoLoc = @geoip_record_by_name(USER_IP);
switch(@$geoLoc['continent_code'])
{
	case 'EU':
	$geoTimeZoneCont = 'Europe';
	break;
	case 'NA':
	$geoTimeZoneCont = 'America';
	break;
	case 'SA':
	$geoTimeZoneCont = 'America';
	break;
	case 'OC':
	$geoTimeZoneCont = 'Pacific';
	break;
	case 'AS':
	$geoTimeZoneCont = 'Asia';
	break;
	case 'AN':
	$geoTimeZoneCont = 'Antarctica';
	break;
	case 'AF':
	$geoTimeZoneCont = 'Africa';
	break;
}
$db->query('UPDATE admin_users SET geoCountry="'.@$geoLoc['country_code'].'",geoContinent="'.@$geoLoc['continent_code'].'",geoCity="'.mb_convert_encoding(@$geoLoc['city'], 'UTF-8', 'ISO-8859-1').'",geoPostalCode="'.@$geoLoc['postal_code'].'",geoLat="'.@$geoLoc['latitude'].'",geoLong="'.@$geoLoc['longitude'].'",geoTimeZone="'.$geoTimeZoneCont.'/'.@$geoLoc['country_name'].'",lang="'.USER_LANG.'",lastIp=INET_ATON(\''.USER_IP.'\'),lastLogin="'.time().'" WHERE user="'.$_POST['loginAdminUser'].'"') or die($db->error);
$core->session_setNew('yumiAdminUser',$_POST['loginAdminUser']);
if($core->session_isSet('yumiAdminUserLocked'))
{
    $core->session_destroy('yumiAdminUserLocked');
}
$db->query('INSERT INTO admin_logs (type,ip,user,timestamp) VALUES ("LOGIN_SUCCESS",INET_ATON(\''.USER_IP.'\'),"'.$db->query('SELECT user FROM admin_users WHERE user="'.$core->session_getValue('yumiAdminUser').'"')->fetch_row()[0].'","'.time().'")');
echo 'LOGIN_SUCCESS|SUCCESS';