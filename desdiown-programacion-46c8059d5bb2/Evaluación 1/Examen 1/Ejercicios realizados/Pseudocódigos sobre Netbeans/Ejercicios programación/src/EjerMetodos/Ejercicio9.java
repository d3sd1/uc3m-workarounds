package EjerMetodos;
import java.util.Scanner;
public class Ejercicio9 {
    public static void welcome()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce la distancia: ");
        int dist = input.nextInt();
        System.out.println("¿Eres familia numerosa? (0 = NO/1 = SI)");
        boolean famNum = input.nextBoolean();
        System.out.println("¿En qué categoria viaja? 1 o 2");
        short cat = input.nextShort();
        calcCost(dist,famNum,cat);
    }
    public static void calcCost(int dist, boolean famNum, short cat)
    {
        Scanner input = new Scanner(System.in);
        double price = 0;
        if(cat == 1)
        {
            price = dist*0.10;
            if(dist > 1000 && famNum == true)
            {
                price = price - (price*15/100);
            }
        }
        else if(cat == 2)
        {
            price = dist*0.08;
        }
        else
        {
            System.out.println("Categoría incorrecta.");
        }
        if(dist > 1000 || famNum == true)
        {
            price = price - (price*20/100);
        }
        System.out.println("El precio final del billete es: " + price);
        System.out.println("¿Quieres comprobar más billetes? 0 = no/1 = si");
        boolean comp = input.nextBoolean();
        if(comp == true)
        {
            welcome();
        }
    }
    public static void main(String[] args)
    {
        System.out.println("Bienvenido a RENFE");
        welcome();
    }
}
