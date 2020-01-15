package Ejer_Vectores;
import java.util.Scanner;

public class OneMethod {
    public static void main(String[] args)
    {
       int[] arrayLleno = llenar(10); //Llenar array con los caracteres dados
       int[] valorMaximoArrayOrdenado = valorMaximo(arrayLleno);
       visualizar(valorMaximoArrayOrdenado);
    }
    public static void visualizar(int[] valorMaxArray)
    {
         int valorMax = valorMaxArray[0];
         int valorMaxReps = valorMaxArray[1];
        System.out.println("Valor máximo: " + valorMax + " y repetido " + valorMaxReps + " veces.");
    }
    public static int[] llenar(int amount)
    {
        Scanner input = new Scanner(System.in);
        int[] arraynumerico = new int[amount];
        for(int i = 0; i < amount; i++)
        {
            System.out.println("Introduce un número");
            arraynumerico[i] = input.nextInt();
        }
        return arraynumerico;
    }
    public static int[] valorMaximo(int[] arrayGiven)
    {
        int[] valorMax = new int[2];
        valorMax[1] = 1;
        for(int lastNum:arrayGiven)
        {
            if(lastNum == valorMax[0])
            {
                valorMax[1]++;
            }
            if(lastNum > valorMax[0])
            {
                valorMax[0] = lastNum;
            }
        }
        return valorMax;
    }
}