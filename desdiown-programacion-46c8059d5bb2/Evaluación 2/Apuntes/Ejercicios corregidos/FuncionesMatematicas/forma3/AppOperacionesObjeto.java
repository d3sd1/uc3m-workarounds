/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forma3;

import MiApi.*;
import java.util.Scanner;

/**
 *
 * @author Carmen
 */
public class AppOperacionesObjeto {
       public static Scanner leer= new Scanner (System.in);
   public static void main (String args[])
   {
        char opc;
	int n;
      //  Operaciones calculator=new Operaciones(); /* al utilizar un OBJETO los metodos no tienen que ser static*/
        Operaciones2 calculator=new Operaciones2();
	System.out.print("Introduce un numero: ");
	n=leer.nextInt();
        
	do
	 {
           opc=menu();
	   switch(opc){
	     case 'a':
		     calculator.signo(n);
			 break;
	     case 'b':
		    if(calculator.esPrimo(n)){
                        System.out.println("El numero es primo");
                    }
                    else{
                        System.out.println("NO es primo");
                    }
		    break;
	     case'c':
		    if(calculator.perfecto(n)){
                        System.out.println("(El numero es perfecto");
                    }
                    else{
                        System.out.println("NO es perfecto");
                    }
		    break;
	     case'd':
		       System.out.println("Su valor absoluto es:"+calculator.absoluto(n));               
		       break;  
	     case'e':
		     calculator.divisores(n);
		     break;
             case'f':
                   System.out.println("Su factorial es:"+calculator.factorial(n));
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
