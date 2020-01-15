import java.util.Scanner;

public class Ejercicio10 {
	public static void main(String[] args) {
		int num = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce un número: ");
		num = input.nextInt();
		switch(num) {
		case 1:
			System.out.println("11111");
			break;
		case 2:
			System.out.println("22222");
			break;
			default:
				System.out.println("Otro");
		}
	}
}
