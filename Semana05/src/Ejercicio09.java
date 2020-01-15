import java.util.Scanner;

public class Ejercicio09 {
	public static void main(String[] args) {
		int num = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce un número: ");
		num = input.nextInt();
		if(num == 1) {
			System.out.println("11111");
		}
		else if(num == 2) {
			System.out.println("22222");
		}
		else {
			System.out.println("Otro");
		}
	}
}
