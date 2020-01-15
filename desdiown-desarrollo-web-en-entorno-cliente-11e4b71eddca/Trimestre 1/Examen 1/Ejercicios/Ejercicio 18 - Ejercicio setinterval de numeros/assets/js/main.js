var min = 10,
max = 20,
numActual = min,
actualDir = "+",
iterates = 0;
function generarNumeroSiguiente()
{
	if(iterates != 0)
	{
		if(numActual <= min)
		{
			document.write(++numActual + "<br>");
			actualDir = "+";
		}
		else if(numActual >= max)
		{
			document.write(--numActual + "<br>");
			actualDir = "-";
		}
		else
		{
			numActual = eval(numActual + actualDir + 1);
			document.write(numActual + "<br>");
		}
	}
	else
	{
		document.write(numActual + "<br>");
		iterates++;
	}
}
setInterval(generarNumeroSiguiente,500);