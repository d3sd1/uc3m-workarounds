package EjerciciosProgramacion;
import java.util.Scanner; 
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num_input = lector.nextInt();
        if(num_input == 0)
        {
            System.out.println("El número no puede ser 0");
        }
        else
        {
            System.out.println("El doble del número " + num_input + " es: " + num_input*2);
        }
    }
    
}
