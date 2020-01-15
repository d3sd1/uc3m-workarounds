package ejerMatrices;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ejer6 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ClaseMatrices caller = new ClaseMatrices();
        System.out.println("Introduce el número de clases");
        int max_alumnos_por_clase = 30;
        int[][] clases = new int[input.nextInt()][];
        int alumnosTotales = 0;
        for(int clase = 0; clase < clases.length; clase++)
        {
            System.out.println("Introduce el número de alumnos de la clase " + (clase+1));
            int num_alumnos = input.nextInt();
            clases[clase] = new int[num_alumnos];
            for(int thisAlum = 0; thisAlum < num_alumnos; thisAlum++)
            {
                //System.out.println("Introduce la nota del alumno " + thisAlum + " de la clase " + i);
                int notaAlumno = ThreadLocalRandom.current().nextInt(0,11);
                clases[clase][thisAlum] = notaAlumno;
                alumnosTotales++;
            }
        }
        caller.verMatriz(clases);
        String notasMaximas = null;
        int notaMaximaActual = 0;
        int numeroClase = 0;
        for(int[] claseActual:clases)
        {
            int numeroAlumno = 0;
            for(int alumnoActual:claseActual)
            {
                if(alumnoActual > notaMaximaActual)
                {
                    notaMaximaActual = alumnoActual;
                    notasMaximas = "Nueva nota máxima = " + alumnoActual + ". Alumno: Grupo " + numeroClase + " y número de alumno " + numeroAlumno;
                }
                else if(alumnoActual == notaMaximaActual)
                {
                    notasMaximas += "Alumno: Grupo " + numeroClase + " y número de alumno " + numeroAlumno;
                }
                numeroAlumno++;
            }
            numeroClase++;
        }
        System.out.println(notasMaximas);
    }
}