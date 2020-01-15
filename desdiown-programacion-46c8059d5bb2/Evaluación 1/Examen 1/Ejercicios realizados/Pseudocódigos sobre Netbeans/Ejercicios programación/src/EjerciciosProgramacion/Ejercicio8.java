package EjerciciosProgramacion;
import java.util.Scanner;
public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número. Si es igual o menor a 0, la ejecución devolverá la media");
        int lastNum = input.nextInt();
        int numSums = lastNum;
        int numAmount = 1;
        while(lastNum > 0)
        {
            System.out.println("Introduce otro número ");
            lastNum = input.nextInt();
            numSums += lastNum;
            numAmount++;
        }
        System.out.println("La media de los números es: " + (numSums/numAmount));
    }
    
}
