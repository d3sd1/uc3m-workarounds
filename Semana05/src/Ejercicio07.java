import java.util.Scanner;

public class Ejercicio07 {
	public static void main(String[] args) {
		int num1 = 0, num2 = 0, num3 = 0;
		double precioBase = 9.0, precioFinal = precioBase;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce el número 1: ");
		num1 = input.nextInt();		
		System.out.println("Introduce el número 2: ");
		num2 = input.nextInt();		
		System.out.println("Introduce el número 3: ");
		num3 = input.nextInt();
		
		/* Descuentos */
		if(num1 < num2 && num2 < num3) {
			System.out.println(num1 + " < " + num2 + " < " + num3);
		}
		else if(num3 < num2 && num2 < num1) {
			System.out.println(num3 + " < " + num2 + " < " + num1);
		}
		else if(num2 < num3 && num3 < num1) {
			System.out.println(num2 + " < " + num3 + " < " + num1);
		}
		else if(num2 < num1 && num1 < num3) {
			System.out.println(num2 + " < " + num1 + " < " + num3);
		}
		else if(num3 < num1 && num1 < num2) {
			System.out.println(num3 + " < " + num1 + " < " + num2);
		}
		else if(num1 < num3 && num3 < num2) {
			System.out.println(num1 + " < " + num3 + " < " + num2);
		}
		else if(num1 == num2 && num2 < num3) {
			System.out.println(num1 + " = " + num2 + " < " + num3);
		}
		else if(num1 == num2 && num2 > num3) {
			System.out.println(num3 + " < " + num1 + " = " + num2);
		}
		else if(num3 == num2 && num2 < num1) {
			System.out.println(num3 + " = " + num2 + " < " + num1);
		}
		else if(num3 == num2 && num2 < num1) {
			System.out.println(num1 + " < " + num1 + " = " + num2);
		}
		else if(num1 == num3 && num3 < num2) {
			System.out.println(num1 + " = " + num2 + " < " + num3);
		}
		else if(num1 == num3 && num3 > num2) {
			System.out.println(num2 + " < " + num1 + " = " + num2);
		}
		else {
			System.out.println("¡Algo no estaba bien programado, y se ha capturado un flujo no controlado!");
		}
	}
}
