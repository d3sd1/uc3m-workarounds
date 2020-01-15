var array = new Array(1,2,5,7,3,4);
// mostrar array original
document.write("ARRAY ORIGINAL");
document.write("<br>");
for(var ind in array)
{
	document.write("Elemento -> " + ind + " = " + array[ind] + "<br>");
}
// Ordenar ascendente
var aux,i,x;
for(i = 0; i < array.length-1; i++)
{
	for(x = i+1; x < array.length; x++)
	{
		if(array[i] > array[x])
		{
			aux = array[i];
			array[i] = array[x];
			array[x] = aux;
		}
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