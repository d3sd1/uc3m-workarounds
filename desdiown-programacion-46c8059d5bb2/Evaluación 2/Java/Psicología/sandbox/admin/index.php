<?php require('admin.php');
if(!ADMIN_LOGGED_IN)
{
	header('Location: '.URL.'/login');
}
if(ADMIN_USER_LOCKED)
{
	header('Location: '.URL.'/locked');
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
        <title><?php echo $lang['title.start'] ?></title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Preview page of Metronic Admin Theme #6 for statistics, charts, recent events and reports" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN LAYOUT FIRST STYLES -->
        <link href="//fonts.googleapis.com/css?family=Oswald:400,300,700" rel="stylesheet" type="text/css" />
        <!-- END LAYOUT FIRST STYLES -->
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
        <link href="<?php echo URL ?>/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="<?php echo URL ?>/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="<?php echo URL ?>/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="<?php echo URL ?>/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <link href="<?php echo URL ?>/assets/global/plugins/bootstrap-daterangepicker/daterangepicker.min.css" rel="stylesheet" type="text/css" />
        <link href="<?php echo URL ?>/assets/global/plugins/morris/morris.css" rel="stylesheet" type="text/css" />
        <link href="<?php echo URL ?>/assets/global/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" type="text/css" />
        <link href="<?php echo URL ?>/assets/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="<?php echo URL ?>/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="<?php echo URL ?>/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="<?php echo URL ?>/assets/layouts/css/layout.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="<?php echo BASEURL ?>/favicon.ico" /> </head>
    <!-- END HEAD -->

    <body class="" data-toggle="context" data-target="#context-menu">
        <!-- BEGIN HEADER -->
        <header class="page-header">
            <nav class="navbar" role="navigation">
                <div class="container-fluid">
                    <div class="havbar-header">
                        <!-- BEGIN LOGO -->
                        <a id="index" class="navbar-brand" href="<?php echo URL ?>">
                            <img draggable="false" src="<?php echo BASEURL ?>/images/logo/logo.png" alt="Logo"> </a>
                        <!-- END LOGO -->
                        <!-- BEGIN TOPBAR ACTIONS -->
                        <div class="topbar-actions">
                            <!-- DOC: Apply "search-form-expanded" right after the "search-form" class to have half expanded search box -->
                            <form class="search-form" action="extra_search.html" method="GET">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="<?php echo $lang['menu.search.ph'] ?>" name="query">
                                    <span class="input-group-btn">
                                        <a href="javascript:;" class="btn md-skip submit">
                                            <i class="fa fa-search"></i>
                                        </a>
                                    </span>
                                </div>
                            </form>
                            <!-- END HEADER SEARCH BOX -->
                            <!-- BEGIN GROUP NOTIFICATION -->
                            <div class="btn-group-notification btn-group" id="header_notification_bar">
                                <button type="button" class="btn md-skip dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true" style="margin-right: 10px">
                                    <span class="badge" id="logoutTimer"></span>
                                </button>
                            </div>
                            <!-- END GROUP NOTIFICATION -->
                            <!-- BEGIN USER PROFILE -->
                            <div class="btn-group-img btn-group">
                                <button type="button" class="btn btn-sm dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                    <img src="<?php echo ADMIN_PHOTO ?>" alt=""> </button>
                                <ul class="dropdown-menu-v2" role="menu">
                                    <?php echo $admin->userMenu() ?>
                                </ul>
                            </div>
                            <!-- END USER PROFILE -->
                        </div>
                        <!-- END TOPBAR ACTIONS -->
                    </div>
                </div>
                <!--/container-->
            </nav>
        </header>
        <!-- END HEADER -->
        <!-- BEGIN CONTAINER -->
        <div class="container-fluid">
            <div class="page-content page-content-popup">
                <div class="page-content-fixed-header">
                    <!-- BEGIN BREADCRUMBS -->
                    <ul class="page-breadcrumb">
                        <li><?php echo $lang['path.start'] ?></li>
                    </ul>
                    <!-- END BREADCRUMBS -->
                    <div class="content-header-menu">
                        <!-- BEGIN DROPDOWN AJAX MENU -->
                        <div class="dropdown-ajax-menu btn-group">
                            <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                <i class="fa fa-circle"></i>
                                <i class="fa fa-circle"></i>
                                <i class="fa fa-circle"></i>
                            </button>
                            <ul class="dropdown-menu-v2">
                                <li>
                                    <a href="<?php echo URL ?>/start"><?php echo $lang['path.menu.start'] ?></a>
                                </li>
                                <li>
                                    <a href="<?php echo URL ?>/users"><?php echo $lang['path.menu.users'] ?></a>
                                </li>
                                <li>
                                    <a href="<?php echo URL ?>/config"><?php echo $lang['path.menu.config'] ?></a>
                                </li>
                                <li>
                                    <a href="<?php echo URL ?>/langsMgr/admin/es"><?php echo $lang['path.menu.langs'] ?></a>
                                </li>
                            </ul>
                        </div>
                        <!-- END DROPDOWN AJAX MENU -->
                        <!-- BEGIN MENU TOGGLER -->
                        <button type="button" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="toggle-icon">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </span>
                        </button>
                        <!-- END MENU TOGGLER -->
                    </div>
                </div>
                <div class="page-sidebar-wrapper">
                    <!-- BEGIN SIDEBAR -->
                    <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
                    <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
                    <div class="page-sidebar navbar-collapse collapse">
                        <!-- BEGIN SIDEBAR MENU -->
                        <!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
                        <!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
                        <!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
                        <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
                        <!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
                        <!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
                        <?php echo $admin->menu('start'); ?>
                        <!-- END SIDEBAR MENU -->
                    </div>
                    <!-- END SIDEBAR -->
                </div>
                <div class="page-fixed-main-content">
                    <!-- BEGIN PAGE BASE CONTENT -->
                    <!-- BEGIN DASHBOARD STATS 1-->
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <a class="dashboard-stat dashboard-stat-v2 blue" href="#">
                                <div class="visual">
                                    <i class="fa fa-user"></i>
                                </div>
                                <div class="details">
                                    <div class="number">
                                        <span data-counter="counterup" data-value="<?php echo $db->query('SELECT id FROM users WHERE type="client"')->num_rows; ?>">0</span>
                                    </div>
                                    <div class="desc"> <?php echo $lang['overview.clients'] ?> </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <a class="dashboard-stat dashboard-stat-v2 red" href="#">
                                <div class="visual">
                                    <i class="fa fa-user-md"></i>
                                </div>
                                <div class="details">
                                    <div class="number">
                                        <span data-counter="counterup" data-value="<?php echo $db->query('SELECT id FROM users WHERE type="psico"')->num_rows; ?>">0</span>
									</div>
                                    <div class="desc"> <?php echo $lang['overview.psicos'] ?> </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <a class="dashboard-stat dashboard-stat-v2 green" href="#">
                                <div class="visual">
                                    <i class="fa fa-shopping-cart"></i>
                                </div>
                                <div class="details">
                                    <div class="number">
                                        <span data-counter="counterup" data-value="<?php echo $db->query('SELECT id FROM pays')->num_rows; ?>">0</span>
                                    </div>
                                    <div class="desc"> <?php echo $lang['overview.paids'] ?> </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <a class="dashboard-stat dashboard-stat-v2 purple" href="#">
                                <div class="visual">
                                    <i class="fa fa-globe"></i>
                                </div>
                                <div class="details">
                                    <div class="number">
                                        <span data-counter="counterup" data-value="<?php echo $db->query('SELECT id FROM admin_users')->num_rows; ?>">0</span>
									</div>
                                    <div class="desc"> <?php echo $lang['overview.admins'] ?> </div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <!-- END DASHBOARD STATS 1-->
                    <div class="row">
                        <div class="col-lg-6 col-xs-12 col-sm-12">
                            <!-- BEGIN PORTLET-->
                            <div class="portlet light bordered">
                                <div class="portlet-title">
                                    <div class="caption">
                                        <i class="icon-bar-chart font-dark hide"></i>
                                        <span class="caption-subject font-dark bold uppercase"><?php echo $lang['overview.sitevisits'] ?></span>
                                        <span class="caption-helper"><?php echo $lang['overview.sitevisits.weekly'] ?></span>
                                    </div>
                                    <div class="actions">
                                        <a href="<?php echo URL ?>/site/stats"><button type="button" class="btn btn-info"><?php echo $lang['overview.sitevisits.showfull'] ?></button></a>
                                    </div>
                                </div>
                                <div class="portlet-body">
                                    <div id="site_statistics_loading">
                                        <img src="assets/global/img/loading.gif" alt="loading" /> </div>
                                    <div id="site_statistics_content" class="display-none">
                                        <div id="site_statistics" class="chart"> </div>
                                    </div>
                                </div>
                            </div>
                            <!-- END PORTLET-->
                        </div>
                        <div class="col-lg-6 col-xs-12 col-sm-12">
                            <!-- BEGIN REGIONAL STATS PORTLET-->
                            <div class="portlet light bordered">
                                <div class="portlet-title">
                                    <div class="caption">
                                        <i class="icon-share font-dark hide"></i>
                                        <span class="caption-subject font-dark bold uppercase">Regional Stats</span>
                                    </div>
                                    <div class="actions">
                                        <a class="btn btn-circle btn-icon-only btn-default" href="javascript:;">
                                            <i class="icon-cloud-upload"></i>
                                        </a>
                                        <a class="btn btn-circle btn-icon-only btn-default" href="javascript:;">
                                            <i class="icon-wrench"></i>
                                        </a>
                                        <a class="btn btn-circle btn-icon-only btn-default fullscreen" data-container="false" data-placement="bottom" href="javascript:;"> </a>
                                        <a class="btn btn-circle btn-icon-only btn-default" href="javascript:;">
                                            <i class="icon-trash"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="portlet-body">
                                    <div id="region_statistics_loading">
                                        <img src="assets/global/img/loading.gif" alt="loading" /> </div>
                                    <div id="region_statistics_content" class="display-none">
                                        <div class="btn-toolbar margin-bottom-10">
                                            <div class="btn-group btn-group-circle" data-toggle="buttons">
                                                <a href="" class="btn grey-salsa btn-sm active"> Users </a>
                                                <a href="" class="btn grey-salsa btn-sm"> Orders </a>
                                            </div>
                                            <div class="btn-group pull-right">
                                                <a href="" class="btn btn-circle grey-salsa btn-sm dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true"> Select Region
                                                    <span class="fa fa-angle-down"> </span>
                                                </a>
                                                <ul class="dropdown-menu pull-right">
                                                    <li>
                                                        <a href="javascript:;" id="regional_stat_world"> World </a>
                                                    </li>
                                                    <li>
                                                        <a href="javascript:;" id="regional_stat_usa"> USA </a>
                                                    </li>
                                                    <li>
                                                        <a href="javascript:;" id="regional_stat_europe"> Europe </a>
                                                    </li>
                                                    <li>
                                                        <a href="javascript:;" id="regional_stat_russia"> Russia </a>
                                                    </li>
                                                    <li>
                                                        <a href="javascript:;" id="regional_stat_germany"> Germany </a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div id="vmap_world" class="vmaps display-none"> </div>
                                        <div id="vmap_usa" class="vmaps display-none"> </div>
                                        <div id="vmap_europe" class="vmaps display-none"> </div>
                                        <div id="vmap_russia" class="vmaps display-none"> </div>
                                        <div id="vmap_germany" class="vmaps display-none"> </div>
                                    </div>
                                </div>
                            </div>
                            <!-- END REGIONAL STATS PORTLET-->
                        </div>
                    </div>
                   
                    <div class="row">
                        <div class="col-lg-6 col-xs-12 col-sm-12">
                            <div class="portlet light bordered">
                                <div class="portlet-title">
                                    <div class="caption">
                                        <i class="icon-cursor font-dark hide"></i>
                                        <span class="caption-subject font-dark bold uppercase"><?php echo $lang['frontpage.comparemonths.title'] ?></span>
                                    </div>
                                    <!--<div class="actions">
                                        <a href="javascript:;" class="btn btn-sm btn-circle red easy-pie-chart-reload">
                                            <i class="fa fa-repeat"></i> <?php echo $lang['frontpage.comparemonths.reload'] ?> </a>
                                    </div>-->
                                </div>
                                <div class="portlet-body">
                                    <div class="row">
                                        <?php
                                        $comparemonthsPaysPre = $db->query('SELECT id FROM users WHERE type="client" AND EXTRACT(MONTH FROM DATE_FORMAT(FROM_UNIXTIME(dateRegistered), \'%Y-%c-%e\'))='.(date('j')-1))->num_rows;
                                        $comparemonthsPaysThis = $db->query('SELECT id FROM users WHERE type="client" AND EXTRACT(MONTH FROM DATE_FORMAT(FROM_UNIXTIME(dateRegistered), \'%Y-%c-%e\'))='.date('j'))->num_rows;
                                        $comparemonthPaysPerc = $comparemonthsPaysThis/($comparemonthsPaysPre != 0 ? $comparemonthsPaysPre:1);
                                        if($comparemonthPaysPerc < 1 && $comparemonthPaysPerc > 0)
                                        {
                                            $comparemonthPaysPerc = '-'.($comparemonthPaysPerc*100);
                                        }
                                        if($comparemonthPaysPerc >= 1)
                                        {
                                            $comparemonthPaysPerc = '+'.($comparemonthPaysPerc*100);
                                        }
                                        ?>
                                        <div class="col-md-3">
                                            <div class="easy-pie-chart">
                                                <div class="number transactions" data-percent="<?php echo str_replace(array('+','-'),array(null,null),$comparemonthPaysPerc) ?>">
                                                    <span><?php echo $comparemonthPaysPerc ?></span>% </div>
                                                <a class="title" href="javascript:;"> <?php echo $lang['frontpage.comparemonths.transactions'] ?>
                                                    <i class="icon-arrow-right"></i>
                                                </a>
                                            </div>
                                        </div>
                                        <div class="margin-bottom-10 visible-sm"> </div>
                                        <?php
                                        $comparemonthsVisitsPre = $db->query('SELECT id FROM web_visits WHERE SUBSTRING(timestamp,3,2)='.(date('m')-1))->num_rows;
                                        $comparemonthsVisitsThis = $db->query('SELECT id FROM web_visits WHERE SUBSTRING(timestamp,3,2)='.date('m'))->num_rows;
                                        $compareMonthsVisitsPerc = $comparemonthsVisitsThis/($comparemonthsVisitsPre != 0 ? $comparemonthsVisitsPre:1);
                                        if($compareMonthsVisitsPerc < 1 && $compareMonthsVisitsPerc > 0)
                                        {
                                            $compareMonthsVisitsPerc = '-'.($compareMonthsVisitsPerc*100);
                                        }
                                        if($compareMonthsVisitsPerc >= 1)
                                        {
                                            $compareMonthsVisitsPerc = '+'.($compareMonthsVisitsPerc*100);
                                        }
                                        ?>
                                        <div class="col-md-3">
                                            <div class="easy-pie-chart">
                                                <div class="number visits" data-percent="<?php echo str_replace(array('+','-'),array(null,null),$compareMonthsVisitsPerc) ?>">
                                                    <span><?php echo $compareMonthsVisitsPerc ?></span>% </div>
                                                <a class="title" href="javascript:;"> <?php echo $lang['frontpage.comparemonths.visits'] ?>
                                                    <i class="icon-arrow-right"></i>
                                                </a>
                                            </div>
                                        </div>
                                        <div class="margin-bottom-10 visible-sm"> </div>
                                        <?php
                                        $comparemonthsClientsPre = $db->query('SELECT id FROM users WHERE type="client" AND EXTRACT(MONTH FROM DATE_FORMAT(FROM_UNIXTIME(dateRegistered), \'%Y-%c-%e\'))='.(date('j')-1))->num_rows;
                                        $comparemonthsClientsThis = $db->query('SELECT id FROM users WHERE type="client" AND EXTRACT(MONTH FROM DATE_FORMAT(FROM_UNIXTIME(dateRegistered), \'%Y-%c-%e\'))='.date('j'))->num_rows;
                                        $comparemonthsClientsPerc = $comparemonthsClientsThis/($comparemonthsClientsPre != 0 ? $comparemonthsClientsPre:1);
                                        if($comparemonthsClientsPerc < 1 && $comparemonthsClientsPerc > 0)
                                        {
                                            $comparemonthsClientsPerc = '-'.($comparemonthsClientsPerc*100);
                                        }
                                        if($comparemonthsClientsPerc >= 1)
                                        {
                                            $comparemonthsClientsPerc = '+'.($comparemonthsClientsPerc*100);
                                        }
                                        ?>
                                        <div class="col-md-3">
                                            <div class="easy-pie-chart">
                                                <div class="number clients" data-percent="<?php echo str_replace(array('+','-'),array(null,null),$comparemonthsClientsPerc) ?>">
                                                    <span><?php echo $comparemonthsClientsPerc ?></span>% </div>
                                                <a class="title" href="javascript:;"> <?php echo $lang['frontpage.comparemonths.clients'] ?>
                                                    <i class="icon-arrow-right"></i>
                                                </a>
                                            </div>
                                        </div>
                                        <div class="margin-bottom-10 visible-sm"> </div>
                                        <?php
                                        $comparemonthsPsicosPre = $db->query('SELECT id FROM users WHERE type="client" AND EXTRACT(MONTH FROM DATE_FORMAT(FROM_UNIXTIME(dateRegistered), \'%Y-%c-%e\'))='.(date('j')-1))->num_rows;
                                        $comparemonthsPsicosThis = $db->query('SELECT id FROM users WHERE type="client" AND EXTRACT(MONTH FROM DATE_FORMAT(FROM_UNIXTIME(dateRegistered), \'%Y-%c-%e\'))='.date('j'))->num_rows;
                                        $comparemonthsPsicosPerc = $comparemonthsPsicosThis/($comparemonthsPsicosPre != 0 ? $comparemonthsPsicosPre:1);
                                        if($comparemonthsPsicosPerc < 1 && $comparemonthsPsicosPerc > 0)
                                        {
                                            $comparemonthsPsicosPerc = '-'.($comparemonthsPsicosPerc*100);
                                        }
                                        if($comparemonthsPsicosPerc >= 1)
                                        {
                                            $comparemonthsPsicosPerc = '+'.($comparemonthsPsicosPerc*100);
                                        }
                                        ?>
                                        <div class="col-md-3">
                                            <div class="easy-pie-chart">
                                                <div class="number psicos" data-percent="<?php echo str_replace(array('+','-'),array(null,null),$comparemonthsPsicosPerc) ?>">
                                                    <span><?php echo $comparemonthsPsicosPerc ?></span>% </div>
                                                <a class="title" href="javascript:;"> <?php echo $lang['frontpage.comparemonths.psicos'] ?>
                                                    <i class="icon-arrow-right"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-xs-12 col-sm-12">
                            <div class="portlet light bordered">
                                <div class="portlet-title">
                                    <div class="caption">
                                        <i class="icon-equalizer font-dark hide"></i>
                                        <span class="caption-subject font-dark bold uppercase"><?php echo $lang['frontpage.serverStatus'] ?></span>
                                        <span class="caption-helper"><?php echo $lang['frontpage.serverStatus.justNow'] ?></span>
                                    </div>
                                </div>
                                <div class="portlet-body">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="sparkline-chart">
                                                <div class="number" id="sparkline_bar5"></div>
                                                <a class="title" href="javascript:;"> <?php echo $lang['frontpage.serverStatus.network'] ?>
                                                    <i class="icon-arrow-right"></i>
                                                </a>
                                            </div>
                                        </div>
                                        <div class="margin-bottom-10 visible-sm"> </div>
                                        <div class="col-md-4">
                                            <div class="sparkline-chart">
                                                <div class="number" id="sparkline_bar6"></div>
                                                <a class="title" href="javascript:;"> <?php echo $lang['frontpage.serverStatus.cpuLoad'] ?>
                                                    <i class="icon-arrow-right"></i>
                                                </a>
                                            </div>
                                        </div>
                                        <div class="margin-bottom-10 visible-sm"> </div>
                                        <div class="col-md-4">
                                            <div class="sparkline-chart">
                                                <div class="number" id="sparkline_line"></div>
                                                <a class="title" href="javascript:;"> <?php echo $lang['frontpage.serverStatus.overLoad'] ?>
                                                    <i class="icon-arrow-right"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 col-xs-12 col-sm-12">
                            <!-- BEGIN PORTLET-->
                            <div class="portlet light bordered">
                                <div class="portlet-title">
                                    <div class="caption">
                                        <i class="icon-share font-red-sunglo hide"></i>
                                        <span class="caption-subject font-dark bold uppercase">Revenue</span>
                                        <span class="caption-helper">monthly stats...</span>
                                    </div>
                                    <div class="actions">
                                        <div class="btn-group">
                                            <a href="" class="btn dark btn-outline btn-circle btn-sm dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true"> Filter Range
                                                <span class="fa fa-angle-down"> </span>
                                            </a>
                                            <ul class="dropdown-menu pull-right">
                                                <li>
                                                    <a href="javascript:;"> Q1 2014
                                                        <span class="label label-sm label-default"> past </span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;"> Q2 2014
                                                        <span class="label label-sm label-default"> past </span>
                                                    </a>
                                                </li>
                                                <li class="active">
                                                    <a href="javascript:;"> Q3 2014
                                                        <span class="label label-sm label-success"> current </span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;"> Q4 2014
                                                        <span class="label label-sm label-warning"> upcoming </span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="portlet-body">
                                    <div id="site_activities_loading">
                                        <img src="assets/global/img/loading.gif" alt="loading" /> </div>
                                    <div id="site_activities_content" class="display-none">
                                        <div id="site_activities" style="height: 228px;"> </div>
                                    </div>
                                    <div style="margin: 20px 0 10px 30px">
                                        <div class="row">
                                            <div class="col-md-3 col-sm-3 col-xs-6 text-stat">
                                                <span class="label label-sm label-success"> Revenue: </span>
                                                <h3>$13,234</h3>
                                            </div>
                                            <div class="col-md-3 col-sm-3 col-xs-6 text-stat">
                                                <span class="label label-sm label-info"> Tax: </span>
                                                <h3>$134,900</h3>
                                            </div>
                                            <div class="col-md-3 col-sm-3 col-xs-6 text-stat">
                                                <span class="label label-sm label-danger"> Shipment: </span>
                                                <h3>$1,134</h3>
                                            </div>
                                            <div class="col-md-3 col-sm-3 col-xs-6 text-stat">
                                                <span class="label label-sm label-warning"> Orders: </span>
                                                <h3>235090</h3>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- END PORTLET-->
                        </div>
                        <div class="col-lg-6 col-xs-12 col-sm-12">
                            <!-- BEGIN PORTLET-->
                            <div class="portlet light bordered">
                                <div class="portlet-title tabbable-line">
                                    <div class="caption">
                                        <i class="icon-globe font-dark hide"></i>
                                        <span class="caption-subject font-dark bold uppercase"><?php echo $lang['frontpage.logs'] ?></span>
                                    </div>
                                </div>
                                <div class="portlet-body">
                                    <!--BEGIN TABS-->
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="tab_1_1">
                                            <div class="scroller" style="height: 339px;" data-always-visible="1" data-rail-visible="0">
                                                <ul class="feeds">
                                                    <?php
                                                    $logData = $db->query('SELECT type,INET_NTOA(ip),user,timestamp FROM admin_logs ORDER BY timestamp DESC LIMIT '.$config['admin.logs.maxtoshow']);
                                                    while($thisLog = $logData->fetch_row())
                                                    {
                                                        $iconGet = 'dot-circle-o';
                                                        if(stristr($thisLog[0],'LOGIN') !== FALSE)
                                                        {
                                                            $iconGet = 'sign-in';
                                                        }
                                                        else if(stristr($thisLog[0],'LOGOUT') !== FALSE)
                                                        {
                                                            $iconGet = 'sign-out';
                                                        }
                                                        else if(stristr($thisLog[0],'LOCKED') !== FALSE)
                                                        {
                                                            $iconGet = 'lock';
                                                        }
                                                        
                                                        if(stristr($thisLog[0],'ERROR') !== FALSE || stristr($thisLog[0],'FAILED') !== FALSE)
                                                        {
                                                            $iconColor = 'danger';
                                                        }
                                                        elseif(stristr($thisLog[0],'SUCCESS') !== FALSE)
                                                        {
                                                            $iconColor = 'success';
                                                        }
                                                        elseif(stristr($thisLog[0],'LOCKED') !== FALSE)
                                                        {
                                                            $iconColor = 'warning';
                                                        }
                                                        else
                                                        {
                                                            $iconColor = 'info';
                                                        }
                                                        echo '<li>
                                                        <div class="col1">
                                                            <div class="cont">
                                                                <div class="cont-col1">
                                                                    <div class="label label-sm label-'.$iconColor.'">
                                                                        <i class="fa fa-'.$iconGet.'"></i>
                                                                    </div>
                                                                </div>
                                                                <div class="cont-col2">
                                                                    <div class="desc">[<b>'.$thisLog[1].'</b>] [<b>'.$thisLog[2].'</b>] '.$lang['log.'.str_replace('_','.',$thisLog[0])].' </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col2">
                                                            <div class="date"> '.$core->timeElapsed($thisLog[3]).' </div>
                                                        </div>
                                                    </li>    ';
                                                    }
                                                    ?>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <!--END TABS-->
                                </div>
                            </div>
                            <!-- END PORTLET-->
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 col-xs-12 col-sm-12">
                            <!-- BEGIN PORTLET-->
                            <div class="portlet light calendar bordered">
                                <div class="portlet-title ">
                                    <div class="caption">
                                        <i class="icon-calendar font-dark hide"></i>
                                        <span class="caption-subject font-dark bold uppercase">Feeds</span>
                                    </div>
                                </div>
                                <div class="portlet-body">
                                    <div id="calendar"> </div>
                                </div>
                            </div>
                            <!-- END PORTLET-->
                        </div>
                        <div class="col-lg-6 col-xs-12 col-sm-12">
                            <!-- BEGIN PORTLET-->
                            <div class="portlet light bordered">
                                <div class="portlet-title">
                                    <div class="caption">
                                        <i class="icon-bubble font-hide hide"></i>
                                        <span class="caption-subject font-hide bold uppercase">Chats</span>
                                    </div>
                                    <div class="actions">
                                        <div class="portlet-input input-inline">
                                            <div class="input-icon right">
                                                <i class="icon-magnifier"></i>
                                                <input type="text" class="form-control input-circle" placeholder="search..."> </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="portlet-body" id="chats">
                                    <div class="scroller" style="height: 525px;" data-always-visible="1" data-rail-visible1="1">
                                        <ul class="chats">
                                            <li class="out">
                                                <img class="avatar" alt="" src="assets//layouts/img/avatar2.jpg" />
                                                <div class="message">
                                                    <span class="arrow"> </span>
                                                    <a href="javascript:;" class="name"> Lisa Wong </a>
                                                    <span class="datetime"> at 20:11 </span>
                                                    <span class="body"> Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
                                                </div>
                                            </li>
                                            <li class="out">
                                                <img class="avatar" alt="" src="assets//layouts/img/avatar2.jpg" />
                                                <div class="message">
                                                    <span class="arrow"> </span>
                                                    <a href="javascript:;" class="name"> Lisa Wong </a>
                                                    <span class="datetime"> at 20:11 </span>
                                                    <span class="body"> Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
                                                </div>
                                            </li>
                                            <li class="in">
                                                <img class="avatar" alt="" src="assets//layouts/img/avatar1.jpg" />
                                                <div class="message">
                                                    <span class="arrow"> </span>
                                                    <a href="javascript:;" class="name"> Bob Nilson </a>
                                                    <span class="datetime"> at 20:30 </span>
                                                    <span class="body"> Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
                                                </div>
                                            </li>
                                            <li class="in">
                                                <img class="avatar" alt="" src="assets//layouts/img/avatar1.jpg" />
                                                <div class="message">
                                                    <span class="arrow"> </span>
                                                    <a href="javascript:;" class="name"> Bob Nilson </a>
                                                    <span class="datetime"> at 20:30 </span>
                                                    <span class="body"> Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
                                                </div>
                                            </li>
                                            <li class="out">
                                                <img class="avatar" alt="" src="assets//layouts/img/avatar3.jpg" />
                                                <div class="message">
                                                    <span class="arrow"> </span>
                                                    <a href="javascript:;" class="name"> Richard Doe </a>
                                                    <span class="datetime"> at 20:33 </span>
                                                    <span class="body"> Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
                                                </div>
                                            </li>
                                            <li class="in">
                                                <img class="avatar" alt="" src="assets//layouts/img/avatar3.jpg" />
                                                <div class="message">
                                                    <span class="arrow"> </span>
                                                    <a href="javascript:;" class="name"> Richard Doe </a>
                                                    <span class="datetime"> at 20:35 </span>
                                                    <span class="body"> Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
                                                </div>
                                            </li>
                                            <li class="out">
                                                <img class="avatar" alt="" src="assets//layouts/img/avatar1.jpg" />
                                                <div class="message">
                                                    <span class="arrow"> </span>
                                                    <a href="javascript:;" class="name"> Bob Nilson </a>
                                                    <span class="datetime"> at 20:40 </span>
                                                    <span class="body"> Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
                                                </div>
                                            </li>
                                            <li class="in">
                                                <img class="avatar" alt="" src="assets//layouts/img/avatar3.jpg" />
                                                <div class="message">
                                                    <span class="arrow"> </span>
                                                    <a href="javascript:;" class="name"> Richard Doe </a>
                                                    <span class="datetime"> at 20:40 </span>
                                                    <span class="body"> Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </span>
                                                </div>
                                            </li>
                                            <li class="out">
                                                <img class="avatar" alt="" src="assets//layouts/img/avatar1.jpg" />
                                                <div class="message">
                                                    <span class="arrow"> </span>
                                                    <a href="javascript:;" class="name"> Bob Nilson </a>
                                                    <span class="datetime"> at 20:54 </span>
                                                    <span class="body"> Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. sed diam nonummy nibh euismod tincidunt ut laoreet. </span>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="chat-form">
                                        <div class="input-cont">
                                            <input class="form-control" type="text" placeholder="Type a message here..." /> </div>
                                        <div class="btn-cont">
                                            <span class="arrow"> </span>
                                            <a href="" class="btn blue icn-only">
                                                <i class="fa fa-check icon-white"></i>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- END PORTLET-->
                        </div>
                    </div>
                    <!-- END PAGE BASE CONTENT -->
                </div>
                <!-- BEGIN FOOTER -->
                <p class="copyright-v2"> <?php echo $lang['footer.copy'] ?></p>
                <?php echo $admin->userSidebar(); ?>
        <!--[if lt IE 9]>
<script src="<?php echo URL ?>/assets/global/plugins/respond.min.js"></script>
<script src="<?php echo URL ?>/assets/global/plugins/excanvas.min.js"></script> 
<script src="<?php echo URL ?>/assets/global/plugins/ie8.fix.min.js"></script> 
<![endif]-->
        <?php echo $admin->contextUserMenu(); ?>
        <!-- BEGIN CORE PLUGINS -->
        <script src="<?php echo URL ?>/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <script src="<?php echo URL ?>/assets/global/plugins/moment.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/bootstrap-daterangepicker/daterangepicker.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/morris/morris.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/morris/raphael-min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/counterup/jquery.waypoints.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/counterup/jquery.counterup.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/amcharts/amcharts/amcharts.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/amcharts/amcharts/serial.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/amcharts/amcharts/pie.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/amcharts/amcharts/radar.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/amcharts/amcharts/themes/light.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/amcharts/amcharts/themes/patterns.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/amcharts/amcharts/themes/chalk.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/amcharts/ammap/ammap.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/amcharts/ammap/maps/js/worldLow.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/amcharts/amstockcharts/amstock.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/horizontal-timeline/horizontal-timeline.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL SCRIPTS -->
        <script src="<?php echo URL ?>/assets/global/scripts/app.min.js" type="text/javascript"></script>
        <!-- END THEME GLOBAL SCRIPTS -->
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script type="text/javascript">var Dashboard=function() {
            return {
                initJQVMAP:function() {
                    if(jQuery().vectorMap) {
                        var e=function(e) {
                            jQuery(".vmaps").hide(),
                            jQuery("#vmap_"+e).show()
                        }
                        ,
                        t=function(e) {
                            var t=jQuery("#vmap_"+e);
                            if(1===t.size()) {
                                var a= {
                                    map:"world_en",
                                    backgroundColor:null,
                                    borderColor:"#333333",
                                    borderOpacity:.5,
                                    borderWidth:1,
                                    color:"#c6c6c6",
                                    enableZoom:!0,
                                    hoverColor:"#c9dfaf",
                                    hoverOpacity:null,
                                    values:sample_data,
                                    normalizeFunction:"linear",
                                    scaleColors:["#b6da93",
                                    "#909cae"],
                                    selectedColor:"#c9dfaf",
                                    selectedRegion:null,
                                    showTooltip:!0,
                                    onLabelShow:function(e, t, a) {}
                                    ,
                                    onRegionOver:function(e, t) {
                                        "ca"==t&&e.preventDefault()
                                    }
                                    ,
                                    onRegionClick:function(e, t, a) {
                                        var i='You clicked "'+a+'" which has the code: '+t.toUpperCase();
                                        alert(i)
                                    }
                                }
                                ;
                                a.map=e+"_en",
                                t.width(t.parent().parent().width()),
                                t.show(),
                                t.vectorMap(a),
                                t.hide()
                            }
                        }
                        ;
                        t("world"),
                        t("usa"),
                        t("europe"),
                        t("russia"),
                        t("germany"),
                        e("world"),
                        jQuery("#regional_stat_world").click(function() {
                            e("world")
                        }
                        ),
                        jQuery("#regional_stat_usa").click(function() {
                            e("usa")
                        }
                        ),
                        jQuery("#regional_stat_europe").click(function() {
                            e("europe")
                        }
                        ),
                        jQuery("#regional_stat_russia").click(function() {
                            e("russia")
                        }
                        ),
                        jQuery("#regional_stat_germany").click(function() {
                            e("germany")
                        }
                        ),
                        $("#region_statistics_loading").hide(),
                        $("#region_statistics_content").show(),
                        App.addResizeHandler(function() {
                            jQuery(".vmaps").each(function() {
                                var e=jQuery(this);
                                e.width(e.parent().width())
                            }
                            )
                        }
                        )
                    }
                }
                ,
                initCalendar:function() {
                    if(jQuery().fullCalendar) {
                        var e=new Date,
                        t=e.getDate(),
                        a=e.getMonth(),
                        i=e.getFullYear(),
                        l= {}
                        ;
                        $("#calendar").width()<=400?($("#calendar").addClass("mobile"), l= {
                            left: "title, prev, next", center: "", right: "today,month,agendaWeek,agendaDay"
                        }
                        ):($("#calendar").removeClass("mobile"), l=App.isRTL()? {
                            right: "title", center: "", left: "prev,next,today,month,agendaWeek,agendaDay"
                        }
                        : {
                            left: "title", center: "", right: "prev,next,today,month,agendaWeek,agendaDay"
                        }
                        ),
                        $("#calendar").fullCalendar("destroy"),
                        $("#calendar").fullCalendar( {
                            disableDragging:!1, header:l, editable:!0, events:[ {
                                title: "All Day", start: new Date(i, a, 1), backgroundColor: App.getBrandColor("yellow")
                            }
                            , {
                                title: "Long Event", start: new Date(i, a, t-5), end: new Date(i, a, t-2), backgroundColor: App.getBrandColor("blue")
                            }
                            , {
                                title: "Repeating Event", start: new Date(i, a, t-3, 16, 0), allDay: !1, backgroundColor: App.getBrandColor("red")
                            }
                            , {
                                title: "Repeating Event", start: new Date(i, a, t+6, 16, 0), allDay: !1, backgroundColor: App.getBrandColor("green")
                            }
                            , {
                                title: "Meeting", start: new Date(i, a, t+9, 10, 30), allDay: !1
                            }
                            , {
                                title: "Lunch", start: new Date(i, a, t, 14, 0), end: new Date(i, a, t, 14, 0), backgroundColor: App.getBrandColor("grey"), allDay: !1
                            }
                            , {
                                title: "Birthday", start: new Date(i, a, t+1, 19, 0), end: new Date(i, a, t+1, 22, 30), backgroundColor: App.getBrandColor("purple"), allDay: !1
                            }
                            , {
                                title: "Click for Google", start: new Date(i, a, 28), end: new Date(i, a, 29), backgroundColor: App.getBrandColor("yellow"), url: "http://google.com/"
                            }
                            ]
                        }
                        )
                    }
                }
                ,
                initCharts:function() {
                    function e(e, t, a, i) {
                        $('<div id="tooltip" class="chart-tooltip">'+i+"</div>").css( {
                            position: "absolute", display: "none", top: t-40, left: e-40, border: "0px solid #ccc", padding: "2px 6px", "background-color": "#fff"
                        }
                        ).appendTo("body").fadeIn(200)
                    }
                    if(jQuery.plot) {
                        var t=[
                            <?php
                        $actualMonth = date('m');
                        $days = array();
                        $visits = array();
                        $date = date('d');
                        $chartLogsOutpot = null;
                        for($i = $config['admin.charts.visits.interval']; $i >= 0; $i--)
                        {
                           $actualDay = $date-$i;
                           if($db->query('SELECT SUBSTRING(TIMESTAMP,1,2) FROM web_visits WHERE SUBSTRING(TIMESTAMP,1,2)='.$actualDay)->num_rows > 0)
                           {
                                $chartLogsOutpot .= '["'.$db->query('SELECT SUBSTRING(TIMESTAMP,1,2) FROM web_visits WHERE SUBSTRING(TIMESTAMP,1,2)='.$actualDay)->fetch_row()[0].'/'.$db->query('SELECT SUBSTRING(TIMESTAMP,3,2) FROM web_visits WHERE SUBSTRING(TIMESTAMP,1,2)='.$actualDay)->fetch_row()[0].'",'.$db->query('SELECT id FROM web_visits WHERE SUBSTRING(TIMESTAMP,1,2)='.$actualDay)->num_rows.'],';
                           }
                        }
                        echo substr($chartLogsOutpot,0,-1);
                        ?>];
                        if(0!=$("#site_statistics").size()) {
                            $("#site_statistics_loading").hide(),
                            $("#site_statistics_content").show();
                            var a=($.plot($("#site_statistics"), [ {
                                data:t, lines: {
                                    fill: .6, lineWidth: 0
                                }
                                , color:["#f89f9f"]
                            }
                            , {
                                data:t, points: {
                                    show: !0, fill: !0, radius: 5, fillColor: "#f89f9f", lineWidth: 3
                                }
                                , color:"#fff", shadowSize:0
                            }
                            ], {
                                xaxis: {
                                    tickLength:0, tickDecimals:0, mode:"categories", min:0, font: {
                                        lineHeight: 14, style: "normal", variant: "small-caps", color: "#6F7B8A"
                                    }
                                }
                                , yaxis: {
                                    ticks:5, tickDecimals:0, tickColor:"#eee", font: {
                                        lineHeight: 14, style: "normal", variant: "small-caps", color: "#6F7B8A"
                                    }
                                }
                                , grid: {
                                    hoverable: !0, clickable: !0, tickColor: "#eee", borderColor: "#eee", borderWidth: 1
                                }
                            }
                            ), null);
                            $("#site_statistics").bind("plothover", function(t, i, l) {
                                if($("#x").text(i.x.toFixed(2)), $("#y").text(i.y.toFixed(2)), l) {
                                    if(a!=l.dataIndex) {
                                        a=l.dataIndex, $("#tooltip").remove();
                                        l.datapoint[0].toFixed(2), l.datapoint[1].toFixed(2);
                                        e(l.pageX, l.pageY, l.datapoint[0], l.datapoint[1]+" <?php echo $lang['overview.sitevisits.single'] ?>.")
                                    }
                                }
                                else $("#tooltip").remove(), a=null
                            }
                            )
                        }
                        if(0!=$("#site_activities").size()) {
                            var i=null;
                            $("#site_activities_loading").hide(),
                            $("#site_activities_content").show();
                            var l=[["DEC",
                            300],
                            ["JAN",
                            600],
                            ["FEB",
                            1100],
                            ["MAR",
                            1200],
                            ["APR",
                            860],
                            ["MAY",
                            1200],
                            ["JUN",
                            1450],
                            ["JUL",
                            1800],
                            ["AUG",
                            1200],
                            ["SEP",
                            600]];
                            $.plot($("#site_activities"), [ {
                                data:l, lines: {
                                    fill: .2, lineWidth: 0
                                }
                                , color:["#BAD9F5"]
                            }
                            , {
                                data:l, points: {
                                    show: !0, fill: !0, radius: 4, fillColor: "#9ACAE6", lineWidth: 2
                                }
                                , color:"#9ACAE6", shadowSize:1
                            }
                            , {
                                data:l, lines: {
                                    show: !0, fill: !1, lineWidth: 3
                                }
                                , color:"#9ACAE6", shadowSize:0
                            }
                            ], {
                                xaxis: {
                                    tickLength:0, tickDecimals:0, mode:"categories", min:0, font: {
                                        lineHeight: 18, style: "normal", variant: "small-caps", color: "#6F7B8A"
                                    }
                                }
                                , yaxis: {
                                    ticks:5, tickDecimals:0, tickColor:"#eee", font: {
                                        lineHeight: 14, style: "normal", variant: "small-caps", color: "#6F7B8A"
                                    }
                                }
                                , grid: {
                                    hoverable: !0, clickable: !0, tickColor: "#eee", borderColor: "#eee", borderWidth: 1
                                }
                            }
                            );
                            $("#site_activities").bind("plothover", function(t, a, l) {
                                if($("#x").text(a.x.toFixed(2)), $("#y").text(a.y.toFixed(2)), l&&i!=l.dataIndex) {
                                    i=l.dataIndex, $("#tooltip").remove();
                                    l.datapoint[0].toFixed(2), l.datapoint[1].toFixed(2);
                                    e(l.pageX, l.pageY, l.datapoint[0], l.datapoint[1]+"M$")
                                }
                            }
                            ),
                            $("#site_activities").bind("mouseleave", function() {
                                $("#tooltip").remove()
                            }
                            )
                        }
                    }
                }
                ,
                initEasyPieCharts:function() {
                    jQuery().easyPieChart&&($(".easy-pie-chart .number.transactions").easyPieChart( {
                        animate: 1e3, size: 75, lineWidth: 3, barColor: App.getBrandColor("yellow")
                    }
                    ), $(".easy-pie-chart .number.visits").easyPieChart( {
                        animate: 1e3, size: 75, lineWidth: 3, barColor: App.getBrandColor("green")
                    }
                    ), $(".easy-pie-chart .number.clients").easyPieChart( {
                        animate: 1e3, size: 75, lineWidth: 3, barColor: App.getBrandColor("red")
                    }
                    ), $(".easy-pie-chart .number.psicos").easyPieChart( {
                        animate: 1e3, size: 75, lineWidth: 3, barColor: App.getBrandColor("blue")
                    }
                    ), $(".easy-pie-chart-reload").click(function() {
                        $(".easy-pie-chart .number").each(function() {
                            var e=Math.floor(100*Math.random());
                            $(this).data("easyPieChart").update(e), $("span", this).text(e)
                        }
                        )
                    }
                    ))
                }
                ,
                initSparklineCharts:function() {
                    jQuery().sparkline&&($("#sparkline_bar").sparkline([8, 9, 10, 11, 10, 10, 12, 10, 10, 11, 9, 12, 11, 10, 9, 11, 13, 13, 12], {
                        type: "bar", width: "100", barWidth: 5, height: "55", barColor: "#f36a5b", negBarColor: "#e02222"
                    }
                    ), $("#sparkline_bar2").sparkline([9, 11, 12, 13, 12, 13, 10, 14, 13, 11, 11, 12, 11, 11, 10, 12, 11, 10], {
                        type: "bar", width: "100", barWidth: 5, height: "55", barColor: "#5c9bd1", negBarColor: "#e02222"
                    }
                    ), $("#sparkline_bar5").sparkline([8, 9, 10, 11, 10, 10, 12, 10, 10, 11, 9, 12, 11, 10, 9, 11, 13, 13, 12], {
                        type: "bar", width: "100", barWidth: 5, height: "55", barColor: "#35aa47", negBarColor: "#e02222"
                    }
                    ), $("#sparkline_bar6").sparkline([9, 11, 12, 13, 12, 13, 10, 14, 13, 11, 11, 12, 11, 11, 10, 12, 11, 10], {
                        type: "bar", width: "100", barWidth: 5, height: "55", barColor: "#ffb848", negBarColor: "#e02222"
                    }
                    ), $("#sparkline_line").sparkline([9, 10, 9, 10, 10, 11, 12, 10, 10, 11, 11, 12, 11, 10, 12, 11, 10, 12], {
                        type: "line", width: "100", height: "55", lineColor: "#ffb848"
                    }
                    ))
                }
                ,
                initMorisCharts:function() {
                    Morris.EventEmitter&&$("#sales_statistics").size()>0&&(dashboardMainChart=Morris.Area( {
                        element:"sales_statistics", padding:0, behaveLikeLine:!1, gridEnabled:!1, gridLineColor:!1, axes:!1, fillOpacity:1, data:[ {
                            period: "2011 Q1", sales: 1400, profit: 400
                        }
                        , {
                            period: "2011 Q2", sales: 1100, profit: 600
                        }
                        , {
                            period: "2011 Q3", sales: 1600, profit: 500
                        }
                        , {
                            period: "2011 Q4", sales: 1200, profit: 400
                        }
                        , {
                            period: "2012 Q1", sales: 1550, profit: 800
                        }
                        ], lineColors:["#399a8c", "#92e9dc"], xkey:"period", ykeys:["sales", "profit"], labels:["Sales", "Profit"], pointSize:0, lineWidth:0, hideHover:"auto", resize:!0
                    }
                    ))
                }
                ,
                initChat:function() {
                    var e=$("#chats"),
                    t=$(".chats", e),
                    a=$(".chat-form", e),
                    i=$("input", a),
                    l=$(".btn", a),
                    o=function(a) {
                        a.preventDefault();
                        var l=i.val();
                        if(0!=l.length) {
                            var o=new Date,
                            n=o.getHours()+":"+o.getMinutes(),
                            r="";
                            r+='<li class="out">',
                            r+='<img class="avatar" alt="" src="'+Layout.getLayoutImgPath()+'avatar1.jpg"/>',
                            r+='<div class="message">',
                            r+='<span class="arrow"></span>',
                            r+='<a href="#" class="name">Bob Nilson</a>&nbsp;',
                            r+='<span class="datetime">at '+n+"</span>",
                            r+='<span class="body">',
                            r+=l,
                            r+="</span>",
                            r+="</div>",
                            r+="</li>";
                            t.append(r);
                            i.val("");
                            var s=function() {
                                var t=0;
                                return e.find("li.out, li.in").each(function() {
                                    t+=$(this).outerHeight()
                                }
                                ),
                                t
                            }
                            ;
                            e.find(".scroller").slimScroll( {
                                scrollTo: s()
                            }
                            )
                        }
                    }
                    ;
                    $("body").on("click", ".message .name", function(e) {
                        e.preventDefault();
                        var t=$(this).text();
                        i.val("@"+t+":"), App.scrollTo(i)
                    }
                    ),
                    l.click(o),
                    i.keypress(function(e) {
                        return 13==e.which?(o(e), !1): void 0
                    }
                    )
                }
                ,
                initDashboardDaterange:function() {
                    jQuery().daterangepicker&&($("#dashboard-report-range").daterangepicker( {
                        ranges: {
                            Today: [moment(), moment()], Yesterday: [moment().subtract("days", 1), moment().subtract("days", 1)], "Last 7 Days": [moment().subtract("days", 6), moment()], "Last 30 Days": [moment().subtract("days", 29), moment()], "This Month": [moment().startOf("month"), moment().endOf("month")], "Last Month": [moment().subtract("month", 1).startOf("month"), moment().subtract("month", 1).endOf("month")]
                        }
                        , locale: {
                            format: "MM/DD/YYYY", separator: " - ", applyLabel: "Apply", cancelLabel: "Cancel", fromLabel: "From", toLabel: "To", customRangeLabel: "Custom", daysOfWeek: ["Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"], monthNames: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"], firstDay: 1
                        }
                        , opens:App.isRTL()?"right":"left"
                    }
                    , function(e, t, a) {
                        "0"!=$("#dashboard-report-range").attr("data-display-range")&&$("#dashboard-report-range span").html(e.format("MMMM D, YYYY")+" - "+t.format("MMMM D, YYYY"))
                    }
                    ), "0"!=$("#dashboard-report-range").attr("data-display-range")&&$("#dashboard-report-range span").html(moment().subtract("days", 29).format("MMMM D, YYYY")+" - "+moment().format("MMMM D, YYYY")), $("#dashboard-report-range").show())
                }
                ,
                initAmChart1:function() {
                    if("undefined"!=typeof AmCharts&&0!==$("#dashboard_amchart_1").size()) {
                        var e=[ {
                            date: "2012-01-05", distance: 480, townName: "Miami", townName2: "Miami", townSize: 10, latitude: 25.83, duration: 501
                        }
                        ,
                        {
                            date: "2012-01-06", distance: 386, townName: "Tallahassee", townSize: 7, latitude: 30.46, duration: 443
                        }
                        ,
                        {
                            date: "2012-01-07", distance: 348, townName: "New Orleans", townSize: 10, latitude: 29.94, duration: 405
                        }
                        ,
                        {
                            date: "2012-01-08", distance: 238, townName: "Houston", townName2: "Houston", townSize: 16, latitude: 29.76, duration: 309
                        }
                        ,
                        {
                            date: "2012-01-09", distance: 218, townName: "Dalas", townSize: 17, latitude: 32.8, duration: 287
                        }
                        ,
                        {
                            date: "2012-01-10", distance: 349, townName: "Oklahoma City", townSize: 11, latitude: 35.49, duration: 485
                        }
                        ,
                        {
                            date: "2012-01-11", distance: 603, townName: "Kansas City", townSize: 10, latitude: 39.1, duration: 890
                        }
                        ,
                        {
                            date: "2012-01-12", distance: 534, townName: "Denver", townName2: "Denver", townSize: 18, latitude: 39.74, duration: 810
                        }
                        ,
                        {
                            date: "2012-01-13", townName: "Salt Lake City", townSize: 12, distance: 425, duration: 670, latitude: 40.75, alpha: .4
                        }
                        ,
                        {
                            date: "2012-01-14", latitude: 36.1, duration: 470, townName: "Las Vegas", townName2: "Las Vegas", bulletClass: "lastBullet"
                        }
                        ,
                        {
                            date: "2012-01-15"
                        }
                        ];
                        AmCharts.makeChart("dashboard_amchart_1", {
                            type:"serial", fontSize:12, fontFamily:"Open Sans", dataDateFormat:"YYYY-MM-DD", dataProvider:e, addClassNames:!0, startDuration:1, color:"#6c7b88", marginLeft:0, categoryField:"date", categoryAxis: {
                                parseDates:!0, minPeriod:"DD", autoGridCount:!1, gridCount:50, gridAlpha:.1, gridColor:"#FFFFFF", axisColor:"#555555", dateFormats:[ {
                                    period: "DD", format: "DD"
                                }
                                , {
                                    period: "WW", format: "MMM DD"
                                }
                                , {
                                    period: "MM", format: "MMM"
                                }
                                , {
                                    period: "YYYY", format: "YYYY"
                                }
                                ]
                            }
                            , valueAxes:[ {
                                id: "a1", title: "distance", gridAlpha: 0, axisAlpha: 0
                            }
                            , {
                                id: "a2", position: "right", gridAlpha: 0, axisAlpha: 0, labelsEnabled: !1
                            }
                            , {
                                id:"a3", title:"duration", position:"right", gridAlpha:0, axisAlpha:0, inside:!0, duration:"mm", durationUnits: {
                                    DD: "d. ", hh: "h ", mm: "min", ss: ""
                                }
                            }
                            ], graphs:[ {
                                id: "g1", valueField: "distance", title: "distance", type: "column", fillAlphas: .7, valueAxis: "a1", balloonText: "[[value]] miles", legendValueText: "[[value]] mi", legendPeriodValueText: "total: [[value.sum]] mi", lineColor: "#08a3cc", alphaField: "alpha"
                            }
                            , {
                                id: "g2", valueField: "latitude", classNameField: "bulletClass", title: "latitude/city", type: "line", valueAxis: "a2", lineColor: "#786c56", lineThickness: 1, legendValueText: "[[description]]/[[value]]", descriptionField: "townName", bullet: "round", bulletSizeField: "townSize", bulletBorderColor: "#02617a", bulletBorderAlpha: 1, bulletBorderThickness: 2, bulletColor: "#89c4f4", labelText: "[[townName2]]", labelPosition: "right", balloonText: "latitude:[[value]]", showBalloon: !0, animationPlayed: !0
                            }
                            , {
                                id: "g3", title: "duration", valueField: "duration", type: "line", valueAxis: "a3", lineAlpha: .8, lineColor: "#e26a6a", balloonText: "[[value]]", lineThickness: 1, legendValueText: "[[value]]", bullet: "square", bulletBorderColor: "#e26a6a", bulletBorderThickness: 1, bulletBorderAlpha: .8, dashLengthField: "dashLength", animationPlayed: !0
                            }
                            ], chartCursor: {
                                zoomable: !1, categoryBalloonDateFormat: "DD", cursorAlpha: 0, categoryBalloonColor: "#e26a6a", categoryBalloonAlpha: .8, valueBalloonsEnabled: !1
                            }
                            , legend: {
                                bulletType: "round", equalWidths: !1, valueWidth: 120, useGraphSettings: !0, color: "#6c7b88"
                            }
                        }
                        )
                    }
                }
                ,
                initAmChart2:function() {
                    if("undefined"!=typeof AmCharts&&0!==$("#dashboard_amchart_2").size()) {
                        var e="M9,0C4.029,0,0,4.029,0,9s4.029,9,9,9s9-4.029,9-9S13.971,0,9,0z M9,15.93 c-3.83,0-6.93-3.1-6.93-6.93S5.17,2.07,9,2.07s6.93,3.1,6.93,6.93S12.83,15.93,9,15.93 M12.5,9c0,1.933-1.567,3.5-3.5,3.5S5.5,10.933,5.5,9S7.067,5.5,9,5.5 S12.5,7.067,12.5,9z",
                        t="M19.671,8.11l-2.777,2.777l-3.837-0.861c0.362-0.505,0.916-1.683,0.464-2.135c-0.518-0.517-1.979,0.278-2.305,0.604l-0.913,0.913L7.614,8.804l-2.021,2.021l2.232,1.061l-0.082,0.082l1.701,1.701l0.688-0.687l3.164,1.504L9.571,18.21H6.413l-1.137,1.138l3.6,0.948l1.83,1.83l0.947,3.598l1.137-1.137V21.43l3.725-3.725l1.504,3.164l-0.687,0.687l1.702,1.701l0.081-0.081l1.062,2.231l2.02-2.02l-0.604-2.689l0.912-0.912c0.326-0.326,1.121-1.789,0.604-2.306c-0.452-0.452-1.63,0.101-2.135,0.464l-0.861-3.838l2.777-2.777c0.947-0.947,3.599-4.862,2.62-5.839C24.533,4.512,20.618,7.163,19.671,8.11z";
                        AmCharts.makeChart("dashboard_amchart_2", {
                            type:"map", theme:"light", pathToImages:"assets/global/plugins/amcharts/ammap/images/", dataProvider: {
                                map:"worldLow", linkToObject:"london", images:[ {
                                    id:"london", color:"#009dc7", svgPath:e, title:"London", latitude:51.5002, longitude:-.1262, scale:1.5, zoomLevel:2.74, zoomLongitude:-20.1341, zoomLatitude:49.1712, lines:[ {
                                        latitudes: [51.5002, 50.4422], longitudes: [-.1262, 30.5367]
                                    }
                                    , {
                                        latitudes: [51.5002, 46.948], longitudes: [-.1262, 7.4481]
                                    }
                                    , {
                                        latitudes: [51.5002, 59.3328], longitudes: [-.1262, 18.0645]
                                    }
                                    , {
                                        latitudes: [51.5002, 40.4167], longitudes: [-.1262, -3.7033]
                                    }
                                    , {
                                        latitudes: [51.5002, 46.0514], longitudes: [-.1262, 14.506]
                                    }
                                    , {
                                        latitudes: [51.5002, 48.2116], longitudes: [-.1262, 17.1547]
                                    }
                                    , {
                                        latitudes: [51.5002, 44.8048], longitudes: [-.1262, 20.4781]
                                    }
                                    , {
                                        latitudes: [51.5002, 55.7558], longitudes: [-.1262, 37.6176]
                                    }
                                    , {
                                        latitudes: [51.5002, 38.7072], longitudes: [-.1262, -9.1355]
                                    }
                                    , {
                                        latitudes: [51.5002, 54.6896], longitudes: [-.1262, 25.2799]
                                    }
                                    , {
                                        latitudes: [51.5002, 64.1353], longitudes: [-.1262, -21.8952]
                                    }
                                    , {
                                        latitudes: [51.5002, 40.43], longitudes: [-.1262, -74]
                                    }
                                    ], images:[ {
                                        label: "Flights from London", svgPath: t, left: 100, top: 45, labelShiftY: 5, color: "#d93d5e", labelColor: "#d93d5e", labelRollOverColor: "#d93d5e", labelFontSize: 20
                                    }
                                    , {
                                        label: "show flights from Vilnius", left: 106, top: 70, labelColor: "#6c7b88", labelRollOverColor: "#d93d5e", labelFontSize: 11, linkToObject: "vilnius"
                                    }
                                    ]
                                }
                                , {
                                    id:"vilnius", color:"#009dc7", svgPath:e, title:"Vilnius", latitude:54.6896, longitude:25.2799, scale:1.5, zoomLevel:4.92, zoomLongitude:15.4492, zoomLatitude:50.2631, lines:[ {
                                        latitudes: [54.6896, 50.8371], longitudes: [25.2799, 4.3676]
                                    }
                                    , {
                                        latitudes: [54.6896, 59.9138], longitudes: [25.2799, 10.7387]
                                    }
                                    , {
                                        latitudes: [54.6896, 40.4167], longitudes: [25.2799, -3.7033]
                                    }
                                    , {
                                        latitudes: [54.6896, 50.0878], longitudes: [25.2799, 14.4205]
                                    }
                                    , {
                                        latitudes: [54.6896, 48.2116], longitudes: [25.2799, 17.1547]
                                    }
                                    , {
                                        latitudes: [54.6896, 44.8048], longitudes: [25.2799, 20.4781]
                                    }
                                    , {
                                        latitudes: [54.6896, 55.7558], longitudes: [25.2799, 37.6176]
                                    }
                                    , {
                                        latitudes: [54.6896, 37.9792], longitudes: [25.2799, 23.7166]
                                    }
                                    , {
                                        latitudes: [54.6896, 54.6896], longitudes: [25.2799, 25.2799]
                                    }
                                    , {
                                        latitudes: [54.6896, 51.5002], longitudes: [25.2799, -.1262]
                                    }
                                    , {
                                        latitudes: [54.6896, 53.3441], longitudes: [25.2799, -6.2675]
                                    }
                                    ], images:[ {
                                        label: "Flights from Vilnius", svgPath: t, left: 100, top: 45, labelShiftY: 5, color: "#d93d5e", labelColor: "#d93d5e", labelRollOverColor: "#d93d5e", labelFontSize: 20
                                    }
                                    , {
                                        label: "show flights from London", left: 106, top: 70, labelColor: "#009dc7", labelRollOverColor: "#d93d5e", labelFontSize: 11, linkToObject: "london"
                                    }
                                    ]
                                }
                                , {
                                    svgPath: e, title: "Brussels", latitude: 50.8371, longitude: 4.3676
                                }
                                , {
                                    svgPath: e, title: "Prague", latitude: 50.0878, longitude: 14.4205
                                }
                                , {
                                    svgPath: e, title: "Athens", latitude: 37.9792, longitude: 23.7166
                                }
                                , {
                                    svgPath: e, title: "Reykjavik", latitude: 64.1353, longitude: -21.8952
                                }
                                , {
                                    svgPath: e, title: "Dublin", latitude: 53.3441, longitude: -6.2675
                                }
                                , {
                                    svgPath: e, title: "Oslo", latitude: 59.9138, longitude: 10.7387
                                }
                                , {
                                    svgPath: e, title: "Lisbon", latitude: 38.7072, longitude: -9.1355
                                }
                                , {
                                    svgPath: e, title: "Moscow", latitude: 55.7558, longitude: 37.6176
                                }
                                , {
                                    svgPath: e, title: "Belgrade", latitude: 44.8048, longitude: 20.4781
                                }
                                , {
                                    svgPath: e, title: "Bratislava", latitude: 48.2116, longitude: 17.1547
                                }
                                , {
                                    svgPath: e, title: "Ljubljana", latitude: 46.0514, longitude: 14.506
                                }
                                , {
                                    svgPath: e, title: "Madrid", latitude: 40.4167, longitude: -3.7033
                                }
                                , {
                                    svgPath: e, title: "Stockholm", latitude: 59.3328, longitude: 18.0645
                                }
                                , {
                                    svgPath: e, title: "Bern", latitude: 46.948, longitude: 7.4481
                                }
                                , {
                                    svgPath: e, title: "Kiev", latitude: 50.4422, longitude: 30.5367
                                }
                                , {
                                    svgPath: e, title: "Paris", latitude: 48.8567, longitude: 2.351
                                }
                                , {
                                    svgPath: e, title: "New York", latitude: 40.43, longitude: -74
                                }
                                ]
                            }
                            , zoomControl: {
                                buttonFillColor: "#dddddd"
                            }
                            , areasSettings: {
                                unlistedAreasColor: "#15A892"
                            }
                            , imagesSettings: {
                                color: "#d93d5e", rollOverColor: "#d93d5e", selectedColor: "#009dc7"
                            }
                            , linesSettings: {
                                color: "#d93d5e", alpha: .4
                            }
                            , backgroundZoomsToTop:!0, linesAboveImages:!0, "export": {
                                enabled:!0, libs: {
                                    path: "http://www.amcharts.com/lib/3/plugins/export/libs/"
                                }
                            }
                        }
                        )
                    }
                }
                ,
                initAmChart3:function() {
                    if("undefined"!=typeof AmCharts&&0!==$("#dashboard_amchart_3").size()) {
                        AmCharts.makeChart("dashboard_amchart_3", {
                            type:"serial", addClassNames:!0, theme:"light", path:"assets/global/plugins/amcharts/ammap/images/", autoMargins:!1, marginLeft:30, marginRight:8, marginTop:10, marginBottom:26, balloon: {
                                adjustBorderColor: !1, horizontalPadding: 10, verticalPadding: 8, color: "#ffffff"
                            }
                            , dataProvider:[ {
                                year: 2009, income: 23.5, expenses: 21.1
                            }
                            , {
                                year: 2010, income: 26.2, expenses: 30.5
                            }
                            , {
                                year: 2011, income: 30.1, expenses: 34.9
                            }
                            , {
                                year: 2012, income: 29.5, expenses: 31.1
                            }
                            , {
                                year: 2013, income: 30.6, expenses: 28.2
                            }
                            , {
                                year: 2014, income: 34.1, expenses: 32.9, dashLengthColumn: 5, alpha: .2, additional: "(projection)"
                            }
                            ], valueAxes:[ {
                                axisAlpha: 0, position: "left"
                            }
                            ], startDuration:1, graphs:[ {
                                alphaField: "alpha", balloonText: "<span style='font-size:12px;'>[[title]] in [[category]]:<br><span style='font-size:20px;'>[[value]]</span> [[additional]]</span>", fillAlphas: 1, title: "Income", type: "column", valueField: "income", dashLengthField: "dashLengthColumn"
                            }
                            , {
                                id: "graph2", balloonText: "<span style='font-size:12px;'>[[title]] in [[category]]:<br><span style='font-size:20px;'>[[value]]</span> [[additional]]</span>", bullet: "round", lineThickness: 3, bulletSize: 7, bulletBorderAlpha: 1, bulletColor: "#FFFFFF", useLineColorForBulletBorder: !0, bulletBorderThickness: 3, fillAlphas: 0, lineAlpha: 1, title: "Expenses", valueField: "expenses"
                            }
                            ], categoryField:"year", categoryAxis: {
                                gridPosition: "start", axisAlpha: 0, tickLength: 0
                            }
                            , "export": {
                                enabled: !0
                            }
                        }
                        )
                    }
                }
                ,
                initAmChart4:function() {
                    if("undefined"!=typeof AmCharts&&0!==$("#dashboard_amchart_4").size()) {
                        var e=AmCharts.makeChart("dashboard_amchart_4", {
                            type:"pie", theme:"light", path:"assets/global/plugins/amcharts/ammap/images/", dataProvider:[ {
                                country: "Lithuania", value: 260
                            }
                            , {
                                country: "Ireland", value: 201
                            }
                            , {
                                country: "Germany", value: 65
                            }
                            , {
                                country: "Australia", value: 39
                            }
                            , {
                                country: "UK", value: 19
                            }
                            , {
                                country: "Latvia", value: 10
                            }
                            ], valueField:"value", titleField:"country", outlineAlpha:.4, depth3D:15, balloonText:"[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>", angle:30, "export": {
                                enabled: !0
                            }
                        }
                        );
                        jQuery(".chart-input").off().on("input change", function() {
                            var t=jQuery(this).data("property"), a=e, i=Number(this.value);
                            e.startDuration=0, "innerRadius"==t&&(i+="%"), a[t]=i, e.validateNow()
                        }
                        )
                    }
                }
                ,
                initWorldMapStats:function() {
                    0!==$("#mapplic").size()&&($("#mapplic").mapplic( {
                        source: "assets/global/plugins/mapplic/world.json", height: 265, animate: !1, sidebar: !1, minimap: !1, locations: !0, deeplinking: !0, fullscreen: !1, hovertip: !0, zoombuttons: !1, clearbutton: !1, developer: !1, maxscale: 2, skin: "mapplic-dark", zoom: !0
                    }
                    ), $("#widget_sparkline_bar").sparkline([8, 7, 9, 8.5, 8, 8.2, 8, 8.5, 9, 8, 9], {
                        type: "bar", width: "100", barWidth: 5, height: "30", barColor: "#4db3a4", negBarColor: "#e02222"
                    }
                    ), $("#widget_sparkline_bar2").sparkline([8, 7, 9, 8.5, 8, 8.2, 8, 8.5, 9, 8, 9], {
                        type: "bar", width: "100", barWidth: 5, height: "30", barColor: "#f36a5a", negBarColor: "#e02222"
                    }
                    ), $("#widget_sparkline_bar3").sparkline([8, 7, 9, 8.5, 8, 8.2, 8, 8.5, 9, 8, 9], {
                        type: "bar", width: "100", barWidth: 5, height: "30", barColor: "#5b9bd1", negBarColor: "#e02222"
                    }
                    ), $("#widget_sparkline_bar4").sparkline([8, 7, 9, 8.5, 8, 8.2, 8, 8.5, 9, 8, 9], {
                        type: "bar", width: "100", barWidth: 5, height: "30", barColor: "#9a7caf", negBarColor: "#e02222"
                    }
                    ))
                }
                ,
                init:function() {
                    this.initJQVMAP(),
                    this.initCalendar(),
                    this.initCharts(),
                    this.initEasyPieCharts(),
                    this.initSparklineCharts(),
                    this.initChat(),
                    this.initDashboardDaterange(),
                    this.initMorisCharts(),
                    this.initAmChart1(),
                    this.initAmChart2(),
                    this.initAmChart3(),
                    this.initAmChart4(),
                    this.initWorldMapStats()
                }
            }
        }

        ();
        App.isAngularJsApp()===!1&&jQuery(document).ready(function() {
            Dashboard.init()
        }

        );
                </script>
        <!-- END PAGE LEVEL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <script src="<?php echo URL ?>/assets/layouts/scripts/layout.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/layouts/scripts/quick-sidebar.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/layouts/scripts/quick-nav.min.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/global/plugins/bootstrap-contextmenu/bootstrap-contextmenu.js" type="text/javascript"></script>
        <script src="<?php echo URL ?>/assets/pages/scripts/components-context-menu.min.js" type="text/javascript"></script>
		<?php
		if(isset($_GET['ref']) && $_GET['ref'] == 'relogged')
		{
			echo '<script type="text/javascript">
				$(window).load(function(){
					$("#reloggedLocked").modal("show");
				});
			</script>';
		}
		?>
		<script type="text/javascript">
                    (function (win)
{
    var _LOCALSTORAGE_KEY = 'WINDOW_VALIDATION';
    var _initialized = false;
    var _isMainWindow = false;
    var _unloaded = false;
    var _windowArray;
    var _windowId;
    var _isNewWindowPromotedToMain = false;
    var _onWindowUpdated;
    function WindowStateManager(isNewWindowPromotedToMain, onWindowUpdated)
    {
        _onWindowUpdated = onWindowUpdated;
        _isNewWindowPromotedToMain = isNewWindowPromotedToMain;
        _windowId = Date.now().toString();
        bindUnload();
        determineWindowState.call(this);
        _initialized = true;
        _onWindowUpdated.call(this);
    }
    function determineWindowState()
    {
        var self = this;
        var _previousState = _isMainWindow;
        _windowArray = localStorage.getItem(_LOCALSTORAGE_KEY);
        if (_windowArray === null || _windowArray === "NaN")
        {
            _windowArray = [];
        }
        else
        {
            _windowArray = JSON.parse(_windowArray);
        }
        if (_initialized)
        {
            if (_windowArray.length <= 1 ||
               (_isNewWindowPromotedToMain ? _windowArray[_windowArray.length - 1] : _windowArray[0]) === _windowId)
            {
                _isMainWindow = true;
            }
            else
            {
                _isMainWindow = false;
            }
        }
        else
        {
            if (_windowArray.length === 0)
            {
                _isMainWindow = true;
                _windowArray[0] = _windowId;
                localStorage.setItem(_LOCALSTORAGE_KEY, JSON.stringify(_windowArray));
            }
            else
            {
                _isMainWindow = false;
                _windowArray.push(_windowId);
                localStorage.setItem(_LOCALSTORAGE_KEY, JSON.stringify(_windowArray));
            }
        }

        if (_previousState !== _isMainWindow)
        {
            _onWindowUpdated.call(this);
        }
        setTimeout(function()
                   {
                     determineWindowState.call(self);
                   }, 50);
    }
    function removeWindow()
    {
        var __windowArray = JSON.parse(localStorage.getItem(_LOCALSTORAGE_KEY));
        for (var i = 0, length = __windowArray.length; i < length; i++)
        {
            if (__windowArray[i] === _windowId)
            {
                __windowArray.splice(i, 1);
                break;
            }
        }
        localStorage.setItem(_LOCALSTORAGE_KEY, JSON.stringify(__windowArray));
    }
    function bindUnload()
    {
        win.addEventListener('beforeunload', function ()
        {
            if (!_unloaded)
            {
                removeWindow();
            }
        });
        win.addEventListener('unload', function ()
        {
            if (!_unloaded)
            {
                removeWindow();
            }
        });
    }
    WindowStateManager.prototype.isMainWindow = function ()
    {
        return _isMainWindow;
    };
    WindowStateManager.prototype.resetWindows = function ()
    {
        localStorage.removeItem(_LOCALSTORAGE_KEY);
    };
    win.WindowStateManager = WindowStateManager;
})(window);
var WindowStateManager = new WindowStateManager(true, windowUpdated);
var timesCalled = 0;
var windowStatusDisabled = false;
function windowUpdated()
{
    if(this.isMainWindow() === false && timesCalled > 0)
	{
            windowStatusDisabled = true;
            $("#openedSmwElse").modal("show");
            $('body').click(false);
            document.onkeydown = function (e) {
                    return false;
            }
	}
	timesCalled++;
}
		function startTimer(duration, display) {
			var timer = duration, minutes, seconds;
			var myTimer = setInterval(function () {
                            if(windowStatusDisabled == false)
                            {
				minutes = parseInt(timer / 60, 10);
				seconds = parseInt(timer % 60, 10);

				minutes = minutes < 10 ? "0" + minutes : minutes;
				seconds = seconds < 10 ? "0" + seconds : seconds;
				if (timer-- < 0) {
					clearInterval(myTimer);
					window.location.replace("<?php echo URL ?>/locked?ref=timeout");
				}
				else
				{
					display.text(minutes + ":" + seconds);
				}
                            }
			}, 1000);
		}

		jQuery(function ($) {
			startTimer(<?php echo $config['admin.session.timeout'] ?>, $('#logoutTimer'));
		});
                $('body').click(function (e){  
                    if (e.ctrlKey) {
                        return false;
                    }
                });
		</script>
        <!-- END THEME LAYOUT SCRIPTS -->
</body>


</html>