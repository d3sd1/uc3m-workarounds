<?php
require('kernel/core.php');
if(!isset($_POST['g-recaptcha-response']) or @$_POST['g-recaptcha-response'] == null)
{
	echo 'ERROR_CAPTCHA';
	die();
}
$captchaResponse = json_decode(file_get_contents('https://www.google.com/recaptcha/api/siteverify?secret='.$config['recaptcha.secretkey'].'&response='.$_POST['g-recaptcha-response'].'&remoteip='.USER_IP), true);
if(!$captchaResponse['success'])
{
	echo 'ERROR_CAPTCHA';
	die();
}
if(!isset($_POST['loginEmail']) or @$_POST['loginEmail'] == null or strlen($_POST['loginEmail']) >= 250 or $core->validate('email',$_POST['loginEmail']))
{
	echo 'ERROR_EMAIL';
	die();
}
if(!isset($_POST['loginPwd']) or @$_POST['loginPwd'] == null or strlen($_POST['loginPwd']) >= 200)
{
	echo 'ERROR_PWD';
	die();
}
if($db->query('SELECT id FROM users WHERE email="'.$_POST['loginEmail'].'"')->num_rows == 0)
{
	echo 'ERROR_EMAIL';
	die();
}
if($db->query('SELECT id FROM users WHERE email="'.$_POST['loginEmail'].'" AND pwd="'.md5($core->crypt($_POST['loginPwd'])).'"')->num_rows == 0)
{
	echo 'ERROR_PWD';
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
$db->query('UPDATE users SET geoCountry="'.@$geoLoc['country_code'].'",geoContinent="'.@$geoLoc['continent_code'].'",geoCity="'.mb_convert_encoding(@$geoLoc['city'], 'UTF-8', 'ISO-8859-1').'",geoPostalCode="'.@$geoLoc['postal_code'].'",geoLat="'.@$geoLoc['latitude'].'",geoLong="'.@$geoLoc['longitude'].'",geoTimeZone="'.$geoTimeZoneCont.'/'.@$geoLoc['country_name'].'",lang="'.USER_LANG.'",lastIp=INET_ATON(\''.USER_IP.'\'),dateLastLogin="'.time().'" WHERE email="'.$_POST['loginEmail'].'"') or die($db->error);
$core->session_setNew('yumiUserEmail',$_POST['loginEmail']);
echo 'LOGIN_SUCCESS';