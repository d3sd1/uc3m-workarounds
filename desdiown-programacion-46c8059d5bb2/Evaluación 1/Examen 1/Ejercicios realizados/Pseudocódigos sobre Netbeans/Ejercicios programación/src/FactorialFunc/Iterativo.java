package FactorialFunc;
import java.util.Scanner;
public class Iterativo {
    public static long factorial(int num)
    {
        long total = 1;
        for(int i = num;i > 0; i--)
        {
            total *= i;
        }
        return total;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número");
        int num = input.nextInt();
        if(num > 0)
        {
            factorial(num);
        }
    }
}
