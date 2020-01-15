package EjerMetodos;
import java.util.Scanner;
public class Ejercicio4 {
    public static void clients()
    {
     Scanner input = new Scanner(System.in);
        System.out.println("SUPERMERCADO TIERNO");
        double lastPrice = 0;
        double countPrice = 0;
        while(lastPrice != -1)
        {
            System.out.println("Introduce el precio del artículo: ");
            lastPrice = input.nextDouble();
            countPrice += lastPrice;
        }
        System.out.println("Precio total de la compra: " + countPrice + "€");
        System.out.println("¿Cuánto ha pagado el cliente?");
        double paid = input.nextDouble();
        while(paid < countPrice)
        {
            System.out.println("Debe pagar el importe exacto o mayor. ¿Cuánto ha pagado?");
            paid = input.nextDouble();
        }
        System.out.println("El cambio a devolver es de: " + (paid - countPrice));
        System.out.println("Pulsa s para introducir un nuevo cliente.");
        String newClient = input.next();
        if(newClient.equals("s") == true)
        {
           clients(); 
        }   
    }
    public static void main(String[] args)
    {
        clients();
    }
}
