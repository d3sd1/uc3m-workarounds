import java.util.Scanner;

public class Ejercicio13 {
	public static void main(String[] args) {
		int anyo = 0;
		boolean bisiesto = false; //Por defecto no es bisiesto, así reducimos los nested if.
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce un año: ");
		anyo = input.nextInt();

		/* Se podría hacer sin nested if pero quedaría menos claro y tendría redundancias */
		if(anyo % 4 == 0) {
			if(anyo % 100 == 0) {
				if(anyo % 400 == 0) {
					bisiesto = true;
				}
			}
			else {
				bisiesto = true;
			}
		}
		
		if(bisiesto) {
			System.out.println("El año es bisiesto.");
		}
		else {
			System.out.println("El año no es bisiesto.");
		}
	}
}
