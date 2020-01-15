/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist2ComparatorComparable;

/**
 *
 * @author user
 */
import java.util.*;
public class AppPersonaComparatorComparable {
        public static void main(String[] args) {

        List<Persona> lista = new ArrayList();

       
        Persona persona1 =
           new Persona("Francisco Javier","Martínez Páez","11111111A",25);
        
        Persona persona2 =
            new Persona("Roberto","Canales Mora","22222222B",18);
       
        Persona persona3 =
            new Persona("Alejandro","Pérez García","33333333C",23);
        
        Persona persona4 =
            new Persona("Germán","Jiménez Centeno","44444444D",20);
     
        Persona persona5 =
            new Persona("Pablo","Blanco Criado","55555555E",17);
     
        Persona persona6 =
            new Persona("Ana","Blanco Criado","66666666F",20);

        lista.add(persona1);
        lista.add(persona2);
        lista.add(persona3);
        lista.add(persona4);
        lista.add(persona5);
        lista.add(persona6);

        System.out.println("---------- SIN ORDENAR ------------");
        pintaLista(lista);
        //RECORRERLA CON ITERADOR
        System.out.println(
                "---------- ORDEN NATURAL DEFINIDO en compareTo ------------");
        Collections.sort(lista);
        pintaLista(lista);
        System.out.println("---------- POR EDAD ------------");
        Collections.sort(lista, new EdadPersonaComparator());
        pintaLista(lista);
}
    public static void pintaLista(List lista) {
        for(int i=0;i<lista.size();i++) {
            System.out.println(lista.get(i));
        }
    }


    
    
}
