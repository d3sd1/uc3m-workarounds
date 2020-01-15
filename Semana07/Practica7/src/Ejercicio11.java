import java.util.Scanner;

class Matriz {
	// No se pone Scanner como atributo porque ni es una propiedad del objeto ni nos
	// interesa que se almacene el buffer
	private int[][] matriz;
	private String nombre = "";

	public Matriz(String nombre) {
		this.nombre = nombre;

		int filas = 0, columnas = 0; // Se declaran una vez y se reutilizan
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce el numero de filas de la " + this.nombre + " y pulsa Enter");
		filas = input.nextInt();
		System.out.println("Introduce el numero de columnas de la " + this.nombre + " y pulsa Enter");
		columnas = input.nextInt();

		this.matriz = new int[filas][columnas];
	}
	
	public int[][] getMatriz() {
		return this.matriz;
	}

	public void rellenarManualmente() {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz[i].length; j++) {
				System.out.println("Introduce el numero de la posicion " + i + ", " + j);
				this.matriz[i][j] = input.nextInt();
			}
		}
	}

	public void mostrar() {
		System.out.println("La " + this.nombre + " es: ");
		for (int i = 0; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz[i].length; j++) {
				System.out.print((j != 0 ? "  " : "") + this.matriz[i][j]);
			}
			System.out.println();
		}
	}

	/* He ciomplicado un poco este método para repasar conceptos. Espero no haber sido un capullo a la hora de corregirlo. */
	public void mostrarRepetidosCon(Matriz... matrices) {
		// Loop matriz actual
		for (int i = 0; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz[i].length; j++) {
				// Loop entre las matrices parámetro
				for (Matriz matrizComp : matrices) {
					for (int k = 0; k < matrizComp.getMatriz().length; k++) {
						for (int l = 0; l < matrizComp.getMatriz()[k].length; l++) {
							if(this.matriz[i][j] == matrizComp.getMatriz()[k][l]) {
								System.out.println(
										"El elemento " + this.matriz[i][j] + " esta incluido en alguna en comparación.");
							}
						}
					}
				}
			}
		}
	}
}

public class Ejercicio11 {
	public static void main(String[] args) {

		Matriz matrizA = new Matriz("Matriz A");
		matrizA.rellenarManualmente();
		matrizA.mostrar();
		Matriz matrizB = new Matriz("Matriz B");
		matrizB.rellenarManualmente();
		matrizB.mostrar();

		matrizA.mostrarRepetidosCon(matrizB); // Valdría hacer lo mismo a la inversa.
		/*
		 * Cerramos el System.in del Scanner. Esto se comparte entre todos los escaneres
		 * y si no lo cerráramos aquí no se cerraría. Al cerrar este cerraremos todos,
		 * incluidos los de las clases Matriz. Si se cerraran en matriz petaría de este
		 * modo: Exception in thread "main" java.util.NoSuchElementException at
		 * java.base/java.util.Scanner.throwFor(Scanner.java:937) at
		 * java.base/java.util.Scanner.next(Scanner.java:1594) at
		 * java.base/java.util.Scanner.nextInt(Scanner.java:2258) at
		 * java.base/java.util.Scanner.nextInt(Scanner.java:2212) at
		 * Matriz.<init>(Ejercicio11.java:13) at Ejercicio11.main(Ejercicio11.java:48)
		 */
		Scanner input = new Scanner(System.in);
		input.close();
	}
}
