window.onload = function() {
	init();
};
var dTable,tableCols,tableRows;
function init()
{
	/* Init HTML */
	document.title = "Tablas dinámicas";
	
	/* Init BUTTONS */
	var buttons = {
		"addRow": "Insertar fila",
		"delRow": "Eliminar fila",
		"addCol": "Insertar columna",
		"delCol": "Eliminar columna",
		"queryCell": "Consultar celda",
		"modifyCell": "Modificar celda",
	};
	for(btn in buttons)
	{
		var newBtn = document.createElement('button');
		newBtn.innerText = buttons[btn];
		newBtn.setAttribute("id", btn);
		newBtn.addEventListener("click", eval(btn));
		document.body.appendChild(newBtn);
	}
	
	/* Init TABLE */
	dTable = document.createElement('table');
	tableCols = parseInt(prompt("Introduce el número de columnas"));
	tableRows = parseInt(prompt("Introduce el número de filas"));
	
	for (var row = 0; row < tableRows; row++)
	{
		addRow(row);
	}
	document.body.appendChild(dTable);
}
/*
* Functions section
 */
 /* Añadir fila */
function addRow(rowPos = null)
{
	var manualAdd = !Number.isInteger(rowPos);
	/* Si no se le da un valor al argumento rowPos significa que es una inserción manual */
	if(manualAdd)
	{
		rowPos = parseInt(prompt("Inserta la posición vertical de la fila (0 primera," + tableRows + " última)"));
	}
	var row = dTable.insertRow(rowPos);

	for(var col = 0; col < tableCols; col++)
	{
		var x = row.insertCell(col);
		x.innerHTML = 'Fila ' + rowPos + " columna " + col;
	}
	if(manualAdd)
	{
		alert("Fila insertada correctamente");
		tableRows++;
	}
}
/* Eliminar fila */
function delRow()
{
	var rowToDel = parseInt(prompt("Inserta la posición vertical de la fila a eliminar (0 a " + tableRows + ")"));
	dTable.deleteRow(rowToDel);
	alert("Fila eliminada correctamente");
	tableRows--;
}
/* Añadir columna */
function addCol()
{
	var colToAdd = parseInt(prompt("Inserta la posición horizontal de la columna a eliminar (0 a " + tableCols + ")"));
	for(var row = 0; row < tableRows; row++)
	{
		var x = dTable.rows[row].insertCell(colToAdd);
		x.innerHTML = 'Fila ' + row + " columna " + colToAdd;
	}
	tableCols++;
}
/* Eliminar columna */
function delCol()
{
	var colToDel = parseInt(prompt("Inserta la posición horizontal de la columna a eliminar (0 a " + tableCols + ")"));
	for(var row = 0; row < tableRows; row++)
	{
		dTable.rows[row].deleteCell(colToDel);
	}
	tableCols--;
}
/* Consultar celda */
function queryCell()
{
	var rowPos = parseInt(prompt("Introduce la fila (0 a " + tableRows + ")")),
		colPos = parseInt(prompt("Introduce la columna (0 a " + tableRows + ")")),
		cell = dTable.rows[rowPos].cells[colPos].innerHTML;
	alert(cell);
}
/* Modificar celda */
function modifyCell()
{
	var rowPos = parseInt(prompt("Introduce la fila (0 a " + tableRows + ")")),
		colPos = parseInt(prompt("Introduce la columna (0 a " + tableRows + ")")),
		newContent = prompt("Introduce el nuevo contenido");
	dTable.rows[rowPos].cells[colPos].innerHTML = newContent;
}