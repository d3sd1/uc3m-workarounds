var maxHeight = 200,
	maxWidth = 200,
	actualHeight = 0,
	actualWidth = 0,
	
	actualMarginTop = 0,
	actualMarginLeft = 0,
	maxMarginTop = 900,
	maxMarginLeft = 900,
	
	actualDir = '+',
	actualMarginDir = '+',
	actualAvImage = -1,
	msSpeed = 1,
	avImages = [
		'http://cdn3.computerhoy.com/sites/computerhoy.com/files/novedades/google-fotos_1.jpg',
		'https://gweb-earth.storage.googleapis.com/assets/google_earth_banner.jpg',
		'http://www.clashmusic.com/sites/default/files/styles/article_feature/public/field/image/Queen-band.jpg?itok=i3AxFOcF',
		'http://assets.blabbermouth.net/media/scorpions2017bandwithmikkey_638.jpg'
	];
function getNextImage()
{
	++actualAvImage;
	if(actualAvImage >= avImages.length)
	{
		actualAvImage = 0;
		return avImages[0];
	}
	else
	{
		return avImages[actualAvImage];
	}
}
function cambiarImagen()
{
	actualHeight = document.images["imagenCambiante"].height;
	actualWidth = document.images["imagenCambiante"].width;
	actualMarginTop = document.images["imagenCambiante"].style.top.replace("px","");
	actualMarginLeft = document.images["imagenCambiante"].style.left.replace("px","");
	if(actualHeight == 0 || actualWidth == 0)
	{
		document.images["imagenCambiante"].src = getNextImage();
	}
	if(actualHeight == 0 && actualWidth == 0)
	{
		actualDir = '+';
	}
	else if(actualHeight >= maxHeight && actualWidth >= maxWidth)
	{
		actualDir = '-';
	}
	
	if(actualMarginTop == 0 && actualMarginLeft == 0)
	{
		actualMarginDir = '+';
	}
	else if(actualMarginTop >= maxMarginTop && actualMarginLeft >= maxMarginLeft)
	{
		actualMarginDir = '-';
	}
	document.images["imagenCambiante"].height = eval(actualHeight + actualDir + 1);
	document.images["imagenCambiante"].width = eval(actualWidth + actualDir + 1);
	document.images["imagenCambiante"].style.top = eval(actualMarginTop + actualMarginDir + 1) + "px";
	document.images["imagenCambiante"].style.left = eval(actualMarginLeft + actualMarginDir + 1) + "px";
}
setInterval(cambiarImagen,msSpeed);