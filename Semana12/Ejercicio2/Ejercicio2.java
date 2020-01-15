package Semana12.Ejercicio2;

import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio2 {
    public static void main(String[] args) {
        //En lugar de pedir por teclado lo generé aleatoriamente, para ver la carga de cpu que produce.

        int rows = ThreadLocalRandom.current().current().nextInt(1, 50 + 1);
        int cols = ThreadLocalRandom.current().nextInt(1, 50 + 1);

        double[][] matrix = new double[rows][cols];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(1, 50 + 1);
            }
        }
        System.out.println("La suma de todos los elementos de la matriz es: " + sumarMatriz(matrix));
        System.out.println("La fila con la mayor suma en sus elementos es: " + indiceMayorSuma(matrix));
        imprimirMatriz(matrix);
    }
    public static double sumarMatriz(double[][] matrix) {
        double sum = 0;
        for(double[] vector:matrix) {
            for(double num:vector) {
                sum += num;
            }
        }
        return sum;
    }
    public static double indiceMayorSuma(double[][] matrix) {
        double maxSum = 0;
        int rowNum = 0;
        int rowCount = 0;
        for(double[] vector:matrix) {
            double rowSum = 0;
            for(double num:vector) {
                rowSum += num;
            }
            if(maxSum < rowSum) {
                maxSum = rowSum;
                rowNum = rowCount;
            }
            rowCount++;
        }
        return rowNum;
    }
    public static void imprimirMatriz(double[][] matrix) {
        for(double[] vector:matrix) {
            for(double num:vector) {
                System.out.print(num + "  ");
            }
            System.out.println();
        }
    }
}
