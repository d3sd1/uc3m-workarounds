<?php
require('kernel/core.php');
?><!DOCTYPE html>
	<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]--><!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"> <![endif]--><!--[if IE 8]><html class="no-js lt-ie9"><![endif]--><!--[if gt IE 8]><!--><html class="no-js"><!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title><?php echo $lang['title.nojs'] ?></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<?php echo URL ?>/css/base.css">
        <link rel="stylesheet" href="<?php echo URL ?>/css/bootstrap.css">
        <link rel="stylesheet" href="<?php echo URL ?>/css/normalize.css">
        <link rel="stylesheet" href="<?php echo URL ?>/css/nojs.css">		
		<link rel="stylesheet" href="<?php echo URL ?>/css/responsive.css">
		<script type="text/javascript">
			window.location = "<?php echo URL ?>";
		</script>
		<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="browsehappy"><?php echo $lang['nojs.download'] ?></p>
        <![endif]-->
		<div class="four_zero_warapper_area column">
			<div class="four_zero_text">
				<h1><?php echo $lang['nojs.h1'] ?></h1>
				<p><?php echo $lang['nojs.desc'] ?></p>
			</div>
		</div>
		<div class="mainmenu_area">
			<div class="menu_heading column">
				<h2><?php echo $lang['nojs.download'] ?></h2>
			</div>
			
		</div>
    </body>
</html>
