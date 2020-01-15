import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[20];
		for (int i = 0; i < arr.length; i++) {
			int numAleatorio = ThreadLocalRandom.current().nextInt(1, 9 + 1); // Número aleatorio en rango de 1 a 9 (+1
																				// ya que no está includo el último).
			arr[i] = numAleatorio;
		}

		System.out.println("Introduce el número a buscar en el array (1 al 9): ");
		int numBusqueda = input.nextInt();
		if (numBusqueda >= 1 && numBusqueda <= 0) {
			boolean encontrado = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == numBusqueda) {
					System.out.println("El numero " + numBusqueda + " está en la posición " + i);
					encontrado = true;
				}
			}
			if (!encontrado) {
				System.out.println("El numero " + numBusqueda + " no esta en el array");
			}

		} else {
			System.out.println("El número de búsqueda no estaba en el rango [1-9].");
		}
		input.close();
	}
}
