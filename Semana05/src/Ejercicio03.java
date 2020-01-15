import java.util.Scanner;

public class Ejercicio03 {
	public static void main(String[] args) {
		System.out.println("Comprobar si el primer número es divisible (de manera exacta) entre el segundo.");
		int num1 = 0, num2 = 0; // Se pone como entero ya que no se especifica
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce el número entero primero: ");
		num1 = input.nextInt();
		System.out.println("Introduce el número entero segundo: ");
		num2 = input.nextInt();
		
		/* Comprobación */
		if(num1 % num2 == 0) {
			System.out.println("El número " + num1 + " es divisible entre " + num2 + ".");
		}
		else {
			System.out.println("El número " + num1 + " NO es divisible entre " + num2 + ".");
		}
	}
}
