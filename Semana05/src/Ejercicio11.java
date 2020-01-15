import java.util.Scanner;

public class Ejercicio11 {
	public static void main(String[] args) {
		int x = 0, y = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce coordenada x: ");
		x = input.nextInt();
		System.out.println("Introduce coordenada y: ");
		y = input.nextInt();
		
		if(x == 0 || y == 0) {
			System.out.println("Las coordenadas x o y no pueden ser 0.");
		}
		else if(x > 0 && y > 0) {
			System.out.println("Primer cuadrante.");
		}
		else if(x < 0 && y > 0) {
			System.out.println("Segundo cuadrante.");
		}
		else if(x < 0 && y < 0) {
			System.out.println("Tercer cuadrante.");
		}
		else if(x > 0 && y < 0) {
			System.out.println("Cuarto cuadrante.");
		}
	}
}
