package realizarOperaciones;
import java.util.Scanner;
public class classOperaciones {
    protected double valor1 = 0;
    protected double valor2 = 0;
    protected double resultado = 0;
    public static Scanner input = new Scanner(System.in);
    classOperaciones()
    {
        
    }
    classOperaciones(double valor1, double valor2)
    {
        this.valor1=valor1;
        this.valor2=valor2;
    }
    public void cargar1()
    {
        System.out.println("Introduce el valor 1: ");
        this.valor1 = input.nextDouble();
        System.out.println("Valor 1: " + this.valor1);
    }
    public void cargar2()
    {
        System.out.println("Introduce el valor 2: ");
        this.valor2 = input.nextDouble();
    }
    
    public void mostrarResultado()
    {
        System.out.println("El resultado es: " + this.resultado);
    }
}
