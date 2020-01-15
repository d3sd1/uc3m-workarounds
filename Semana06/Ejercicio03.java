import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce un número entero: ");
		int numero = input.nextInt();
		System.out.println("Introduce los múltiplos a hayar: ");
		int numMultiplosRequeridos = input.nextInt();
		
		//Almacenamos en un array para mostrar con el mismo formato de comas y un punto al final del último numero.
		//3, 6, 9, 12, 15. 
		int[] multiplosOutput = new int[numMultiplosRequeridos];
		int multiplosEncontrados = 0;
		
		//Loop para averiguar los múltiplos. Determinar si es positivo o negativo para variar el orden
		if(numero > 0) {
			for(int intentoMultiplo = numero; multiplosEncontrados < numMultiplosRequeridos; intentoMultiplo++) {
				if(intentoMultiplo % numero == 0) {
					multiplosOutput[multiplosEncontrados] = intentoMultiplo; 
					multiplosEncontrados++;
				}
			}
		}
		else {
			for(int intentoMultiplo = numero; multiplosEncontrados < numMultiplosRequeridos; intentoMultiplo--) {
				if(intentoMultiplo % numero == 0) {
					multiplosOutput[multiplosEncontrados] = intentoMultiplo; 
					multiplosEncontrados++;
				}
			}
		}
		
		//Loop para mostrar los múltiplos en el formato requerido.
		int i = 0;
		for(int multiplo : multiplosOutput) {
			//Última iteración, poner punto y no coma!
			if(i++ == multiplosOutput.length - 1){
				System.out.println(multiplo + ".");
		    }
			else {
				System.out.println(multiplo + ", ");
			}
		}
	}

}
