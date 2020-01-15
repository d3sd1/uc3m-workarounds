var array = new Array(1,2,5,7,3,4);
// mostrar array original
document.write("ARRAY ORIGINAL");
document.write("<br>");
for(var ind in array)
{
	document.write("Elemento -> " + ind + " = " + array[ind] + "<br>");
}
// Ordenar ascendente
var ordenado = false, i, aux, cambiosEnPasada;
while(!ordenado)
{
	cambiosEnPasada = false;
	for(i = 0; i < array.length-1; i++)
	{
		if(array[i] > array[i+1])
		{
			aux = array[i];
			array[i] = array[i+1];
			array[i+1] = aux;
			cambiosEnPasada = true;
		}
	}
	if(!cambiosEnPasada)
	{
		ordenado = true;
	}
}
document.write("<br>");
document.write("ARRAY ORDENADO ASCENDENTE");
document.write("<br>");
//Mostrar de nuevo el array
for(var ind in array)
{
	document.write("Elemento -> " + ind + " = " + array[ind] + "<br>");
}
/*
var array,cambiosEnPasada,i;
MOSTRAR array;
MIENTRAS(ordenado == false)
{
	cambiosEnPasada = false;
	PARA(i = 0; i < longitud(array)-1; incrementar i)
	{
		aux = array[i];
		array[i] = array[i+1];
		array[i+1] = aux;
		cambiosEnPasada = true;
	}
	SI(cambiosEnPasada == false)
	{
		ordenado = true;
	}
}
*/