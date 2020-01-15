package Ejer_Vectores;
import java.util.Scanner;
public class One {
    public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);
       int[] arraynumerico = {};
       int valorMax = 0;
       int valorMaxReps = 1;
       int lastNum = 0;
       for(int i = 0; i < 10; i++)
       {
           System.out.println("Introduce un número");
           lastNum = input.nextInt();
           if(lastNum == valorMax)
           {
               valorMaxReps++;
           }
           if(lastNum > valorMax)
           {
               valorMax = lastNum;
           }
       }
        System.out.println("Valor máximo: " + valorMax + " y repetido " + valorMaxReps + " veces.");
       
    }
}