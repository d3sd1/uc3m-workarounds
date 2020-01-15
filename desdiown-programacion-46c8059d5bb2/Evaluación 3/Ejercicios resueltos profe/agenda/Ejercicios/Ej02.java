package Ejercicios;

import java.util.*;

public class Ej02 {

    public static void main(String[] args) {
        TreeSet<persona> agenda = new TreeSet();
        Scanner teclado = new Scanner(System.in);
        String nb;
        String telf;

        System.out.println("introduce nombre o fin:");
        nb = teclado.nextLine();

        while (!nb.equals("fin")) {
            System.out.println("introduce telefono:");
            telf = teclado.next();
            persona p = new persona(nb, telf);
            System.out.println("el hash de persona es: " + p.hashCode());
            agenda.add(p);
            teclado.nextLine();
            System.out.println("introduce nombre o fin:");
            nb = teclado.nextLine();
        }

        for (persona a : agenda) {
            System.out.println(a);
        }
    }
}

class persona implements Comparable<persona> {

    private String nombre;
    private String telefono;

    public persona(String nombre, String telefono) {
        this.telefono = telefono;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public int compareTo(persona obj) {
        if (this.nombre.compareTo(obj.nombre) == 0) {
            return (this.telefono.compareTo(obj.telefono));
        } else {
            return this.nombre.compareTo(obj.nombre);
        }
    }
    @Override
    public String toString() {
        return (nombre + " " + telefono);
    }
}
