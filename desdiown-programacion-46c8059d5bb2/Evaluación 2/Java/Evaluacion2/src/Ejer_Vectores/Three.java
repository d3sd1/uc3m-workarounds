package Ejer_Vectores;
import java.util.Scanner;

public class Three {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];
        for(int i = 0; i < 10; i++)
        {
            System.out.println("Introduce un número: ");
            numbers[i] = input.nextInt();
        }
        int actualPosition = 1;
        for(int actualNumber:numbers)
        {
            if(actualNumber%2 == 0)
            {
                System.out.println("El número " + actualNumber + " es par, y se encuentra en la posición: " + actualPosition + ".");
            }
            actualPosition++;
        }
    }
}