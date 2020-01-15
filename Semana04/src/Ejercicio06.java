
public class Ejercicio06 {

	public static void main(String[] args) {
		 /*
		  * Respuesta:
		  * El comportamiento se ha indicado
		  * encima de cada operador.
		  */
		int a = 4;
		 float b = 13.3F;
		 boolean c = false;
		 
		 /* 
		  * Operador de asignación "Suma"
		  * Suma el valor asignado al valor previo de la varible.
		  * a = 4+2=6
		  */
		 a += 2;
		 System.out.println(a);
		 /* 
		  * Operador de asignación "Resta"
		  * Resta el valor asignado al valor previo de la varible.
		  * a = 6-3=3
		  */
		 a -= 3;
		 System.out.println(a);
		 /* 
		  * Operador de asignación "Producto"
		  * Multiplica el valor asignado al valor previo de la varible.
		  * a = 3*3=9
		  */
		 a *= 3;
		 System.out.println(a);
		 /* 
		  * Operador de asignación "División"
		  * Divide el valor asignado al valor previo de la varible.
		  * a = 9/2=4.5 = 4 (ya que el tipo de variable es de número
		  * entero, y perdemos precisión).
		  */
		 a /= 2;
		 System.out.println(a);
		 /* 
		  * Operador de asignación "Módulo"
		  * Obtiene el resto de la division del valor asignado al valor previo de la varible.
		  * a = 4%4=0 (ya que la división no tiene resto)
		  */
		 a %= 4; System.out.println(a);

		 /* 
		  * Operador de asignación "División"
		  * Divide el valor asignado al valor previo de la varible.
		  * b = 13.3/2=6.65 (no pierde precisión en este caso ya que
		  * la variable es de tipo float).
		  */
		 b /= 2;
		 System.out.println(b);
		 /* 
		  * Operador de asignación "Comparación lógica bit a bit AND"
		  * Evalúa el valor previo con el nuevo valor para comprobar si 
		  * éstos son iguales. TODOS los bit deben ser exactamente iguales.
		  * c = false & true = false
		  */
		 c &= true;
		 System.out.println(c);
		 /* 
		  * Operador de asignación "Comparación lógica bit a bit OR"
		  * Evalúa el valor previo con el nuevo valor para comprobar si 
		  * éstos son iguales. Si coincide algún bit, se cumple la condición.
		  * c = false & true = true
		  */
		 c |= true;
		 System.out.println(c); 
	}

}
