import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Indica el límite superior para generar numeros perfectos y pulsa Enter: ");
		int cotaSuperior = input.nextInt();
		boolean detectados = false;
		
		if(cotaSuperior < 0) {
			System.out.println("El número de cota superior ha de ser positivo (no hay negativos perfectos).");
		}
		else {
		
			//iterar sobre todos los numeros menores a la cota, ascendentemente
			for(int numero = 1; numero < cotaSuperior; numero++) {
				int sumatorioDivisores = 0;
				//Obtener el sumatorio de los divisores
				for(int divisor = 1; divisor < numero; divisor++) {
					if(numero != divisor && numero % divisor == 0) {
						sumatorioDivisores += divisor;
					}
				}
				
				//Determinar si el sumatorio de divisores es igual al numero actual (si es perfecto ea).
				if(sumatorioDivisores == numero) {
					System.out.println("El número " + numero + " es perfecto");
					detectados = true;
				}
			}
			if(!detectados) {
				System.out.println("¡No hay números perfectos en el rango indicado!");
			}
			
		}
	}

}
