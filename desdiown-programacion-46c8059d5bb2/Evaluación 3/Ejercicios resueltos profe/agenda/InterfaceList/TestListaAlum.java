package InterfaceList;

import java.util.*;

public class TestListaAlum {

    static double media;

    public static void main(String args[]) {
        Scanner leer = new Scanner(System.in);
        int op;
        ArrayList<NodoLista> lista = new ArrayList();
        do {
            NodoLista nodo = new NodoLista();
            System.out.println("Ingrese el nombre del alumno:");
            String nombre=leer.nextLine();
            nodo.setNom(nombre);
            System.out.println("Ingrese la primera calificación:");
            int c1 = leer.nextInt();
            nodo.setCalif1(c1);
            System.out.println("Ingrese la segunda calificación:");
            int c2 = leer.nextInt();
            nodo.setCalif2(c2);
            System.out.println("Ingrese la tercera calificación:");
            int c3 = leer.nextInt();
            nodo.setCalif3(c3);
            nodo.setMedia(promedio(c1, c2, c3));
            lista.add(nodo);
            System.out.println("¿Desea ingresar otro alumno?");
            System.out.println("1.-Si\t 2.-No");
            op = leer.nextInt();
            leer.nextLine();
        } while (op != 2);
        Iterator it = lista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next() + "");
        }
    }

    private static double promedio(int calif1, int calif2, int calif3) {
        int suma = calif1 + calif2 + calif3;
        double media = suma / 3;
        return media;
    }
}
