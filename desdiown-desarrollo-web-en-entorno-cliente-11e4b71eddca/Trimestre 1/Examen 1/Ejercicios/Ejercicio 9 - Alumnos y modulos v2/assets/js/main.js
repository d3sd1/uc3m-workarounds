var continuar = true,
	vnombre,
	vedad,
	vnumModulos,
	alumnos = [],
	i,
	vNombreModulo,
	vCalificacionModulo,
	alumnosSuspensos = "",
	numModulos;
/* Función que dice aprobado o suspenso */
function mostrarEstadoModulo(estado)
{
	if(estado)
	{
		return "Aprobado";
	}
	else
	{
		return "Suspenso";
	}
}
/* Objeto modulo*/
function modulo(pNombre,pCalificacion)
{
	this.nombre = pNombre;
	this.calificacion = pCalificacion;
	this.aprobado = function()
	{
		if(this.calificacion >= 5)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
while(continuar)
{
	vnombre = prompt("Introduce el nombre del alumno","andrei");
	if(vnombre in alumnos)
	{
		alert("¡Vaya! El alumno ya existía. ¡Agreguémosle nuevos módulos!");
	}
	else
	{
		vedad = prompt("Introduce la edad del alumno","19");
		alumnos[vnombre] = {
			edad: vedad,
			notaMedia: function()
			{
				var notaMediaSumatorio = 0, numModulosCursados = 0;
				for(var vModulo in this.modulos)
				{
					notaMediaSumatorio += parseInt(this.modulos[vModulo].calificacion);
					numModulosCursados++;
				}
				return notaMediaSumatorio/numModulosCursados;
			},
			modulos: {}
		};
	}
	vnumModulos = parseInt(prompt("Introduce el número de módulos a rellenar","1"));
	
	for(i = 0; i < vnumModulos; i++)
	{
		vNombreModulo = prompt("Introduce el nombre del módulo","DEC");
		
		if(vNombreModulo in alumnos[vnombre].modulos)
		{
			alert("Módulo duplicado. No se aceptan módulos duplicados.");
		}
		else
		{
			vCalificacionModulo = prompt("Introduce la calificación del módulo","10");
			if(vCalificacionModulo <= 10 && vCalificacionModulo >= 0)
			{
				alumnos[vnombre].modulos[vNombreModulo] = new modulo(vNombreModulo,vCalificacionModulo);
			}
			else
			{
				alert("Calificación inválida. Debe estar comprendida entre 0 y 10");
			}
		}
	}
	continuar = (prompt("¿Quieres más alumnos?","si") == "si" ? true:false);
}
/* Ordenar por nota media DESC y si es la misma nota, por nombre */
//no me funcona bien el 
alumnos.sort(function(a,b) {return parseFloat(a.notaMedia()) - parseFloat(b.notaMedia());});
console.log(alumnos);
alumnos.reverse();
console.log(alumnos);
/* Mostrar alumnos aprobados */
for(var alumno in alumnos)
{
	if(alumnos[alumno].notaMedia() >= 5)
	{
		document.write("--- Alumno: " + alumno + "---" + '<br>');
		document.write("- Edad: " + alumnos[alumno].edad + '<br>');
		document.write("- Módulos: " + '<br>');
		for(var modulo in alumnos[alumno].modulos)
		{
			document.write("----------- Nombre: " + alumnos[alumno].modulos[modulo].nombre + '<br>');
			document.write("----------- Calificación: " + alumnos[alumno].modulos[modulo].calificacion + '<br>');
			document.write("----------- ¿Aprobado?: " + mostrarEstadoModulo(alumnos[alumno].modulos[modulo].aprobado()) + '<br>');
		}
		document.write("------ Nota media: " + alumnos[alumno].notaMedia() + '<br>');
	}
	else
	{
		if(alumnosSuspensos == "")
		{
			alumnosSuspensos += alumno;
		}
		else
		{
			alumnosSuspensos += ", " + alumno;
		}
	}
}
document.write("--- Alumnos suspensos ---");
document.write(alumnosSuspensos);