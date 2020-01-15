package ejercicio.pkg11;
import java.util.Scanner;
public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce una hora del día (0 a 23 horas): ");
        int hour = input.nextInt();
        if(hour >= 6 && hour <= 11)
        {
            System.out.println("La hora corresponde a la mañana.");
        }
        else if(hour >= 12 && hour <= 17)
        {
            System.out.println("La hora corresponde a la tarde.");
        }
        else if(hour >= 20 && hour <= 23)
        {
            System.out.println("La hora corresponde a la noche.");
        }
        else if(hour >= 0 && hour <= 5)
        {
            System.out.println("La hora corresponde a la madrugada.");
        }
        else
        {
            System.out.println("El número introducido no corresponde a ninguna hora.");
        }
    }
    
}
