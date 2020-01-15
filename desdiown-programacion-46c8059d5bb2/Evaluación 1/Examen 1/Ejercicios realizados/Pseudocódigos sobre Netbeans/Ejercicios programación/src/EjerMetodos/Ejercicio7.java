package EjerMetodos;
import java.util.Scanner;
public class Ejercicio7 {
    public static boolean digits(int numAbs)
    {
        if(numAbs >= 1000 && numAbs < 10000)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static int absolute(int numAbs)
    {
        return numAbs;
    }
    public static int sumdigit(int num)
    {
        int finalNum=0;
       
        for(finalNum=finalNum; num!=0; num/=10) 
        {
            finalNum+=num%10; 
        }
        return finalNum;
    }
    public static String isCap(int numAbs)
    {
        int real;
        int i = 0;
	int startNum=numAbs;
        while(numAbs!=0)
	{    
            real=numAbs%10;
            i=i*10+real;
            numAbs=numAbs/10;
     	}
        if(i==startNum)
        {
            return "Sí";
        }
        else
        {
            return "No";
        }
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número de 4 cifras.");
        int num = input.nextInt();
        int numAbs = 0;
        if(num < 0)
        {
            numAbs = num*-1;
        }
        else
        {
            numAbs = num;      
        }
        if(digits(numAbs) == true)
        {
            System.out.println("Valor absoluto: " + absolute(numAbs)); //Print absolute value
            System.out.println("Suma de sus dígitos: " + sumdigit(num)); //Print sumatory of digits
            System.out.println("¿Es capicúa?: " + isCap(numAbs)); //Print if is cap
        }
        else
        {
            System.out.println("El número no es de 4 cifras.");
        }
    }
}
