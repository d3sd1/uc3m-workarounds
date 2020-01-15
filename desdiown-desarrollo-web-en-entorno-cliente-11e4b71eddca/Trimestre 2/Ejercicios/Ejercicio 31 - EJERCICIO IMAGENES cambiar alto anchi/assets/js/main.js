var maxHeight = 1000,maxWidth = 1000;
function randomNumberRange(min, max) {
    return parseInt(Math.random() * (max - min) + min);
}
function cambiarImagen()
{
	document.images["imagenCambiante"].height = randomNumberRange(0,maxHeight);
	document.images["imagenCambiante"].width = randomNumberRange(0,maxWidth);
}
setInterval(cambiarImagen,2000);