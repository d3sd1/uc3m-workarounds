import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio12 {
	public static void main(String[] args) {
		/* Declaración de variables */
		double amount, finalRateSimple = 0, finalRateComposed = 0;
		float yearlyRate;
		int years;
		
		/* Entrada */
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce la cantidad de dinero (en €):");
		amount = input.nextDouble();
		
		System.out.println("Introduce el tipo de interés anual (en % sin el %):");
		yearlyRate = input.nextFloat();
		
		System.out.println("Introduce el tiempo en año/s:");
		years = input.nextInt();
		
		/* Cálculo de cantidad final acumulada. Limitamos a dos decimales sólo en el output, la variable sigue almacenando todo el valor */
		DecimalFormat df = new DecimalFormat("#.00");
		finalRateSimple = amount * (1 + (yearlyRate * years));
		System.out.println("Cantidad final acumulada - Interés simple: " + df.format(finalRateSimple) + "€");
		
		finalRateComposed = amount * Math.pow((1 + yearlyRate), years);
		System.out.println("Cantidad final acumulada - Interés compuesto: " + df.format(finalRateComposed) + "€");
	}
}
