package ejerMatrices;
import java.util.concurrent.ThreadLocalRandom;

public class ClaseMatrices {
    public void verMatriz(int[][] matrizAVer)
    {
        for(int numFila = 0; numFila < matrizAVer.length; numFila++)
        {
            for(int numColumna = 0; numColumna < matrizAVer[numFila].length; numColumna++)
            {
                if(matrizAVer[numFila][numColumna] != 0)
                {
                     System.out.println("Fila " + numFila + " y columna " + numColumna + ". Valor: " + matrizAVer[numFila][numColumna]);
            
                }
            }
        }
    }
    public int[][] crearMatriz(int filas, int columnas)
    {
        int[][] matrizGenerada = new int[filas][columnas];
        for(int filasRelleno = 0; filasRelleno < filas; filasRelleno++)
        {
            for(int columnasRelleno = 0; columnasRelleno < columnas; columnasRelleno++)
            {
                matrizGenerada[filasRelleno][columnasRelleno] = ThreadLocalRandom.current().nextInt(0,11);
            }
        }
        return matrizGenerada;
    }
    public int[][] crearMatrizAleatoria(int filas) //Ejer 8
    {
        int[][] matrizGenerada = new int[filas][5];
        for(int filasRelleno = 0; filasRelleno < filas; filasRelleno++)
        {
            int columnas = ThreadLocalRandom.current().nextInt(1,6);
            for(int columnasRelleno = 0; columnasRelleno < columnas; columnasRelleno++)
            {
                matrizGenerada[filasRelleno][columnasRelleno] = ThreadLocalRandom.current().nextInt(0,11);
            }
        }
        return matrizGenerada;
    }
    public double[][] crearMatrizDouble(int filas, int columnas) //Ejer 7
    {
        double[][] matrizGenerada = new double[filas][columnas];
        for(int filasRelleno = 0; filasRelleno < filas; filasRelleno++)
        {
            for(int columnasRelleno = 0; columnasRelleno < columnas; columnasRelleno++)
            {
                matrizGenerada[filasRelleno][columnasRelleno] = ThreadLocalRandom.current().nextInt(0,11);
            }
        }
        return matrizGenerada;
    }
    public int[][] crearMatrizBinaria(int filas, int columnas) //Ejer 2
    {
        int[][] matrizGenerada = new int[filas][columnas];
        for(int filasRelleno = 0; filasRelleno < filas; filasRelleno++)
        {
            for(int columnasRelleno = 0; columnasRelleno < columnas; columnasRelleno++)
            {
                if(columnasRelleno%2 == 0)
                {
                   matrizGenerada[filasRelleno][columnasRelleno] = 1; 
                }
                else
                {
                   matrizGenerada[filasRelleno][columnasRelleno] = 0; 
                }
            }
        }
        return matrizGenerada;
    }
    public int[][] crearMatrizBinariaDiagonal(int filas, int columnas) //Ejer 3
    {
        int[][] matrizGenerada = new int[filas][columnas];
        for(int filasRelleno = 0; filasRelleno < filas; filasRelleno++)
        {
            for(int columnasRelleno = 0; columnasRelleno < columnas; columnasRelleno++)
            {
                if(columnasRelleno == filasRelleno)
                {
                   matrizGenerada[filasRelleno][columnasRelleno] = 1; 
                }
                else
                {
                   matrizGenerada[filasRelleno][columnasRelleno] = 0; 
                }
            }
        }
        return matrizGenerada;
    }
    public void verMatrizSumada(int[][] matrizAVer)
    {
        int sumaTotal = 0;
        for(int numFila = 0; numFila < matrizAVer.length; numFila++)
        {
            int sumaColumnas = 0;
            for(int numColumna = 0; numColumna < matrizAVer[numFila].length; numColumna++)
            {
                sumaColumnas += matrizAVer[numFila][numColumna];
                sumaTotal += matrizAVer[numFila][numColumna];
                System.out.println("Suma columnas de la fila " + numFila + ": " + sumaColumnas);
            }
        }
        System.out.println("Suma total: " + sumaTotal);
    }
}