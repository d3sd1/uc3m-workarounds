
package Ejercicios;

import java.util.*;

public class Ej01 {
    public static void main(String[]args){
        HashSet<String> hashset = new HashSet();
        hashset.add("cadena 1");
        hashset.add("cadena 2");
        hashset.add("cadena 3");
        hashset.add("cadena 4");
        hashset.add("cadena 1");
        
        for(String b:hashset){
            System.out.println(b);
        }
    }
}
