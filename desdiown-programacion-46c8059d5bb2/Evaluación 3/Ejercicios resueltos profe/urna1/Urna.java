/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package profe.urna1;

import java.util.*;
public class Urna {
    private int numBolas;
    private HashSet urna;
    
    Urna(){
        numBolas=0;
        urna=new HashSet();
    }
    
  /*  public void introducirBola(Integer bola){
        boolean bolaRepe;
        bolaRepe= !(urna.add(bola));// si la bola no esta, añade y devuelve true, con lo que bolaRepe es false
        if (!bolaRepe){
            numBolas++;
        }
    } */ 
    
     public void introducirBola(Integer bola){
        boolean bolaValida;
        bolaValida= urna.add(bola);// si la bola no esta, añade y devuelve true
        if (bolaValida){
            numBolas++;
        }
    }  
    
        
     public Integer sacarBola(){
         Integer bola=null;
         Iterator it = urna.iterator();
         if(it.hasNext()){
             bola=(Integer) it.next();
             System.out.println("Saco la bola:"+bola);
             it.remove();
             numBolas--;
         }
         return bola;
     }
     
     public int getNumBolas(){
         return numBolas;
     }
     
     public void cambiarBolas(int max){
         urna.clear();
         for(int i=0;i<max;i++){
            int num=(int)(Math.random()*20);
            urna.add(new Integer(num));
         }
     }
        
    @Override
     public String toString()
    {
        Iterator it;
        String res = "";

        if(!urna.isEmpty())
        {

            it = urna.iterator();
            while(it.hasNext())
            {
                res = res + (Integer) it.next() + " ";
            }
        }
        else{
            System.out.println("Urna vacía");
        }    
        return res;
    }   
}
    
    
    
    
