/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carmen
 */
package excepciones;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.*;
public class Excepcion2b {

    
    public static void main(String[] args) {
        /* metodo practico para leer de teclado*/
       Scanner teclado= new Scanner(System.in);
       int Posicion=0;
       float[] Valores = new float[3];
       do
       {
         try{

             
             System.out.println("Introduzca posicion:");
             Posicion=teclado.nextInt();
             //teclado=new Scanner(System.in);//limpiar buffer

             System.out.println("Introduzca valor:");
             int Valor =teclado.nextInt();
             //teclado=new Scanner(System.in);
             //float Auxiliar = 8/Valor;
             Valores[Posicion]= Valor;
            

         }

         catch(ArithmeticException e){
                    System.out.println("Error: division por cero.");

                }
          
         catch(InputMismatchException  e){
                    System.out.println("Error: ha tecleado un dato que no es numérico.");

                }
        catch(IndexOutOfBoundsException e){
            System.out.println("Error: indice fuera de rango");
           // e.printStackTrace();
        }

        System.out.println("despues de catch.");

        teclado=new Scanner(System.in);
       }while(Posicion!=-1);
       
for(int i=0;i<3;i++) {
            System.out.println("posicion: " + i+ "  valor:"+ Valores[i]);
        }
    }

}
