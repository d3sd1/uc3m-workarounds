document.title = 'Ejercicio de alumnos';
function modulo(nomb,cal)
{
	this.nombre = nomb;
	this.calificacion = cal;
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
var alumno = {
	nombre: prompt("Introduce el nombre del alumno","Andrei"),
	edad: prompt("Introduce la edad del alumno","19"),
	modulo_1: new modulo(prompt("Introduce el nombre del modulo 1","DAW"),prompt("Introduce la calificacion del modulo 1","10")),
	modulo_2: new modulo(prompt("Introduce el nombre del modulo 2","DAM"),prompt("Introduce la calificacion del modulo 2","10")),
	aprobado: function()
	{
		if(this.modulo_1.aprobado && this.modulo_2.aprobado)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
};
alert("Modulo 1: " + (alumno.modulo_1.aprobado() ? 'aprobado':'suspenso'));
alert("Modulo 2: " + (alumno.modulo_2.aprobado() ? 'aprobado':'suspenso'));
alert("Curso aprobado: " + (alumno.modulo_2.aprobado() && alumno.modulo_1.aprobado() ? 'aprobado':'suspenso'));