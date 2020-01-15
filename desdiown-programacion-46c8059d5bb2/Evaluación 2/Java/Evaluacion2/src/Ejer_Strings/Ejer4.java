package Ejer_Strings;
import java.util.Scanner;
public class Ejer4 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce una cadena de texto");
        String cadena = input.nextLine();
        String cadenaSinEspacios = cadena.replace(" ", "");
        System.out.println("Cadena sin espacios: " + cadenaSinEspacios);
    }
}