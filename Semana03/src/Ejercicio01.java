
public class Ejercicio01 {
	public static void main(String[] args) {
		
		/* Declaración de variables */
		boolean varBoolean; //1 bit
		byte varByte; //1 byte
		short varShort; //2 bytes
		int varInt; //4 bytes
		float varFloat; //4 bytes
		long varLong; //8 bytes
		double varDouble; //8 bytes
		char varChar; //2 bytes
		String varString; //n bytes
		
		/* Asignación de variables */

		varBoolean = false; //[true,false]
		varByte = 100; //[-128,127]
		varShort = -32100; //[-32768,32767]
		varInt = 60000; //[-2147483648, 2147483647]
		varFloat = 0.02F; //[-9223372036854775808, 9223372036854775807]
		varLong = 248232342; //[3.40282347 x 1038, 1.40239846 x 10-45]
		varDouble = 0.0000000004; //[1.7976931348623157 x 10308, 4.9406564584124654 x 10-324]
		varChar = 'A'; //[ANY]
		varString = "Hi there"; //[ANY]
		
		/* Impresión de variables */

		System.out.println(varBoolean);
		System.out.println(varByte);
		System.out.println(varShort);
		System.out.println(varInt);
		System.out.println(varFloat);
		System.out.println(varLong);
		System.out.println(varDouble);
		System.out.println(varChar);
		System.out.println(varString);
	}
}
