
public class Ejercicio04 {

	public static void main(String[] args) {
		final String constante = "Me llamo andrei, y eso no va a cambiar!!";
		constante = "hola ahora me llamo pepe";
		/*
		 * Respuesta 1:
		 * No se puede cambiar el valor de una constante
		 * por definición, ya que es un valor inmutable.
		 */
		
		final String cambiame;
		cambiame = "hola ahora me llamo pepe";
		
		/*
		 * Respuesta 2:
		 * Se puede inicializar el valor de una constante en 
		 * una asignación sucesiva y no en la misma línea de 
		 * creación de la constante, ya que no tenía valor previo,
		 * y le estamos dando su primer y único valor.
		 */
	}
}
