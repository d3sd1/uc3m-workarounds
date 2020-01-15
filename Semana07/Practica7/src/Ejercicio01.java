
public class Ejercicio01 {
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3};
		arr[0] = arr[1];
		System.out.println("Posición 0: " + arr[0]);
		System.out.println("Posición 1: " + arr[1]);
		arr[1] = 100;

		System.out.println("----------------------");
		System.out.println("Posición 0: " + arr[0]);
		System.out.println("Posición 1: " + arr[1]);
		/*
		 * Respuesta 1:
		 * No cambia el valor del primero porque se asigna por valor y no por referencia.
		 * Si cambiamos valores sucesivos modificará el valor actual pero no reasignará ya que se ha 
		 * almacenado previamente sólo el valor (2) y no la referencia (ya que se trata de un valor primitivo y no un objeto).
		 */
		arr[0] = 20;

		System.out.println("----------------------");
		System.out.println("Posición 0: " + arr[0]);
		System.out.println("Posición 1: " + arr[1]);
		/*
		 * Respuesta 2:
		 * Cambiando el valor del primero en lugar del segundo ocurre exactamente lo anteriormente mencionado.
		 */
	}
}
