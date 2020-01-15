
package InterfaceList;
import java.util.*;
public class TestArrayList
{
	public static void main(String[] args)
	{
		List<String> ciudades = new ArrayList();
		ciudades.add("Madrid");
		ciudades.add("Barcelona");
		ciudades.add("Malaga");
		ciudades.add("Vigo");
		ciudades.add(1,"Sevilla");
		ciudades.add("Madrid"); // Repetido.
		Iterator it = ciudades.iterator();
		while(it.hasNext())
		{
		  String elemento=(String) it.next();
		  System.out.println("Ciudad: " + elemento);
		}  
	}
}

