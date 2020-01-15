var keepIntroducing = true,
cadenaTotal = "";
while(keepIntroducing)
{
	var preguntarName = prompt("Introduce el nombre de la variable","var1"),
	preguntarVal = prompt("Introduce el valor de la variable","val1"),
	preguntarKeep = prompt("¿Deseas continuar introduciendo variables? (S/N)","S");
	cadenaTotal += preguntarName + "=" + preguntarVal + ";";
	if(preguntarKeep.toLowerCase() != "s")
	{
		keepIntroducing = false;
	}
}
document.write("CADENA TOTAL: " + cadenaTotal + "<br>");
var cadenaDepurada = cadenaTotal.substring(0, cadenaTotal.length - 1).split(";");
for(var varActual in cadenaDepurada)
{
	var detallado = cadenaDepurada[varActual].split("=");
	document.write("La variable " + detallado[0] + " tiene como valor: " + detallado[1] + "<br>");
}
console.log(cadenaTotal.substring(0, cadenaTotal.length - 1));
document.cookie = cadenaTotal.substring(0, cadenaTotal.length - 1);