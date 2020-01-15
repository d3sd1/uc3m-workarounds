import java.util.Scanner;

public class Ejercicio09 {

	public static void main(String[] args) {
		/* Declaraciones */
		int intNum = 0;
		double dblNum = 0;
		float sum = 0;
		System.out.println("IMPORTANTE: SI PONES 50.5 EN LUGAR DE 50,5 (Nótese la coma), es probable que Java pete por el tema de los decimales anglosajones. Depende de tu codificación, así que prueba.");
		/* Solicitar números */
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce el número entero (int): ");
		intNum = input.nextInt();

		System.out.println("Introduce el número decimal (double): ");
		dblNum = input.nextDouble();
		

		/* Output. Float perderá precisión, tenerlo en cuenta
		 *  (casteo forzado a tipo de dato con menores bytes) */
		sum = (float) (intNum + dblNum);
		System.out.println("Suma de los anteriores números (como float): " + sum);
	}

}
