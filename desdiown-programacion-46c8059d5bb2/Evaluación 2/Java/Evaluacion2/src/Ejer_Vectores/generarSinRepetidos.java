package Ejer_Vectores;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class generarSinRepetidos {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido al generador de números sin repetidos.");
        System.out.println("¿Cuántas cifras debe tener el número generado?(1 mínimo, 9 máximo)");
        char numLength = input.next().charAt(0);
        int actualNum = 0,startNum = 0,endNum = 0;
        switch(numLength)
        {
            case '1': //Una cifra
                startNum = 1;
                endNum = 9;
            break;
            case '2': //Dos cifras
                startNum = 10;
                endNum = 99;
            break;
            case '3': //Tres cifras
                startNum = 100;
                endNum = 999;
            break;
            case '4': //Cuatro cifras
                startNum = 1000;
                endNum = 9999;
            break;
            case '5': //Cinco cifras
                startNum = 10000;
                endNum = 99999;
            break;
            case '6': //Seis cifras
                startNum = 100000;
                endNum = 999999;
            break;
            case '7': //Siete cifras
                startNum = 1000000;
                endNum = 9999999;
            break;
            case '8': //Ocho cifras
                startNum = 10000000;
                endNum = 99999999;
            break;
            case '9': //Nueve cifras
                startNum = 100000000;
                endNum = 999999999;
            break;
            default:
                startNum = 1;
                endNum = 9;
        }
        boolean checkValidNum = false; //[BOOL] ¿Es un número válido?
        while(checkValidNum == false)
        {
            actualNum = ThreadLocalRandom.current().nextInt(startNum,endNum+1);
            int actualNumEdited = actualNum; //Número para trastear sin tocar el original
            int[] numArray = new int[Character.getNumericValue(numLength)];
            for(int i = (Character.getNumericValue(numLength)-1); i >= 0; i--) //Verificar repetidos
            {
                System.out.println("Actual: " + i);
                int thisChar = actualNumEdited%10;
                numArray[i] = thisChar;
                actualNumEdited = actualNumEdited/10; //Para que se elimine el último caracter del número
            }
            boolean numRepeteated = false;
            for(int actualArrayNum:numArray) //Número actual
            {
                int vecesRepetido = 0;
                
                for(int i=0;i<numArray.length;i++)
                {
                    
                    if(actualArrayNum == numArray[i])
                    {
                        vecesRepetido++;
                    }
                    if(actualArrayNum == numArray[i] && vecesRepetido > 1)
                    {
                        numRepeteated = true;
                    }
                }
            }
            if(numRepeteated)
            {
                System.out.println("Número descartado (no válido): " + actualNum);
                checkValidNum = false; //No es un número válido
            }
            else
            {
                System.out.println("Número válido (es correcto): " + actualNum);
                checkValidNum = true; //Es un número válido
            }
        }
        System.out.println("Número final generado: " + actualNum);
    }
}