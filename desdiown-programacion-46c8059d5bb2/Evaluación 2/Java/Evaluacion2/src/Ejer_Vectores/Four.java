package Ejer_Vectores;
import java.util.Scanner;

public class Four {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];
        for(int i = 0;i < 10; i++)
        {
            System.out.println("Introduce un número: ");
            numbers[i] = input.nextInt();
        }
        double mediaPares = 0;
        int sumaPares = 0;
        double mediaImpares = 0;
        int sumaImpares = 0;
        for(int thisNum:numbers)
        {
            if(thisNum%2 == 0)
            {
                sumaPares += thisNum;
            }
            else
            {
                sumaImpares += thisNum;
            }
        }
        System.out.println("La media de los números pares es: " + mediaPares);
        System.out.println("La media de los números impares es: " + mediaImpares);
    }
}