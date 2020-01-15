package MathPack;
import java.util.Scanner;
public class Funcion {
    public static void main(String[] args)
    {
        Scanner Plumero = new Scanner(System.in);
        System.out.println("Introduce un número");
        funcion(Plumero.nextInt());
    }
    public static void funcion(int numeraso)
    {
        if(numeraso >= 0)
        {
            System.out.println("Numero:" + numeraso);
            numeraso--;
            funcion(numeraso);
        }
    }
}
