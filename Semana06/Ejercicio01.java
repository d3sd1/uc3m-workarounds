import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		boolean keepReading = true;
		double numSum = 0.0, numAvg = 0.0;
		int numCount = 0;
		Scanner input = new Scanner(System.in);
		while(keepReading) {
			System.out.println("Introduce un número: ");
			double actualNumber = input.nextDouble();
			if(actualNumber != 0.0) {
				numSum += actualNumber;
				numCount++;
			}
			else {
				//Se podría hacer un break pero para preservar la integridad de la expresión del bucle hacemos la expresión no cumplida
				keepReading = false;
			}
		}
		numAvg = numSum/numCount;
		System.out.println("La suma de los números es: " + numSum);
		System.out.println("La media de los números es: " + numAvg);
	}

}
