window.onload = function() {
	init();
};
function init()
{
	getLocation();
}
/*
* Functions section
 */
function getLocation() {
	if (navigator.geolocation)
	{
		console.log(navigator.geolocation);
		navigator.geolocation.getCurrentPosition(initMap);
	}
	else
	{
		alert("Geolocalización no soportada");
	}
}

function initMap(position)
{
	if(typeof position != "undefined")
	{
		alert("Enviado console.log con datos extra");
		console.log(position);
		var uluru = {lat: position.coords.latitude, lng: position.coords.longitude};
		var map = new google.maps.Map(document.getElementById('map'), {
		  zoom: 4,
		  center: uluru
		});
		var marker = new google.maps.Marker({
		  position: uluru,
		  map: map
		});
	}
}