package EjerciciosPseudocódigo;
import java.util.Scanner;
public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número base: ");
        int num_base = input.nextInt();
        System.out.println("Introduce un número exponente: ");
        int num_exp = input.nextInt();
        int num_final = 1;
        for(int i = 0;i < num_exp; i++)
        {
            num_final *= num_base;
        }
        System.out.println("La potencia de " + num_base + "^" + num_exp + " es " + num_final);
    }
}
