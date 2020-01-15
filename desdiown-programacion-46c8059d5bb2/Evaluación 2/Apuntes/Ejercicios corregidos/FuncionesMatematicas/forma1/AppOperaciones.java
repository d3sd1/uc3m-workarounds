
package forma1;

import java.util.Scanner;


class AppOperaciones {
    
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


class Operaciones {
    
     public static long factorial(int num){
        long resultado=1;
         num=absoluto(num);
        while(num>0){
            resultado*=num;
            num--;
        }
        return resultado;
    }
    public static long potencia(int base, int exponente){
        long resultado=1;
        for(int i=0; i<exponente; i++){
            resultado*=base;
        }
        return resultado;
    }
    public static boolean esPrimo(int num){
         num=absoluto(num);
        if((num!=2)&&(num%2==0)){
            return false;
        }
        for(int i=3; i<num/2; i+=2){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public static double absoluto(double x){
        if(x<0){
            return -x;
        }
        return x;
    }
     public static int absoluto(int x){
        if(x<0){
            return -x;
        }
        return x;
    }
   
   public static void signo (int num)
    {
	 if (num>0){
             System.out.println("El numero es positivo.");
         }
	 else
      {
	    if(num<0){
                System.out.println("El numero es negativo");
            }
            else{
                System.out.println("El numero es 0");
            }
	  }
	     
   } 
  public static boolean perfecto(int num)
    {
	 int cont, sum=0;
         num=absoluto(num);
	 for (cont=1;cont<num;cont++)
	  {
	   if (num%cont==0){
               sum=sum+cont;
           }
	  }
	 if(sum==num){
             return true;
         }
         else{
             return false;
         }	 
	} 
   public static  void divisores(int num)
   {
    int x;
         num=absoluto(num);
	System.out.print("Los divisores de "+num+" son: ");
	for(x=1;x<num;x++)
	 {
	  if(num%x==0){
              System.out.print(" "+x);
          }
	 }
   } 
}