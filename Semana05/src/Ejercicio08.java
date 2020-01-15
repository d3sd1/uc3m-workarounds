import java.util.Scanner;

public class Ejercicio08 {
	public static void main(String[] args) {
		String num = "";
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce un número (o no): ");
		num = input.next();
		
		if(num.length() > 1) {
			System.out.println("Sólo puedes introducir un dígito.");
		}
		
		switch(num) {
		case "0":
			System.out.println("¡Es un número!");
		break;
		case "1":
			System.out.println("¡Es un número!");
		break;
		case "2":
			System.out.println("¡Es un número!");
		break;
		case "3":
			System.out.println("¡Es un número!");
		break;
		case "4":
			System.out.println("¡Es un número!");
		break;
		case "5":
			System.out.println("¡Es un número!");
		break;
		case "6":
			System.out.println("¡Es un número!");
		break;
		case "7":
			System.out.println("¡Es un número!");
		break;
		case "8":
			System.out.println("¡Es un número!");
		break;
		case "9":
			System.out.println("¡Es un número!");
		break;
		default:
			System.out.println("¡No es un número!");
		}
	}
}
