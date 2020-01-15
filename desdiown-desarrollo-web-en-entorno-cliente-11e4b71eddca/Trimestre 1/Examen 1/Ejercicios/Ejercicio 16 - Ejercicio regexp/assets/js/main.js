var cadena = prompt("Escribe un apalabra", "andreigarciacuadra@gmail.com");
var esvalido = new RegExp(/\w+[^.]@([A-Za-z][^@].){0,2}([A-Za-z][^@]){1}/g);
/* revisar si tiene a's */
if(esvalido.test(cadena))
{
	document.write("Es válido");
}
else{
	document.write("NOOOOOOOOOOOOO es valido weon");
}