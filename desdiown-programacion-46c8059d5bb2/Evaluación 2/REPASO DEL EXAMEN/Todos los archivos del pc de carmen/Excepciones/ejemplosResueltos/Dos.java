/**
 *
 * @author Carmen 
 * La salida por pantalla será:
 * - Valor al final del catch: 43
 * - Valor al final de finally: 44
 * - Valor antes del return: 45
 * - 45
 * El motivo es que se producirá una excepción NumberFormatException al intentar
 * convertir el caracter W en un entero con lo que la ejecución del programa
 * pasará al bloque catch sin llegar a ejecutar la línea que imprime por pantalla
 * el valor de la variable al final del try. El bloque catch sumará 42 a la 
 * variable valor y la imprimirá por pantalla. 
 * Después de esto se ejecutará el bloque finally que incrementará
 * en uno el valor de la variable y lo mostrará por pantalla. Por último se volverá
 * a incrementar el valor de la variable en 1 y se mostrará por pantalla antes
 * de ejecutar el return. El bloque catch del programa principal NO se ejecutará
 * porque la excepción ya se habrá manejado en metodo().
 */
package excepciones;

public class Dos
{
      private static int metodo() 
      { 
            int valor=0; 
            try 
            { 
                  valor = valor+1; 
                  valor = valor + Integer.parseInt("W"); 
                  valor = valor + 1; 
                  System.out.println("Valor al final del try: " + valor); 
            } 
            catch(NumberFormatException e) 
            { 
                  valor = valor + Integer.parseInt("42"); 
                  System.out.println("Valor al final del catch: " + valor);
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
      
      public static void main (String[] args) 
      { 
            try 
            { 
                System .out.println(metodo()); 
            }
            catch (Exception e) 
            { 
                  System.err.println("Excepcion en metodo()"); 
                  e.printStackTrace(); 
            } 
      } 
} 


