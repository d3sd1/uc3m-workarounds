import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio05 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce el tamaño del array a crear: ");

		double[] arr = new double[input.nextInt()];
		int total = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int numAleatorio = ThreadLocalRandom.current().nextInt(1, 49 + 1); // Número aleatorio en rango de 1 a 49 (+1 ya que no está includo el último).
			arr[i] = numAleatorio;
			total += arr[i];
		}
		
		System.out.println("La suma de todos los elementos es " + total);

		input.close();
	}
}
