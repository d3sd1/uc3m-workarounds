package Ejercicios.Word1_Ejer2;
import java.util.Scanner;
public class App {
    public static void main(String[] args)
    {
        Campo olivo = new Campo();
        Scanner inp = new Scanner(System.in);
        boolean stop = false;
        while(stop == false)
        {
            System.out.println("Introduce el peso en kilos de la cosecha (0 para acabar de introducir datos)");
            int pesoOlivosInp = inp.nextInt();
            System.out.println("Introduce la edad del olivo");
            int edadOlivosInp = inp.nextInt();
            if(pesoOlivosInp != 0)
            {
                olivo.setNewValues(pesoOlivosInp,edadOlivosInp);
            }
            else
            {
                System.out.println("Cantidad de ganancias en €: " + olivo.beneficio());
                System.out.println("¡Adiós!");
                stop = true;   
            }
        }
    }
}