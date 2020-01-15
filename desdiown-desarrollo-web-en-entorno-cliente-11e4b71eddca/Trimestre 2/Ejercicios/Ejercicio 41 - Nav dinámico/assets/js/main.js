var lastPos = 0,
menu = document.getElementById("navigation");

window.onload = function() {
	init();
};
function init()
{
	document.getElementById("add").addEventListener("click", function(){
		addNav();
	});
	document.getElementById("del").addEventListener("click", function(){
		delNav();
	});
	document.getElementById("mod").addEventListener("click", function(){
		modNav();
	});
}
function addNav()
{
	var posError = true,
	pos = 0;
	while(posError)
	{
		if(lastPos == 0)
		{
			posError = false;
			pos = 1;
			break;
		}
		pos = prompt("Introduce la posición (primera: 1, última: " + lastPos + ")");
		if(pos >= 1 && pos <= lastPos)
		{
			posError = false;
			--pos;
		}
	}
	var txt = prompt("Introduce el texto", "txtttttt"),
	elem = document.createElement("a");
	
	elem.appendChild(document.createTextNode(txt));
	elem.href = prompt("Introduce el enlace", "http://lol.es");
	elem.style.margin = "0px 0px 0px 20px";
	
	if(lastPos != 1)
	{
		menu.insertBefore(elem,menu.children[pos]);
	}
	else
	{
		menu.appendChild(elem);
	}
	lastPos++;
}
function delNav()
{
	var pos = prompt("Introduce la posición (primera: 1, última: " + lastPos + ")"),
	deleted = false;
	--pos;
	if(typeof menu.childNodes[pos] == "object")
	{
		deleted = menu.removeChild(menu.childNodes[pos]);
	}
	
	if(deleted)
	{
		alert("Eliminado correctamente.");
		lastPos--;
	}
	else
	{
		alert("Error al eliminar.");
	}
}
function modNav()
{
	var posError = true;
	while(posError)
	{
		var pos = prompt("Introduce la posición (primera: 1, última: " + lastPos + ")");
		if(pos >= 1 && pos <= lastPos)
		{
			posError = false;
		}
	}
	var txt = prompt("Introduce el texto"),
	elem = menu.childNodes[--pos];
	elem.innerHTML = '';
	elem.appendChild(document.createTextNode(txt));
	elem.href = prompt("Introduce el enlace");
}