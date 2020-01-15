import java.util.Scanner;

public class Ejercicio05 {
	public static void main(String[] args) {
		int edad1 = 0, edad2 = 0;
		String nombre1 = "", nombre2 = "";
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce el nombre de la primera persona: ");
		nombre1 = input.next();
		System.out.println("Introduce la edad de la primera persona: ");
		edad1 = input.nextInt();
		
		System.out.println("Introduce el nombre de la segunda persona: ");
		nombre2 = input.next();
		System.out.println("Introduce la edad de la segunda persona: ");
		edad2 = input.nextInt();
		
		/* Comprobación */
		if(edad1 > edad2) {
			System.out.println(nombre1 + " es mayor que " + nombre2);
		}
		else if(edad1 < edad2) {
			System.out.println(nombre2 + " es mayor que " + nombre1);
		}
		else {
			System.out.println(nombre1 + " y " + nombre2 + " tienen la misma edad.");
		}
	}
}
