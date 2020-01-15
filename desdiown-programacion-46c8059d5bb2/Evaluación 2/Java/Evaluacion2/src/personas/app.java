package personas;
import java.util.Scanner;
import static personas.personasClass.ANSI_BLUE;

public class app {
    public static void main(String[] args)
    {
        personasClass caller = new personasClass();
        Scanner input = new Scanner(System.in);
        boolean keepLoop = true;
        System.out.println("Agenda actual: ");
        caller.ver();
        while(keepLoop == true)
        {
            System.out.println("Introduce una acción (" + caller.ANSI_BLUE + "ayuda" + caller.ANSI_RESET + " muestra información): ");
            String accion = input.nextLine();
            caller.acciones(accion);
            if(accion.equals("salir"))
            {
                System.out.println("¡Adiós!");
                keepLoop = false;
            }
        }
    }
}