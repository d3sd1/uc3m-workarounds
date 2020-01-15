package ejerMatrices;

public class Ejer2 {
    public static void main(String[] args)
    {
        ClaseMatrices caller = new ClaseMatrices();
        int[][] tabla = caller.crearMatrizBinaria(10,10);
        caller.verMatriz(tabla);
    }
}