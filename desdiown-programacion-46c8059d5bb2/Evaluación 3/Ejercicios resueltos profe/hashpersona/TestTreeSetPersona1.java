/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplos.hashpersona;

/**
 *
 * @author carmen
 */
import java.util.*;

public class TestTreeSetPersona1 {
  public static void main(String[] args){
    Scanner teclado=new Scanner(System.in);
    //Set <Persona1> agenda = new HashSet <Persona1>();
   Set <Persona1> agenda = new TreeSet <>();
    String nb;
    String telf;
    System.out.println("introduce nombre o fin:");
    nb=teclado.nextLine();
    while(!nb.equals("fin"))
    {
      System.out.println("introduce telefono:");
      telf=teclado.next();
      Persona1 p = new Persona1(nb,telf);
        System.out.println("el hash de persona es: "+p.hashCode());
      agenda.add(p);
      teclado.nextLine();
      System.out.println("introduce nombre o fin:");
      nb=teclado.nextLine();
    }
    Iterator <Persona1> it = agenda.iterator();
    while(it.hasNext()){
      System.out.println("Nombre: " + it.next());
    }  
  }
}
