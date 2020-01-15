package Semana11.Ejercicio4;

import java.util.Scanner;

public class MatrizHelper {
    public void llenar(int[][] matriz) {
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                System.out.println("Introduce el número de la posición " + i + ", " + j + ":");
                matriz[i][j] = input.nextInt();
            }
        }
    }

    public void impimir(int[][] matriz) {
        for(int[] vector:matriz) {
            for(int num:vector) {
                System.out.print(num + "  ");
            }
            System.out.println();
        }
    }

    public int minimo(int[][] matriz) {
        Integer smallest = null;
        for(int[] vector:matriz) {
            for(int num:vector) {
                if(smallest == null || smallest > num) {
                    smallest = num;
                }
            }
        }
        return smallest;
    }

    public int maximo(int[][] matriz) {
        Integer biggest = null;
        for(int[] vector:matriz) {
            for(int num:vector) {
                if(biggest == null || biggest < num) {
                    biggest = num;
                }
            }
        }
        return biggest;
    }

    public void intercambiar(int[][] matrizA, int[][] matrizB) {
        int minimosA = this.minimo(matrizA);
        int maximosB = this.maximo(matrizB);

        // Cambiar minimos de A con maximos de B
        for(int i = 0; i < matrizA.length; i++) {
            for(int j = 0; j < matrizA[i].length; j++) {
                if(matrizA[i][j] == minimosA) {
                    matrizA[i][j] = maximosB;
                }
            }
        }
        //Cambiar maximos de B con minimos de A
        for(int i = 0; i < matrizB.length; i++) {
            for(int j = 0; j < matrizB[i].length; j++) {
                if(matrizB[i][j] == maximosB) {
                    matrizB[i][j] = minimosA;
                }
            }
        }
    }
}
