function guardarCookie(name,value = null)
{
	var date = new Date();
	date.setSeconds(date.getSeconds() + 300);
	document.cookie = name + "=" + (value == null ? '':value) + "; expires=" + date.toUTCString();
}
function consultarCookie(name)
{
	var cookies = document.cookie,
	cookiesSingle = cookies.split(";"),
	cookieExiste = false;
	for(var i = 0; i < cookiesSingle.length; i++)
	{
		var actualCookieData = cookiesSingle[i].split("=");
		if(actualCookieData[0] == name)
		{
			cookieExiste = true;
			return actualCookieData[1];
		}
	}
	if(!cookieExiste)
	{
		return false;
	}
}
function borrarCookie(name)
{
	document.cookie = name + "=; expires=" + new Date().toUTCString();
}
function listarCookies()
{
	console.log(document.cookie);
}
if(isNaN(parseInt(consultarCookie("numeroSesiones"))))
{
	guardarCookie("numeroSesiones",0);
}
else
{
	guardarCookie("numeroSesiones",parseInt(consultarCookie("numeroSesiones"))+1);
}
document.title = consultarCookie("numeroSesiones");
document.getElementById("actualVisitsNumber").value = consultarCookie("numeroSesiones");