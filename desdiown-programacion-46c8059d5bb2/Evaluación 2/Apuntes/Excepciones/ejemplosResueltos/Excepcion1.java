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

public class Excepcion1 {
   public static void main(String[] args) {
       int num1=0;
       do
       {
         try{

                    /* metodo practico para leer de teclado*/
                    BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

                    System.out.println("Introduzca un numero, -1 para terminar:");
                    String numCad1=teclado.readLine();
                     num1=Integer.parseInt(numCad1);
                    float num2 = 8/num1;
                     System.out.println("8/" + num1+" = "+num2);

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
        

                    System.out.println("despues de catch.");


       }while(num1!=-1);
}
}
