import java.util.Scanner;

public class Ejercicio01 {
	public static void main(String[] args) {
		int num = 0; // Se pone como entero ya que no se especifica
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce el número entero a comprobar: ");
		num = input.nextInt();
		
		/* Comprobación */
		if(num % 2 == 0) {
			System.out.println("El número " + num + " es par.");
		}
		else {
			System.out.println("El número " + num + " es impar.");
		}
	}
}
