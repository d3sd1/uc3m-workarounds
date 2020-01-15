package FactorialFunc;
import java.util.Scanner;
public class Fibonacci {
    public static int fibonacci(int num)
    {
        if(num == 0)
            return 0;
        if(num > 0)
        {
            int fibo1=1;
            int fibo2=1; 
            for(int i = 2;i <= num;i++){
             fibo2 = fibo1 + fibo2;
             fibo1 = fibo2 - fibo1;
            }
            return fibo2;
        }
        else
        {
            return 1;   
        }
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Escribe un número");
        int num = input.nextInt();
        System.out.println("El fibonacci de " + num + " es " + fibonacci(num));
    }
}
