package InterfazSet;

import java.util.*;

public class TestHashSet {

    public static void main(String[] args) {
        HashSet<String> ciudades = new HashSet();
        ciudades.add("Madrid");
        ciudades.add("Barcelona");
        ciudades.add("Malaga");
        ciudades.add("Barcelona");//repetido
        ciudades.add("Vigo");
        ciudades.add("Sevilla");
        ciudades.add("Madrid"); // Repetido.
        Iterator it = ciudades.iterator();
        while (it.hasNext()) {
            System.out.println("Ciudad: " + it.next());
        }
        System.out.println("la coleccion tiene " + ciudades.size() + " elementos");
        System.out.println("Ahora borro los elementos");
        ciudades.clear();
        System.out.println("la coleccion tiene " + ciudades.size() + " elementos");
    }
}
