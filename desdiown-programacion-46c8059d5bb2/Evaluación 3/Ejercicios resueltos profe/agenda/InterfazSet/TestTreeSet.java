package InterfazSet;

import java.util.*;

public class TestTreeSet {

    public static void main(String[] args) {
        TreeSet<String> ciudades = new TreeSet();
        ciudades.add("Madrid");
        ciudades.add("Barcelona");
        ciudades.add("Malaga");
        ciudades.add("Barcelona"); //Repetido
        ciudades.add("Vigo");
        ciudades.add("Sevilla");
        ciudades.add("Madrid"); // Repetido.
        Iterator it = ciudades.iterator();
        while (it.hasNext()) {
            System.out.println("Ciudad: " + it.next());
        }
        System.out.println("la coleccion tiene " + ciudades.size() + " elementos");
    }
}
