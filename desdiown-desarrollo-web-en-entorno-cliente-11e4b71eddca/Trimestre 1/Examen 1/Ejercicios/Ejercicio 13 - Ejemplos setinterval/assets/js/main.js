var inicio = new Date().getTime();
function crono()
{
	document.title = Math.round((new Date().getTime()-inicio)/1000);
}
setInterval(crono,1000);