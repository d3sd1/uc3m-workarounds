
public class Ejercicio07 {

	public static void main(String[] args) {
		int a=5,b=3;
		boolean r=true,s=false;
		a+=b+8*b;
		r&=s;
		 System.out.println("a:" + a);
		 System.out.println("b:" + b);
		 System.out.println("r:" + r);
		 System.out.println("s:" + s); 

		 /*
		  * Output:
		  	a:32
			b:3
			r:false
			s:false

		  * Respuesta:
		  * a vale 32, ya que se está sumando el resultado de la operación 
		  * b+8*b, que resulta en 27. 27+5=32.
		  * 
		  * b vale 3, que es su valor inicial, ya que éste no se ha reasignado.
		  * 
		  * r vale false, ya que no todos los bit comparados coinciden 
		  * al realizar true & false (= false).
		  * 
		  * s vale false, ya que su valor no se ha reasignado.
		  */
	}

}
