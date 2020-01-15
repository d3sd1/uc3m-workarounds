package Ejercicio1;
import java.util.Scanner;
public class Java {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce un número:");
        int num_input = input.nextInt();
        if(num_input < 0)
        {
            num_input *= -1;
        }
        if(num_input < 10)
        {
            System.out.println("El número tiene una cifra.");
        }
        else if(num_input < 100)
        {
            System.out.println("El número tiene dos cifras.");
        }
        else if(num_input < 1000)
        {
            System.out.println("El número tiene tres cifras.");
        }
        else if(num_input > 1000)
        {
            System.out.println("El número tiene más de tres cifras.");
        }
    }
}
