
public class Ejercicio01 {
	public static void main(String[] args) {
		byte myByte = 125;
		System.out.println(myByte);
		short myShort = 32342;
		System.out.println(myShort);
		char myChar = 97;
		System.out.println(myChar);
		float myFloat = 3.0;
		System.out.println(myFloat);
		
		/*
		 * Respuesta:
		 * No permite la ejecución del código
		 * ya que hay un error de conversión.
		 * Por defecto, los decimales se tratan 
		 * como tipo double, pero en este caso
		 * estamos asignando literalmente
		 * un decimal a un float (de menor precisión),
		 * sin hacer el casting implícito, por ende
		 * da un error de tipo y no permite la ejecución del 
		 * programa.
		 * Por defecto se asignan los 64 bits
		 * a todo número decimal, mientras que el float
		 * consta de 32, por eso da dicho error
		 * de tipos, intenta almacenar los 64 bits
		 * del número decimal en una variable de 32,
		 * y sencillamente no cabe, por eso hay que
		 * castear.
		 * 
		 * La solución:
		 * float myFloat = 3.0F;
		 * float myFloat = (float) 3.0;
		 */
	}
}
