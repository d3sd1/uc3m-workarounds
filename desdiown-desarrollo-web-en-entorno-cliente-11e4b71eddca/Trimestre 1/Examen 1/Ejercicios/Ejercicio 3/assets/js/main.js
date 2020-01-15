function mostrarSuperficie()
{
	return this.ancho*this.alto;
}
function abrir()
{
	this.abierta = true;
}
function cerrar()
{
	this.abierta = false;
}
function mostrarEstado()
{
	return this.abierta;
}
function ventana(ancho,alto)
{
	/* Atributos */
	this.ancho = ancho;
	this.alto = alto;
	this.abierta = false;
	/* Métodos */
	this.mostrarEstado = mostrarEstado;
	this.mostrarSuperficie = mostrarSuperficie;
	this.cerrar = cerrar;
	this.abrir = abrir;
}
var ancho = prompt('Introduce el ancho',5), alto = prompt('Introduce el alto',5), ventana1 = new ventana(ancho,alto);
ventana1.abrir();
document.write('Superficie: ' + ventana1.mostrarSuperficie() + '<br>');
document.write('Estado de la ventana: ' + (ventana1.mostrarEstado() ? 'Abierta':'Cerrada'));