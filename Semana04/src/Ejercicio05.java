
public class Ejercicio05 {
	public static void main(String[] args) {
		int a,b;
		boolean r,s;
		a = 3;
		b = 8;
		r = a == 0 || b >= a;
		s = a != 0 && b < a;
		System.out.println("r:" + r);
		System.out.println("s:" + s); 
		/*
		 * Output:
		 	r:true
			s:false
		 * Respuesta:
		 * r vale true ya que está comparando si la variable a es igual a 0
		 * o si la variable b es mayor o igual que a. En este caso se cumple
		 * la condición de que b es mayor o igual que a, y la otra (a es igual a 0) no,
		 * pero al ser un operador lógico OR (||), con que se cumpla una condición vale.
		 * 
		 * s vale false ya que se está comparando si a es distinto de cero, pero además
		 * se tiene que cumplir que b sea menor que a.
		 * Al cumplirse solo una condición de las dos, y estar operado lógicamente por un
		 * AND (&&), no se cumple la condición, ya que se deben cumplir ambos bloques.
		 */
	}
}
