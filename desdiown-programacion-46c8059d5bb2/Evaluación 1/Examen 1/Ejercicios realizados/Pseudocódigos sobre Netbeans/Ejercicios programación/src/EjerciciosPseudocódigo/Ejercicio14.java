package EjerciciosPseudocódigo;
import java.util.Scanner;
public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int calCount = 0;
        int calSum = 0;
        int alumAprob = 0;
        int alumSusp = 0;
        int alumTotal = 0;
       for(int lastNum = 1;lastNum > 0;lastNum++)
       {
           System.out.println("Introduce calificación (-1 para parar): ");
           int thisNote = input.nextInt();
           if(thisNote != -1)
           {
               if(thisNote > 10 || thisNote < 0)
               {
                   System.out.println("Debes introducir una nota válida");
               }
               else
               {
                calSum += thisNote;
                if(thisNote < 5)
                {
                    alumSusp++;
                }
                else if(thisNote >= 5)
                {
                    alumAprob++;
                }
                alumTotal++;
               }
              calCount++;
           }
           else
           {
               break;
           }
       };
       System.out.println("La nota media del grupo es: "  + (calSum/calCount)  + ", con " + alumAprob + " aprobados y " + alumSusp + " suspensos, total alumnos: " + alumTotal);
    }
    
}
