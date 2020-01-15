package ejercicio.pkg2;
import java.util.Scanner; 
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num_introcido = lector.nextInt(); 
        System.out.println("Introduce otro número: ");
        int num_introcido2 = lector.nextInt(); 
        if(num_introcido%2 == 0 && num_introcido2%2 == 0) //Los dos son pares
        {
            System.out.println("Ambos son pares");
        }
        else if(num_introcido%2 != 0 && num_introcido2%2 != 0) //Los dos son pares
        {
            System.out.println("Ambos son impares");
        }
    }
    
}
