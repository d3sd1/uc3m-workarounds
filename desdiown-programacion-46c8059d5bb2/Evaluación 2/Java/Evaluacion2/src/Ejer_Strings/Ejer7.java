package Ejer_Strings;
import java.util.Scanner;

public class Ejer7 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el número de cadenas a introducir: ");
        int numCadenas = input.nextInt();
        String[] cadenas = new String[numCadenas];
        int whileLoop = 0;
        while(whileLoop < numCadenas) //Crear cadenas
        {
            System.out.println("Introduce la cadena para la posición " + whileLoop + ":");
            String ultimaCadena = input.next();
            cadenas[whileLoop] = ultimaCadena;
            input.nextLine();
            whileLoop++;
        }
        System.out.println("Procediendo a comprobar cadenas...");
        int cadenaMasLargaNum = 0;
        int cadenaMasLargaLength = 0;
        int cadenaMasLargaNumVocales = 0;
        int cadenaMasLargaLengthVocales = 0;
        for(int i = 0; i < numCadenas; i++) //Comprobar cadenas
        {
            if(cadenaMasLargaLength < cadenas[i].length())
            {
                cadenaMasLargaNum = i;
                cadenaMasLargaLength = cadenas[i].length();
            }
            int numVocales = 0;
            String vocales = "AEIOUaeiou";
            for(int i2 = 0; i2 < cadenas[i].length(); i2++) //Comprobar numero vocales
            {
                for(int i3 = 0; i3 < vocales.length(); i3++)
                {
                    if(cadenas[i].charAt(i2) == vocales.charAt(i3))
                    {
                        numVocales++;
                    }
                }
            }
            if(cadenaMasLargaLengthVocales < numVocales)
            {
                cadenaMasLargaNumVocales = i;
                cadenaMasLargaLengthVocales = numVocales;
            }
        }
        System.out.println("Cadena más larga (posición " + cadenaMasLargaNum + " con " + cadenaMasLargaLength + " caracteres): " + cadenas[cadenaMasLargaNum]);
        System.out.println("Cadena con más vocales (posición " + cadenaMasLargaNumVocales + " con " + cadenaMasLargaLengthVocales + " vocales): " + cadenas[cadenaMasLargaNumVocales]);
    }
}