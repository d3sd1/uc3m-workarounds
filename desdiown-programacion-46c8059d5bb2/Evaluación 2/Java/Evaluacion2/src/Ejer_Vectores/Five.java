package Ejer_Vectores;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Five {
    public static void main(String[] args)
    {
        int numAlumnos = 10;
        int estaturaMinima = 160;
        int estaturaMaxima = 195;
        
        Scanner input = new Scanner(System.in);
        int[] estaturasAlumnos = new int[numAlumnos];
        int sumaEstaturas = 0;
        int maxAltura = 0;
        int maxAlturaCont = 0;
        int minAltura = 0;
        int minAlturaCont = 0;
        for(int i = 0; i < numAlumnos; i++)
        {
            int thisEstatura = Five.generarAltura(estaturaMinima,estaturaMaxima);
            estaturasAlumnos[i] = thisEstatura;
            sumaEstaturas += thisEstatura;
            if(thisEstatura > maxAltura)
            {
                maxAltura = thisEstatura;
                maxAlturaCont++;
            }
            else if(thisEstatura == maxAltura)
            {
                maxAlturaCont++;
            }
            if(minAltura < minAlturaCont)
            {
                minAltura = thisEstatura;
                minAlturaCont++;
            }
            else if(thisEstatura == maxAltura)
            {
                minAlturaCont++;
            }
        }
        int mediaEstaturas = sumaEstaturas/numAlumnos;
        Five.mostrarAlturas(sumaEstaturas,mediaEstaturas,minAltura,maxAltura,minAlturaCont,maxAlturaCont);
    }
    public static int generarAltura(int estaturaMinima, int estaturaMaxima)
    {
        return ThreadLocalRandom.current().nextInt(estaturaMinima, estaturaMaxima + 1);
    }
    public static void mostrarAlturas(int sumaEstaturas, int mediaEstaturas, int minAltura, int maxAltura, int minAlturaCont, int maxAlturaCont)
    {
        System.out.println("Suma de las estaturas: " + sumaEstaturas + "cm");
        System.out.println("Media de las estaturas: " + mediaEstaturas + "cm");
        System.out.println("Altura máxima: " + maxAltura + " cm (repetida " + maxAlturaCont + " veces).");
        System.out.println("Altura mínima: " + minAltura + " cm (repetida " + minAlturaCont + " veces).");
    }
}