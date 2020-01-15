package MathPack;
public class MathFunc {
    public static long factorial(int num)
    {
        long total = 1;
        for(int i = num;i > 0; i--)
        {
            total *= i;
        }
        return total;
    }
    public static long potencia(int base, int exponente)
    {
        long total = 1;
        for(int i = exponente;i > 0; i--)
        {
            total *= base;
        }
        return total;
    }
    public static boolean esPrimo(int numero)
    {
        boolean esPrimo = true;
        for(int i = numero;i > 0; i--)
        {
            if(numero%i == 0)
            {
                if(i != numero && i != 1)
                {
                    esPrimo = false;
                }
            }
        }
        return esPrimo;
    }
    public static double valorAbsolutoDecimal(double numero)
    {
        double total = numero;
        if(total < 0)
        {
            total *= -1;
        }
        return total;
    }
    public static int valorAbsolutoEntero(int numero)
    {
        int total = numero;
        if(total < 0)
        {
            total *= -1;
        }
        return total;
    }
    public static boolean esPerfecto(int numero)
    {
        boolean esPerfecto = false;
        int finalNum = 0;
        for(int i = numero; i > 0; i--)
        {
            if(numero%i == 0 && i != numero)
            {
                finalNum += i;
         
            }
        }
        if(finalNum == numero)
        {
            esPerfecto = true;
        }
        return esPerfecto;
    }
}
