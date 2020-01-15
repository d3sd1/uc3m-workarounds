package FactorialFunc;
import java.util.Scanner;
public class Recursivo {
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
        while(num != 0)
        {
            System.out.println("Factorial de " + num + " es " + factorial(num));
            num--;
        }
    }
}
