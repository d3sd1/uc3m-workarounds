
public class Ejercicio14 {

	public static void main(String[] args) {
		int i = 0;
		i = 2147483647 + 1000;
		System.out.println("i = " + i);
		/*
		 * Respuesta 1:
		 * S� es posible, ya que al operar no es una recta
		 * real de n�meros, sino un c�rculo real de n�meros y al
		 * terminar por un extremo pasa al siguiente,
		 * y por eso sale el n�mero negativo del extremo "opuesto".
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
