window.addEventListener("load",init);
var numero1 = 0,
	numero2 = 0;
function init()
{
	setInterval(avanzarTiempo,1000);
}
function avanzarTiempo()
{
	if(numero1 == 5 && numero2 == 9)
	{
		numero1 = 0;
		numero2 = 0;
	}
	else if(numero2 == 9)
	{
		numero2 = 0;
		numero1++;
	}
	else
	{
		numero2++;
	}
	pintarImagenes();
}
function pintarImagenes()
{
	var temporizador = document.getElementById("temporizador")
	
		imagen = temporizador.querySelectorAll("img");
	imagen[0].src = numero1 + ".jpg";
	imagen[1].src = numero2 + ".jpg";
}