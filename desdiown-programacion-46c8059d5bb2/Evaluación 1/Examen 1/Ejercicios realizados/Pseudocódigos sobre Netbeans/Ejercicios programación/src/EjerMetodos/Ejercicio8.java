package EjerMetodos;
import java.util.Scanner;
public class Ejercicio8 {
    public static int mcd(int num1, int num2) {
        int mcd = 0;
        int a;
        int b;
        if(num1 > num2) //Higher num
        {
            a = num1;
        }
        else
        {
            a = num2;
        }
        if(num1 < num2) //Lower num
        {
            b = num1;
        }
        else
        {
            b = num2;
        }
        int attempts = 0;
        while(b!=0 || attempts == 0)
        {
            mcd = b;
            b = a%b;
            a = mcd;
            attempts++;
        }
        return mcd;
    }
    public static int mcm(int num1, int num2) {
        int mcm;
        int a;
        int b;
        if(num1 > num2) //Higher num
        {
            a = num1;
        }
        else
        {
            a = num2;
        }
        if(num1 < num2) //Lower num
        {
            b = num1;
        }
        else
        {
            b = num2;
        }
        mcm = (a/mcd(a, b))*b;
        return mcm;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número entero: ");
        int num1 = input.nextInt();
        System.out.println("Introduce otro número entero: ");
        int num2 = input.nextInt();
        /* MCM */
        System.out.println("El MCM de " + num1 + " y " + num2 + " es: " + mcm(num1,num2));
        /* MCD */
        System.out.println("El MCD de " + num1 + " y " + num2 + " es: " + mcd(num1,num2));
    }
}
