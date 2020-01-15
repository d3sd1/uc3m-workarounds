import java.util.Scanner;

public class Ejercicio12 {
	public static void main(String[] args) {
		int antiguedad = 0;
		float sueldo = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce la antiguedad (años): ");
		antiguedad = input.nextInt();
		System.out.println("Introduce el sueldo: ");
		sueldo = input.nextFloat();

		if(sueldo < 500 && antiguedad > 10) {
			System.out.println("Aumento de salario del 20%");
			sueldo += sueldo * 20/100;
		}
		else if(sueldo < 500 && antiguedad < 10) {
			System.out.println("Aumento de salario del 5%");
			sueldo += sueldo * 5/100;
		}
		else {
			System.out.println("No opta a aumento salarial.");
		}

		System.out.println("Sueldo final: " + sueldo);
	}
}
