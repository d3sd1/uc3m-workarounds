
package ClaseMatrices;

public class Matrices {
    public static void main(String[] args) {
        MatricesPrivadas matrizGenerada = new MatricesPrivadas(5,false,true);
        System.out.println("Matriz generada: ");
        matrizGenerada.visualizarMatriz();
        System.out.println("Matriz ordenada: ");
        matrizGenerada.ordenarMatriz();
        matrizGenerada.visualizarMatriz();
        System.out.println("Valor posición 0,0: " + matrizGenerada.devolverPosicion(0,0));
        matrizGenerada.modificarPosicion(0,0,5);
        System.out.println("Nuevo valor posición 0,0: " + matrizGenerada.devolverPosicion(0,0));
        matrizGenerada.modificarPosicion(0,0,5);
        matrizGenerada.visualizarMatriz();
        System.out.println("Buscado número 5 en matriz: Posición " + matrizGenerada.buscarEnMatriz(5));
    }
}
