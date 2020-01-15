/* programa q simule una caja registradora de un supermercado con las siguientes
especificaciones:
pondra una cabecera para cada cliente = SUPERMERCADO TIERNO
para cada cliente tomara precios de articulos
se dara por terminada la entrada de datos para un cliente el introducir un -1
se expondra el total del precio de la compra
se introducira el pago del cliente. Se pedira nuevo pago hasta q sea mayor o igual
q el precio de la compra
se mostrara el cambio q hay que devolver
clientes mientras introduces s */

package funciones;

import java.util.*;
 public class Ejer4FI {
  static int cont=0;  
  public static void main(String[] args){
	char seguir='s';
    double precio, pago,pago_parcial;
	String cad;
   Scanner teclado= new Scanner(System.in); 

   while(seguir=='s' || seguir=='S')
   {
      cabecera();
      precio=cliente();
      System.out.println("\n\tTOTAL: "+precio+" euros");
      System.out.println("\n\tPago: ");
      pago_parcial=teclado.nextDouble();
      pago=pago_parcial;
     	while(pago<precio)
        {
     		System.out.println("\n\tPago incorrecto le falta "+(precio-pago));
        	System.out.println("\n\tResto Pago: ");
	     	pago_parcial=teclado.nextDouble();
            pago+=pago_parcial;
     	}
     	devolucion(precio,pago);
     	System.out.println("\n\n\tGRACIAS POR SU COMPRA");
        System.out.println("\n Existe nuevo cliente(introduce s o n): ");
		cad=teclado.next();
        seguir=cad.charAt(0);
   	
   }
   System.out.println("\n Hasta pronto");
  }

public static double cliente()
{
	double pvp,suma=0;
   int art=0;
   Scanner teclado= new Scanner(System.in); 
   System.out.println("\n Precio del articulo (-1 salir): ");
   pvp=teclado.nextDouble();
   while(pvp!=-1)
   {
   	suma=suma+pvp;
      art++;
      System.out.println("\n Precio del articulo (-1 salir): ");
      pvp=teclado.nextDouble();
   }
   System.out.println("\n\tTOTAL ARTICULOS: "+art);
   return (suma);
}
public static void devolucion(double total, double dinero)
{
	double resul;
	resul=dinero-total;
   System.out.println("\n\tDEVOLVER: "+resul+" euros");
}
public static void cabecera()
{
  
  cont=cont+1;
  System.out.println("\n\t *********************");
  System.out.println("\n\t  SUPERMERCADO TIERNO");
  System.out.println("\n\t *********************\n");
  System.out.println("\n\t cliente numero: "+cont);
}  
}