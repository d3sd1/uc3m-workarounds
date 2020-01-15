package Semana13.Ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.getProperty("line.separator"));
        Programacion progra = new Programacion();
        //Añadir y si es 5 o 6, buscar tambien.
        for(byte i = 1; i <= 6; i++) {
            Estudiante t = new Estudiante();
            System.out.println("Nombre del estudiante " + i);
            t.setNombre(input.next());
            System.out.println("Apellidos del estudiante " + i);
            t.setApellidos(input.next());

            if(progra.anadirEstudiante(t)) {
                System.out.println(t.getNombre() + " añadido correctamente.");
            }
            else {
                System.out.println(t.getNombre() + " no se pudo añadir.");
            }

            //Buscar alumnos 5 y 6 para comprobar que funciona bien
            if(i == 5 || i == 6) {
                short index = progra.searchEstudiante(t);
                if(index != -1) {
                    System.out.println("Estudiante " + t + " encontrado en la posición " + index);
                }
                else {
                    System.out.println("Estudiante " + i + " no encontrado en la programación.");
                }
            }
        }
        input.close();
    }
}
