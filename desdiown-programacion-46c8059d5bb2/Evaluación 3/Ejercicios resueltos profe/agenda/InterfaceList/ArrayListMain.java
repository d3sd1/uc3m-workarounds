
package InterfaceList;

import java.util.*;
public class ArrayListMain {
    public static void main(String[] args){
        Collection<String> c=new ArrayList(); //creo un objeto ArrayList y lo moldeo a               
        for(int i=0; i<10;i++){               // una Collection
            c.add(Integer.toString(i));
        }
        Iterator it =c.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    } 
}

