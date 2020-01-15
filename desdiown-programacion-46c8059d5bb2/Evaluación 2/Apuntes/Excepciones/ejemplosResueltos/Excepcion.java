/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package excepciones;

import java.io.*;

public class Excepcion {
    
 public static void main(String[] args) {
   InputStreamReader isr = new InputStreamReader(System.in);
   BufferedReader teclado= new BufferedReader(isr);
   int a,b;
   boolean error;
   do
   {
     try
     {
        error=false;
        System.out.println("Dame un numero ");
        String texto=teclado.readLine();
        a=Integer.parseInt(texto);
        System.out.println("Dame un numero ");
        texto=teclado.readLine();
        b=Integer.parseInt(texto);
        System.out.printf("La division de %d / %d = %d",a,b,a/b);
     }
     catch (Exception e)
     {
        error=true;
        System.out.println(e.getMessage());
         System.out.println(e.toString());
        System.out.println("\n Salida de printStackTrace():\n");
        e.printStackTrace();
         System.out.println("");
    }
  } while (error);
}
}


