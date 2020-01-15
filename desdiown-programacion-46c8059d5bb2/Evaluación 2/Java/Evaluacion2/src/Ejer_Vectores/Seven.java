package Ejer_Vectores;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Seven {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int maxLength = 10;
        int minNum = 1;
        int maxNum = 50;
        int[] vectorOrdenado =  Seven.generateVector(maxLength,minNum,maxNum);
        Arrays.sort(vectorOrdenado); //Give an ordered vector after random it.
        int i = 0;
        for(int thisVector:vectorOrdenado)
        {
            i++;
            System.out.print(thisVector);
            if(i != vectorOrdenado.length)
            {
                System.out.print(", ");
            }
        }
        System.out.println("");
        System.out.println("Introduce un número: ");
        int newNum = input.nextInt();
        int[] newArrayOrdenado = Seven.orderNumOnArray(newNum,vectorOrdenado);
        i = 0;
        for(int thisNum:newArrayOrdenado)
        {
            i++;
            System.out.print(thisNum);
            if(i != newArrayOrdenado.length)
            {
                System.out.print(", ");   
            }
        }
    }
    public static int generateNum(int minNum, int maxNum)
    {
        return ThreadLocalRandom.current().nextInt(minNum, maxNum + 1);
    }
    public static int[] generateVector(int maxLength,int minNum, int maxNum)
    {
        int[] finalVector = new int[maxLength];
        for(int i = 0; i < maxLength; i++)
        {
            finalVector[i] = Seven.generateNum(minNum,maxNum);
        }
        return finalVector;
    }
    public static int[] orderNumOnArray(int newNum, int[] arrayGiven)
    {
        int arrayLength = arrayGiven.length;
        int[] finalArray = new int[(arrayLength+1)];
        int numPosition = 0;
        for(int i = 0; i < arrayLength; i++)
        {
            if(arrayGiven[i] <= newNum && arrayGiven[(i+1)] > newNum)
            {
                finalArray[i] = arrayGiven[i];
                numPosition = i+1;
            }
            else
            {
                finalArray[(i+1)] = arrayGiven[i];   
            }
        }
        finalArray[numPosition] = newNum;     
        return finalArray;
    }
}