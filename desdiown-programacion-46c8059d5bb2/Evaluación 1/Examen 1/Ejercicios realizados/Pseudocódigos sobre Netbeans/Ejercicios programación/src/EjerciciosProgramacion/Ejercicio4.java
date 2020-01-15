package EjerciciosProgramacion;
import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int num_input = input.nextInt();
        if(num_input%2 != 0 || num_input < 3 || num_input > 500)
        {
            System.out.println("Introduce un número par entre 3 y 500");
        }
        else if(num_input%2 == 0 && num_input > 3 && num_input < 500)
        {
            System.out.println("El número introducido es válido.");
        }
    }
    
}
