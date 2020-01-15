var continuarIntroduciendoMatriculas = true, matriculaciones = [];
while(continuarIntroduciendoMatriculas)
{
	var matricula = prompt("Introduce la matrícula","2364654534HSF"),
	newanyo = parseInt(prompt("Introduce el año de matriculación","2015")),
	newmes = parseInt(prompt("Introduce el mes de matriculación","12")),
	newmultas = parseInt(prompt("Introduce las multas de la matrícula","50")),
	error = false;
	if((matricula == null || matricula == '') && (newanyo == null || newanyo == '') && (newmes == null || newmes == '') && (newmultas == null || newmultas == ''))
	{
		alert("Por favor, rellena todos los datos para poder validar tu consulta.");
		error = true;
	}
	else if(newanyo >= 2011 && newanyo <= 2017)
	{
		if(!(newmes >= 1 && newmes <= 12))
		{
			alert("El mes debe estar comprendido entre Enero y Diciembre (del 1 al 12)");
			error = true;
		}
	}
	else
	{
		alert("El año introducido es inválido. Debe estar comprendido entre 2011 y 2017 (ambos inclusive).");
		error = true;
	}
	if(!error)
	{
		if(matricula in matriculaciones)
		{
				if(matriculaciones[matricula].anyo == newanyo && matriculaciones[matricula].mes == newmes && matriculaciones[matricula].multas == newmultas && (prompt("¡Espera! matrícula duplicada. ¿Deseas sobreescribir los datos?","si") == "si" ? true:false))
				{
					matriculaciones[matricula].push({
				anyo: newanyo,
				mes: newmes,
				multas: newmultas
			});
				}
				else
				{
					matriculaciones[matricula].push({
				anyo: newanyo,
				mes: newmes,
				multas: newmultas
			});
				}
		}
		else
		{
			matriculaciones[matricula] = [];
			matriculaciones[matricula].push({
				anyo: newanyo,
				mes: newmes,
				multas: newmultas
			});
		}
		/* Preguntar si se desea continuar ejecución */
	continuarIntroduciendoMatriculas = (prompt("¿Deseas continuar introduciendo matrículas?","si").toLowerCase() == 'si' ? true:false);
	}
}
/* Ordenar */
var i,j,aux;
for(i in matriculaciones) //las matriculas
{
	for(j in matriculaciones)
	{
		if(matriculaciones[j].multas < matriculaciones[i].multas) //orden ascendente
		{
			aux = matriculaciones[i];
			matriculaciones[i] = matriculaciones[j];
			matriculaciones[j] = aux;
		}
	}
}
/* Mostrar numero de multas */
for(var objetoMatricula in matriculaciones)
{
	document.write('-' + objetoMatricula + '<br>');
	matriculaciones[objetoMatricula].forEach(function(valor,ind)
	{
		document.write('-- ' + matriculaciones[objetoMatricula][ind].anyo + ' año' + '<br>');
		document.write('-- ' + matriculaciones[objetoMatricula][ind].mes + ' mes' + '<br>');
		document.write('-- ' + matriculaciones[objetoMatricula][ind].multas + ' multas' + '<br>');
		document.write('------------------------------<br>');
	});
	document.write('<br>');
}