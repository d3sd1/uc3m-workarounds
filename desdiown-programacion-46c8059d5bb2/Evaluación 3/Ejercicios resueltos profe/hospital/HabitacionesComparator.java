/********************************************************/
package hospital;
import java.util.*;

public class HabitacionesComparator implements Comparator<Paciente>
{
    @Override
    public int compare(Paciente o1,Paciente o2){
        return(o1.getNumHab()-o2.getNumHab());
    }
}
/* la forma anterior esta mejor, pero las dos hacen lo mismo y de la misma forma
public class HabitacionesComparator implements Comparator
{
    public int compare(Object o1, Object o2)
    {
        Paciente paciente1 = (Paciente)o1;
        Paciente paciente2 = (Paciente)o2;
        if(paciente1.getNumHab()> paciente2.getNumHab())
            return 1;
        else if(paciente1.getNumHab()< paciente2.getNumHab())
            return -1;
        return 0;

    }
}
*/