var ventanita
limitX = 900,
limitY = 900,
actualY = 0,
actualX = 0,
actualDir = "+",
seguirVentanita = true;
function abrirVentanita()
{
	ventanita = window.open("hijo.html", "hijo", "width: 100, height: 100");
}
function cerrarVentanita()
{
	ventanita.close();
}
function resimendionarA800()
{
	ventanita.resizeTo(800,600);
}
function redimensionarMenos100()
{
	ventanita.resizeBy(-100,-100);
}
function moverlaventanaa300100()
{
	ventanita.moveTo(300,100);
}
function moverlaventanaamas100100()
{
	ventanita.moveBy(100,100);
}
function animarVentanita()
{
	seguirVentanita = true;
	setInterval(function()
	{
		console.log(eval(actualX + actualDir + 1));
		actualX++;
		actualY++;
		ventanita.moveBy(actualX,actualY);
	},50);
}
function detenerVentanita()
{
	seguirVentanita = false;
}