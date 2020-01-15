/*
	Escribir un programa que despues de visualizar una cabecera,
realiza sucesivas veces la lectura de dos numeros que representan los
lados de un rectangulo, y que visualiza el perimetro y el area
correspondiente. La aplicaci�n termina cuando se introduce un numero que
sea 0.
	La funcion principal realiza llamadas a tres funciones:
		1�: Visualiza la cabecera
      		Calculo del perimetro y area del rectangulo.
      2�: Calcula y visualiza el perimetro del rectangulo correspondiente.
		3�: Calcula el area del rectangulo correspondiente y la retorna
      		a la funcion principal que la visualiza.
                * */
package funciones;

import java.util.*;
 public class Ejer1FI {
    
  public static void main(String[] args){
 int a,b;
 Scanner teclado= new Scanner(System.in);
 
 do
 {
   cabecera();
   System.out.println("\n introduce los dos lados de un rectangulo : ");
   
   a=teclado.nextInt();
   b=teclado.nextInt();
   if(a!=0 && b!=0){
     calculo1(a,b);
     System.out.println("\narea:"+(calculo2(a,b)));
   }
 }while(a!=0 && b!=0);
 
}

static void cabecera()
{  System.out.println("\n\ncalculo de perimetro y area\n,0 para terminar");
}
static void calculo1(int b,int h)
{
   System.out.println("\nperimetro: "+((b*2)+(h*2)));
}
static int calculo2(int b,int h)
{
  return (b*h);
}
}




