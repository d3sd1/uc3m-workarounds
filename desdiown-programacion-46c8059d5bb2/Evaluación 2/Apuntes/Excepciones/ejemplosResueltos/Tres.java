/**
 *
 * @author Carmen 
 * La salida por pantalla será:
 * Valor al final de finally: 2
 * Excepcion en metodo()
 * java.lang.NumberFormatException: For input string: "W"
 *       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:48)
 *       at java.lang.Integer.parseInt(Integer.java:449)
 *       at java.lang.Integer.parseInt(Integer.java:499)
 *       at Tres.metodo(Tres.java:36)
 *       at Tres.main(Tres.java:53)
 * El motivo será que se producirá una excepción en el bloque try al intentar
 * convertir a un entero el caracter W, entonces el flujo de ejecución pasará
 * al bloque catch donde se volverá a producir la la misma excepción por el 
 * mismo motivo, de este modo primero se ejecutará el bloque finally que 
 * escribirá por pantalla el valor de la variable y la excepción pasará a ser 
 * manejada por el bloque try que llamó a metodo() el cual manejará la excepción
 * en el bloque catch asociado. En este momento se escribirá por pantalla 
 * "Excepcion en metodo()" y la pila de llamadas a los métodos.
 */
package excepciones;

public class Tres 
{ 
      private static int metodo()
      { 
            int valor = 0; 
            try 
            { 
                  valor = valor +1; 
                  valor = valor + Integer.parseInt("W"); 
                  valor = valor + 1; 
                  System.out.println("Valor al final del try : " + valor); 
            } 
            catch (NumberFormatException e) 
            { 
                  valor = valor + Integer.parseInt("W"); 
                  System.out.println("Valor al final del catch : " + valor); 
            }
            finally
            { 
                  valor = valor + 1; 
                  System.out.println("Valor al final de finally: " + valor); 
            } 
            valor = valor + 1; 
            System.out.println ("Valor antes del return: " + valor); 
            return valor ; 
      } 

      public static void main (String[ ] args) 
      { 
            try 
            { 
                  System.out.println(metodo ()); 
            }
            catch (Exception e) 
            { 
                  System.err.println("Excepcion en metodo()") ; 
                  e.printStackTrace(); 
            } 
      } 
} 

 


