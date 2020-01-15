

/**
 *
 * @author Carmen 
 * La salida por pantalla será:
 * Valor al final de finally: 2
 * Excepcion en metodo()
 * java.lang.NumberFormatException: For input string: "W"
 *       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
 *       at java.lang.Integer.parseInt(Integer.java:481)
 *       at java.lang.Integer.parseInt(Integer.java:514)
 *       at Cuatro.metodo(Cuatro.java:31)
 *       at Cuatro.main(Cuatro.java:55)
 * El motivo es que se produce una excepción del tipo NumberFormatException
 * al intentar convertir a entero el caracter "W", en este momento el bloque
 * catch no la manejará pues esta excepción no es una excepción de Entrada/Salida
 * con lo que pasará a ejcutarse el bloque finally que escribirá el valor de la
 * variable al final del bloque finally y a continuación el flujo de ejecución 
 * del programa continuará en el  bloque catch del bloque try que ha llamado a 
 * metodo, en este caso las excepciones que se manejan en este bloque son de la
 * clase Exception, como una excepción de tipo NumberFormatException hereda de
 * esta clase la excepción se manejará escribiendo por pantalla Excepcion en metodo
 * y la pila de llamadas a los métodos.
 */
package excepciones;

import java.io.*;

public class Cuatro 
{ 
      private static int metodo() 
      { 
            int valor = 0; 
            try 
            { 
                  valor = valor+1; 
                  valor = valor + Integer.parseInt("W"); 
                  valor = valor + 1; 
                  System.out.println("Valor al final del try : " + valor); 
                  throw new IOException(); 
            } 
            catch (IOException e) 
            { 
                  valor = valor + Integer.parseInt("42"); 
                  System.out.println("Valor al final del catch :"  + valor); 
            }
            finally
            { 
                  valor = valor + 1; 
                  System.out.println("Valor al final de finally: " + valor); 
            } 
            valor = valor + 1; 
            System.out.println ("Valor antes del return: " + valor) ; 
            return valor ; 
      } 

      public static void main(String[] args) 
      { 
            try 
            { 
                  System.out.println(metodo()); 
            }
            catch (Exception e) 
            { 
                  System.err.println("Excepcion en metodo()"); 
                  e.printStackTrace(); 
            } 
      } 
} 
