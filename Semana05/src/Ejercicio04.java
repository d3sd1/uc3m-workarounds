import java.util.Scanner;

public class Ejercicio04 {
	public static void main(String[] args) {
		int num1 = 0, num2 = 0; // Se pone como entero ya que no se especifica
		double resultado = 0; //Ya que el resultado puede contener decimales.
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce el número entero primero: ");
		num1 = input.nextInt();
		System.out.println("Introduce el número entero segundo: ");
		num2 = input.nextInt();
		
		/* Comprobación */
		if(num2 == 0) {
			System.out.println("No se puede dividir entre 0 usando enteros.");
		}
		else {
			resultado = (double)(num1)/ (double)(num2); //se castean ambos números a double porque sino el resultado de la operación pierde precisión decimal.
			System.out.println(num1 + "/" + num2 + " = " + resultado);
		}
	}
}
