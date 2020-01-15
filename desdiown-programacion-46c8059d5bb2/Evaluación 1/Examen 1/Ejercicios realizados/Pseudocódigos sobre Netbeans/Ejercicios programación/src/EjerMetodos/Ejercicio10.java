package EjerMetodos;
import java.util.Scanner;
public class Ejercicio10 {
    public static double calcuSemanal(int hours, int hourPrice)
    {
        double finalPay = 0;
        if(hours > 40)
        {
            int hoursPassed = hours-40;
            finalPay = (hoursPassed*(1.5*hourPrice))+(40*hourPrice);
        }
        else if(hours <= 40)
        {
            finalPay = hours*hourPrice;
        }
        return finalPay;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número de empleado: ");
        int numEmp = input.nextInt();
        int hours = 0;
        int hourPrice = 15; //Euros per hour
        if(numEmp != 0)
        {
            switch(numEmp)
            {
                case 1:
                hours = 6;
                break;
                case 2:
                hours = 14;
                break;
                case 3:
                hours = 45;
                break;
                case 4:
                hours = 3;
                break;
                default:
                    System.out.println("No existe tal empleado.");
                break;
            }
            System.out.println("Deberá cobrar: " + calcuSemanal(hours,hourPrice) + "€ por " + hours + " horas trabajadas.");
        }
        else
        {
           System.out.println("No existe tal empleado.");
        }
    }
}
