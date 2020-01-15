package ejercicio.pkg1;
import java.util.Scanner; 
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num_introcido = lector.nextInt(); 
        if(num_introcido < 0)
        {
            System.out.println("Valor absoluto: " + num_introcido*-1);
        }
        else
        {
            System.out.println("Valor absoluto: " + num_introcido);
        }
        if(num_introcido < 10)
        {
            System.out.println("Es un número de 1 cifra.");
        }
        else if(num_introcido < 100)
        {
            System.out.println("Es un número de 2 cifras.");
        }
        else if(num_introcido < 1000)
        {
            System.out.println("Es un número de 3 cifras.");
        }
        else
        {
            System.out.println("Es un número de más de 3 cifras.");
        }
    }
}
