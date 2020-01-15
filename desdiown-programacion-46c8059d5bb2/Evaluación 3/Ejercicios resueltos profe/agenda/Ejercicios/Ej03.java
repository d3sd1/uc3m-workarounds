package Ejercicios;

import java.util.*;

public class Ej03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        int n1;
        int n2;
        int n3;
        boolean salir = false;
        TreeSet<alumno> lista = new TreeSet();

        do {
            System.out.print("Nombre del alumno: ");
            nombre = sc.nextLine();
            System.out.print("Nota 1: ");
            n1 = sc.nextInt();
            System.out.print("Nota 2: ");
            n2 = sc.nextInt();
            System.out.print("Nota 3: ");
            n3 = sc.nextInt();
            
            alumno a = new alumno(nombre, n1, n2, n3);
            lista.add(a);

            System.out.println("¿Quieres añadir más alumnos? s/n");
            char continuar = sc.next().charAt(0);

            sc.nextLine();
            
            if (continuar == 'n') {
                salir = true;
            }

        } while (salir == false);

        Iterator<alumno> it = lista.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

class alumno implements Comparable<alumno> {

    private String nombre;
    private int nota1;
    private int nota2;
    private int nota3;

    alumno(String nombre, int nota1, int nota2, int nota3) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public double media() {
        return (nota1 + nota2 + nota3) / 3;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n Media: " + media() + "\n";
    }

    @Override
    public int compareTo(alumno a) {
        if (this.nombre.compareTo(a.nombre) == 0) {
            if (this.nota1 == a.nota1) {
                if (this.nota2 == a.nota2) {
                    if (this.nota3 == a.nota3) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        } else {
            return this.nombre.compareTo(a.nombre);
        }
    }
}
