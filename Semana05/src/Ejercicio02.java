import java.util.Scanner;

public class Ejercicio02 {
	public static void main(String[] args) {
		int num1 = 0, num2 = 0; // Se pone como entero ya que no se especifica
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce el número entero primero: ");
		num1 = input.nextInt();
		System.out.println("Introduce el número entero segundo: ");
		num2 = input.nextInt();
		
		/* Comprobación */
		if(num1 == num2) {
			System.out.println("Los números " + num1 + " y " + num2 + " son iguales.");
		}
		else if(num1 < num2) {
			System.out.println("El número mayor entre " + num1 + " y " + num2 + " es: " + num2);
		}
		else {
			System.out.println("El número mayor entre " + num1 + " y " + num2 + " es: " + num1);
		}
	}
}
