/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package profe.urna1;

//import java.util.*;
public class TestUrna {
    public static void main(String[] args){
        Urna miUrna=new Urna();
        int maxBolas=(int)(Math.random()*17+4);//numero de bolas entre 4 y 20
        System.out.println("En mi urna caben "+maxBolas+"  bolas");
        for(int i=0;i<maxBolas;i++){
            int num=(int)(Math.random()*20); //numeros entre 0 y 19
            miUrna.introducirBola(new Integer(num));
         }
        //llenarUrna(miUrna,maxBolas);
        System.out.println("En mi urna tengo:"+miUrna.getNumBolas()+ "  bolas");
        System.out.println("Las bolas introducidas en la urna son :  " +  miUrna.toString());
        System.out.println("Saco una bola ");
        System.out.println(" He sacado: "+miUrna.sacarBola());
        //miUrna.sacarBola();
        System.out.println("En mi urna tengo:"+miUrna.getNumBolas()+ "  bolas");
        System.out.println("vacio la urna y la vuelvo a llenar");
        miUrna.cambiarBolas(maxBolas);
        System.out.println("En mi urna tengo:"+miUrna.getNumBolas()+ "  bolas");
        System.out.println("Las nuevas bolas introducidas en la urna son :  " +  miUrna.toString());
    }
    /*public static void llenarUrna(Urna miUrna,int maxBolas){
        for(int i=0;i<maxBolas;i++){
            int num=(int)(Math.random()*20);
            miUrna.introducirBola(new Integer(num));
         }
    }*/
    
}
