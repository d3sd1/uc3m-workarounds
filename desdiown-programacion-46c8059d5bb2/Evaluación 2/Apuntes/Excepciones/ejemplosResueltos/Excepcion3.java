/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package excepciones;

import java.util.*;

public class Excepcion3 {
    public static void main(String[] args) {
        /* metodo practico para leer de teclado*/
       Scanner teclado= new Scanner(System.in);
       int posicion=0;
       float[] Valores = new float[3];
       do
       {
         try{
             System.out.println("Introduzca posicion -1 para terminar:");
             posicion=teclado.nextInt();
             if(posicion!=-1){
                 System.out.println("Introduzca valor:");
                 int Valor =teclado.nextInt();
                 Valores[posicion]= Valor;
             }
         }

         catch(ArithmeticException e){
                    System.out.println("Error: division por cero.");
         }
         catch(InputMismatchException  e){
                    System.out.println("Error: ha tecleado un dato que no es numérico.");
         }
        catch(IndexOutOfBoundsException e){
            System.out.println("Error: indice fuera de rango");
        }
       }while(posicion!=-1);

    for(int i=0;i<3;i++) {
            System.out.println("posicion: " + i+ "  valor:"+ Valores[i]);
        }
    }


}
