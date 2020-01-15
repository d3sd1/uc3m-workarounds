
public class Ejercicio11 {
	public static void main(String[] args) {
		 int a,b;
		 int c,d;
		 a = 2; //2
		 b = 3 * 3; //9
		 c = 7 / 3; //2.33333... -> 2 (int)
		 d = a + b * c; //2 + 9 * 2
		 System.out.println(d);
		 /*
		  * Respuesta:
		  * Da como resultado 20, ya que se pierde precisión
		  * numérica al operar con enteros, si esta operación
		  * da como resultado un conjunto de números mayor.
		  * En este caso, operamos con enteros, y dan resultados
		  * de números reales (decimales periódicos puros).
		  * Al no poder contener 2.333333... en una variable entera,
		  * se trunca y se coge sólo el número entero.
		  */
	}
}
