var ventanita;
function abrirVentanita()
{
	ventanita = window.open("hijo.html", "hijo");
}
function cerrarVentanita()
{
	ventanita.close();
}
setTimeout(abrirVentanita,3000);