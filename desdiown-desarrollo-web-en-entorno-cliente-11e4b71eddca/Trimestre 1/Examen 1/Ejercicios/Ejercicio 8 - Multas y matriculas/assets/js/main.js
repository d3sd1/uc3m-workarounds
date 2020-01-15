var $introducedatos = true, $datosMatriculas = [];
while($introducedatos)
{
	var $numMatricula = prompt("Introduce el número de matrícula","34545345HGH"), $numMultas = parseInt(prompt("Introduce el número de multas para la matricula " + $numMatricula,"12"));
	if($numMatricula in $datosMatriculas)
	{
		$datosMatriculas[$numMatricula] += $numMultas;
	}
	else
	{
		$datosMatriculas[$numMatricula] = $numMultas;
	}
	$introducedatos = (prompt("¿Deseas continuar introduciendo matrículas?","si").toLowerCase() == 'si' ? true:false);
}
/* Ordenar por numero de multas */
var i,j,aux;
for(i in $datosMatriculas) //los meses
{
	for(j in $datosMatriculas)
	{
		if($datosMatriculas[j] > $datosMatriculas[i]) //orden ascendente
		{
			aux = $datosMatriculas[i];
			$datosMatriculas[i] = $datosMatriculas[j];
			$datosMatriculas[j] = aux;
		}
	}
}
/* Mostrar datos*/
for(var $matricula in $datosMatriculas)
{
	document.write('-' + $matricula + '<br>');
	document.write('-- ' + $datosMatriculas[$matricula] + ' multas' + '<br>');
	document.write('<br>');
}