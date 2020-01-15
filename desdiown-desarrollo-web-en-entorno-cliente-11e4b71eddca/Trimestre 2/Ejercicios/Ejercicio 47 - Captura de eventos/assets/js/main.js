window.onload = function() {
	init();
};
function init()
{
	document.getElementById("rojo").addEventListener("click", function(e) { clickado(e); });
	document.getElementById("verde").addEventListener("click", function(e) { clickado(e); });
	document.getElementById("azul").addEventListener("click", function(e) { clickado(e); });
	document.getElementById("imagen").addEventListener("click", function(e) { clickado(e); });
}
/*
* Functions section
 */
function clickado(event)
{
	var color = event.path[0].id,
		camino = event.path;
	console.clear();
	event.stopPropagation();
	console.log("camino", camino);
	console.log("Has clickado: " + color);
	camino.shift(); // borrar el elemento actual
	console.log("Pariente: " + (camino[0].id ? camino[0].id:"No tiene"));
	console.log("Parientes (menor a Mayor): " + serializarCamino(camino,false));
	console.log("Parientes (Mayor a menor): " + serializarCamino(camino,true));
}
function serializarCamino(camino,mayoramenor)
{
	var rtn = "";
	if(mayoramenor)
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