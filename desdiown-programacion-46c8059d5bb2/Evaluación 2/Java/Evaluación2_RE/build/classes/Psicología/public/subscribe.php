<?php
$db_host = 'localhost';
$db_user = 'root';
$db_pass = 'ginzr4wmn6gdf5n9dwuyb729ndsgztuz7ieiug78md6wr7u6kiiriqv76bnj';
$db_base = 'yumikey_comingsoon';
$db = new mysqli($db_host,$db_user,$db_pass,$db_base);
if ($db->connect_errno) {
    exit();
}
function clean($val) 
	 {
     $val = preg_replace('/([\x00-\x08][\x0b-\x0c][\x0e-\x20])/', '', $val);$search = 'abcdefghijklmnopqrstuvwxyz';$search .= 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';$search .= '1234567890!@#$%^&*()';$search .= '~`";:?+/={}[]-_|\'\\';for ($i = 0; $i < strlen($search); $i++) {$val = preg_replace('/(&#[x|X]0{0,8}'.dechex(ord($search[$i])).';?)/i', $search[$i], $val);$val = preg_replace('/(&#0{0,8}'.ord($search[$i]).';?)/', $search[$i], $val); }
	 $ra1 = Array('javascript', 'vbscript', 'expression', 'applet', 'meta', 'xml', 'blink', 'link', 'style', 'script', 'embed', 'object', 'iframe', 'frame', 'frameset', 'ilayer', 'layer', 'bgsound', 'title', 'base');$ra2 = Array('onabort', 'onactivate', 'onafterprint', 'onafterupdate', 'onbeforeactivate', 'onbeforecopy', 'onbeforecut', 'onbeforedeactivate', 'onbeforeeditfocus', 'onbeforepaste', 'onbeforeprint', 'onbeforeunload', 'onbeforeupdate', 'onblur', 'onbounce', 'oncellchange', 'onchange', 'onclick', 'oncontextmenu', 'oncontrolselect', 'oncopy', 'oncut', 'ondataavailable', 'ondatasetchanged', 'ondatasetcomplete', 'ondblclick', 'ondeactivate', 'ondrag', 'ondragend', 'ondragenter', 'ondragleave', 'ondragover', 'ondragstart', 'ondrop', 'onerror', 'onerrorupdate', 'onfilterchange', 'onfinish', 'onfocus', 'onfocusin', 'onfocusout', 'onhelp', 'onkeydown', 'onkeypress', 'onkeyup', 'onlayoutcomplete', 'onload', 'onlosecapture', 'onmousedown', 'onmouseenter', 'onmouseleave', 'onmousemove', 'onmouseout', 'onmouseover', 'onmouseup', 'onmousewheel', 'onmove', 'onmoveend', 'onmovestart', 'onpaste', 'onpropertychange', 'onreadystatechange', 'onreset', 'onresize', 'onresizeend', 'onresizestart', 'onrowenter', 'onrowexit', 'onrowsdelete', 'onrowsinserted', 'onscroll', 'onselect', 'onselectionchange', 'onselectstart', 'onstart', 'onstop', 'onsubmit', 'onunload');$ra = array_merge($ra1, $ra2);$found = true;while ($found == true) {
$val_before = $val;for ($i = 0; $i < sizeof($ra); $i++) {$pattern = '/';for ($j = 0; $j < strlen($ra[$i]); $j++) {if ($j > 0) { $pattern .= '(';$pattern .= '(&#[x|X]0{0,8}([9][a][b]);?)?';$pattern .= '|(&#0{0,8}([9][10][13]);?)?';$pattern .= ')?';}$pattern .= $ra[$i][$j];}$pattern .= '/i';$replacement = substr($ra[$i], 0, 2).'<x>'.substr($ra[$i], 2);$val = preg_replace($pattern, $replacement, $val);if ($val_before == $val) {$found = false;}}} return $val;
    }
$input_arr = array();
foreach ($_POST as $key => $input_arr)
{ 
	$_POST[$key] = @addslashes(clean($input_arr)); 
}
foreach ($_GET as $key => $input_arr)
{ 
	$_GET[$key] = @addslashes(clean($input_arr)); 
}
$db ->query("SET NAMES 'utf8'"); //Encode ES types
if($db->query('SELECT id FROM subs WHERE email="'.$_POST['subscribe_email'].'"')->num_rows == 0)
{
	$db->query('INSERT INTO subs (email,timestamp) VALUES ("'.$_POST['subscribe_email'].'",'.time().')') or die($db->error);
}