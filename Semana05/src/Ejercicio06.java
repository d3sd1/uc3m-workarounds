import java.util.Scanner;

public class Ejercicio06 {
	public static void main(String[] args) {
		int edad = 0;
		double precioBase = 9.0, precioFinal = precioBase;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce la edad: ");
		edad = input.nextInt();
		
		/* Descuentos */
		if(edad < 5) {
			System.out.println("Eligible a descuento de 60% por menor de 5 años.");
			precioFinal -= (precioBase * 60/100 );
		}
		else if(edad < 26) {
			System.out.println("Eligible a descuento de 20% por menor de 26 años.");
			precioFinal -= (precioBase * 20/100 );
		}
		else if(edad > 65) {
			System.out.println("Eligible a descuento de 40% por mayor de 65 años.");
			precioFinal -= (precioBase * 40/100 );
		}
		System.out.println("Precio final a pagar: " + precioFinal);
	}
}
