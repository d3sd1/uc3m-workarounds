var avImages = [
	'http://cdn3.computerhoy.com/sites/computerhoy.com/files/novedades/google-fotos_1.jpg',
	'https://gweb-earth.storage.googleapis.com/assets/google_earth_banner.jpg',
	'http://www.clashmusic.com/sites/default/files/styles/article_feature/public/field/image/Queen-band.jpg?itok=i3AxFOcF',
	'http://assets.blabbermouth.net/media/scorpions2017bandwithmikkey_638.jpg'
];
function randomNumberRange(min, max) {
    return parseInt(Math.random() * (max - min) + min);
}
function cambiarImagen()
{
	document.images["imagenCambiante"].src = avImages[randomNumberRange(0,avImages.length)];
}
setInterval(cambiarImagen,4000);