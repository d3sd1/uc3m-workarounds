import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		/* Declaración */
		int inputSeconds = 0,
			seconds = 0,
			minutes = 0,
			hours = 0;
		
		/* Entrada */
		Scanner input = new Scanner(System.in);

		System.out.println("Introduce el número de segundos: ");
		inputSeconds = input.nextInt();
		
		/* Reasignaciones y cálculos */
		
		hours = inputSeconds / (60 * 60); //Cociente de la operación en horas
		minutes = (inputSeconds / 60) % 60; //Resto de la operación en horas
		seconds = inputSeconds % 60; //Resto total
		 //ESTA MAL
		/* Salida. Ponemos en singular/plural en función del valor :) */
		if(inputSeconds > 1 || inputSeconds == 0) {
			System.out.println(inputSeconds + " segundos son: ");
		}
		else {
			System.out.println(inputSeconds + " segundo es: ");
		}
		
		if(hours > 1 || hours == 0) {
			System.out.print(hours + " horas, ");		
		}
		else {
			System.out.print(hours + " hora, ");	
		}
		
		if(minutes > 1 || minutes == 0) {
			System.out.print(minutes + " minutos, ");		
		}
		else {
			System.out.print(minutes + " minuto, ");	
		}
		
		if(seconds > 1 || seconds == 0) {
			System.out.print(seconds + " segundos.");		
		}
		else {
			System.out.print(seconds + " segundo.");	
		}
	}

}
