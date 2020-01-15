package EjerciciosPráctica;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.BigInteger;
public class InputTypes {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Escribe un número: ");
        int lastNum = input.nextInt();
        System.out.println("Escribe un caracter alfanumérico: ");
        String lastChar = input.next();
        System.out.println("Escribe un número con decimales: ");
        double lastDoubleNum = input.nextDouble();
        System.out.println("Escribe un número gigante: ");
        BigDecimal fatDec = input.nextBigDecimal();
        System.out.println("Escribe un número gigante: ");
        BigInteger fatInt = input.nextBigInteger();
        System.out.println("Escribe un 0 o un 1 (sí o no): ");
        boolean bool = input.nextBoolean();
        System.out.println("Escribe un caracter simple: ");
        byte byteChar = input.nextByte();
        System.out.println("Escribe un número con muchos decimales: ");
        float floatNum = input.nextFloat();
        System.out.println("Escribe algo que se ignorará: ");
        String getNextLine = input.nextLine();
        System.out.println("El siguiente valor será tomado por la variable getNextLine: ");
        String ignoreline = input.next();
        System.out.println("Escribe un número enorme con decimales: ");
        long numLong = input.nextLong();
        System.out.println("Escribe un número enano con decimales: ");
        short numShort = input.nextShort();
    }
}
