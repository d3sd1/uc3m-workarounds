package EjerMetodos;
import java.util.Scanner;
public class Ejercicio1 {
    public static void cabecera()
    {
        System.out.println("Cabecera del ejercicio 1");
    }
    public static void results(double bas,double alt)
    {
        double perimeter = bas*2 + alt*2;
        System.out.println("El perímetro del rectángulo es: " + perimeter);
        double area = bas*alt;
        System.out.println("El área del rectángulo es: " + area);   
    }
    public static void main(String[] args)
    {
        cabecera();
        Scanner input = new Scanner(System.in);
        boolean stop = false;
        while(stop == false)
        {
            System.out.println("Introduce la base del rectángulo: ");
            double bas = input.nextDouble();
            System.out.println("Introduce la altura del rectángulo: ");
            double alt = input.nextDouble();
            
            /* Show results */
            results(bas,alt);
            /* Keep exec? */
            System.out.println("¿Desea introducir más rectángulos? (Y/N)");
            String stopStr = input.next();
            if(stopStr == "n" || stopStr == "N")
            {
                stop = true;
                break;
            }
        }
    }
}
