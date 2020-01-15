package excepciones;
import java.util.*;
public class Excepcion1b
{
   public static void main (String args[])
   {
	Scanner teclado= new Scanner(System.in);
	int a,b=0;
	boolean error=false;
	do
	{
	 error=false;
         try
	  {
	   System.out.println("\n Dame un numero ");
	   a=teclado.nextInt();
           System.out.println("Dame un numero ");
	   b=teclado.nextInt();
	  // System.out.printf("La division de %d / %d = %d",a,b,a/b);
           System.out.println("la division de "+ a +" / "+ b+" = "+ a/b);
	  }
	 catch (InputMismatchException e)
	 {
	   error=true;
            System.out.println("Error: ha tecleado un dato que no es numérico.");
	//   System.out.println(e.getMessage());
          teclado=new Scanner(System.in);// limpiar buffer
	 }
        catch(Exception e) 
        {
         error=true;   
         System.out.println(e.getMessage());   
        }    
       } while (error);
       System.out.println("FIN");
   }
}
	
