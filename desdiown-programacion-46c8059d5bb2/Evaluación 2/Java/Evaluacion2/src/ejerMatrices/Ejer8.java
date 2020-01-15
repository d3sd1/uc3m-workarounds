package ejerMatrices;

public class Ejer8 {
    public static void main(String[] args)
    {
        ClaseMatrices caller = new ClaseMatrices();
        int[][] matriz = caller.crearMatrizAleatoria(5);
        caller.verMatriz(matriz);
    }
}