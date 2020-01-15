package EjerciciosProgramacion;
import java.util.Scanner;
public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int number_fact = input.nextInt();
        int number_final = 1;
        for(int i = 1; i <= number_fact; i++)
        {
            number_final *= i;
        }
        System.out.println("El factorial de !" + number_fact + " es " + number_final);
    }
}
