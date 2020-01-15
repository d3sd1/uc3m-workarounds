package EjerciciosPseudocódigo;
import java.util.Scanner;
public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Supermercado pagamenos");
        
        int lastInput = 0;
        double totalPrice = 0;
        int totalItems = 0;
        while(lastInput != -1)
        {
            System.out.println("Introduce el precio del artículo (en euros): ");
            lastInput = input.nextInt();
            totalPrice += lastInput;
            totalItems++;
        }
        System.out.println("Precio total a pagar: " + totalPrice + "€");
        System.out.println("¿Cuánto ha pagado el cliente?");
        int clientGivenMoney = input.nextInt();
        while(clientGivenMoney < totalPrice)
        {
            System.out.println("Debes pagar al menos el importe de los productos, nunca menos.");
        }
        System.out.println("El cambio de " + clientGivenMoney + "€ es de " + (clientGivenMoney-totalPrice) + "€. ¡Gracias por su compra!");
    }
}
