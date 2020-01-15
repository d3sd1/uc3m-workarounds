package Ejercicios;

import java.text.*;
import java.util.*;

public class Ej04 {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String nombre;
        String apellido;
        String dni;
        Date fecha;
        boolean salir = false;
        ArrayList<persona_04> lista = new ArrayList();
        do {
            System.out.print("Nombre: ");
            nombre = sc.nextLine();
            System.out.print("Apellidos: ");
            apellido = sc.nextLine();
            System.out.print("dni: ");
            dni = sc.nextLine();
            System.out.print("Fecha de nacimiento (dd/mm/yyyy): ");
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());

            persona_04 persona = new persona_04(nombre, apellido, dni, fecha);
            lista.add(persona);

            System.out.println("¿Quieres añadir mas personas? s/n");
            char continuar = sc.next().charAt(0);
            sc.nextLine();

            if (continuar == 'n') {
                salir = true;
            }
        } while (salir == false);

        System.out.println("\nVisualizar sin ordenar\n");
        System.out.println("==============================");
        Iterator it = lista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            System.out.println("==============================");
        }

        Collections.sort(lista, new Comparator<persona_04>() {
            @Override
            public int compare(persona_04 p1, persona_04 p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        });

        System.out.println("\nVisualizar ordenado\n");
        System.out.println("==============================");
        it = lista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            System.out.println("==============================");
        }

        Collections.sort(lista, new Comparator<persona_04>() {
            @Override
            public int compare(persona_04 p1, persona_04 p2) {
                return p1.getFecha().compareTo(p2.getFecha());
            }
        });

        System.out.println("\nVisualizar ordenado por fecha de nacimiento\n");
        System.out.println("==============================");
        it = lista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            System.out.println("==============================");
        }
    }
}

class persona_04 {

    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaNacimiento;

    persona_04(String nombre, String apellido, String dni, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nApellido: " + apellido + "\nDNI: " + dni + "\nFecha de nacimiento: "
                + fechaNacimiento.getDate() + "/" + (fechaNacimiento.getMonth() + 1) + "/" + (fechaNacimiento.getYear() + 1900);
    }
}
