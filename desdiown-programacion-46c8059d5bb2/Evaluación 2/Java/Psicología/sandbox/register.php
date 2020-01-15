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
if(!isset($_POST['registerUser']) or @$_POST['registerUser'] == null or strlen($_POST['registerUser']) >= 250 or !preg_match('/^[a-z’\'‘ A-Z\x{00C0}\x{00ff}]+$/',$_POST['registerUser']))
{
	echo 'ERROR_USER';
	die();
}
if(!isset($_POST['registerEmail']) or @$_POST['registerEmail'] == null or strlen($_POST['registerEmail']) >= 250 or $core->validate('email',$_POST['registerEmail']))
{
	echo 'ERROR_EMAIL';
	die();
}
if($db->query('SELECT id FROM users WHERE email="'.$_POST['registerEmail'].'"')->num_rows > 0)
{
	echo 'ERROR_EMAIL_USED';
	die();
}
if(!isset($_POST['registerPass']) or @$_POST['registerPass'] == null or strlen($_POST['registerPass']) >= 200 or strlen($_POST['registerPass']) < 6 or $_POST['registerPass'] == $_POST['registerUser'] or $_POST['registerPass'] == $_POST['registerEmail'] or !preg_match('/[0-9]/',$_POST['registerPass']) or !preg_match('/[a-z]/',$_POST['registerPass']) or !preg_match('/[A-Z]/',$_POST['registerPass']))
{
	echo 'ERROR_PASS';
	die();
}
if(!isset($_POST['registerPassRep']) or @$_POST['registerPassRep'] == null or $_POST['registerPassRep'] != $_POST['registerPass'])
{
	echo 'ERROR_PASSREP';
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

$db->query('INSERT INTO users (email,pwd,dateRegistered,dateLastLogin,lang,lastIp,registerIp,geoCountry,geoContinent,geoCity,geoPostalCode,geoLat,geoLong,geoTimeZone)  VALUES ("'.$_POST['registerEmail'].'","'.md5($core->crypt($_POST['registerPass'])).'",'.time().','.time().',"'.USER_LANG.'",INET_ATON(\''.USER_IP.'\'),INET_ATON(\''.USER_IP.'\'),"'.@$geoLoc['country_code'].'","'.@$geoLoc['continent_code'].'", "'.mb_convert_encoding(@$geoLoc['city'], 'UTF-8', 'ISO-8859-1').'","'.@$geoLoc['postal_code'].'","'.@$geoLoc['latitude'].'","'.@$geoLoc['longitude'].'","'.$geoTimeZoneCont.'/'.@$geoLoc['country_name'].'")') or die($db->error);
$core->session_setNew('yumiUserEmail',$_POST['registerEmail']);
echo 'REGISTER_SUCCESS';