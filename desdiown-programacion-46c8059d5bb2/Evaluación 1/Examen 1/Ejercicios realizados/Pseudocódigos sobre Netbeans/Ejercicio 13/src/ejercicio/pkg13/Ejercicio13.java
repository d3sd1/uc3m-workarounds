package ejercicio.pkg13;
import java.util.Scanner;
public class Ejercicio13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce la distancia en kilómetros: ");
        int distance = input.nextInt();
        System.out.println("¿Eres familia numerosa?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        int famDiscount = input.nextInt();
        double basePrice = (distance*0.10); //On Euros
        double price = basePrice;
        if(distance > 1000 || famDiscount == 1)
        {
            double discount = 0.30; //Percent
            System.out.println(basePrice * discount);
            price -= (basePrice * (discount/100));
        }
        /* IVA Applying */
        double iva = 0.07; //Percent
        price += (basePrice * iva);
        System.out.println("El precio final es de: " + price + "€");
    }
    
}
