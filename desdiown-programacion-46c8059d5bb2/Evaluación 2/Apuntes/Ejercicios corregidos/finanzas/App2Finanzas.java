package finanzas;
import java.util.Scanner;

public class App2Finanzas{
    static Scanner teclado=new Scanner(System.in);
     public static void main(String [] args){
       // Scanner teclado=new Scanner(System.in);
	double dolar;
	System.out.println("1. Cambio Fijo");
        System.out.println("2. Cambio Variable");
	System.out.println("Introduce opcion:");
	int modo=teclado.nextInt();
	switch(modo){
	  case 1:
            Finanzas objeto1=new Finanzas();
	    menu2(objeto1);
	    break;
	  case 2:	
            System.out.println(" A como esta el dolar?:");
            dolar=teclado.nextDouble();			
            Finanzas objeto2=new Finanzas(dolar);
	    menu2(objeto2);          
	    break;
          default: 
            System.out.println("No has elegido ninguna opcion correcta");  
        }   
       }
      public static void menu2(Finanzas obj){
	  System.out.println("Elige que conversión necesitas");
          System.out.println("1. Cambio Dolares a Euros");
          System.out.println("2. Cambio Euros a Dolares");
	  System.out.println("elige opcion:");
	  int opcion=teclado.nextInt();
          switch(opcion){
             case 1:
               System.out.println("¿Cuantos dolares quieres convertir a euros?:");
               double monedolar=teclado.nextDouble();
               System.out.println("Tu cambio:"+obj.dolaresToEuros(monedolar)+"€");
               break;
             case 2:
               System.out.println("¿Cuantos euros quieres convertir a dolares?:");
               double moneeuro=teclado.nextDouble();
               System.out.println("Tu cambio:"+obj.eurosToDolares(moneeuro)+"$");
               break;
             default:
               System.out.println("No has elegido ninguna opcion correcta");
          }
        }
    }
	
	
