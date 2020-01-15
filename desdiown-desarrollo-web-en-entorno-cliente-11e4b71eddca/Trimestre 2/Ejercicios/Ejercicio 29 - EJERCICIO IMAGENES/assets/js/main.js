 for (var actual in document.images) {
	 var actualSRC = document.images[actual].src;
	 console.log(actualSRC);
	if(typeof actualSRC != "undefined")
	{
		document.write(actualSRC);
	}
 }