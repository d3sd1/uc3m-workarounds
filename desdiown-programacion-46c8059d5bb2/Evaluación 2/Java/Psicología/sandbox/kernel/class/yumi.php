<?php
$core = new yumi();
define('URL',sprintf("%s://%s",isset($_SERVER['HTTPS']) && $_SERVER['HTTPS'] != 'off' ? 'https' : 'http',$_SERVER['SERVER_NAME']));
define('BASEDIR',__DIR__.'/../../');
class yumi
{
	public function timeElapsed($time)
	{
		global $lang;
		$etime = (time() - $time);

		if ($etime < 1)
		{
			return '0 '.$lang['time.elapsed.seconds'];
		}

		$a = array( 365 * 24 * 60 * 60  =>  $lang['time.elapsed.year'],
					 30 * 24 * 60 * 60  =>  $lang['time.elapsed.month'],
						  24 * 60 * 60  =>  $lang['time.elapsed.day'],
							   60 * 60  =>  $lang['time.elapsed.hour'],
									60  =>  $lang['time.elapsed.minute'],
									 1  =>  $lang['time.elapsed.second']
					);
		$a_plural = array( $lang['time.elapsed.year']   => $lang['time.elapsed.years'],
						   $lang['time.elapsed.month']  => $lang['time.elapsed.months'],
						   $lang['time.elapsed.day']    => $lang['time.elapsed.days'],
						   $lang['time.elapsed.hour']   => $lang['time.elapsed.hours'],
						   $lang['time.elapsed.minute'] => $lang['time.elapsed.minutes'],
						   $lang['time.elapsed.second'] => $lang['time.elapsed.seconds']
					);

		foreach ($a as $secs => $str)
		{
			$d = $etime / $secs;
			if ($d >= 1)
			{
				$r = round($d);
				return $lang['time.elapsed.ago'].' '.$r . ' ' . ($r > 1 ? $a_plural[$str] : $str) . '';
			}
		}
	}
	public function hex2rgb($hex) {
	   $hex = str_replace('#', null, $hex);

	   if(strlen($hex) == 3) {
		  $r = hexdec(substr($hex,0,1).substr($hex,0,1));
		  $g = hexdec(substr($hex,1,1).substr($hex,1,1));
		  $b = hexdec(substr($hex,2,1).substr($hex,2,1));
	   } else {
		  $r = hexdec(substr($hex,0,2));
		  $g = hexdec(substr($hex,2,2));
		  $b = hexdec(substr($hex,4,2));
	   }
	   $rgb = array($r, $g, $b);
	   return $rgb;
	}

	public function rgb2hex($rgb) {
	   return "#".str_pad(dechex($rgb[0]), 2, "0", STR_PAD_LEFT).str_pad(dechex($rgb[1]), 2, "0", STR_PAD_LEFT).str_pad(dechex($rgb[2]), 2, "0", STR_PAD_LEFT);
	}
	
	public function crypt($string) {
		$output = false;

		$encrypt_method = "AES-256-CBC";
		$secret_key = $GLOBALS['config']['secretkey.1'];
		$secret_iv = $GLOBALS['config']['secretkey.2'];
		$key = hash('sha256', $secret_key);
		$iv = substr(hash('sha256', $secret_iv), 0, 16);
		return base64_encode(openssl_encrypt($string, $encrypt_method, $key, 0, $iv));
	}
	public function decrypt($string) {
		$output = false;

		$encrypt_method = "AES-256-CBC";
		$secret_key = $GLOBALS['config']['secretkey.1'];
		$secret_iv = $GLOBALS['config']['secretkey.2'];
		$key = hash('sha256', $secret_key);
		$iv = substr(hash('sha256', $secret_iv), 0, 16);
		return openssl_decrypt(base64_decode($string), $encrypt_method, $key, 0, $iv);
	}
	public function validate($type,$validate)
	{
		switch($type)
		{
			case 'email':
			$email = $validate;
			if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
			  return false;
			}
			break;
			case 'url':
			$website = $validate;
			if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$website)) {
			  return false;
			}
			break;
			case 'name':
			$name = $validate;
			if (!preg_match("/^[a-zA-Z ]*$/",$name)) {
			  return false;
			}
			break;
		}
	}
	public function session_isSet($sessionName)
	{
		if(isset($_SESSION[$this->crypt($sessionName)]))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public function session_setNew($sessionName,$sessionValue)
	{
		$_SESSION[$this->crypt($sessionName)] = $this->crypt($sessionValue);
	}
	public function session_getValue($sessionName)
	{
		return $this->decrypt($_SESSION[$this->crypt($sessionName)]);
	}
	public function session_destroy($sessionName)
	{
		unset($_SESSION[$this->crypt($sessionName)]);
	}
	public function getUserIP() {
    if( array_key_exists('HTTP_X_FORWARDED_FOR', $_SERVER) && !empty($_SERVER['HTTP_X_FORWARDED_FOR']) ) {
        if (strpos($_SERVER['HTTP_X_FORWARDED_FOR'], ',')>0) {
            $addr = explode(",",$_SERVER['HTTP_X_FORWARDED_FOR']);
            return trim($addr[0]);
        } else {
            return $_SERVER['HTTP_X_FORWARDED_FOR'];
        }
    }
    else {
        return $_SERVER['REMOTE_ADDR'];
    }
}
}