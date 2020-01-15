package Ejer_Vectores;
import java.util.Scanner;
public class Nine {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número positivo de 10 cifras: ");
        int numGiven = input.nextInt();
        int numGivenEdit = numGiven;
        int numGivenLength = (int)(Math.log10(numGiven)+1);
        if(numGivenLength == 10 && numGiven > 0)
        {
            int[] arrayBase = new int[10];
            for(int i = 0; i < numGivenLength; i++)
            {
                arrayBase[i] = numGivenEdit%10;
                numGivenEdit = numGivenEdit/10;
            }
            /* Check if it’s capicua */
            boolean numCap = true;
            for(int i = 0; i < (numGivenLength/2); i++)
            {
                if(arrayBase[i] != arrayBase[9-i])
                {
                    numCap = false;
                }
            }
            if(numCap ==  true)
            {
                    System.out.println("El número es capicúa.");
            }
            else
            {
                    System.out.println("El número no es capicúa.");
            }
        }
        else
        {
            System.out.println("El número introducido no es de 10 cifras y positivo.");   
        }
    }
}