window.addEventListener("load",init);
function init()
{
	var changeColorBtn = document.getElementById("changeClass"),
	changeVisibilityBtn = document.getElementById("changeVisibility"),
	changeContentBtn = document.getElementById("changeContent"),
	parrafo = document.getElementById("par");
	
	changeColorBtn.addEventListener("click",swapColor);
	changeVisibilityBtn.addEventListener("click",changeVisibility);
	changeContentBtn.addEventListener("click",changeText);
}
function swapColor()
{
	var colorActual = document.getElementById("par").className;
	if(colorActual == "verde")
	{
		document.getElementById("par").className = "rojo";
	}
	else
	{
		document.getElementById("par").className = "verde";
	}
}
function changeVisibility()
{
	var visibilidadActual = document.getElementById("par").style.visibility;
	if(visibilidadActual == "hidden")
	{
		document.getElementById("par").style.visibility = "visible";
	}
	else
	{
		document.getElementById("par").style.visibility = "hidden";
	}
}
function changeText()
{
	var texto = prompt("Introduce el nuevo texto del párrafo");
	document.getElementById("par").innerText = texto;
}