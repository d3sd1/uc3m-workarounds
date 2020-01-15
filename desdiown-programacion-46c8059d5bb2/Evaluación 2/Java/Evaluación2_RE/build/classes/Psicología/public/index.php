<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
	<!--<![endif]-->
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Yumikey - ¡Estamos ultimando nuestro servicio!</title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<link href="favicon.ico" rel="shortcut icon" type="image/x-icon" />
		<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,600,700,300' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Exo+2:400,100,100italic,200,200italic,300,300italic,400italic,500,500italic,700,700italic,600,600italic' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Josefin+Sans:100,300,400,600' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" type="text/css" href="css/normalize.css">
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<link rel="stylesheet" type="text/css" href="css/bg-slider.css" />
		<link rel="stylesheet" type="text/css" href="clock/css/clock.css">
		<link rel="stylesheet" type="text/css" href="css/main.css">
		<link rel="stylesheet" type="text/css" href="css/responsive.css">
		<script src="js/vendor/modernizr-2.6.2.min.js"></script>
	</head>
	<body onload="run()" class="raindrops">
        <script src="js/vendor/rainyday.js"></script>
	 	<script>
	
            function run() {
                var image = document.getElementById('rain_bg'),
                	somediv = document.getElementById('rain_wrapper');
                image.onload = function() {
                    var engine = new RainyDay({
                        image: this,
                        parentElement: somediv
                    });
                    
                    engine.rain([ [0, 2, 200], [3, 3, 1] ], 100);
                };
                image.crossOrigin = 'anonymous';
                image.src = 'img/rain-bg.jpg';  // Background Image URL
            }
        </script>
        <img id="rain_bg" />
		<!--[if lt IE 7]>
		<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
		<![endif]-->
		<!--<section class="twitter-container">
			<div class="twitter">
				<ul class="tweet_list" id="tweet_list">
					<li class="tweet_first tweet_odd">
						<span class="tweet_text">WordPress 3.8 “Parker” is out and
							<br>
							ready for download <a href="#">buff.ly/18EGYRR</a></span><span class="tweet_time"><a href="#" title="view tweet on twitter">about 5 days ago</a></span>
					</li>
					<li class="tweet_even">
						<span class="tweet_text"><span class="at">@</span><a href="http://twitter.com/BeyondLocal_">BeyondLocal_</a> <span class="at">@</span><a href="http://twitter.com/bespokeav">bespokeav</a> Thanks :)</span><span class="tweet_time"><a href="http://twitter.com/pixelthrone/status/466325405507387392" title="view tweet on twitter">about 15 days ago</a></span>
					</li>
					<li class="tweet_odd">
						<span class="tweet_text"><span class="at">@</span><a href="http://twitter.com/geeks_in_motion">geeks_in_motion</a> ,hi for a better support please visit our online forum.I have a great team able to help you. → <a href="http://goo.gl/fghIzb">goo.gl/fghIzb</a></span><span class="tweet_time"><a href="http://twitter.com/pixelthrone/status/466280221889409024" title="view tweet on twitter">about 15 days ago</a></span>
					</li>
				</ul>
			</div>
		</section>-->
		<section class="mainarea">
			<div id="clock" class="active">
				<div class="clock-container">
					<div id="time-container-wrap">
						<div id="time-container">
							<div class="numbers-container"></div>
							<span id="ticker" class="clock-label">YUMIKEY</span>
							<figure id="canvas"></figure>
						</div>
					</div>
				</div>
				<h3>Yumikey se lanzará pronto</h3>
				<form action="#" class="subscribe" id="subscribe">
					<input type="email" placeholder="Introduce tu email" class="email form_item requiredField" name="subscribe_email" />
					<input type="submit" class='form_submit' value="Suscribir" />
					<div id="form_results"></div>
				</form>
			</div>
			<a class="close" href="#"><img alt="" src="img/close.png"></a>
		</section>
		<section class="social-container">
			<ul class="social">
				<li>
					<a href="https://twitter.com/Yumikeyweb" target="yumikeySocial"><img src="img/icons/twitter-icon.png" alt="" /></a>
				</li>
				<li>
					<a href="https://twitter.com/Yumikeyweb" target="yumikeySocial"><img src="img/icons/facebook-icon.png" alt="" /></a>
				</li>
			</ul>
		</section>

		<script src="js/vendor/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/vendor/classie.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/vendor/jquery.easing.1.3.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/vendor/jquery.tubular.1.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/vendor/jquery.cycle.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/plugins.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/main.js" type="text/javascript" charset="utf-8"></script>

		<script src="clock/js/svg.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="clock/js/svg.easing.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="clock/js/svg.clock.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="clock/js/jquery.timers.min.js" type="text/javascript" charset="utf-8"></script>	
		<script src="clock/js/clock.js" type="text/javascript" charset="utf-8"></script>
		
        <div id="rain_wrapper"></div>
	</body>
</html>
