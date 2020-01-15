public class Ejercicio02 {
	public static void main(String[] args) {
		int[] arr1 = new int[] {1,2,3,4,5,6};
		int[] arr2 = arr1;
		arr1[0] = 10;
		System.out.println("Valor 0 en arr1: " + arr1[0]);
		System.out.println("Valor 0 en arr2: " + arr2[0]);
		/*
		 * Respuesta 1:
		 * Se copia la referencia entonces al modificar el primer array se modifica el segundo, ya que éste enlaza a la referencia del array
		 * y no a sus valores.
		 */
		arr2[0] = 100;
		System.out.println("Valor 0 en arr1: " + arr1[0]);
		System.out.println("Valor 0 en arr2: " + arr2[0]);
		/*
		 * Respuesta 2:
		 * Ocurre lo mismo que en el apartado anterior.
		 */

		int[] arr3 = new int[] {1,2,3,4,5,6};
		int[] arr4 = new int[6];
		System.arraycopy(arr3, 0, arr4, 0, 6);
		arr4[0] = 9990;
		System.out.println("Valor 0 en arr3: " + arr3[0]);
		System.out.println("Valor 0 en arr4: " + arr4[0]);
		
		/*
		 * Respuesta 3:
		 * En este caso se copia por valor y no por referencia, creando así arrays autónomos, con su propia referencia y valores.
		 * Aunque los valores coincidan al principio, si estos se modifican se modifican solo en el array indicado (por valor y no referencia).
		 */
	}
}
