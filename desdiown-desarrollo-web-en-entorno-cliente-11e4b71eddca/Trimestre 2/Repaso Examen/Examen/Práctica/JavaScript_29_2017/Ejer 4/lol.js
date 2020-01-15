window.addEventListener("load",init);
var table;
function init()
{
	table = document.createElement("table");
	document.body.appendChild(table);
	var filas = parseInt(prompt("Introcuce el número de filas de la tabla")),
		columnas = parseInt(prompt("Introcuce el número de columnas de la tabla"));
	for(var fila = 0; fila < filas; fila++)
	{
		var filaActual = table.insertRow(fila);
		for(var columna = 0; columna < columnas; columna++)
		{
			var columnaActual = filaActual.insertCell(columna);
			
			var texto = prompt("Introduce el texto de la celda");
			columnaActual.innerText = texto;
		}
	}
}