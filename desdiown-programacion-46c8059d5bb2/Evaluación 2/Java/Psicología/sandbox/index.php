<?php
require('kernel/core.php');
if(USER_LOGGED_IN)
{
	header('Location: '.URL.'/home');
}
?><!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=<?php echo $lang['meta.encoding'] ?>/>
<!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <![endif]-->
<meta name="description" content="<?php echo $lang['meta.description'] ?>"/>
<meta name="author" content="<?php echo $lang['meta.author'] ?>"/>
 
<meta name="viewport" content="width=device-width, initial-scale=1"/>
 
<link rel="icon" href="<?php echo URL ?>/favicon.ico" type="image/x-icon"/>
<title><?php echo $lang['title.index'] ?></title>
 
<link rel="stylesheet" type="text/css" href="<?php echo URL ?>/css/base.css"/>
<link rel="stylesheet" type="text/css" href="<?php echo URL ?>/css/animate.css"/>
<link rel="stylesheet" type="text/css" href="<?php echo URL ?>/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<?php echo URL ?>/css/font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="<?php echo URL ?>/css/owl.carousel.css"/>
<link rel="stylesheet" type="text/css" href="<?php echo URL ?>/css/owl.theme.css"/>
<link rel="stylesheet" type="text/css" href="<?php echo URL ?>/css/jquery.fancybox.css"/>
<link rel="stylesheet" type="text/css" href="<?php echo URL ?>/css/d2_style.css"/>
<style>
#main .workflow #flow-switcher>li.active{
	background-color: rgba(<?php echo $db->query('SELECT value FROM web_design WHERE keyname="index_bgcolor_howyumiworks_blows"')->fetch_row()[0] ?>) !important
}
#main .workflow #flow-switcher>li.done{
	background-color: rgba(<?php echo $db->query('SELECT value FROM web_design WHERE keyname="index_bgcolor_howyumiworks_blowsnonactive"')->fetch_row()[0] ?>) !important
}
#main .workflow #flow-switcher>li{
	background-color: rgba(<?php echo $db->query('SELECT value FROM web_design WHERE keyname="index_bgcolor_howyumiworks_blowsnonactive"')->fetch_row()[0] ?>) !important
}
.mainnav.sticky {
    background-color: rgba(<?php echo $db->query('SELECT value FROM web_design WHERE keyname="index_bgcolor_header"')->fetch_row()[0] ?>) !important
}
</style>
<noscript>
  <meta http-equiv="refresh" content="0; URL=<?php echo URL ?>/nojs">
</noscript>
 
<link href='https://fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900|Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'/>
<script>var loginRecaptcha; var registerRecaptcha;var reCaptchaCallback = function() {loginRecaptcha=grecaptcha.render('googleRecaptchaValueLogin', {'sitekey' : '<?php echo $config['recaptcha.publickey'] ?>'}); registerRecaptcha = grecaptcha.render('googleRecaptchaValueRegister', {'sitekey' : '<?php echo $config['recaptcha.publickey'] ?>'});};</script>
<script src="https://www.google.com/recaptcha/api.js?onload=reCaptchaCallback&render=explicit&hl=<?php echo USER_LANG ?>" async defer></script>
</head>
<body class="cms_index">
 
<div id="header">
	<video autoplay="autoplay" loop="loop" class="video_background" preload="auto" muted><source src="<?php echo URL ?>/assets/video/indexBg/background.mp4" type="video/mp4" /></video>
	<div class="mainnav">
		<div class="container">
			<div class="logo col-md-2 col-sm-8 col-xs-8">
			<a class="text_logo" href="#header"><?php echo $lang['header.logo'] ?></a>
			</div>
			<div class="col-md-10 col-sm-4 col-xs-4">
				<a id="offcanvas_toggler" class="visible-sm visible-xs" href="#"><i class="fa fa-bars"></i></a>
				<div class="main_navigation">
					<ul>
						<li><a href="<?php echo URL ?>/findPsico"><?php echo $lang['header.findpsico'] ?></a></li>
						<li><a class="h_menu" href="#patient"><?php echo $lang['header.needhelp'] ?></a></li>
						<li><a data-toggle="modal" data-target="#register"><?php echo $lang['header.register'] ?></a></li>
						<li><a data-toggle="modal" data-target="#login"><?php echo $lang['header.login'] ?></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="header_content">
			<h1><?php echo $lang['index.h1'] ?></h1>
			<h4><?php echo $lang['index.h4'] ?></h4>
		</div>
	</div>
</div>
 
 
<div class="content_wrapper">
	<div id="patient">
	<?php
	if($db->query('SELECT id FROM testimonials')->num_rows > 0)
	{
		?>
		<div id="testimonials" class="even_div" style="background-color: rgba(<?php echo $db->query('SELECT value FROM web_design WHERE keyname="index_bgcolor_testimonials"')->fetch_row()[0] ?>) !important">
			<div class="container">
				<div class="testimonials_slider_wrapp">
					<div id="testimonials_slider" class="hidden-buttons">
						<div class="slider-items slider-width-col6">
						<?php
						$testimonials = $db->query('SELECT content,uName,uMod,uImage FROM testimonials ORDER BY timestamp DESC LIMIT 5');
						while($testimonial = $testimonials->fetch_row())
						{
							echo '<div class="item">
								<div class="col-item">
									<div class="item-inner">
										<div class="product-wrapper">
											<div class="thumb-wrapper">
												<div class="message">
													<h3>
													'.$testimonial[0].'
													</h3>
													<div class="clearfix"></div>
												</div>
												<div class="client_wrap">
												<div class="client_image">
													<img class="img-responsive" src="'.str_replace(array('{url}','{defaultProfileImage}'),array(URL,PROFILE_IMAGE_DEFAULT),$testimonial[3]).'" alt="'.$testimonial[1].'"/>
												</div>
												<div class="client_info">
												<div class="client_name">'.$testimonial[1].'</div>
												<div class="client_desi">'.$testimonial[2].'</div>
												</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>';
						}
						?>
						</div>
					</div>
				</div>
			</div>
		</div>
	<?php } ?>
		<div id="solutions" style="background-color: rgba(<?php echo $db->query('SELECT value FROM web_design WHERE keyname="index_bgcolor_banners"')->fetch_row()[0] ?>) !important">
		<div class="container">
		<div class="solutions_wrap">
		<div class="col-md-4 col-sm-4 col-xs-12">
		<div class="solutions_display_block">
		<div class="icon_box">
		<i class="fa fa-life-ring"></i>
		</div>
		<h3><?php echo $lang['join.client.box1'] ?></h3>
		<p><?php echo $lang['join.client.box1.desc'] ?></p>
		</div>
		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
		<div class="solutions_display_block">
		<div class="icon_box">
		<i class="fa fa-question"></i>
		</div>
		<h3><?php echo $lang['join.client.box2'] ?></h3>
		<p><?php echo $lang['join.client.box2.desc'] ?></p>
		</div>
		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
		<div class="solutions_display_block">
		<div class="icon_box">
		<i class="fa fa-money"></i>
		</div>
		<h3><?php echo $lang['join.client.box3'] ?></h3>
		<p><?php echo $lang['join.client.box3.desc'] ?></p>
		</div>
		</div>
		</div>
		</div>
		</div>
		 
		 
		<div id="download" class="even_div" style="background-color: rgba(<?php echo $db->query('SELECT value FROM web_design WHERE keyname="index_bgcolor_howyumiworks"')->fetch_row()[0] ?>) !important">
		 
		<div id="main">
		<div id="main-content">
		<div class="main workflow">
		<div class="content">
		<div class="icon">
		<h2><?php echo $lang['join.client.process'] ?></h2>
		<p><?php echo $lang['join.client.process.desc'] ?></p>
		</div>
		<ul id="flow-switcher">
		<li class="active"><?php echo $lang['join.client.process.1'] ?></span></li>
		<li><?php echo $lang['join.client.process.2'] ?></li>
		<li><?php echo $lang['join.client.process.3'] ?></li>
		<li><?php echo $lang['join.client.process.4'] ?></li>
		<li><?php echo $lang['join.client.process.5'] ?></li>
		</ul>
		</div>
		<div id="flow-boxes">
		<div class="boxes active">
		<div class="codebox-container active">
		<div class="codebox active">
		<pre><?php echo $lang['join.client.process.1.box'] ?></pre>
		</div>
		<div class="codebox hiddenRight">
		<pre><?php echo $lang['join.client.process.2.box'] ?></pre>
		</div>
		<div class="codebox hiddenRight">
		<pre><?php echo $lang['join.client.process.3.box'] ?></pre>
		</div>
		<div class="codebox hiddenRight">
		<pre><?php echo $lang['join.client.process.4.box'] ?></pre>
		</div>
		</div>
		<div class="text-container">
		<div class="text three-lines active">
		<h3><?php echo $lang['join.client.process.1.title'] ?></h3>
		<p><?php echo $lang['join.client.process.1.desc'] ?></p>
		</div>
		<div class="text four-lines hiddenRight">
		<h3><?php echo $lang['join.client.process.2.title'] ?></h3>
		<p><?php echo $lang['join.client.process.2.desc'] ?></p>
		</div>
		<div class="text four-lines hiddenRight">
		<h3><?php echo $lang['join.client.process.3.title'] ?></h3>
		<p><?php echo $lang['join.client.process.3.desc'] ?></p>
		</div>
		<div class="text three-lines hiddenRight">
		<h3><?php echo $lang['join.client.process.4.title'] ?></h3>
		<p><?php echo $lang['join.client.process.4.desc'] ?></p>
		</div>
		</div>
		</div>
		<div class="end" id="automatic-renewals">
		<div class="text three-lines">
		<h3><?php echo $lang['join.client.process.5.title'] ?></h3>
		<p><?php echo $lang['join.client.process.5.desc'] ?></p>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
	</div>

	<div id="newsletter" style="background-color: rgba(<?php echo $db->query('SELECT value FROM web_design WHERE keyname="index_bgcolor_joinnow"')->fetch_row()[0] ?>) !important">
	<div class="container">
	<h2><?php echo $lang['index.join.title'] ?></h2>
	<p>
	<?php echo $lang['index.join.desc'] ?>
	</p>
	<button type="submit" data-toggle="modal" data-target="#register" class="btn btn_getstart"><?php echo $lang['index.join.button'] ?></button>
	</div>
	</div>
</div>
 
 
 
<div id="footer" style="background-color: rgba(<?php echo $db->query('SELECT value FROM web_design WHERE keyname="index_bgcolor_footer"')->fetch_row()[0] ?>) !important">
<div class="container">
<div class="col-lg-6 col-md-6 col-sm-8 col-xs-8 coppyright"><?php echo $lang['footer'] ?></div>
<div class="social col-lg-6 col-md-6 col-sm-4 col-xs-4">
<ul class="social_links">
<li><a target="yumikeySocial" href="https://www.facebook.com/yumikeyweb"><i class="fa fa-facebook"></i></a></li>
<li><a target="yumikeySocial" href="https://twitter.com/yumikeyweb"><i class="fa fa-twitter"></i></a></li>
</ul>
</div>
</div>
</div>
 
</div>
 
 
<div class="offcanvas_menu">
<a href="#" class="close_offcanvas"><i class="fa fa-remove"></i></a>
<div class="offcanvas_inner">
<div class="sp_module">
<h3 class="sp_module_title"><?php echo $lang['header.logo'] ?></h3>
<div class="sp_module_content">
<ul class="nav menu">
<li><a class="h_menu" href="<?php echo URL ?>/findPsico"><?php echo $lang['header.findpsico'] ?></a></li>
						<li><a class="h_menu" href="#patient"><?php echo $lang['header.needhelp'] ?></a></li>
						<li><a data-toggle="modal" data-target="#register"><?php echo $lang['header.register'] ?></a></li>
						<li><a data-toggle="modal" data-target="#login"><?php echo $lang['header.login'] ?></a></li>
</ul>
</div>
</div>
</div>
</div>
<div class="offcanvas_overlay"></div>

 <div id="register" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title"><?php echo $lang['tooltip.register.title'] ?></h4>
      </div>
          <?php
          if($config['register.enabled'] == true)
          {
              ?>
      <div class="modal-body">
        <form class="form-horizontal" id="registerForm" method="post">
		  <div class="form-group" id="registerUserCtrl">
			<div class="col-sm-12">
				<label class="groupInputSpacing control-label "><?php echo $lang['tooltip.register.input.user'] ?>:</label>
				<input type="text" autocomplete="off" data-toggle="popover" data-trigger="manual" data-placement="bottom" title="" data-content="<?php echo $lang['tooltip.register.input.user.tooltip'] ?>" onblur="checkRegisterInput('user');" placeholder="<?php echo $lang['tooltip.register.input.user.ph'] ?>" class="form-control" name="registerUser">
				<span class="registerInputIconName" id="registerUserSpanCtrl">
			</div>
		  </div>
		  
		  <div class="form-group" id="registerEmailCtrl">
			<div class="col-sm-12">
				<label class="groupInputSpacing"><?php echo $lang['tooltip.register.input.email'] ?>:</label>
				<input type="email" autocomplete="off" data-toggle="popover" data-trigger="manual" data-placement="top" title="" data-content="<?php echo $lang['tooltip.register.input.email.tooltip'] ?>" onblur="checkRegisterInput('email');" placeholder="<?php echo $lang['tooltip.register.input.email.ph'] ?>" class="form-control" name="registerEmail">
				<span class="registerInputIconOthers" id="registerEmailSpanCtrl">
			</div>
		  </div>
		  <div class="form-group" id="registerPassCtrl">
			<div class="col-sm-12">
				<label class="groupInputSpacing"><?php echo $lang['tooltip.register.input.pass'] ?>:</label>
				<input type="password" autocomplete="off" data-toggle="popover" data-trigger="manual" data-placement="top" title="" data-content="<?php echo $lang['tooltip.register.input.pass.tooltip'] ?>" onblur="checkRegisterInput('pass');" placeholder="<?php echo $lang['tooltip.register.input.pass.ph'] ?>" class="form-control" name="registerPass">
				<span class="registerInputIconOthers" id="registerPassSpanCtrl">
			</div>
		  </div>
		  <div class="form-group" id="registerPassRepCtrl">
			<div class="col-sm-12">
				<label class="groupInputSpacing"><?php echo $lang['tooltip.register.input.passrep'] ?>:</label>
				<input type="password" autocomplete="off" data-toggle="popover" data-trigger="manual" data-placement="top" title="" data-content="<?php echo $lang['tooltip.register.input.passrep.tooltip'] ?>" onblur="checkRegisterInput('passRep');" placeholder="<?php echo $lang['tooltip.register.input.passrep.ph'] ?>" class="form-control" name="registerPassRep">
				<span class="registerInputIconOthers" id="registerPassRepSpanCtrl">
			</div>
		  </div>
		  <div class="form-group">
			<div class="col-sm-12"> 
			  <div class="g-recaptcha" id="googleRecaptchaValueRegister"></div>
			</div>
		  </div>
      </div>
      <div class="modal-footer">
		  <div class="btn-group btn-group-justified">
			<a href="#" class="btn btn-default" data-dismiss="modal"><?php echo $lang['tooltip.register.close'] ?></a>
			<a href="#" onclick="document.getElementById('submitRegister').click();" class="btn btn-default"><?php echo $lang['tooltip.register.send'] ?></a>
		  </div>
			<div style="display:none"><input id="submitRegister" type="submit"></div>
		  </div>
		</form>
          <?php }
          else
          {
              echo '<div class="modal-body"><h1><div class="alert alert-danger">
                <strong>'.$lang['tooltip.register.disabled'].'</strong> '.$lang['tooltip.register.disabled.desc'].'
              </div></h1></div>';
          }
          ?>
      </div>
    </div>
  </div>
</div>

<div id="login" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" style="text-align: center"><?php echo $lang['tooltip.login.title'] ?></h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" id="loginForm" method="post">
		  <div class="form-group" id="loginFormUserInputCtrl">
			<label class="control-label col-sm-2" for="email"><?php echo $lang['tooltip.login.email'] ?>:</label>
			<div class="col-sm-10">
			  <input type="email" autocomplete="off" maxlength="250" required class="form-control" name="loginEmail" placeholder="<?php echo $lang['tooltip.login.email.ph'] ?>">
			   <span style="margin-top: 2px;" id="loginFormUserInputCross" class=""></span>
			</div>
		  </div>
		  <div class="form-group" id="loginFormPassInputCtrl">
			<label class="control-label col-sm-2" for="pwd"><?php echo $lang['tooltip.login.password'] ?>:</label>
			<div class="col-sm-10"> 
			  <input type="password" autocomplete="off" maxlength="200" required class="form-control" name="loginPwd" placeholder="<?php echo $lang['tooltip.login.password.ph'] ?>">
			  <span style="margin-top: -4px;" id="loginFormPassInputCross" class=""></span>
			</div>
		  </div>
		  <div class="form-group">
			<div class="col-sm-12"> 
			  <div class="g-recaptcha" id="googleRecaptchaValueLogin"></div>
			</div>
		  </div>
      </div>
      <div class="modal-footer">
		  <div class="btn-group btn-group-justified">
			<a href="#" class="btn btn-default" data-dismiss="modal"><?php echo $lang['tooltip.login.close'] ?></a>
			<a href="#" onclick="document.getElementById('submitLogin').click();" class="btn btn-default"><?php echo $lang['tooltip.login.send'] ?></a>
		  </div>
			<div style="display:none"><input id="submitLogin" type="submit"></div>
		</form>
      </div>
    </div>

  </div>
</div>
 
<script type="text/javascript" src="<?php echo URL ?>/js/coatFlow.js"></script>
<script type="text/javascript" src="<?php echo URL ?>/js/subscriptions.js"></script>
<script type="text/javascript" src="<?php echo URL ?>/js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $('[data-toggle="popover"]').popover(); 
});
startFlowSwitcher();
</script>
<script type="text/javascript" src="<?php echo URL ?>/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="<?php echo URL ?>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<?php echo URL ?>/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="<?php echo URL ?>/js/js-functions.js"></script>
<script type="text/javascript" src="<?php echo URL ?>/js/scripts.js"></script>
<script type="text/javascript" src="<?php echo URL ?>/js/carousel-3d.js"></script>
<script type="text/javascript" src="<?php echo URL ?>/js/jquery.carouFred.js"></script>
<script type="text/javascript">
var modalUniqueClass = ".modal";
$('.modal').on('show.bs.modal', function(e) {
  var $element = $(this);
  var $uniques = $(modalUniqueClass + ':visible').not($(this));
  if ($uniques.length) {
    $uniques.modal('hide');
    $uniques.one('hidden.bs.modal', function(e) {
      $element.modal('show');
    });
    return false;
  }
});
function checkRegisterInput(type)
{
	switch(type)
	{
		case 'user':
			$('#registerUserCtrl').removeClass('has-success has-feedback').removeClass('has-error has-feedback');
			$('#registerUserSpanCtrl').removeClass('glyphicon glyphicon-remove form-control-feedback').removeClass('glyphicon glyphicon-ok form-control-feedback');
			$('#registerUserSpanCtrl').addClass('has-warning has-feedback').addClass('glyphicon glyphicon glyphicon-refresh gly-spin form-control-feedback');
			if(!/^[a-z’'‘ A-Z\u00C0-\u00ff]+$/.test($('input[name=registerUser').val()) || $('input[name=registerUser').val() == '')
			{
				$('input[name=registerEmail').popover('destroy');
				$('input[name=registerPass').popover('destroy');
				$('input[name=registerPassRep').popover('destroy');
				$('input[name=registerUser').popover('show');
				$('#registerUserCtrl').removeClass('has-warning has-feedback').addClass('has-error has-feedback');
				$('#registerUserSpanCtrl').removeClass('glyphicon glyphicon glyphicon-refresh gly-spin form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
			}
			else
			{
				$('input[name=registerUser').popover('destroy');
				$('#registerUserCtrl').removeClass('has-warning has-feedback').addClass('has-success has-feedback');
				$('#registerUserSpanCtrl').removeClass('glyphicon glyphicon glyphicon-refresh gly-spin form-control-feedback').addClass('glyphicon glyphicon-ok form-control-feedback');
			}
		break;
		case 'email':
			$('#registerEmailCtrl').removeClass('has-success has-feedback').removeClass('has-error has-feedback');
			$('#registerEmailSpanCtrl').removeClass('glyphicon glyphicon-remove form-control-feedback').removeClass('glyphicon glyphicon-ok form-control-feedback');
			$('#registerEmailSpanCtrl').addClass('has-warning has-feedback').addClass('glyphicon glyphicon glyphicon-refresh gly-spin form-control-feedback');
			if(!/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test($('input[name=registerEmail').val()) || $('input[name=registerEmail').val() == '')
			{
				$('input[name=registerUser').popover('destroy');
				$('input[name=registerPass').popover('destroy');
				$('input[name=registerPassRep').popover('destroy');
				$('input[name=registerEmail').popover('show');
				$('#registerEmailCtrl').removeClass('has-warning has-feedback').addClass('has-error has-feedback');
				$('#registerEmailSpanCtrl').removeClass('glyphicon glyphicon glyphicon-refresh gly-spin form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
			}
			else
			{
				$('input[name=registerEmail').popover('destroy');
				$('#registerEmailCtrl').removeClass('has-warning has-feedback').addClass('has-success has-feedback');
				$('#registerEmailSpanCtrl').removeClass('glyphicon glyphicon glyphicon-refresh gly-spin form-control-feedback').addClass('glyphicon glyphicon-ok form-control-feedback');
			}
		break;
		case 'pass':
			$('#registerPassCtrl').removeClass('has-success has-feedback').removeClass('has-error has-feedback');
			$('#registerPassSpanCtrl').removeClass('glyphicon glyphicon-remove form-control-feedback').removeClass('glyphicon glyphicon-ok form-control-feedback');
			$('#registerPassSpanCtrl').addClass('has-warning has-feedback').addClass('glyphicon glyphicon glyphicon-refresh gly-spin form-control-feedback');
			if($('input[name=registerPass').val() == '' || $('input[name=registerPass').val().length < 6 || $('input[name=registerPass').val() == $('input[name=registerUser').val()|| $('input[name=registerPass').val() == $('input[name=registerEmail').val() || !/[0-9]/.test($('input[name=registerPass').val()) || !/[a-z]/.test($('input[name=registerPass').val()) || !/[A-Z]/.test($('input[name=registerPass').val()))
			{
				$('input[name=registerUser').popover('destroy');
				$('input[name=registerEmail').popover('destroy');
				$('input[name=registerPassRep').popover('destroy');
				$('input[name=registerPass').popover('show');
				$('#registerPassCtrl').removeClass('has-warning has-feedback').addClass('has-error has-feedback');
				$('#registerPassSpanCtrl').removeClass('glyphicon glyphicon glyphicon-refresh gly-spin form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
			}
			else
			{
				$('input[name=registerPass').popover('destroy');
				$('#registerPassCtrl').removeClass('has-warning has-feedback').addClass('has-success has-feedback');
				$('#registerPassSpanCtrl').removeClass('glyphicon glyphicon glyphicon-refresh gly-spin form-control-feedback').addClass('glyphicon glyphicon-ok form-control-feedback');
			}
		break;
		case 'passRep':
			$('#registerPassRepCtrl').removeClass('has-success has-feedback').removeClass('has-error has-feedback');
			$('#registerPassRepSpanCtrl').removeClass('glyphicon glyphicon-remove form-control-feedback').removeClass('glyphicon glyphicon-ok form-control-feedback');
			$('#registerPassRepSpanCtrl').addClass('has-warning has-feedback').addClass('glyphicon glyphicon glyphicon-refresh gly-spin form-control-feedback');
			if($('input[name=registerPassRep').val() == '' || $('input[name=registerPass').val() != $('input[name=registerPassRep').val())
			{
				$('input[name=registerUser').popover('destroy');
				$('input[name=registerEmail').popover('destroy');
				$('input[name=registerPass').popover('destroy');
				$('input[name=registerPassRep').popover('show');
				$('#registerPassRepCtrl').removeClass('has-warning has-feedback').addClass('has-error has-feedback');
				$('#registerPassRepSpanCtrl').removeClass('glyphicon glyphicon glyphicon-refresh gly-spin form-control-feedback').addClass('glyphicon glyphicon-remove form-control-feedback');
			}
			else
			{
				$('input[name=registerPassRep').popover('destroy');
				$('#registerPassRepCtrl').removeClass('has-warning has-feedback').addClass('has-success has-feedback');
				$('#registerPassRepSpanCtrl').removeClass('glyphicon glyphicon glyphicon-refresh gly-spin form-control-feedback').addClass('glyphicon glyphicon-ok form-control-feedback');
			}
		break;
	}
}
$("#registerForm").submit(function(event) {
		event.preventDefault();
		$('#googleRecaptchaValueRegister').removeClass('animated shake');
        $.ajax({
                data:  $("#registerForm").serialize(),
                url:   '<?php echo URL ?>/register',
                type:  'POST',
                success:  function (response) {
					if(response == 'ERROR_CAPTCHA')
					{
						grecaptcha.reset(registerRecaptcha);
						$('#googleRecaptchaValueRegister').addClass('animated shake');
					}
					else if(response == 'ERROR_USER')
					{
						grecaptcha.reset(registerRecaptcha);
						$('#googleRecaptchaValueRegister').addClass('animated shake');
						$('input[name=registerUser]').addClass('animated shake');
						$('#registerUserCtrl').addClass('has-error has-feedback');
						$('#registerUserSpanCtrl').addClass('glyphicon glyphicon-remove form-control-feedback');
					}
					else if(response == 'ERROR_EMAIL')
					{
						grecaptcha.reset(registerRecaptcha);
						$('#googleRecaptchaValueRegister').addClass('animated shake');
						$('input[name=registerEmail]').attr('data-content', '<?php echo $lang['tooltip.register.input.email.tooltip'] ?>');
						$('input[name=registerEmail]').popover('show');
						$('input[name=registerEmail]').addClass('animated shake');
						$('#registerEmailCtrl').addClass('has-error has-feedback');
						$('#registerEmailSpanCtrl').addClass('glyphicon glyphicon-remove form-control-feedback');
					}
					else if(response == 'ERROR_EMAIL_USED')
					{
						grecaptcha.reset(registerRecaptcha);
						$('#googleRecaptchaValueRegister').addClass('animated shake');
						$('input[name=registerEmail]').attr('data-content', '<?php echo $lang['tooltip.register.input.emailused.tooltip'] ?>');
						$('input[name=registerEmail]').popover('show');
						$('input[name=registerEmail]').addClass('animated shake');
						$('#registerEmailCtrl').addClass('has-error has-feedback');
						$('#registerEmailSpanCtrl').addClass('glyphicon glyphicon-remove form-control-feedback');
					}
					else if(response == 'ERROR_PASS')
					{
						grecaptcha.reset(registerRecaptcha);
						$('#googleRecaptchaValueRegister').addClass('animated shake');
						$('input[name=registerPass]').addClass('animated shake');
						$('#registerPassCtrl').addClass('has-error has-feedback');
						$('#registerPassSpanCtrl').addClass('glyphicon glyphicon-remove form-control-feedback');
					}
					else if(response == 'ERROR_PASSREP')
					{
						grecaptcha.reset(registerRecaptcha);
						$('#googleRecaptchaValueRegister').addClass('animated shake');
						$('input[name=registerPassRep]').addClass('animated shake');
						$('#registerPassRepCtrl').addClass('has-error has-feedback');
						$('#registerPassRepSpanCtrl').addClass('glyphicon glyphicon-remove form-control-feedback');
					}
					else if(response == 'REGISTER_SUCCESS')
					{
						$('input[name=registerUser]').addClass('animated pulse');
						$('input[name=registerEmail]').addClass('animated pulse');
						$('input[name=registerPass]').addClass('animated pulse');
						$('input[name=registerPassRep]').addClass('animated pulse');
						window.location.replace("<?php echo URL ?>/home");
					}
                }
        });
});
$("#loginForm").submit(function(event) {
		event.preventDefault();
		$('input[name=loginEmail').removeClass('animated shake');
		$('#loginFormUserInputCtrl').removeClass('has-error has-feedback');
		$('#loginFormUserInputCross').removeClass('glyphicon glyphicon-remove form-control-feedback');
		$('input[name=loginPwd').removeClass('animated shake');
		$('#loginFormPassInputCtrl').removeClass('has-error has-feedback');
		$('#loginFormPassInputCross').removeClass('glyphicon glyphicon-remove form-control-feedback');
		$('#googleRecaptchaValueLogin').removeClass('animated shake');
        $.ajax({
                data:  $("#loginForm").serialize(),
                url:   '<?php echo URL ?>/login',
                type:  'POST',
                success:  function (response) {
					if(response == 'ERROR_CAPTCHA')
					{
						grecaptcha.reset(loginRecaptcha);
						$('#googleRecaptchaValueLogin').addClass('animated shake');
					}
					else if(response == 'ERROR_EMAIL')
					{
						grecaptcha.reset(loginRecaptcha);
						$('#googleRecaptchaValueLogin').addClass('animated shake');
						$('input[name=loginEmail]').addClass('animated shake');
						$('#loginFormUserInputCtrl').addClass('has-error has-feedback');
						$('#loginFormUserInputCross').addClass('glyphicon glyphicon-remove form-control-feedback');
					}
					else if(response == 'ERROR_PWD')
					{
						grecaptcha.reset(loginRecaptcha);
						$('#googleRecaptchaValueLogin').addClass('animated shake');
						$('input[name=loginPwd]').addClass('animated shake');
						$('#loginFormPassInputCtrl').addClass('has-error has-feedback');
						$('#loginFormPassInputCross').addClass('glyphicon glyphicon-remove form-control-feedback');
					}
					else if(response == 'LOGIN_SUCCESS')
					{
						$('input[name=loginEmail]').addClass('animated pulse');
						$('input[name=loginEmail]').css('border-color', 'green');
						$('input[name=loginPwd]').addClass('animated pulse');
						$('input[name=loginPwd]').css('border-color', 'green');
						window.location.replace("<?php echo URL ?>/home");
					}
                }
        });
});
</script>
</body>
</html>
