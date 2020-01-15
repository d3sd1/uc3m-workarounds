/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosCorregidosProfe;

import java.util.*;
public class Arrays {
    static Scanner teclado=new Scanner(System.in);
    public static void main(String [] args){
        final int N=10;
        int vector[]=new int[N];
        int x,sw=0;
        menullenar(vector);
        while (sw == 0) {

            System.out.println("------------------------------------------");
            System.out.println("ELIJE LA OPCION QUE DESEES EJECUTAR");
            System.out.println("------------------------------------------");
            System.out.println("1.BUSQUEDA DE UN NUMERO EN EL VECTOR");
            System.out.println("2.ORDENAR EL VECTOR");
            System.out.println("3.ELIMINAR ELEMENTOS REPETIDOS EN EL VECTOR");
            System.out.println("4.ELIMINAR UN ELEMENTO CONCRETO DEL VECTOR");
            System.out.println("5.INSERTAR UN ELEMENTO ORDENADO DENTRO DEL VECTOR");
            System.out.println("6.VOLVER A LLENAR EL VECTOR");
            System.out.println("7.SALIR DEL PROGRAMA");
            System.out.println("------------------------------------------");
            x=teclado.nextInt();
            switch (x) {
                case 1:
                    buscar(vector);
                    break;
                case 2:
                    ordenar(vector);
                    break;
                case 3:
                    ordenar(vector);
                    eliminarepe(vector);
                    break;
                case 4:
                    eliminar(vector);
                    break;
                case 5:
                    ordenar(vector);
                    insertar(vector);
                    break;
                case 6:
                    menullenar(vector);
                    break;
                case 7:
                    sw = 1;
                    break;
                default:
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("OPCION ERRONEA ELIJE UNA OPCION COMPRENDIDA ENTRE 1 Y 7");
                    System.out.println("-----------------------------------------------------------");
            }
        }
}
public static void llenar(int v[]){
    for (int i = 0; i < v.length; i++) {
        if (i < v.length-3) {
            v[i] = (int) (Math.random() * (9) + 1);
        } else {
            v[i] = -1;
        }
    }
    System.out.println("------------------------------------------");
    System.out.println("ESTE ES TU VECTOR LLENADO AUTOMATICAMENTE");
    System.out.println("------------------------------------------");
    visualizar(v);
}
public static void visualizar(int v[]){
    for (int i = 0; i < v.length; i++) {
        System.out.print(v[i] + ",");
    }
    System.out.println("");
}
public static void menullenar(int v[])
{
    int x;
    System.out.println("------------------------------------------");
    System.out.println("ELIJE LA OPCION QUE DESEES EJECUTAR");
    System.out.println("------------------------------------------");
    System.out.println("1.LLENADO AUTOMATICO DEL VECTOR.");
    System.out.println("2.LLENADO MANUAL DEL VECTOR");
    System.out.println("------------------------------------------");
    x = teclado.nextInt();
    switch (x) {
        case 1:
            llenar(v);
            break;
        case 2:
            llenarmano(v);
            break;
        default:
            System.out.println("OPCION ERRONEA.INTRODUCE O 1 O 2 ");
            menullenar(v);

}

}
public static void buscar(int v[])
{
    int n, sw = 0;
    System.out.println("------------------------");
    System.out.println("ESTE ES TU VECTOR");
    System.out.println("------------------------");
    visualizar(v);
    System.out.println("\nINTRODUCE UN NUMERO A BUSCAR");
    n = teclado.nextInt();
    for (int i = 0; i < v.length; i++) {
        if (v[i] == n) {
            System.out.println("------------------------------------------");
            System.out.println("\nEL NUMERO " + n + " SE ENCUENTRA EN LA POSICION" + i);
            System.out.println("------------------------------------------");
            sw = 1;
        }
    }
    if (sw == 0) {
        System.out.println(" EL NUMERO NO SE ENCUENTRA EN EL VECTOR ");
    }
}
public static void ordenar(int v[])
{

    int aux,sw=0;

    System.out.println("------------------------------------------");
    System.out.println("ESTE ES EL VECTOR ORDENADO");
    System.out.println("------------------------------------------");
    while(sw==0) {
        sw=1;
        for (int i=0; i<v.length-1 && v[i+1]!=-1;i++) {
            if (v[i] > v[i+1] ) {
                aux = v[i];
                v[i] = v[i+1];
                v[i+1] = aux;
                sw=0;
            }
        }
    }
    visualizar(v);
    System.out.println("\n");
}
public static void eliminarepe(int v[])
{
    int i, j, z;
    for (i = 0; i < v.length-1; i++) {
        for (j = i + 1; j < v.length; j++) {
            while (v[i] == v[j] && v[i] != -1) {
                for (z = j; z < v.length; z++) {
                    if(z==v.length-1){
                        v[z]=-1;
                    }
                    else{
                      v[z] = v[z + 1];
                    }
                  }
              }
          }
    }
    System.out.println("------------------------------------------");
    System.out.println("\nAHORA ELIMINAREMOS LOS REPETIDOS");
    System.out.println("------------------------------------------");
    visualizar(v);
 }
public static void eliminar(int v[])
{
    int n, i, j, sw = 0;
    visualizar(v);
    while (sw == 0) {
        System.out.println("\n INTRODUCE EL NUMERO A ELIMINAR:");
        n =teclado.nextInt();
        for (i = 0; i < v.length && sw==0; i++) {
            if (v[i] == n) {
                for (j = i; j < v.length; j++) {
                    if(j==v.length-1){
                        v[j]=-1;
                    }
                    else{
                       v[j] = v[j + 1];
                    }
                   sw = 1;
                }
             }
            if (sw == 0) {
               System.out.println("EL NUMERO NO SE ENCUENTRA EN EL VECTOR");
            }
         }
    }
    System.out.println("------------------------------------------");
    System.out.println("ESTE ES EL VECTOR SIN EL NUMERO ");
    System.out.println("------------------------------------------");
    visualizar(v);
}
public static void insertar(int v[])
{
    int n, i, j;
    if(v[v.length-1]!=-1){
        System.out.println("EL VECTOR ESTA LLENO, DEBES ELIMINAR PRIMERO");
    }
    else{
        System.out.println("\n INTRODUCE EL NUMERO QUE DESEES INSERTAR\n");
        n = teclado.nextInt();
        for (i = 0; i < v.length; i++) {
            if(n<=v[i] || v[i]==-1){
                for(j=v.length-1; j>i; j--){
                    v[j]=v[j-1];
                }
                v[i]=n;
                break;
            }
            
        }
        System.out.println("------------------------------------------");
        System.out.println("ESTE ES EL VECTOR CON EL NUMERO  " + n + " COLOCADO");
        System.out.println("------------------------------------------");
        visualizar(v);
    } 
}
public static void llenarmano(int v[])
{
    int n, i;

    for (i = 0; i < v.length-3; i++) {
        System.out.println("---------------------------------------------------");
        System.out.println("INTRODUCE LOS ELEMENTOS QUE QUIERAS EN EL VECTOR");
        System.out.println("---------------------------------------------------");
        System.out.println("INTRODUCE EL ELEMENTO" + (i + 1));
        n = teclado.nextInt();
        v[i] = n;
    }
    for (int j = i; j <v.length ; j++) {
        v[j] = -1;
    }
    System.out.println("------------------------------------------");
    System.out.println("ESTE ES EL VECTOR QUE TU MISMO HAS LLENADO");
    System.out.println("------------------------------------------");
    visualizar(v);
}   
}
