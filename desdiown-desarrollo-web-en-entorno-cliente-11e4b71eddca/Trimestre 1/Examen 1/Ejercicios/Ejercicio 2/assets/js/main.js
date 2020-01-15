var bas = prompt("Introduce la base", "5"), exp = prompt("Introduce el exponente", "2"), resultado;
document.write('Potencia de ' + bas + '^' + exp + '<br>');
function potencia(base,exponente)
{
	if(exponente == 1)
	{
		return base;
	}
	else if(exponente == 0)
	{
		return 1;
	}
	else
	{
		return base*potencia(base,exponente-1);
	}
}
try
{
	document.write(eval('5+37'));
}
catch(error)
{
	document.write('ERRORACO' + error);
}
resultado = potencia(bas,exp);
document.write(resultado);
