INICIO
INT num_entero;
ESCRIBE “Escribe un número entero;
LEE num_entero;
Si(num_entero < 0)
{
	num_entero = (num_entero * -1);
}
Sino
{
	Si(num_entero < 10)
{
	Escribe “El número tiene 1 cifra.”;
}
Sino
{
	Si(num_entero < 100)
	{
		Escribe “El número tiene 2 cifras.”;
	}
	Sino
	{
		Si(num_entero < 1000)
		{
			Escribe “El número tiene 3 cifras”;
		}
Sino
{
	Escribe “El número tiene más de 3 cifras”;
}
	}
}
}
FIN
