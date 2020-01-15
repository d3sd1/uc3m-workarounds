<?php
$areWeInAdmin = true;
require('../kernel/core.php');
unset($lang);
define('BASEURL',str_replace('admin.',null,URL));
if($core->session_isSet('yumiAdminLang') && array_key_exists($core->session_getValue('yumiAdminLang'),array_flip(explode(',',$config['avaliable.langs']))))
{
	$user2keyLang = $core->session_getValue('yumiAdminLang'); 
	$fileLang = file_get_contents(BASEDIR.'/kernel/langs/admin/'.$user2keyLang.'.json');
	$lang = json_decode($fileLang,true);
	define('ADMINUSER_LANG',$user2keyLang);
}
else
{
	$user2keyLang = substr($_SERVER['HTTP_ACCEPT_LANGUAGE'],0,2); 
	if($core->session_isSet('yumiAdminLang'))
	{
		$core->session_destroy('yumiAdminLang');
	}
	if(array_key_exists($user2keyLang,array_flip(explode(',',$config['avaliable.langs']))))
	{
		$fileLang = file_get_contents(BASEDIR.'/kernel/langs/admin/'.$user2keyLang.'.json');
		$lang = json_decode($fileLang,true);
		define('ADMINUSER_LANG',$user2keyLang);
		$core->session_setNew('yumiAdminLang',$user2keyLang);
	}
	else
	{
		$fileLang = file_get_contents(BASEDIR.'/kernel/langs/admin/'.$config['default.lang'].'.json');
		$lang = json_decode($fileLang,true);
		define('ADMINUSER_LANG',$config['default.lang']);
		$core->session_setNew('yumiAdminLang',$user2keyLang);
	}
}
$lang = str_replace(array('{newline}','{font_span}','{/font_span}','{copyright}','{year}','{nojsdownloadnavigator}'),array('<br>','<span>','</span>','&copy;',date('Y'),'<a target="updateBrowser" href="https://www.google.es/chrome/browser/">Google Chrome</a>'),$lang);
if($core->session_isSet('yumiAdminUser'))
{
    $adminInfo = $db->query('SELECT photo,user,id,INET_NTOA(lastIp),profileNots,calendarNots,tasksNots,addedBy,addedDate,accEnabled,geoCity,usrRange FROM admin_users WHERE user="'.$core->session_getValue('yumiAdminUser').'"')->fetch_row();
    
    if(!$adminInfo[9] && !isset($thisPageLogout))
    {
        header('Location: '.URL.'/logout?ref=banned');
        die();   
    }
    else
    {
	define('ADMIN_LOGGED_IN',true);
	define('ADMIN_NAME',$adminInfo[1]);
	define('ADMIN_ID',$adminInfo[2]);
	define('ADMIN_IP',$adminInfo[3]);
	define('ADMIN_PROFILENOTS',$adminInfo[4]);
	define('ADMIN_CALENDARNOTS',$adminInfo[5]);
	define('ADMIN_TASKSNOTS',$adminInfo[6]);
	define('ADMIN_ADDEDBY',(int) $adminInfo[7]);
	define('ADMIN_ADDEDDATE',$adminInfo[8]);
	define('ADMIN_LOCCITY',$adminInfo[10]);
	define('ADMIN_RANGE',$adminInfo[11]);
	define('ADMIN_PHOTO',str_replace(array('{default}','{url}'),array(URL.'/assets/img/profile/default.png',URL),$adminInfo[0]));
	if(ADMIN_IP != USER_IP && empty($imLocked))
	{
		header('Location: '.URL.'/locked?ref=connectedSmwElse');
	}
    }
}
else
{
	define('ADMIN_LOGGED_IN',false);
}

if($core->session_isSet('yumiAdminUserLocked'))
{
	define('ADMIN_USER_LOCKED',true);
}
else
{
	define('ADMIN_USER_LOCKED',false);
}
$admin = new admin;
class admin
{
	public function menu($active = 'start', $subActive = 'start')
	{
		global $lang;
		global $config;
		global $avLangs;
		$submenuLang = null;
		$active = strtolower($active);
		$subActive = strtolower($subActive);
		foreach($avLangs as $langCode)
		{
			$submenuLang .= '<li class="nav-item'.(($subActive == 'langs.'.$langCode) ? ' start active open':null).'">
                                        <a href="'.URL.'/langsMgr/{langOf}/'.$langCode.'" class="nav-link">
                                            <i class="icon-bar-chart"></i> '.$lang['menu.lang.bycode.'.$langCode].' </a>
                                    </li>';
		}
		return '<ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
                            <li class="heading">
                                <h3 class="uppercase">'.$lang['menu.main.header.start'].'</h3>
                            </li>
                            <li class="nav-item'.(($active == 'start') ? ' start active open':null).'">
                                <a href="'.URL.'/start" class="nav-link ">
                                    <i class="fa fa-play"></i>
                                    <span class="title">'.$lang['menu.main.start'].'</span>
                                </a>
                            </li>
                            <li class="nav-item'.(($active == 'webconfig') ? ' start active open':null).'">
                                <a href="'.URL.'/config" class="nav-link ">
                                    <i class="fa fa-cog"></i>
                                    <span class="title">'.$lang['menu.main.webconfig'].'</span>
                                </a>
                            </li>
                            <li class="nav-item'.(($active == 'syslogs') ? ' start active open':null).'">
                                <a href="'.URL.'/syslogs" class="nav-link ">
                                    <i class="fa fa-files-o"></i>
                                    <span class="title">'.$lang['menu.main.syslogs'].'</span>
                                </a>
                            </li>
                            
                            <li class="heading">
                                <h3 class="uppercase">'.$lang['menu.main.header.users'].'</h3>
                            </li>
                            <li class="nav-item'.(($active == 'usersmanager') ? ' start active open':null).'">
                                <a href="'.URL.'/users" class="nav-link ">
                                    <i class="fa fa-users"></i>
                                    <span class="title">'.$lang['menu.main.usrsMgr'].'</span>
                                </a>
                            </li>

                            <li class="heading">
                                <h3 class="uppercase">'.$lang['menu.main.header.frontpage'].'</h3>
                            </li>
                            <li class="nav-item'.(($active == 'frontpagecolors') ? ' start active open':null).'">
                                <a href="'.URL.'/frontpage/colors" class="nav-link ">
                                    <i class="fa fa-paint-brush"></i>
                                    <span class="title">'.$lang['menu.main.frontpagecolors'].'</span>
                                </a>
                            </li>
                            <li class="nav-item'.(($active == 'indexvideo') ? ' start active open':null).'">
                                <a href="'.URL.'/frontpage/video" class="nav-link ">
                                    <i class="fa fa-video-camera"></i>
                                    <span class="title">'.$lang['menu.main.indexvideo'].'</span>
                                </a>
                            </li>
                                
                            <li class="heading">
                                <h3 class="uppercase">'.$lang['menu.main.header.langs'].'</h3>
                            </li>
							<li class="nav-item '.(($active == 'langs.web') ? 'open':null).'">
                                <a href="javascript:;" class="nav-link nav-toggle">
                                    <i class="fa fa-globe"></i>
                                    <span class="title">'.$lang['menu.main.weblangs'].'</span>
                                    <span class="arrow '.(($active == 'langs.web') ? 'open':null).'"></span>
                                </a>
                                <ul class="sub-menu"'.(($active == 'langs.web') ? ' style="display: block"':null).'>
                                    '.str_replace('{langOf}','web',$submenuLang).'
                                </ul>
                            </li>
							<li class="nav-item '.(($active == 'langs.admin') ? 'open':null).'">
                                <a href="javascript:;" class="nav-link nav-toggle">
                                    <i class="fa fa-language"></i>
                                    <span class="title">'.$lang['menu.main.adminlangs'].'</span>
                                    <span class="arrow '.(($active == 'langs.admin') ? 'open':null).'"></span>
                                </a>
                                <ul class="sub-menu"'.(($active == 'langs.admin') ? ' style="display: block"':null).'>
                                    '.str_replace('{langOf}','admin',$submenuLang).'
                                </ul>
                            </li>
                        </ul>';
	}
	public function userMenu($profileNots = array())
	{
		global $lang;
		global $db;
		$notifications = $db->query('SELECT profileNots,calendarNots,tasksNots FROM admin_users WHERE id='.ADMIN_ID)->fetch_row();
		if($notifications[0] == 0)
		{
			$profileNots = null;
		}
		else
		{
			if($notifications[0] > 0 && $notifications[0] <= 3)
			{
				$profileNotsColor = 'success';
			}
			else if($notifications[0] > 3 && $notifications[0] <= 5)
			{
				$profileNotsColor = 'warning';
			}
			else if($notifications[0] > 5)
			{
				$profileNotsColor = 'danger';
			}
			$profileNots = '<span class="badge badge-'.$profileNotsColor.'">'.$notifications[0].'</span>';
		}
		if($notifications[1] == 0)
		{
			$calendarNots = null;
		}
		else
		{
			if($notifications[1] > 0 && $notifications[1] <= 3)
			{
				$calendarNotsColor = 'success';
			}
			else if($notifications[1] > 3 && $notifications[1] <= 5)
			{
				$calendarNotsColor = 'warning';
			}
			else if($notifications[1] > 5)
			{
				$calendarNotsColor = 'danger';
			}
			$calendarNots = '<span class="badge badge-'.$calendarNotsColor.'">'.$notifications[1].'</span>';
		}
		if($notifications[2] == 0)
		{
			$tasksNots = null;
		}
		else
		{
			if($notifications[2] > 0 && $notifications[2] <= 3)
			{
				$tasksNotsColor = 'success';
			}
			else if($notifications[2] > 3 && $notifications[2] <= 5)
			{
				$tasksNotsColor = 'warning';
			}
			else if($notifications[2] > 5)
			{
				$tasksNotsColor = 'danger';
			}
			$tasksNots = '<span class="badge badge-'.$tasksNotsColor.'">'.$notifications[2].'</span>';
		}
		return '<li>
                                        <a href="'.URL.'/profile">
                                            <i class="icon-user"></i> '.ADMIN_NAME.'
                                            '.$profileNots.'
                                        </a>
                                    </li>
                                    <li>
                                        <a href="'.URL.'/calendar">
                                            <i class="icon-calendar"></i> '.$lang['profilemenu.calendar'].'
                                            '.$calendarNots.'
                                        </a>
                                    </li>
                                    <li>
                                        <a href="'.URL.'/tasks">
                                            <i class="icon-rocket"></i> '.$lang['profilemenu.tasks'].'
                                            '.$tasksNots.'
                                        </a>
                                    </li>
                                    <li class="divider"> </li>
                                    <li>
                                        <a href="'.URL.'/locked?ref=timeout">
                                            <i class="icon-lock"></i> '.$lang['profilemenu.lockScreen'].' </a>
                                    </li>
                                    <li>
                                        <a href="'.URL.'/logout">
                                            <i class="icon-key"></i> '.$lang['profilemenu.logout'].' </a>
                                    </li>';
	}
        public function userSidebar()
        {
            global $lang;
            return '<!-- BEGIN QUICK SIDEBAR TOGGLER -->
                    <button type="button" class="quick-sidebar-toggler" data-toggle="collapse">
                        <span class="sr-only">Toggle Quick Sidebar</span>
                        <i class="icon-logout"></i>
                        <div class="quick-sidebar-notification">
                            <span class="badge badge-danger">7</span>
                        </div>
                    </button>
                    <!-- END QUICK SIDEBAR TOGGLER -->
                    <a href="#index" class="go2top">
                        <i class="icon-arrow-up"></i>
                    </a>
                    <!-- END FOOTER -->
                </div>
                <div class="modal fade bs-modal-sm" id="reloggedLocked" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-sm">
                                            <div class="modal-content">
                            <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                                                    <h4 class="modal-title">'.$lang['start.reloggedlocked'].'</h4>
                            </div>
                            <div class="modal-body">'.$lang['start.reloggedlocked.desc'].'</div>
                            <div class="modal-footer">
                                <button type="button" class="btn dark btn-outline" data-dismiss="modal">'.$lang['start.reloggedlocked.close'].'</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal fade bs-modal-sm" id="openedSmwElse" tabindex="-1" role="dialog" aria-hidden="true" data-keyboard="false" data-backdrop="static">
                    <div class="modal-dialog modal-sm">
                                            <div class="modal-content">
                            <div class="modal-header">
                                                                    <h4 class="modal-title">'.$lang['start.openedSmwElse'].'</h4>
                            </div>
                            <div class="modal-body">'.$lang['start.openedSmwElse.desc'].'</div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END CONTAINER -->
            <!-- BEGIN QUICK SIDEBAR -->
            <a href="javascript:;" class="page-quick-sidebar-toggler">
                <i class="icon-login"></i>
            </a>
            <div class="page-quick-sidebar-wrapper" data-close-on-body-click="false">
                <div class="page-quick-sidebar">
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a href="javascript:;" data-target="#quick_sidebar_tab_1" data-toggle="tab"> Users
                                <span class="badge badge-danger">2</span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:;" data-target="#quick_sidebar_tab_2" data-toggle="tab"> Alerts
                                <span class="badge badge-success">7</span>
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"> More
                                <i class="fa fa-angle-down"></i>
                            </a>
                            <ul class="dropdown-menu pull-right">
                                <li>
                                    <a href="javascript:;" data-target="#quick_sidebar_tab_3" data-toggle="tab">
                                        <i class="icon-bell"></i> Alerts </a>
                                </li>
                                <li>
                                    <a href="javascript:;" data-target="#quick_sidebar_tab_3" data-toggle="tab">
                                        <i class="icon-info"></i> Notifications </a>
                                </li>
                                <li>
                                    <a href="javascript:;" data-target="#quick_sidebar_tab_3" data-toggle="tab">
                                        <i class="icon-speech"></i> Activities </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="javascript:;" data-target="#quick_sidebar_tab_3" data-toggle="tab">
                                        <i class="icon-settings"></i> Settings </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active page-quick-sidebar-chat" id="quick_sidebar_tab_1">
                            <div class="page-quick-sidebar-chat-users" data-rail-color="#ddd" data-wrapper-class="page-quick-sidebar-list">
                                <h3 class="list-heading">Staff</h3>
                                <ul class="media-list list-items">
                                    <li class="media">
                                        <div class="media-status">
                                            <span class="badge badge-success">8</span>
                                        </div>
                                        <img class="media-object" src="assets//layouts/img/avatar3.jpg" alt="...">
                                        <div class="media-body">
                                            <h4 class="media-heading">Bob Nilson</h4>
                                            <div class="media-heading-sub"> Project Manager </div>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <img class="media-object" src="assets//layouts/img/avatar1.jpg" alt="...">
                                        <div class="media-body">
                                            <h4 class="media-heading">Nick Larson</h4>
                                            <div class="media-heading-sub"> Art Director </div>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <div class="media-status">
                                            <span class="badge badge-danger">3</span>
                                        </div>
                                        <img class="media-object" src="assets//layouts/img/avatar4.jpg" alt="...">
                                        <div class="media-body">
                                            <h4 class="media-heading">Deon Hubert</h4>
                                            <div class="media-heading-sub"> CTO </div>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <img class="media-object" src="assets//layouts/img/avatar2.jpg" alt="...">
                                        <div class="media-body">
                                            <h4 class="media-heading">Ella Wong</h4>
                                            <div class="media-heading-sub"> CEO </div>
                                        </div>
                                    </li>
                                </ul>
                                <h3 class="list-heading">Customers</h3>
                                <ul class="media-list list-items">
                                    <li class="media">
                                        <div class="media-status">
                                            <span class="badge badge-warning">2</span>
                                        </div>
                                        <img class="media-object" src="assets//layouts/img/avatar6.jpg" alt="...">
                                        <div class="media-body">
                                            <h4 class="media-heading">Lara Kunis</h4>
                                            <div class="media-heading-sub"> CEO, Loop Inc </div>
                                            <div class="media-heading-small"> Last seen 03:10 AM </div>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <div class="media-status">
                                            <span class="label label-sm label-success">new</span>
                                        </div>
                                        <img class="media-object" src="assets//layouts/img/avatar7.jpg" alt="...">
                                        <div class="media-body">
                                            <h4 class="media-heading">Ernie Kyllonen</h4>
                                            <div class="media-heading-sub"> Project Manager,
                                                <br> SmartBizz PTL </div>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <img class="media-object" src="assets//layouts/img/avatar8.jpg" alt="...">
                                        <div class="media-body">
                                            <h4 class="media-heading">Lisa Stone</h4>
                                            <div class="media-heading-sub"> CTO, Keort Inc </div>
                                            <div class="media-heading-small"> Last seen 13:10 PM </div>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <div class="media-status">
                                            <span class="badge badge-success">7</span>
                                        </div>
                                        <img class="media-object" src="assets//layouts/img/avatar9.jpg" alt="...">
                                        <div class="media-body">
                                            <h4 class="media-heading">Deon Portalatin</h4>
                                            <div class="media-heading-sub"> CFO, H&D LTD </div>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <img class="media-object" src="assets//layouts/img/avatar10.jpg" alt="...">
                                        <div class="media-body">
                                            <h4 class="media-heading">Irina Savikova</h4>
                                            <div class="media-heading-sub"> CEO, Tizda Motors Inc </div>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <div class="media-status">
                                            <span class="badge badge-danger">4</span>
                                        </div>
                                        <img class="media-object" src="assets//layouts/img/avatar11.jpg" alt="...">
                                        <div class="media-body">
                                            <h4 class="media-heading">Maria Gomez</h4>
                                            <div class="media-heading-sub"> Manager, Infomatic Inc </div>
                                            <div class="media-heading-small"> Last seen 03:10 AM </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="page-quick-sidebar-item">
                                <div class="page-quick-sidebar-chat-user">
                                    <div class="page-quick-sidebar-nav">
                                        <a href="javascript:;" class="page-quick-sidebar-back-to-list">
                                            <i class="icon-arrow-left"></i>Back</a>
                                    </div>
                                    <div class="page-quick-sidebar-chat-user-messages">
                                        <div class="post out">
                                            <img class="avatar" alt="" src="assets//layouts/img/avatar3.jpg" />
                                            <div class="message">
                                                <span class="arrow"></span>
                                                <a href="javascript:;" class="name">Bob Nilson</a>
                                                <span class="datetime">20:15</span>
                                                <span class="body"> When could you send me the report ? </span>
                                            </div>
                                        </div>
                                        <div class="post in">
                                            <img class="avatar" alt="" src="assets//layouts/img/avatar2.jpg" />
                                            <div class="message">
                                                <span class="arrow"></span>
                                                <a href="javascript:;" class="name">Ella Wong</a>
                                                <span class="datetime">20:15</span>
                                                <span class="body"> Its almost done. I will be sending it shortly </span>
                                            </div>
                                        </div>
                                        <div class="post out">
                                            <img class="avatar" alt="" src="assets//layouts/img/avatar3.jpg" />
                                            <div class="message">
                                                <span class="arrow"></span>
                                                <a href="javascript:;" class="name">Bob Nilson</a>
                                                <span class="datetime">20:15</span>
                                                <span class="body"> Alright. Thanks! :) </span>
                                            </div>
                                        </div>
                                        <div class="post in">
                                            <img class="avatar" alt="" src="assets//layouts/img/avatar2.jpg" />
                                            <div class="message">
                                                <span class="arrow"></span>
                                                <a href="javascript:;" class="name">Ella Wong</a>
                                                <span class="datetime">20:16</span>
                                                <span class="body"> You are most welcome. Sorry for the delay. </span>
                                            </div>
                                        </div>
                                        <div class="post out">
                                            <img class="avatar" alt="" src="assets//layouts/img/avatar3.jpg" />
                                            <div class="message">
                                                <span class="arrow"></span>
                                                <a href="javascript:;" class="name">Bob Nilson</a>
                                                <span class="datetime">20:17</span>
                                                <span class="body"> No probs. Just take your time :) </span>
                                            </div>
                                        </div>
                                        <div class="post in">
                                            <img class="avatar" alt="" src="assets//layouts/img/avatar2.jpg" />
                                            <div class="message">
                                                <span class="arrow"></span>
                                                <a href="javascript:;" class="name">Ella Wong</a>
                                                <span class="datetime">20:40</span>
                                                <span class="body"> Alright. I just emailed it to you. </span>
                                            </div>
                                        </div>
                                        <div class="post out">
                                            <img class="avatar" alt="" src="assets//layouts/img/avatar3.jpg" />
                                            <div class="message">
                                                <span class="arrow"></span>
                                                <a href="javascript:;" class="name">Bob Nilson</a>
                                                <span class="datetime">20:17</span>
                                                <span class="body"> Great! Thanks. Will check it right away. </span>
                                            </div>
                                        </div>
                                        <div class="post in">
                                            <img class="avatar" alt="" src="assets//layouts/img/avatar2.jpg" />
                                            <div class="message">
                                                <span class="arrow"></span>
                                                <a href="javascript:;" class="name">Ella Wong</a>
                                                <span class="datetime">20:40</span>
                                                <span class="body"> Please let me know if you have any comment. </span>
                                            </div>
                                        </div>
                                        <div class="post out">
                                            <img class="avatar" alt="" src="assets//layouts/img/avatar3.jpg" />
                                            <div class="message">
                                                <span class="arrow"></span>
                                                <a href="javascript:;" class="name">Bob Nilson</a>
                                                <span class="datetime">20:17</span>
                                                <span class="body"> Sure. I will check and buzz you if anything needs to be corrected. </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="page-quick-sidebar-chat-user-form">
                                        <div class="input-group">
                                            <input type="text" class="form-control" placeholder="Type a message here...">
                                            <div class="input-group-btn">
                                                <button type="button" class="btn green">
                                                    <i class="icon-paper-clip"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane page-quick-sidebar-alerts" id="quick_sidebar_tab_2">
                            <div class="page-quick-sidebar-alerts-list">
                                <h3 class="list-heading">General</h3>
                                <ul class="feeds list-items">
                                    <li>
                                        <div class="col1">
                                            <div class="cont">
                                                <div class="cont-col1">
                                                    <div class="label label-sm label-info">
                                                        <i class="fa fa-check"></i>
                                                    </div>
                                                </div>
                                                <div class="cont-col2">
                                                    <div class="desc"> You have 4 pending tasks.
                                                        <span class="label label-sm label-warning "> Take action
                                                            <i class="fa fa-share"></i>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col2">
                                            <div class="date"> Just now </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            <div class="col1">
                                                <div class="cont">
                                                    <div class="cont-col1">
                                                        <div class="label label-sm label-success">
                                                            <i class="fa fa-bar-chart-o"></i>
                                                        </div>
                                                    </div>
                                                    <div class="cont-col2">
                                                        <div class="desc"> Finance Report for year 2013 has been released. </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col2">
                                                <div class="date"> 20 mins </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="col1">
                                            <div class="cont">
                                                <div class="cont-col1">
                                                    <div class="label label-sm label-danger">
                                                        <i class="fa fa-user"></i>
                                                    </div>
                                                </div>
                                                <div class="cont-col2">
                                                    <div class="desc"> You have 5 pending membership that requires a quick review. </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col2">
                                            <div class="date"> 24 mins </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="col1">
                                            <div class="cont">
                                                <div class="cont-col1">
                                                    <div class="label label-sm label-info">
                                                        <i class="fa fa-shopping-cart"></i>
                                                    </div>
                                                </div>
                                                <div class="cont-col2">
                                                    <div class="desc"> New order received with
                                                        <span class="label label-sm label-success"> Reference Number: DR23923 </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col2">
                                            <div class="date"> 30 mins </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="col1">
                                            <div class="cont">
                                                <div class="cont-col1">
                                                    <div class="label label-sm label-success">
                                                        <i class="fa fa-user"></i>
                                                    </div>
                                                </div>
                                                <div class="cont-col2">
                                                    <div class="desc"> You have 5 pending membership that requires a quick review. </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col2">
                                            <div class="date"> 24 mins </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="col1">
                                            <div class="cont">
                                                <div class="cont-col1">
                                                    <div class="label label-sm label-info">
                                                        <i class="fa fa-bell-o"></i>
                                                    </div>
                                                </div>
                                                <div class="cont-col2">
                                                    <div class="desc"> Web server hardware needs to be upgraded.
                                                        <span class="label label-sm label-warning"> Overdue </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col2">
                                            <div class="date"> 2 hours </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            <div class="col1">
                                                <div class="cont">
                                                    <div class="cont-col1">
                                                        <div class="label label-sm label-default">
                                                            <i class="fa fa-briefcase"></i>
                                                        </div>
                                                    </div>
                                                    <div class="cont-col2">
                                                        <div class="desc"> IPO Report for year 2013 has been released. </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col2">
                                                <div class="date"> 20 mins </div>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                                <h3 class="list-heading">System</h3>
                                <ul class="feeds list-items">
                                    <li>
                                        <div class="col1">
                                            <div class="cont">
                                                <div class="cont-col1">
                                                    <div class="label label-sm label-info">
                                                        <i class="fa fa-check"></i>
                                                    </div>
                                                </div>
                                                <div class="cont-col2">
                                                    <div class="desc"> You have 4 pending tasks.
                                                        <span class="label label-sm label-warning "> Take action
                                                            <i class="fa fa-share"></i>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col2">
                                            <div class="date"> Just now </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            <div class="col1">
                                                <div class="cont">
                                                    <div class="cont-col1">
                                                        <div class="label label-sm label-danger">
                                                            <i class="fa fa-bar-chart-o"></i>
                                                        </div>
                                                    </div>
                                                    <div class="cont-col2">
                                                        <div class="desc"> Finance Report for year 2013 has been released. </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col2">
                                                <div class="date"> 20 mins </div>
                                            </div>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="col1">
                                            <div class="cont">
                                                <div class="cont-col1">
                                                    <div class="label label-sm label-default">
                                                        <i class="fa fa-user"></i>
                                                    </div>
                                                </div>
                                                <div class="cont-col2">
                                                    <div class="desc"> You have 5 pending membership that requires a quick review. </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col2">
                                            <div class="date"> 24 mins </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="col1">
                                            <div class="cont">
                                                <div class="cont-col1">
                                                    <div class="label label-sm label-info">
                                                        <i class="fa fa-shopping-cart"></i>
                                                    </div>
                                                </div>
                                                <div class="cont-col2">
                                                    <div class="desc"> New order received with
                                                        <span class="label label-sm label-success"> Reference Number: DR23923 </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col2">
                                            <div class="date"> 30 mins </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="col1">
                                            <div class="cont">
                                                <div class="cont-col1">
                                                    <div class="label label-sm label-success">
                                                        <i class="fa fa-user"></i>
                                                    </div>
                                                </div>
                                                <div class="cont-col2">
                                                    <div class="desc"> You have 5 pending membership that requires a quick review. </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col2">
                                            <div class="date"> 24 mins </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="col1">
                                            <div class="cont">
                                                <div class="cont-col1">
                                                    <div class="label label-sm label-warning">
                                                        <i class="fa fa-bell-o"></i>
                                                    </div>
                                                </div>
                                                <div class="cont-col2">
                                                    <div class="desc"> Web server hardware needs to be upgraded.
                                                        <span class="label label-sm label-default "> Overdue </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col2">
                                            <div class="date"> 2 hours </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            <div class="col1">
                                                <div class="cont">
                                                    <div class="cont-col1">
                                                        <div class="label label-sm label-info">
                                                            <i class="fa fa-briefcase"></i>
                                                        </div>
                                                    </div>
                                                    <div class="cont-col2">
                                                        <div class="desc"> IPO Report for year 2013 has been released. </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col2">
                                                <div class="date"> 20 mins </div>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="tab-pane page-quick-sidebar-settings" id="quick_sidebar_tab_3">
                            <div class="page-quick-sidebar-settings-list">
                                <h3 class="list-heading">General Settings</h3>
                                <ul class="list-items borderless">
                                    <li> Enable Notifications
                                        <input type="checkbox" class="make-switch" checked data-size="small" data-on-color="success" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                    <li> Allow Tracking
                                        <input type="checkbox" class="make-switch" data-size="small" data-on-color="info" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                    <li> Log Errors
                                        <input type="checkbox" class="make-switch" checked data-size="small" data-on-color="danger" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                    <li> Auto Sumbit Issues
                                        <input type="checkbox" class="make-switch" data-size="small" data-on-color="warning" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                    <li> Enable SMS Alerts
                                        <input type="checkbox" class="make-switch" checked data-size="small" data-on-color="success" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                </ul>
                                <h3 class="list-heading">System Settings</h3>
                                <ul class="list-items borderless">
                                    <li> Security Level
                                        <select class="form-control input-inline input-sm input-small">
                                            <option value="1">Normal</option>
                                            <option value="2" selected>Medium</option>
                                            <option value="e">High</option>
                                        </select>
                                    </li>
                                    <li> Failed Email Attempts
                                        <input class="form-control input-inline input-sm input-small" value="5" /> </li>
                                    <li> Secondary SMTP Port
                                        <input class="form-control input-inline input-sm input-small" value="3560" /> </li>
                                    <li> Notify On System Error
                                        <input type="checkbox" class="make-switch" checked data-size="small" data-on-color="danger" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                    <li> Notify On SMTP Error
                                        <input type="checkbox" class="make-switch" checked data-size="small" data-on-color="warning" data-on-text="ON" data-off-color="default" data-off-text="OFF"> </li>
                                </ul>
                                <div class="inner-content">
                                    <button class="btn btn-success">
                                        <i class="icon-settings"></i> Save Changes</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END QUICK SIDEBAR -->';
        }
        public function contextUserMenu()
        {
            global $lang;
            return '<div id="context-menu">
                                        <ul class="dropdown-menu" role="menu">
                                            <li onclick="window.location.href=\''.URL.'/profile\'">
                                                <a><i class="icon-user"></i> '.ADMIN_NAME.' </a>
                                            </li>
                                            <li onclick="window.location.href=\''.URL.'/calendar\'">
                                                <a><i class="icon-calendar"></i> '.$lang['profilemenu.calendar'].'</a>
                                            </li>
                                            <li onclick="window.location.href=\''.URL.'/tasks\'">
                                                <a><i class="icon-rocket"></i> '.$lang['profilemenu.tasks'].'</a>
                                            </li>
                                            <li class="divider"> </li>
                                            <li onclick="window.location.href=\''.URL.'/locked?ref=timeout\'">
                                                <a><i class="icon-lock"></i> '.$lang['profilemenu.lockScreen'].'</a>
                                            </li>
                                            <li onclick="window.location.href=\''.URL.'/logout\'">
                                                <a><i class="icon-key"></i> '.$lang['profilemenu.logout'].'</a>
                                            </li>
                                        </ul>
                                    </div>';
        }
}