/**
 *
 * @author Carmen 
 * La salida por pantalla será la siguiente:
 * - Valor al final del try: 44
 * - Valor al final de finally: 45
 * - Valor antes del return: 46
 * - 46
 * El motivo es que no se producirá ninguna excepción en el bloque try del 
 * método() con lo que no se ejecutará ninguna sentencia del bloque catch. Sin
 * embargo como el bloque finally se ejecuta siempre el programa imprimirá el 
 * valor al final de finally y cuando termine de ejecutar este bloque pasará
 * a imprimir el valor antes del return. Por último la sentencia System.out.println
 * mostrará por pantalla el valor devuelto por metodo() y con esto concluirá 
 * el programa.
 */
package excepciones;

public class Uno
{ 
      private static int metodo() 
      { 
            int valor=0; 
            try 
            { 
                  valor = valor + 1; 
                  valor = valor + Integer.parseInt("42"); //convierte cadena en entero
                  valor = valor + 1; 
                  System.out.println("Valor al final del try: " + valor); 
            }
            catch (NumberFormatException e)
            { 
                  valor = valor + Integer.parseInt("42"); 
                  System.out.println("Valor al final del catch: " + valor) ; 
            }
            finally
            { 
                  valor = valor + 1; 
                  System.out.println("Valor al final de finally: " + valor); 
            } 
            valor = valor + 1; 
            System.out.println ("Valor antes del return: " + valor) ; 
            return valor; 
      } 
      
      public static void main(String[] args) 
      { 
            try 
            { 
                  System.out.println (metodo()); 
            }
            catch (Exception e)
            { 
                  System.err.println("Excepcion en metodo()") ; 
                  e.printStackTrace(); 
            } 
      } 
} 
