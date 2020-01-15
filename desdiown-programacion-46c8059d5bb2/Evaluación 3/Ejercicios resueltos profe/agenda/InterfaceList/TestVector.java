package InterfaceList;

import java.util.*;

public class TestVector {

    public static void main(String[] args) {
        Vector<String> vectorStrings = new Vector();

        vectorStrings.add("Jorge");
        vectorStrings.add("Ana");
        vectorStrings.add("Luis");
        vectorStrings.add("Pedro");
        vectorStrings.add("Laura");

        for (String str : vectorStrings) {
            System.out.println(str);
        }
        System.out.println("el primer elemnto del vector es:" + vectorStrings.get(2));
        System.out.println("el ultimo elemnto del vector es:" + vectorStrings.lastElement());
        if (vectorStrings.contains("Luis")) {
            System.out.println("Luis se encuentra en el vector en la posición."
                    + vectorStrings.indexOf("Luis"));
        } else {
            System.out.println("Luis NO se encuentra en el vector ");
        }
        System.out.println("Eliminamos a Pedro");
        vectorStrings.remove("Pedro");
        //insertamos un elemento en una posicion determinada, desplaza los que haya despues
        vectorStrings.add(2, "Pepe");
        //visualizar un elemento determinado
        System.out.println("el elemento de la posicion 2 es: " + vectorStrings.get(2));
        System.out.println("El nuevo vector");
        for (String str : vectorStrings) {
            System.out.println(str);
        }
        //Cuantos elementos tenemos y cual es su capacidad, por defecto es 10
        System.out.println("el vector tiene : " + vectorStrings.size() + " elementos");
        System.out.println("La capacidad del vector es:" + vectorStrings.capacity());
    }
}
