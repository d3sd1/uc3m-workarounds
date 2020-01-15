package Ejer_Vectores;
import java.util.Scanner;

public class Ten {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int givenNum = input.nextInt();
        int editGivenNum = givenNum;
        int givenNumLength = (int)(Math.log10(givenNum)+1); //LOG for max val
        int[] baseNum = new int[givenNumLength];
        for(int i = (givenNumLength-1); i >= 0; i--)
        {
            baseNum[i] = editGivenNum%10;
            editGivenNum = editGivenNum/10;
        }
        System.out.println("Array generado: ");
        int i = 0;
        for(int thisNum:baseNum)
        {
            System.out.println("Caracter " + i + ": " + thisNum);
            i++;
        }
    }
}