package InterfazSet.agenda;

import java.util.*;

public class appPersona {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Set<Persona> agenda = new TreeSet();            //    A
        //Set <Persona> agenda = new HashSet(); //     B
        String nb;
        String telf;
        System.out.println("introduce nombre o fin:");
        nb = teclado.nextLine();
        while (!nb.equals("fin")) {
            System.out.println("introduce telefono:");
            telf = teclado.next();
            Persona p = new Persona(nb, telf);
            agenda.add(p);
            teclado.nextLine();
            System.out.println("introduce nombre o fin:");
            nb = teclado.nextLine();
        }
        Iterator<Persona> it = agenda.iterator();
        while (it.hasNext()) {
            System.out.println("Nombre: " + it.next());
        }
    }
}
