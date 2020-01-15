package EjerMetodos;
import java.util.Scanner;
public class Ejercicio2 {
    public static int menu()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("¿Qué desea hacer? (Pulse número para acción)");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Salir");
        int optNum = input.nextInt();
        if(optNum < 1 || optNum > 5)
        {
            System.out.println("Opción incorrecta");
            System.exit(0);
        }
        return optNum;
    }
    public static void calculate(int optNum, int num1,int num2)
    {
        switch(optNum)
        {
            case 1:
                System.out.println("Has elegido la opción sumar. Resultado: " + (num1+num2));
            break;
            case 2:
                System.out.println("Has elegido la opción restar. Resultado: " + (num1-num2));
            break;
            case 3:
                System.out.println("Has elegido la opción multiplicar. Resultado: " + (num1*num2));
            break;
            case 4:
                System.out.println("Has elegido la opción dividir. Resultado: " + (num1/num2));
            break;
            case 5:
                System.out.println("Has elegido la opción salir. ¡Adiós!");
                System.exit(0);
            break;
        }   
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int optNum = menu();
        System.out.println("Escribe un número: ");
        int num1 = input.nextInt();
        System.out.println("Escribe otro número: ");
        int num2 = input.nextInt();
        calculate(optNum,num1,num2);
    }
}
