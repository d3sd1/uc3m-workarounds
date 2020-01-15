/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forma2;

import MiApi.Operaciones;
import java.util.Scanner;

/**
 *
 * @author Carmen
 */
public class AppOperacionesApi {
      public static Scanner leer= new Scanner (System.in);
   public static void main (String args[])
   {
    char opc;
	int n;
    
	System.out.print("Introduce un numero: ");
	n=leer.nextInt();
        
	do
	 {
           opc=menu();
	   switch(opc){
	     case 'a':
		     Operaciones.signo(n);
			 break;
	     case 'b':
		    if(Operaciones.esPrimo(n)){
                        System.out.println("El numero es primo");
                    }
                    else{
                        System.out.println("NO es primo");
                    }
		    break;
	     case'c':
		    if(Operaciones.perfecto(n)){
                        System.out.println("(El numero es perfecto");
                    }
                    else{
                        System.out.println("NO es perfecto");
                    }
		    break;
	     case'd':
		       System.out.println("Su valor absoluto es:"+Operaciones.absoluto(n));               
		       break;  
	     case'e':
		     Operaciones.divisores(n);
		     break;
             case'f':
                   System.out.println("Su factorial es:"+Operaciones.factorial(n));
                    break;
	     case'g':
		     System.out.println("Adios!");
		     break;
	     default:
		      System.out.println("Has elegido mal la opcion!!!");
           }    
	   }while(opc!='g');
	}

	//FUNCION 1
   public static char menu ()
   {
       char opc;
	String cad;
	
	System.out.println("\n-----------------------------");
	System.out.println("a.-Si es positivo o negativo ");
	System.out.println("b.-Si es primo               ");
	System.out.println("c.-Si es perfecto            ");
	System.out.println("d.-Su valor absoluto");
	System.out.println("e.-Visualizar sus divisores  ");
        System.out.println("f.-Visualizar su factorial  ");
	System.out.println("g.-Salir                     ");
	System.out.println("------------------------------ ");
	System.out.print("Selecciona una opcion: ");
	cad=leer.next();
	opc=cad.charAt(0);
	return opc;
   }
    
}
    
    

