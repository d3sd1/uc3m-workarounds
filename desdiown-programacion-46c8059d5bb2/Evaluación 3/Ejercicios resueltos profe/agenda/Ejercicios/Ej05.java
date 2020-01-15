package Ejercicios;

import java.util.*;

public class Ej05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<persona> agenda = new ArrayList();
        String nombre;
        String telefono;
        boolean salir = false;

        do {
            System.out.print("Nombre: ");
            nombre = sc.nextLine();
            System.out.print("Teléfono: ");
            telefono = sc.nextLine();

            persona p = new persona(nombre, telefono);
            agenda.add(p);

            System.out.println("¿Quieres añadir más contactos a la agenda? s/n");
            char continuar = sc.next().charAt(0);
            sc.nextLine();
            if (continuar == 'n') {
                salir = true;
            }
        } while (salir == false);

        System.out.println("Visualizo ArrayList");
        Iterator it = agenda.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        System.out.println("Vuelco los datos con addFirst y visualizo LinkedList");
        LinkedList<persona> lista1 = new LinkedList();
        it = agenda.iterator();
        while (it.hasNext()) {
            lista1.addFirst((persona) it.next());
        }
        it = lista1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        System.out.println("Vuelco los datos con addLast y visualizo LinkedList");
        LinkedList<persona> lista2 = new LinkedList();
        it = agenda.iterator();
        int contador=0;
        while (it.hasNext()) {
            lista2.addLast((persona) it.next());
            System.out.println(lista2.get(contador));
            contador++;
        }
        
    }
}
