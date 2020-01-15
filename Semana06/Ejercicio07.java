import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		short anyoNac = 0;
		byte mesNac = 0, diaNac = 0;
		
		System.out.println("Introduce el año de nacimiento (4 dígitos) y pulsa Enter");
		anyoNac = input.nextShort();
		System.out.println("Introduce el mes en nacimiento y pulsa Enter");
		mesNac = input.nextByte();
		System.out.println("Introduce el dia de nacimiento y pulsa Enter");
		diaNac = input.nextByte();
		
		short tempNumSuerte = (short) (anyoNac + mesNac + diaNac);
		
		//Calcular el lucky number.
		short numDeLaSuerte = 0;
		while(tempNumSuerte !=0)
		 {
			//Módulo para hayar el número en la posición actual
			numDeLaSuerte += (short) (tempNumSuerte%10);
			//Quitar ese número del número temporal para evitar un bucle infinito
			tempNumSuerte = (short) (tempNumSuerte/10);
		 }
		
		System.out.println("Tu numero de la suerte es el " + numDeLaSuerte);
	}

}
