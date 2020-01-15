package Semana12;

public class Ejercicio3 {
    public static void main(String[] args) {
        factorial(5);
        /*
        Secuencia de invocaciones: Primero de arriba a abajo para la ejecución, y una vez llega a uno vuelve hacia arriba con los resultados.
        factorial(5); -> returns 120
        factorial(4); -> returns 24
        factorial(3); -> returns 6
        factorial(2); -> returns 2
        factorial(1); -> returns 1

        Por ende, al final devuelve como resultado 120.
        La recursividad no es infinita ya que la función tiene el tope n=1/n=0, de no tenerlo, continuaría ejecutándose con números negativoss y nunca ascendería.
         */
    }
    public static long factorial (int n){
        //Base case the self-invocation will stop here
        if (n==1 || n==0)
            return 1;
        //General case, we divide the problem in a simpler problem
        //and invoke again the method
        return n*factorial(n-1);
    }
}
