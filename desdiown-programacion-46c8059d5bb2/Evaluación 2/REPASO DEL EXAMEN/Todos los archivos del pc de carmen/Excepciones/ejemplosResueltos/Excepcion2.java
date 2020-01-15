/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carmen
 */
package excepciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Excepcion2 {

    
    public static void main(String[] args) {
        /* metodo practico para leer de teclado*/
       BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
       int Posicion=0;
       float[] Valores = new float[3];
       do
       {
         try{

             
             System.out.println("Introduzca posicion:");
             String numCad1=teclado.readLine();
             Posicion=Integer.parseInt(numCad1);


             System.out.println("Introduzca valor:");
             String numCad2=teclado.readLine();
             int Valor =Integer.parseInt(numCad2);
             //float Auxiliar = 8/Valor;
             Valores[Posicion]= Valor;
            

         }

         catch(ArithmeticException e){
                    System.out.println("Error: division por cero.");

                }
           catch(IOException e){
                    System.out.println("Error en la entrada de datos.");
                    System.exit(1);

                }
         catch(NumberFormatException e){
                    System.out.println("Error: ha tecleado un dato que no es numérico.");

                }
        catch(IndexOutOfBoundsException e){
            System.out.println("Error: indice fuera de rango");
            e.printStackTrace();
        }

                    System.out.println("despues de catch.");


       }while(Posicion!=-1);
       
for(int i=0;i<3;i++)
     System.out.println("posicion   :" + i+ "valor   :"+ Valores[i]);
    }

}
