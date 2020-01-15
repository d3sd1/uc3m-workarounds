var masdatos = true,preguntaparamasdatos,numeromes,tablaDatos = {},valormulta, mesesEntexto = {1: 'Enero',2: 'Febrero',3: 'Marzo',4: 'Abril',5: 'Mayo',6: 'Junio',7: 'Julio',8: 'Agosto',9: 'Septiembre',10: 'Octubre',11: 'Noviembre',12: 'Diciembre'};;
while(masdatos)
{
	numeromes = prompt("Introduce el número de mes (1-12)","1");
	numeromes = parseInt(numeromes);
	if(numeromes <= 12 && numeromes >= 1)
	{
		valormulta = prompt("Introduce el valor de la multa (€)","50");
		valormulta = parseInt(valormulta);
		if(numeromes in tablaDatos)
		{
			console.log("añadido");
			tablaDatos[numeromes].push(valormulta);
		}
		else
		{
			console.log("creado");
			tablaDatos[numeromes] = new Array();
			tablaDatos[numeromes].push(valormulta);
		}
		masdatos = prompt("¿Quieres seguir introduciendo datos? (SI/NO)","si");
		if(masdatos != null && masdatos.toLowerCase() == "si")
		{
			masdatos = true;
		}
		else
		{
			alert("Introducción de datos finalizada. Mostrando tabla...");
			masdatos = false;
		}
	}
	else
	{
		alert("El mes introduce es erróneo.");
	}
}
/* Ordenar por numero de multas */
var i,j,aux;
for(i = 0; i <= 12; i++) //los meses
{
	for(j = i+1; j <= 12; j++)
	{
		if(i in tablaDatos && j in tablaDatos) //comprobar que el mes tiene multas
		{
			if(tablaDatos[j].length > tablaDatos[i].length)
			{
				aux = tablaDatos[i];
				tablaDatos[i] = tablaDatos[j];
				tablaDatos[j] = aux;
			}
		}
	}
}
/* Mostrar datos*/
for(var mes in tablaDatos)
{
	document.write('-' + mesesEntexto[mes] + '<br>');
	tablaDatos[mes].forEach(function(multa) { //devuelve todas las multas del mes
		document.write('-- ' + multa + '€' + '<br>');
	});
	document.write('<br>');
}
/*
var masdatos = true,numeromes,tablaMeses;
MIENTRAS(masdatos)
{
	INTRODUCE numeromes;
	SI(numeromes <= 12 && numeromes >= 1)
	{
		INTRODUCE valormulta;
		SI(numeromes in tablaMeses)
		{
			tablaMeses[numeromes].introducir(valormulta); //ya existe
		}
		SINO
		{
			tablaMeses[numeromes] = nueva tabla(valormulta);
		}
		INTRODUCE masdatos;
		SI(!masdatos)
		{
			MOSTRAR "No se permiten introducir mas valores.";
		}
	}
	SINO
	{
		MOSTRAR "Mes erroneo";
	}
}
ORDENAR tablaMeses;

MOSTRAR tablaMeses;
*/