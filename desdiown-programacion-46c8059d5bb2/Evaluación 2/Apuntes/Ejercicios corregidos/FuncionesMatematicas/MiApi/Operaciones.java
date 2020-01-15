/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MiApi;

/**
 *
 * @author Carmen
 */
public class Operaciones {
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
