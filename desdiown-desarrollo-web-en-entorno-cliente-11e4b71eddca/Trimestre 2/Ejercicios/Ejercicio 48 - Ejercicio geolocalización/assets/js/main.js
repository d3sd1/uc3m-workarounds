window.onload = function () {
    init();
};
var map;
function initMap(lat,long) {
  map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: lat, lng: long},
    zoom: 15
  });
}
function init()
{
    var opciones = {
        "enableHighAccuracy": true,
        "timeout": 10000,
        "maximumAge": 600000
    };
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(valido, error, opciones);
    } else {
        console.log("Geolocalización no soportada.");
    }
}
/*
 * Functions section
 */
function valido(posicion)
{
    console.log("Latitud: " + posicion.coords.latitude, "Longitud: " + posicion.coords.longitude);
    initMap(posicion.coords.latitude,posicion.coords.longitude);
}
function error(e)
{
    console.log("Ha ocurrido un error al recuperar las coordenadas: ",e);
}