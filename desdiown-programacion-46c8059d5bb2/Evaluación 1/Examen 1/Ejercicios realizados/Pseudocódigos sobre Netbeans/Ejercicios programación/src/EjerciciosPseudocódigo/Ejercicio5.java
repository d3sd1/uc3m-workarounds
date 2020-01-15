package EjerciciosPseudocódigo;
import java.util.Scanner;
import java.util.Random;
public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randomgen = new Random();
        int num_ramdom = randomgen.nextInt(50);
        int intento;
        for(intento = 1; intento <= 5; intento++)
        {
            System.out.println("Introduce el número secreto, comprendido entre 1 y 50 (Intento " + intento + "): ");
            int num_input = input.nextInt();
            if(num_input < num_ramdom && num_input >= 1 && num_input <= 50)
            {
                System.out.println("El número introducido es menor que el secreto.");
            }
            else if(num_input > num_ramdom && num_input >= 1 && num_input <= 50)
            {
                System.out.println("El número introducido es mayor que el secreto.");
            }
            else if(num_input == num_ramdom && num_input >= 1 && num_input <= 50)
            {
                System.out.println("¡El número introducido es el secreto!");
            }
            else if(num_input < 1 && num_input > 50)
            {
                System.out.println("El número ha de estar comprendido entre 1 y 50.");
            }
        }
    }
    
}
