package evaluación2;
import java.util.Scanner;

public class entornosEjercicio2 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Introduce el tipo de figura: ");
        String tipo_figura = input.next();
		this.queFiguraEs(tipo_figura);
    }
    public String queFiguraEs(String figura)
    {
        if(figura.equals("Rectangulo"))
        {
            System.out.println("Introduce la base del rectángulo");
            double base = input.nextDouble();
            double altura = input.nextDouble();
            System.out.println("Area: " + Rectangulo.area(base,altura));
            System.out.println("Perimetro: " + Rectangulo.area(base,altura));
        }
        else if(figura.equals("Circulo"))
        {
            System.out.println("Introduce el radio del círculo");
			double radio = input.next();
            System.out.println("Area: " + Circulo.area(radio));
            System.out.println("Perimetro: " + Circulo.area(radio));
			input.nextLine();
        }
		else
		{
			System.out.println("Figura no encontrada.");
		}
    }
}
public static class Rectangulo {
    public static double area(double base, double altura)
	{
		return base*altura;
	}
    public static double perimetro(double base, double altura)
	{
		return base*2 + altura*2;
	}
}
public static class Circulo {
    public static double area(double radio)
	{
		return radio*3.14;
	}
    public static double perimetro(double radio)
	{
		return radio*2*3.14;
	}
}