package alimentos;

import java.util.*;

public class AlimentosApp
{
    public static void main(String[] args)
    {
        String nombre,cadena;
        double lipidos,hidratos,proteinas;
        Boolean origen;
        char animal,vitaminas,minerales;
        Scanner teclado=new Scanner(System.in);

        System.out.print("Introduce el nombre del alimento: ");
        nombre=teclado.next();

        System.out.print("Introduce el % de lipidos: ");
        lipidos=teclado.nextDouble();

        System.out.print("Introduce el % de hidratos: ");
        hidratos=teclado.nextDouble();

        System.out.print("Introduce el % de proteinas: ");
        proteinas=teclado.nextDouble();

       /* System.out.print("Es de origen animal?");
        cadena=teclado.next();
        animal=cadena.charAt(0);
        origen = animal=='s' ? true : false;*/
        System.out.print("Es de origen animal true/false?");
        origen=teclado.nextBoolean();

        System.out.print("Introduce contenido vitaminas del alimento(A,M,B): ");
        //cadena=teclado.next();
        vitaminas=teclado.next().charAt(0);

        System.out.print("Introduce contenido minerales del alimento (A,M,B): ");
        cadena=teclado.next();
        minerales=cadena.charAt(0);

        Alimento alimento1=new Alimento(nombre,lipidos,hidratos,proteinas,origen,vitaminas,minerales);
        Alimento alimento2=new Alimento("tarta",80,50,43,false,'B','B');
        System.out.println(alimento1.muestraAlimento());

        System.out.println("El contenido energetico del alimento1 es: " +alimento1.calculaConenidoEnergetico());

        if(alimento1.esDietetico()==true){
            System.out.println("El alimento es dietetico.");
        }    
        else{
            System.out.println("El alimento no es dietetico");
        }
        if(alimento1.esRecomendableParaDeportistas()==true){
            System.out.println("El alimento es recomendable para deportistas.");
        }    
        else{
            System.out.println("El alimento no es recomendable para deportistas.");
        } 
       
        
        System.out.println(alimento2.muestraAlimento());

        System.out.println("El contenido energetico del alimento2 es: " +alimento1.calculaConenidoEnergetico());

        if(alimento2.esDietetico()==true){
            System.out.println("El alimento es dietetico.");
        }    
        else{
            System.out.println("El alimento no es dietetico");
        }
        if(alimento2.esRecomendableParaDeportistas()==true){
            System.out.println("El alimento es recomendable para deportistas.");
        }    
        else{
            System.out.println("El alimento no es recomendable para deportistas.");
        } 
         
    }
}
        

/*condicion ? accion1 : accion2

if(condicion)
    accion1
else
    accion2*/