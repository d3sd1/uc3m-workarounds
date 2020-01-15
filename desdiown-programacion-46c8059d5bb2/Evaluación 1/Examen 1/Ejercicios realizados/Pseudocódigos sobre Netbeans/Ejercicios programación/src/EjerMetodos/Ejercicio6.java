package EjerMetodos;
import java.lang.Math;
import java.util.Scanner;
public class Ejercicio6 {
    public static int input()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num = input.nextInt();
        return num;
    }
    public static void main(String[] args)
    {
        int n = input();
        double sum = 0;
        for(int i = 0; i < n; i++)
        {
            double combinatorio = 0;
            for(int ii = n; n > 0; n--)
            {
                combinatorio += n*ii;
            }
            sum += ((Math.pow(n, n))/combinatorio);
        }
        sum = 1 + sum;
    }
}
