import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce el orden del cuadrado latino (1-126)");
		byte orden = input.nextByte();
		if(orden <= 1) {
			System.out.println("El orden debe ser 2 o superior.");
		}
		//Columnas
		for(byte col = 1; col <= orden; col++) {
			//Filas
			for(byte fil = 1; fil <= orden; fil++) {
				//Esto indica que habrá numeros superiores al rango que hay que tratar
				if(fil < col) {
					//Como la variable está  por la parte izquierda al inicio, se opera para conseguir el número previo
					System.out.print(" " + (fil - col + orden + 1));
				}
				else {
					//Se restan filas y columnas para hayar la posición total de la variable, ya que está dentro del rango.
					System.out.print(" " + (fil - col + 1));
				}
			}
			System.out.println("");
		}
	}

}
