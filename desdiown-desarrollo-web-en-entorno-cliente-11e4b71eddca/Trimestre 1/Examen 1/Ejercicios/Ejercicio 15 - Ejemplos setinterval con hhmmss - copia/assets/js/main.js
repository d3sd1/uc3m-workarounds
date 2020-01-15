var inicio, cronometro;
function crono()
{
	var date = (new Date().getTime()-inicio)/1000,
	segundos = parseInt(date%60),
	minutos = parseInt(date/60),
	horas = parseInt(date/(60*60));
	
	document.title = ("0" + horas).substr(-2) + ":" + ("0" + minutos).substr(-2) + ":" + ("0" + segundos).substr(-2);
}
function iniciarCrono()
{
	inicio = new Date().getTime();
	cronometro = setInterval(crono,1000);
}
function pararCrono()
{
	clearInterval(cronometro);
}
iniciarCrono();