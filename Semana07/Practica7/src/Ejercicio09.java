import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio09 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numSecreto = 0, minNumSecreto = 1, maxNumSecreto = 100;
		while(numSecreto > maxNumSecreto || numSecreto < minNumSecreto) {
			System.out.println("Introduce el número secreto (prometo no leer mis referencias de memoria para adivinártelo antes!!): ");
			numSecreto = input.nextInt();
			if(numSecreto > maxNumSecreto || numSecreto < minNumSecreto) {
				System.out.println("Dije del " + minNumSecreto + " al " + maxNumSecreto + "...");
			}
		}

		int[] unCheckedNums = new int[maxNumSecreto];
		int intentos = 0;
		
		/* Crear los valores posibles del rango */
		for(int i = 0; i < unCheckedNums.length; i++) {
			unCheckedNums[i] = i+1;
		}
		
		/* Ahora desordenar el array con el doble de iteraciones del tamaño total del rango para mayor desorden */

		Random rnd = ThreadLocalRandom.current();
	    for (int i = unCheckedNums.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = unCheckedNums[index];
	      unCheckedNums[index] = unCheckedNums[i];
	      unCheckedNums[i] = a;
	    }
		for(int i = 0; i < unCheckedNums.length; i++) {
			System.out.println(unCheckedNums[i]);
		}
		/* Ahora a adivinar computacionalmente, no hace falta nada aleatorio aquí simplemente recorrer el array que ya es aleatorio y no tiene repetidos. */
		boolean adivinado = false;
		adivinando: for(int i = 0; i < unCheckedNums.length; i++) {
			System.out.println("¿Es tu número secreto el " + unCheckedNums[i] + "? (si/no)");
			respuesta: while(true) {
				switch(input.next()) {
					case "si": 
						System.out.println("JAJAJAJA ¡LO ADIVINÉ!");
						adivinado = true;
						break adivinando;
					case "no":
						System.out.println("Jo... A seguirlo intentando.");
						break respuesta;
						default:
							System.out.println("No me respondiste ni si ni no... Vuelve a responder.");
				}
			}
			
			intentos++;
		}
		if(!adivinado) {
			System.out.println("Me has mentido demasiadas veces. Ahora entiendo a Siri.");
			System.out.println("Cierro el programa. Me siento mal, muy mal. Estoy muy enfadada contigo.");
		}
		
		System.out.println("Número de intentos: " + intentos);
		input.close();
	}
}
