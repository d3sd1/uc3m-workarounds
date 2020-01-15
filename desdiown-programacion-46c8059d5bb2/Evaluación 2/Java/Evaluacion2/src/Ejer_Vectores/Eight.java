package Ejer_Vectores;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Eight {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] vectorActual = generateVector(0,100,10);
        for(int i = 0; i < vectorActual.length; i++)
        {
            System.out.println("Posición " + i + ": " + vectorActual[i]);
        }
        System.out.println("Introduce la posición a eliminar: ");
        int posicionEliminar = input.nextInt();
        int i = 0;
        for(int showThisVector:eliminarPosicionVector(posicionEliminar,vectorActual))
        {
            System.out.println("Posición " + i + ":" + showThisVector);
            i++;
        }
    }
    public static int generateNum(int minNum, int maxNum)
    {
        return ThreadLocalRandom.current().nextInt(minNum,maxNum);
    }
    public static int[] generateVector(int minNum, int maxNum, int length)
    {
        int[] finalVector = new int[length];
        for(int i = 0; i < finalVector.length; i++)
        {
            finalVector[i] = generateNum(minNum,maxNum);
        }
        return finalVector;
    }
    public static int[] eliminarPosicionVector(int posDelete, int[] vectorToOrder)
    {
        int[] finalVector = new int[vectorToOrder.length-1];
        for(int i = 0; i <= finalVector.length; i++)
        {
            if(i < posDelete)
            {
                finalVector[i] = vectorToOrder[i];
            }
            else if(i == posDelete)
            {
                finalVector[i] = 0;
            }
            else if(i > posDelete)
            {
                finalVector[(i-1)] = vectorToOrder[i];
            }
        }
        return finalVector;
    }
}