var num1 = prompt("Introduce el número de inicio para generar un aleatorio", "0"),
num2 = prompt("Introduce el número de fin para generar un aleatorio", "500");
function generarAleatorio(min,max)
{
	return Math.floor(Math.random() * (max - min) + min);
}
document.write(generarAleatorio(num1,num2));