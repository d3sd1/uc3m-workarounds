<?php
/* Session improved security */
ini_set('session.cookie_secure',true);
ini_set('session.cookie_httponly',true);
session_start();
$config = parse_ini_file('config.conf');
require('class/database.php');
require('class/security.php');
require('class/yumi.php');
if($core->session_isSet('yumiLang') && array_key_exists($core->session_getValue('yumiLang'),array_flip(explode(',',$config['avaliable.langs']))))
{
	$user2keyLang = $core->session_getValue('yumiLang'); 
	$fileLang = file_get_contents(BASEDIR.'/kernel/langs/'.$user2keyLang.'.json');
	$lang = json_decode($fileLang,true);
	define('USER_LANG',$user2keyLang);
}
else
{
	$user2keyLang = substr($_SERVER['HTTP_ACCEPT_LANGUAGE'],0,2); 
	if($core->session_isSet('yumiLang'))
	{
		$core->session_destroy('yumiLang');
	}
	if(array_key_exists($user2keyLang,array_flip(explode(',',$config['avaliable.langs']))))
	{
		$fileLang = file_get_contents(BASEDIR.'/kernel/langs/'.$user2keyLang.'.json');
		$lang = json_decode($fileLang,true);
		define('USER_LANG',$user2keyLang);
		$core->session_setNew('yumiLang',$user2keyLang);
	}
	else
	{
		$fileLang = file_get_contents(BASEDIR.'/kernel/langs/'.$config['default.lang'].'.json');
		$lang = json_decode($fileLang,true);
		define('USER_LANG',$config['default.lang']);
		$core->session_setNew('yumiLang',$user2keyLang);
	}
}
$lang = str_replace(array('{newline}','{font_span}','{/font_span}','{copyright}','{year}','{nojsdownloadnavigator}'),array('<br>','<span>','</span>','&copy;',date('Y'),'<a target="updateBrowser" href="https://www.google.es/chrome/browser/">Google Chrome</a>'),$lang);
if($core->session_isSet('yumiUserEmail'))
{
	define('USER_LOGGED_IN',true);
}
else
{
	define('USER_LOGGED_IN',false);
}
define('USER_IP',$core->getUserIP());
define('PROFILE_IMAGE_DEFAULT',str_replace('{url}',URL,$config['default.profileImg']));
$avLangs = explode(',',$config['avaliable.langs']);
/* Add logs */
if($config['session.save.logs'] == true && !isset($areWeInAdmin))
{
    if(!$core->session_isSet('yumiUserCountry'))
    {
        $geoLoc = @geoip_record_by_name(USER_IP);
        $core->session_setNew('yumiUserCountry',@$geoLoc['country_code']);
    }
    $db->query('INSERT INTO web_visits (timestamp,country,ip,loggedIn) VALUES ('.date('dmy').',"'.$core->session_getValue('yumiUserCountry').'",INET_ATON("'.USER_IP.'"),'.(int) USER_LOGGED_IN.')') or die($db->error);
}