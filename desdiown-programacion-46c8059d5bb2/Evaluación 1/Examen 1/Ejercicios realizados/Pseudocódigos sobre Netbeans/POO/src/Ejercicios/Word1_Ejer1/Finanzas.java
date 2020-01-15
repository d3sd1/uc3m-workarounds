package Ejercicios.Word1_Ejer1;
import java.util.Scanner;
public class Finanzas {
    private static double converterNumber = 1.36;
    public static double converterToEuros(double amount)
    {
        double result = (amount/converterNumber);
        return result;
    }
    public static double converterToDollars(double amount)
    {
        double result = converterNumber*amount;
        return result;
    }
}