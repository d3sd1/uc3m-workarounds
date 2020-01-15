package ejerMatrices;

public class Ejer3 {
    public static void main(String[] args)
    {
        ClaseMatrices caller = new ClaseMatrices();
        int[][] tabla = caller.crearMatrizBinariaDiagonal(5,5);
        caller.verMatriz(tabla);
    }
}