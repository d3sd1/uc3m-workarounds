package Ejercicios.Word1_Ejer1;

import java.util.Scanner;

public class App {

    
    public static void main(String[] args)
    {
        Scanner ent = new Scanner(System.in);
        System.out.println("Introduce una cantidad para convertir");
        double amount = ent.nextDouble();
        System.out.println("¿Convertir a euros (pulsa 0) o a dólares? (pulsa 1)");
        int opt = ent.nextInt();
        switch(opt)
        {
            case 0:
                System.out.println(Finanzas.converterToEuros(amount));
                break;
            case 1:
                System.out.println(Finanzas.converterToDollars(amount));
                break;
            default: System.out.println("No se ha elegido una opción correcta.");
        }
    }
}