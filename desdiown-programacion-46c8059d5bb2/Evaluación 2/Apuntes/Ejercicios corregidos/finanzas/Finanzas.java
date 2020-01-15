
/** Realizar una clase finanzas que convierta dolares a � y viceversa. La clase tiene que tener:
 * un atributo "cambio: double"; un constructor por defecto el cual establecer� el cambio dolar-�
 * en 1,36; otro constructor (double), el cual permitir� configurar el cambio dolar-�;
 * un metodo dolaresToEuros(mis dolares); otro metodo eurosToDolares(mis euros);
 */
package finanzas;
 
public class Finanzas {
   private double cambio;
   
   Finanzas(){
    cambio=1.36;
}
   Finanzas(double c){
       this.cambio=c;
   }
   double dolaresToEuros(double dolares){
       return dolares/cambio;
   }
   double eurosToDolares(double euros){
       return euros*cambio;
   }
   
   
}
