package EntregaDirecta;
import java.util.Scanner;
public class AndreiGarciaCuadra {
    public static boolean introducir(int num1,int num2)
    {
        if(num1 > 0 && num2 > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static int factorial(int num)
    {
        int fact = 1;
        for(int i = num;i > 0;i--)
        {
            fact *= i;
        }
        return fact;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número entero positivo");
        int num1 = input.nextInt();
        System.out.println("Introduce otro número entero positivo");
        int num2 = input.nextInt();
        boolean validNums = false;
        while(validNums == false)
        {
            if(introducir(num1,num2) == false)
            {
                System.out.println("Error detectado. Introduce los números de nuevo");
                System.out.println("Introduce un número entero positivo");
                num1 = input.nextInt();
                System.out.println("Introduce otro número entero positivo");
                num2 = input.nextInt();
                validNums = true;
            }
            else
            {
                validNums = true;
            }
        }
        int m = num1;
        int n = num2;
        System.out.println("La formula propia de " + num1 + " y " + num2 + " es: " + (factorial(m) / n * (factorial(m-n))));
    }
}
