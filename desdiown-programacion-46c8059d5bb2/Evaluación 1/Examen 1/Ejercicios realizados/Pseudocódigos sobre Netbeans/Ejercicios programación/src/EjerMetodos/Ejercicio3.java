package EjerMetodos;
import java.util.Scanner;
public class Ejercicio3 {
    public static double introducir()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce los grados centígrados: ");
        double grad = input.nextDouble();
        return grad;
    }
    public static int menu()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Selecciona una opción (Pulsa la tecla correspondiente)");
        System.out.println("a) Transformar grados centígrados en Reamur");
        System.out.println("b) Transformar grados centígrados en Fahrenheit");
        System.out.println("c) Transformar grados centígrados en Kelvin");
        String menuOpt = input.next();
        int menuOptInt = 0;
        if(menuOpt.equals("a") == true || menuOpt.equals("A") == true)
        {
            menuOptInt = 1;
        }
        else if(menuOpt.equals("b") == true || menuOpt.equals("B") == true)
        {
            menuOptInt = 2;
        }
        else if(menuOpt.equals("c") == true || menuOpt.equals("C") == true)
        {
            menuOptInt = 3;
        }
        else
        {
            System.out.println("Opción inválida.");
            System.exit(0);
        }
        return menuOptInt;
    }
    public static double Reamur(double grad)
    {
        return (grad * 0.8000000); //Simplified
    }
    public static double Fahrenheit(double grad)
    {
        return (grad * 33.80000); //Simplified
    }
    public static double Kelvin(double grad)
    {
        return (grad * 274.1500); //Simplified
    }
    public static void main(String[] args)
    {
        double grad = introducir();
        int menuOtp = menu();
        if(menuOtp == 1)
        {
            System.out.println(Reamur(grad) + " grados Reamur.");
        }
        else if(menuOtp == 2)
        {
            System.out.println(Fahrenheit(grad) + " grados Fahrenheit.");
        }
        else if(menuOtp == 3)
        {
            System.out.println(Kelvin(grad) + " grados Kelvin.");
        }
        else
        {
            System.out.println("Opción inválida.");
        }
    }
}
