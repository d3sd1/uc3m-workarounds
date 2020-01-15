package Ejer_Vectores;
import java.util.Scanner;

public class Six {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int alumnos = 40;
        int alumnosAprobados = 0;
        int alumnosSuspensos = 0;
        double notaTotalClase = 0;
        for(int i = 0; i < alumnos; i++)
        {
            System.out.println("Introduce la nota del alumno: ");
            double notaActual = input.nextDouble();
            if(notaActual >= 5)
            {
                alumnosAprobados++;
            }
            else if(notaActual < 5)
            {
                alumnosSuspensos++;
            }
            notaTotalClase += notaActual;
        }
        double notaMediaClase = notaTotalClase/alumnos;
        System.out.println("Alumnos aprobados: " + alumnosAprobados);
        System.out.println("Alumnos suspensos: " + alumnosSuspensos);
        System.out.println("Nota media de la clase: " + notaMediaClase);
    }
}