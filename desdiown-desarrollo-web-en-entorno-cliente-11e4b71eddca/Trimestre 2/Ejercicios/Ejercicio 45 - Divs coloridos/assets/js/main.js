window.onload = function() {
	init();
};
function init()
{
	document.getElementById("rojo").addEventListener("click", function(e) { clickado("rojo",e); });
	document.getElementById("verde").addEventListener("click", function(e) { clickado("verde",e); });
	document.getElementById("azul").addEventListener("click", function(e) { clickado("azul",e); });
	document.getElementById("imagen").addEventListener("click", function(e) { clickado("imagen",e); });
}
/*
* Functions section
 */
var mostrarParienteSuperior = true,
	mostrarParientes = true,
	mostrarParientesMayorAMenor = true;
function clickado(color,event)
{
	console.clear();
	event.stopPropagation();
	console.log("evento",event);
	console.log("Has clickado: " + color);
	var camino = event.path;
	camino.shift(); // borrar el elemento actual
	if(mostrarParienteSuperior)
	{
		console.log("Pariente: " + (camino.id ? event.path[1].id:"No tiene"));
	}
	if(mostrarParientes)
	{
		console.log("Parientes: " + serializarCamino(camino));
	}
}
function serializarCamino(camino)
{
	var rtn = "";
	if(mostrarParientesMayorAMenor)
	{
		camino.reverse();
	}
	for(var actual in camino)
	{
		if(typeof camino[actual].id != "undefined" && camino[actual].id != "")
		{
			rtn += camino[actual].id + ",";
		}
	}
	return rtn != "" ? rtn.substring(0, rtn.length-1):"No tiene parientes";
}