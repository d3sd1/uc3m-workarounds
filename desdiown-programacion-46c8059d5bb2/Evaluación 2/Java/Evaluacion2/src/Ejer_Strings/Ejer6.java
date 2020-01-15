package Ejer_Strings;
import java.util.Scanner;
public class Ejer6 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce una palabra y revisaremos si es palíndroma: ");
        String palabra = input.nextLine();
        boolean esPalindroma = true;
        for(int i = 0; i < (palabra.length()/2); i++)
        {
            if(palabra.charAt(i) != palabra.charAt(((palabra.length()-1)-i)))
            {
                esPalindroma = false;
            }
        }
        System.out.println("Es palíndroma: " + esPalindroma);
    }
}