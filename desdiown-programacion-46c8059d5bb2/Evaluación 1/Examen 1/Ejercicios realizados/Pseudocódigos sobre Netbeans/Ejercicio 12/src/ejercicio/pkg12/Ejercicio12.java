package ejercicio.pkg12;
import java.util.Scanner;
public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce tu peso (en Kilogramos): ");
        int weigth = input.nextInt();
        System.out.println("Selecciona una opción y pulsa su número: ");
        System.out.println("1. Mostrar peso en Kilogramos.");
        System.out.println("2. Mostrar peso en gramos.");
        System.out.println("3. Mostrar peso en libras.");
        System.out.println("4. Mostrar peso en onzas.");
        int menuOption = input.nextInt();
        switch(menuOption)
        {
            case 1:
                System.out.println("Tu peso en kilogramos es: " + weigth);
            break;
            case 2:
                System.out.println("Tu peso en gramos es: " + (weigth * 1000));
            break;
            case 3:
                System.out.println("Tu peso en libras es: " + (weigth*0.454));
            break;
            case 4:
                System.out.println("Tu peso en onzas es: " + ((weigth*1000)*28));
            break;
            default:
                System.out.println("Debes introducir una opción del menú.");
            break;
        }
    }
    
}
