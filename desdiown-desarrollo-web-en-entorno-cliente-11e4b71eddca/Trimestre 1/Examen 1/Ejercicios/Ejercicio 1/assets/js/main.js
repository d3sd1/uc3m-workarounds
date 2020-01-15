debugger;
var num = prompt("Por favor introduce el número", "5"), i = 0;
document.write('TABLA DEL ' + num + '<br>');
while(i <= 10)
{
	multiplicado = num*i;
	document.write(num + 'x' + i + '=' + multiplicado);
	document.write('<br>');
	i++
}
/*
	PSEUDO CÓDIGO:
	INICIO
		VAR num = preguntarNumero();
		ESCRIBE 'TABLA DEL NUMERO'
		PARA(i = 0;indice <= 10;i++)
		{
			ESCRIBE 'resultado de la operacion';
		}
	FIN
*/