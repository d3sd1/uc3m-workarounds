function guardarCookie()
{
	var name = prompt("Introduce el nombre de usuario a guardar", "MARI CARMEN"), cookieName = prompt("Introduce el nombre de la cookie a guardar", "nombre"), date = new Date();
	date.setSeconds(date.getSeconds() + 300);
	document.cookie = cookieName + "=" + name + "; expires=" + date.toUTCString();
}
function consultarCookie()
{
	var name = prompt("Introduce el nombre de la cookie a consultar", "nombre"),
	cookies = document.cookie,
	cookiesSingle = cookies.split(";"),
	cookieExiste = false;
	for(var i = 0; i < cookiesSingle.length; i++)
	{
		var actualCookieData = cookiesSingle[i].split("=");
		if(actualCookieData[0] == name)
		{
			console.log("La cookie existe. Valor: " + actualCookieData[1]);
			cookieExiste = true;
			break;
		}
	}
	if(!cookieExiste)
	{
		console.log("La cookie NO existe");
	}
}
function borrarCookie()
{
	var name = prompt("Introduce el nombre de la cookie a borrar", "nombre");
	document.cookie = name + "=; expires=" + new Date().toUTCString();
}
function listarCookies()
{
	console.log(document.cookie);
}