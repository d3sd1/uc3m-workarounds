package Ejer_Strings;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ejer2 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String letras = "qwertyuiopñlkjhgfdsazxcvbnmQWERTYUIOPÑLKJHGFDSAZXCVBNM";
        String vocales = "aeiouAEIOU";
        System.out.println("Introduce el número de letras a generar");
        int letrasAGenerar = input.nextInt();
        String letrasRandom = "";
        for(int i = 0; i < letrasAGenerar; i++)
        {
            char letraGenerada = letras.charAt(ThreadLocalRandom.current().nextInt(0,(letras.length()+1)));
            letrasRandom += letraGenerada;
            boolean esVocal = false;
            for(int i2 = 0; i2 < vocales.length(); i2++) //¿Es vocal?
            {
                if(letraGenerada == vocales.charAt(i2))
                {
                    esVocal = true;
                }
            }
            if(esVocal == true)
            {
                System.out.println("La letra " + letraGenerada + " generada en la posición " + i + " es vocal");
            }
            else
            {
                System.out.println("La letra " + letraGenerada + " generada en la posición " + i + " es consonante");
            }
        }
        System.out.println("Cadena final generada: " + letrasRandom);
    }
}