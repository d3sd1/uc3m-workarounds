
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
		  * Da como resultado 20, ya que se pierde precisi�n
		  * num�rica al operar con enteros, si esta operaci�n
		  * da como resultado un conjunto de n�meros mayor.
		  * En este caso, operamos con enteros, y dan resultados
		  * de n�meros reales (decimales peri�dicos puros).
		  * Al no poder contener 2.333333... en una variable entera,
		  * se trunca y se coge s�lo el n�mero entero.
		  */
	}
}
