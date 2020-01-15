
public class Ejercicio10 {

	public static void main(String[] args) {
		int a = 5,b;
		b = a;
		System.out.println("b = " + b);
		a = 6;
		System.out.println("b = " + b);
		/* 
		 * Respuesta 1:
		 * La segunda no cambia de valor
		 * ya que estamos pasando la variable por valor (al asignar),
		 * y no pasando por referencia.
		 */
		
		String c = "Hola holita vecinito!",d;
		d = c;
		System.out.println("d = " + d);
		c = "que no, que era bromaa!";
		System.out.print("d = " + d);
		/*
		 * Respuesta 2:
		 * Pasa exactamente lo mismo que lo anterior.
		 */
	}
}
