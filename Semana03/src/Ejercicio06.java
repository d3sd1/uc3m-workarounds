
public class Ejercicio06 {

	public static void main(String[] args) {
		float var1 = 1234567890.0F;
		float var2 = 1234567899.0F;
		System.out.println("var1 - var2 = " + (var1 - var2));
		/*
		 * Resultado y pregunta 1:
		 * Imprime 0.0 en la pantalla como resultado de la operaci�n.
		 * Esto se da debido a que al hacer casting de un n�mero mayor
		 * que el m�ximo de una variable de tipo float, el casting
		 * lo reasigna al valor m�ximo de float (que en este caso,
		 * es igual que "var1"), dando como resultado de la operaci�n
		 * resta de un mismo n�mero, 0.0.
		 */

		int var3 = 1234567890;
		int var4 = 1234567899;
		System.out.println("var3 - var4 = " + (var3 - var4));
		/*
		 * Resultado y pregunta 2:
		 * Imprime -9 en la pantalla, ya que ambos n�meros
		 * est�n en el rango v�lido para un entero y no se han casteado 
		 * ni modificado, es una resta normal de var3 y var4.
		 */
	}
}
