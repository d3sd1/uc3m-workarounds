package Semana11.Ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        MatrizHelper mh = new MatrizHelper();

        /* MATRIZ A */
        int filA, colA;
        System.out.println("Introduce el número de filas de la matriz A y pulsa Enter");
        filA = input.nextInt();
        System.out.println("Introduce el número de columnas de la matriz A y pulsa Enter");
        colA = input.nextInt();
        int[][] matrizA = new int[filA][colA];
        mh.llenar(matrizA);

        System.out.println("La matriz a es:");
        mh.impimir(matrizA);
        System.out.println("El mínimo elemento de la matriz A es: " + mh.minimo(matrizA));

        /* MATRIZ B */
        int filB, colB;
        System.out.println("Introduce el número de filas de la matriz B y pulsa Enter");
        filB = input.nextInt();
        System.out.println("Introduce el número de columnas de la matriz B y pulsa Enter");
        colB = input.nextInt();
        int[][] matrizB = new int[filB][colB];
        mh.llenar(matrizB);

        System.out.println("El máximo elemento de la matriz B es:" + mh.maximo(matrizB));
        mh.intercambiar(matrizA,matrizB);
        System.out.println("La matriz A tras el intercambio de elementos es:");
        mh.impimir(matrizA);
        System.out.println("La matriz B tras el intercambio de elementos es:");
        mh.impimir(matrizB);
        input.close();
    }
}
