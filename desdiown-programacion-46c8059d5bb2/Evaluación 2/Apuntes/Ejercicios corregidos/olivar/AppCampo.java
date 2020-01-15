/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olivar;

/**
 *
 * @author user
 */
public class AppCampo {
     public static void main(String[] args) {
       Campo olivo1=new Campo(10,30); //objeto
       Campo olivo2=new Campo(40); //objeto
       Campo olivo3=new Campo();
       System.out.println("datos del olivo3");
       System.out.println(olivo3.toString());
       System.out.println("La edad del olivo1 es: "+olivo1.getEdad());
       olivo1.setEdad(20);//cambio edad olivo1
       System.out.println("La nueva edad del olivo1 es: "+olivo1.getEdad());
       int precioKilo=4;
       double beneficios1=olivo1.beneficio(2);
       System.out.println("El beneficio del primer olivo es: "+beneficios1);

       // double beneficios2=olivo2.beneficio(precioKilo);
       System.out.println("El beneficio del segundo olivo es: "+olivo2.beneficio(precioKilo));

       System.out.println("La edad del olivo2 es: "+olivo2.getEdad());
       //olivo2.sumaEdad(40); // incremento edad mediante función
       System.out.println("La nueva edad del olivo2 es: "+olivo2.getEdad());

       System.out.println("El numero de olivas del olivo2 es: "+olivo2.getKilos());
       //olivo2.sumaOlivas(20); //incremento el numero de olivas
       System.out.println("El numero de olivas del olivo2 es: "+olivo2.getKilos());
         System.out.println("datos del olivo1");
       System.out.println(olivo1.toString());
      Campo olivo4=new Campo(100);
      olivo4.setEdad(olivo1.getKilos());
         
    }

    
}
