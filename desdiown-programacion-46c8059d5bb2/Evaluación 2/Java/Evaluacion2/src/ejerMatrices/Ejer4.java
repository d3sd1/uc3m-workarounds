package ejerMatrices;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ejer4 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ClaseMatrices caller = new ClaseMatrices();
        System.out.println("Introduce el número de filas");
        int filas = input.nextInt();
        System.out.println("Introduce el número de columnas");
        int columnas = input.nextInt();
        int[][] matrizFinal = caller.crearMatriz(filas, columnas);
        caller.verMatriz(matrizFinal);
    }
}