<?php 
$imLocked = true;
require('admin.php');
if(!ADMIN_LOGGED_IN)
{
	header('Location: '.URL.'/login');
}
if(isset($_GET['ref']) && $_GET['ref'] == 'timeout')
{
	if(!$core->session_isSet('yumiAdminUserLocked'))
	{
		$core->session_setNew('yumiAdminUserLocked',true);
	}
	$db->query('INSERT INTO admin_logs (type,ip,user,timestamp) VALUES ("LOGIN_ERROR_PRELOCKED",INET_ATON(\''.USER_IP.'\'),"'.ADMIN_NAME.'","'.time().'")');
	header('Location: '.URL.'/locked');
}
if(isset($_GET['ref']) && $_GET['ref'] == 'connectedSmwElse')
{
	if(!$core->session_isSet('yumiAdminUserLocked'))
	{
		$core->session_setNew('yumiAdminUserLocked',true);
	}
	$db->query('INSERT INTO admin_logs (type,ip,user,timestamp) VALUES ("LOCKED_LOGGED_SMWELSE",INET_ATON(\''.USER_IP.'\'),"'.ADMIN_NAME.'","'.time().'")');
	header('Location: '.URL.'/locked?reason=connectedAnotherIp');
}
if(isset($_GET['notusergiven']) && $_GET['notusergiven'] == 'true')
{
	if($core->session_isSet('yumiAdminUserLocked'))
	{
		$core->session_destroy('yumiAdminUserLocked');
		$core->session_destroy('yumiAdminUser');
		header('Location: '.URL.'/login');
	}
}
if(!$core->session_isSet('yumiAdminUserLocked'))
{
	header('Location: '.URL.'/start');
}
if(isset($_POST['password']) && $_POST['password'] != null)
{
	if($db->query('SELECT id FROM admin_users WHERE id="'.ADMIN_ID.'" AND pwd="'.md5($core->crypt($_POST['password'])).'"')->num_rows == 0)
	{
		$core->session_destroy('yumiAdminUser');
		$db->query('INSERT INTO admin_logs (type,ip,user,timestamp) VALUES ("LOGIN_ERROR_PRELOCKED",INET_ATON(\''.USER_IP.'\'),"'.ADMIN_NAME.'","'.time().'")');
		header('Location: '.URL.'/login?ref=badlocked');
	}
	else
	{
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
		$db->query('UPDATE admin_users SET geoCountry="'.@$geoLoc['country_code'].'",geoContinent="'.@$geoLoc['continent_code'].'",geoCity="'.mb_convert_encoding(@$geoLoc['city'], 'UTF-8', 'ISO-8859-1').'",geoPostalCode="'.@$geoLoc['postal_code'].'",geoLat="'.@$geoLoc['latitude'].'",geoLong="'.@$geoLoc['longitude'].'",geoTimeZone="'.$geoTimeZoneCont.'/'.@$geoLoc['country_name'].'",lang="'.USER_LANG.'",lastIp=INET_ATON(\''.USER_IP.'\') WHERE id="'.ADMIN_ID.'"') or die($db->error);
		$db->query('INSERT INTO admin_logs (type,ip,user,timestamp) VALUES ("LOGIN_SUCCESS_PRELOCKED",INET_ATON(\''.USER_IP.'\'),"'.ADMIN_NAME.'","'.time().'")');
		$core->session_destroy('yumiAdminUserLocked');
		header('Location: '.URL.'/start?ref=relogged');
	}
}
?>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="<?php echo $lang['meta.lang'] ?>" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="<?php echo $lang['meta.lang'] ?>" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="<?php echo $lang['meta.lang'] ?>">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->
    <head>
        <meta charset="<?php echo $lang['meta.encoding'] ?>" />
        <title><?php echo $lang['title.locked'] ?></title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Preview page of Metronic Admin Theme #6 for " name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
        <link href="<?php echo URL ?>/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="<?php echo URL ?>/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="<?php echo URL ?>/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="<?php echo URL ?>/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="<?php echo URL ?>/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="<?php echo URL ?>/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN PAGE LEVEL STYLES -->
        <link href="<?php echo URL ?>/assets/pages/css/lock.min.css" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="<?php echo BASEURL ?>/favicon.ico" /> </head>
    <!-- END HEAD -->

    <body class="" style="-moz-user-select: none; -webkit-user-select: none; -ms-user-select:none; user-select:none;-o-user-select:none;" unselectable="on" onselectstart="return false;">
        <div class="page-lock">
            <div class="page-logo">
                <a class="brand" href="<?php echo URL ?>">
                    <img src="<?php echo BASEURL ?>/images/logo/logo-big.png" alt="logo" /> </a>
            </div>
            <div class="page-body">
			<?php
			if(isset($_GET['reason']) && $_GET['reason'] == 'connectedAnotherIp')
			{
						echo '<div class="alert alert-success fade in alert-dismissable" style="margin-top:18px;">
								<a href="#" class="close" data-dismiss="alert" aria-label="close" title="close">×</a>
								<strong>'.$lang['locked.connectsmwelse'].'</strong> '.$lang['locked.connectsmwelse.desc'].'
							</div>';
			}
			?>
                <div class="lock-head"> <?php echo $lang['locked.h1'] ?> </div>
                <div class="lock-body">
                    <div class="pull-left lock-avatar-block">
                        <img draggable="false" src="<?php echo ADMIN_PHOTO ?>" class="lock-avatar"> </div>
                    <form class="lock-form pull-left" action="<?php echo URL ?>/locked" method="post">
                        <h4><?php echo ADMIN_NAME ?></h4>
                        <div class="form-group">
                            <input class="form-control placeholder-no-fix" required type="password" autocomplete="off" placeholder="<?php echo $lang['locked.password'] ?>" name="password" /> </div>
                        <div class="form-actions">
                            <button type="submit" class="btn red uppercase"><?php echo $lang['locked.relogin'] ?></button>
                        </div>
                    </form>
                </div>
                <div class="lock-bottom">
                    <a href="<?php echo URL ?>/locked?notusergiven=true"><?php echo $lang['locked.notusergiven'] ?></a>
                </div>
            </div>
            <div class="page-footer-custom"> <?php echo $lang['footer.copy'] ?> </div>
        </div>
        <!-- BEGIN CORE PLUGINS -->
        <script src="<?php echo URL ?>/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="<?php echo URL ?>/assets/global/scripts/app.min.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script src="<?php echo URL ?>/assets/pages/scripts/lock.min.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL SCRIPTS -->
        <script>
            document.addEventListener('contextmenu', event => event.preventDefault());
        </script>
</body>


</html>