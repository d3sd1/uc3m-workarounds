package realizarOperaciones;
import java.util.Scanner;
public class appOperaciones {
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Bienvenido a la calculadora de Windows hackeada.");
        String operacionARealizar = input.next();
        
        Operacion operador = new Operacion();
        boolean finalizarPrograma = false;
        while(finalizarPrograma == false)
        {
            try
            {
                System.out.println("Introduce la operación a realizar: ");
                Object resultado = operador.operar(operacionARealizar);
                System.out.println(Operacion.ANSI_GREEN + "Resultado: " + resultado + Operacion.ANSI_RESET);
                System.out.println("¿Quieres realizar otra cuenta?  [S/N]");
                if(input.next().charAt(0) != 'S' || input.next().charAt(0) != 's')
                {
                    finalizarPrograma = true;
                    System.out.println("¡Aprende a contar mejor!");
                }
            }
            catch(Exception e)
            {
                System.out.println(Operacion.ANSI_RED + "¡La cuenta realizada no pudo hacerse!" + Operacion.ANSI_RESET);
            }
        }
    }
}
