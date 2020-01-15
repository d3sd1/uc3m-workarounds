package EjerMetodos;
import java.util.Scanner;
public class Ejercicio5 {
    public static void detectInt(int num)
    {
        if(num > 0)
        {
            System.out.println("El número " + num + " es positivo.");
        }
        else if(num < 0)
        {
            System.out.println("El número " + num + " es negativo.");
        }
        else
        {
            System.out.println("El número introducido es 0.");
        }
    }
    public static void detectPrim(int num)
    {
        int startNum = num;
        boolean error = false;
        for(num = startNum; num > 0; num--)
        {
            if(startNum != num && num != 1)
            {
                if(startNum%num == 0)
                {
                    System.out.println("El número " + num + " no es primo.");
                    error = true;
                    break;
                }
            }
        }
        if(error == false)
        {
            System.out.println("El número " + num + " es primo.");
        }
    }
    public static void detectPerfect(int num)
    {
        int suma = 0;
        for (int range = 1; range < num; range++)
        {
            if (num % range == 0)
            {
                suma = suma + range;
            }
        }
        if (suma == num)
        {
            System.out.println("El número " + num + " es perfecto.");
        }
        else
        {
            System.out.println("El número " + num + " no es perfecto.");
        }
    }
    public static void detectRangePrim(int num)
    {
        int baseNum = num;
        String numbers = "";
        for(num = baseNum; num > 1; num--)
        {
            int startNum = num;
            boolean error = false;
            for(num = startNum; num > 0; num--)
            {
                if(startNum != num && num != 1)
                {
                    if(startNum%num == 0)
                    {
                        error = true;
                        break;
                    }
                }
            }
            if(error == false)
            {
               if(numbers.equals("") == true)
               {
                   numbers += num;   
               }
               else
               {
                   numbers += ", " + num;   
               }
            }
        }
        System.out.println("Los números primos comprendidos entre 1 y " + num + " son los siguientes: " + numbers);
    }
    public static void detectRangePerfect(int num)
    {
        int baseNum = num;
        String numbers = "";
        for(num = baseNum; num > 1; num--)
        {
            int suma = 0;
            for (int range = 1; range < num; range++)
            {
                if (num % range == 0)
                {
                    suma = suma + range;
                }
            }
            if (suma == num)
            {
               if(numbers.equals("") == true)
               {
                   numbers += num;   
               }
               else
               {
                   numbers += ", " + num;   
               }
            }
        }
        System.out.println("Los números perfectos comprendidos entre 1 y " + num + " son los siguientes: " + numbers);
    }
    public static void detectDivisors(int num)
    {
        int baseNum = num;
        String numbers = "";
        for(num = baseNum; num > 1; num--)
        {
            if(baseNum%num == 0)
            {
                if(numbers.equals("") == true)
                {
                    numbers += num;   
                }
                else
                {
                    numbers += ", " + num;   
                }
            }
        }
        System.out.println("Los divisiores de " + num + " son los siguientes: " + numbers);
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número entero");
        int num = input.nextInt();
        System.out.println("Selecciona una opción: ");
        System.out.println("a) Verificar si " + num + " es positivo o negativo.");
        System.out.println("b) Verificar si " + num + " es primo.");
        System.out.println("c) Verificar si " + num + " es perfecto.");
        System.out.println("d) Detectar números primos entre 1 y " + num + ".");
        System.out.println("e) Detectar números perfectos entre 1 y " + num + ".");
        System.out.println("f) Visualizar divisores de " + num + ".");
        String menu = input.next();
        if(menu.equals("a") == true || menu.equals("A") == true)
        {
           detectInt(num); 
        }
        else if(menu.equals("b") == true || menu.equals("B") == true)
        {
           detectPrim(num); 
        }
        else if(menu.equals("c") == true || menu.equals("C") == true)
        {
           detectPerfect(num); 
        }
        else if(menu.equals("d") == true || menu.equals("D") == true)
        {
           detectRangePrim(num); 
        }
        else if(menu.equals("e") == true || menu.equals("E") == true)
        {
           detectRangePerfect(num); 
        }
        else if(menu.equals("f") == true || menu.equals("F") == true)
        {
           detectDivisors(num); 
        }
    }
}
