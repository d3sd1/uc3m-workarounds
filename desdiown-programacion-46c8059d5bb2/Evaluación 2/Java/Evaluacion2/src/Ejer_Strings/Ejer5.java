package Ejer_Strings;
import java.util.Scanner;
public class Ejer5 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce una palabra: ");
        String palabra = input.nextLine();
        String vocales = "AEIOUaeiou";
        String palabraSecreta = palabra;
        String vocalesEncontradas = "";
        for(int i = 0; i < palabra.length(); i++)
        {
            for(int i2 = 0; i2 < vocales.length(); i2++)
            {
                palabraSecreta = palabraSecreta.replace(vocales.charAt(i2),'-');
                vocalesEncontradas += vocales.charAt(i2);
            }
        }
        System.out.println("Adivina la palabra: " + palabraSecreta);
        int maxAttempts = 3, attempts = 0;
        boolean keepLoop = true;
        while(attempts <= maxAttempts && keepLoop == true)
        {
            attempts++;
            System.out.println("Intento " + attempts + " de " + maxAttempts);
            char lastChar = input.next().charAt(0);
            int timesReplaced = 0;
            for(int i = 0; i < palabra.length(); i++)
            {
                if(palabra.charAt(i) != palabraSecreta.charAt(i))
                {
                    char hiddenChar = palabra.charAt(i);
                    if(hiddenChar == lastChar)
                    {
                        timesReplaced++;
                        String nuevaPalabraSecreta = "";
                        char[] cambiarPosicion = new char[palabraSecreta.length()];
                        for(int i2 = 0; i2 < palabraSecreta.length(); i2++)
                        {
                            if(i == i2)
                            {
                                nuevaPalabraSecreta += palabra.charAt(i2);
                            }
                            else
                            {
                                nuevaPalabraSecreta += palabraSecreta.charAt(i2);
                            }
                        }
                        palabraSecreta = nuevaPalabraSecreta;
                    }
                }
            }
            if(palabraSecreta.indexOf("-") == -1)
            {
               keepLoop = false;
                System.out.println("¡Has acertado la palabra!");
            }
            else
            {
                System.out.println("Palabra tras comprobación: " + palabraSecreta);
            }
        }
    }
}