package Operadores;
public class Ejercicio4 {
    public static void main(String[] args)
    {
        System.out.println("Ejercicio 4: ");
        int a = 5;
        int b = 3;
        System.out.println("a = 5; b = 3");
        System.out.println("a) !(a > b && 2 * a <= b) " + (!(a > b && 2 * a <= b)));
        System.out.println("b) b++ > 3 | a + b <= 8 && !(a > b) " + (b++ > 3 | a + b <= 8 && !(a > b)));
        System.out.println("c) a++ < 6 && (b += 2) < a " + (a++ < 6 && (b += 2) < a));
        System.out.println("d) a++ / 2 < b && (a++ / 2 > b || (a * 2 < b * 4)) " + (a++ < 6 && (b += 2) < a));
    }
}
