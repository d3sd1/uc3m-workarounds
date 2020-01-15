import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numeroOculto = (int)(Math.random() * ((100 - 1) + 1)) + 1; //Número aleatorio entre 1 y 100
		int intentos = 0;
		while(true) {
			System.out.println("Introduce el número (¡Ojalá aciertes esta vez!): ");
			int actualNum = input.nextInt();
			if(actualNum < numeroOculto) {
				System.out.println("¡FALLASTE! Y el número secreto es mayor al introducido.");
				intentos++;
			}
			else if(actualNum > numeroOculto) {
				System.out.println("¡FALLASTE! Y el número secreto es menor al introducido.");
				intentos++;
			}
			else {
				break;
			}
		}
		System.out.println("El número secreto era " + numeroOculto + " como bien adivinaste, pero requeriste de " + intentos + " intentos.");
	}

}
