package Ejer_Strings;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
public class Ejer3 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce una frase: ");
        String mayus = "QWERTYUIOPÑLKJHGFDSAZXCVBNM";
        String minus = "qwertyuiopñlkjhgfdsazxcvbnm";
        String frase = input.nextLine();
        int numMayus = 0, numMinus = 0, numNotRecog = 0;
        for(int i = 0; i < frase.length(); i++)
        {
            if(mayus.indexOf(frase.charAt(i)) != -1)
            {
                numMayus++;
            }
            else if(minus.indexOf(frase.charAt(i)) != -1)
            {
                numMinus++;
            }
            else
            {
                numNotRecog++;
            }
        }
        System.out.println("Número de mayúsculas: " + numMayus + ", número de minúsculas: " + numMinus + ", número de caracteres no reconocidos: " + numNotRecog);
    }
}