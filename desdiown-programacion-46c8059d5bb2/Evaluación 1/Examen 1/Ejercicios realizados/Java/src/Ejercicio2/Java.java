package Ejercicio2;
import java.util.Scanner;
public class Java {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce un número:");
        int num_input = input.nextInt();
        System.out.print("Introduce otro número");
        int num_input2 = input.nextInt();
        if(num_input%2 == 0 && num_input2%2 == 0)
        {
            System.out.print("Ambos números son pares (" + num_input + ", " + num_input2 + ")");
        }
        else if(num_input%2 != 0 && num_input2%2 != 0)
        {
            System.out.print("Ambos números son impares (" + num_input + ", " + num_input2 + ")");
        }
    }
}
