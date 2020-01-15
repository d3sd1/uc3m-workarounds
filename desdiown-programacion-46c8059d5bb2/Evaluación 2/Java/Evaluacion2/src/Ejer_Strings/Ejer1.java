package Ejer_Strings;
import java.util.Scanner;

public class Ejer1 {
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un texto.");
        String cadena = input.nextLine();
        System.out.println("Introduce el caracter a buscar");
        char caracterBuscar = input.next().charAt(0);
        int timesRepeat = 0;
        for(int i = 0; i < cadena.length(); i++)
        {
            if(cadena.charAt(i) == caracterBuscar)
            {
                timesRepeat++;
            }
        }
        System.out.println("El caracter " + caracterBuscar + " se ha repetido " + timesRepeat + " en la cadena: " + cadena);
    }
}