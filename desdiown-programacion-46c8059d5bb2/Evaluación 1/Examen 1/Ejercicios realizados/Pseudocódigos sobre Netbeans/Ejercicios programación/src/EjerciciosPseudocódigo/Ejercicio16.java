package EjerciciosPseudocódigo;
import java.util.Scanner;
public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num1 = input.nextInt();
        System.out.println("Introduce otro número: ");
        int num2 = input.nextInt();
        int num;
        String num_primos = "Ninguno";
        String es_perfecto = "Ninguno"; 
        for(num = num1; num >= num1 && num <= num2; num++)
        {
                for(int i = 2;i <= num;i++)
                {
                        if(num%i==0)
                        {
                                num_primos += ", " + num;
                        }
                }
                //Número perfecto
                int suma = 0;

            for(int i = 1; i < num; i++){ 
                if(num%i == 0){ 
                                suma += i;
                }
            }
                if(suma == num){ 
                es_perfecto = "Sí"; 
            }else{ 
                es_perfecto = "No"; 
            } 
        }
         System.out.println("Los números primos comprendidos entre " + num1 + " y " + num2 + " son: " + num_primos + ". ¿Es un número perfecto?: " + es_perfecto);
    }
}
