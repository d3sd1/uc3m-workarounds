import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		/* Declaraciones */
		double temperatureCentigrade = 0,
				temperatureFahrenheit = 0; //Tipo de dato double porque seguro que quieren una conversión más grande que el universo.
		
		/* Entrada */
		Scanner input = new Scanner(System.in);  
		System.out.print("Introduce los grados centígrados: ");
		temperatureCentigrade = input.nextDouble();
		
		/* Reasignación y salida */
		temperatureFahrenheit = 9*(temperatureCentigrade/5)+32;
		System.out.println(temperatureCentigrade + " grados centígrados son " + temperatureFahrenheit + " grados Fahrenheit.");
	}

}
