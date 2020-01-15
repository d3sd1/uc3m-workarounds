package EjerciciosProgramacion;
public class Ejercicio10 {
    public static void main(String[] args) {
        int numSup = 50;
        int numInf = 0;
        while(numSup >= 0 && numInf <= 50)
        {
            numInf++;
            System.out.println(numSup + ", " + numInf);
            numSup -= 2;
            numInf++;
        }
    }
    
}
