import java.util.Scanner;

public class Ejercicio08 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		//Se incluye el output en el bucle de asignación para evitar bucles redundantes y optimizar ya que en este caso no afecta.
		System.out.println("Introduce la dimensión de la matriz cuadrada: ");
		int dimension = input.nextInt();
		char[][] matriz = new char[dimension][dimension];
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				if((i == 0 || i == matriz.length-1) || (j == 0 || j == matriz[i].length-1)) {
					matriz[i][j] = '*';
				}
				else {
					matriz[i][j] = ' ';
				}
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
		input.close();
	}
}
