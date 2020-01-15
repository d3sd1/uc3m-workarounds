
public class Ejercicio14 {

	public static void main(String[] args) {
		int i = 0;
		i = 2147483647 + 1000;
		System.out.println("i = " + i);
		/*
		 * Respuesta 1:
		 * Sí es posible, ya que al operar no es una recta
		 * real de números, sino un círculo real de números y al
		 * terminar por un extremo pasa al siguiente,
		 * y por eso sale el número negativo del extremo "opuesto".
		 */
		float i2 = 0;
		i2 = 2147483647 + 1000;
		System.out.println("i2 = " + i2);
		/*
		 * Respuesta 2:
		 * Ocurre exactamente lo mismo.
		 */
	}
}
