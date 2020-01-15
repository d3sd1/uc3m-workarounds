
public class Ejercicio13 {

	public static void main(String[] args) {
		int a = 5, b = 0, c;
		c = a/b;
		System.out.println("c = " + c);
		/*
		 * Respuesta 1:
		 * No se pueden dividir números enteros entre 0, salta
		 * una excepción.
		 */
		long d = 5, e = 0, f;
		f = d/e;
		System.out.println("f = " + f);
		/*
		 * Respuesta 2:
		 * No cambia, ya que no se pueden divir números enteros
		 * entre 0 (todo igual).
		 */
	}
}
