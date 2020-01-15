package Ejercicios.Word1_Ejer3;
import java.util.Scanner;
public class App {
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        //Alimento nombreAlimento = new Alimento(nombre);
        System.out.println("Introduce la cantidad de lípidos");
        double lipidos = inp.nextDouble();
        System.out.println("Introduce la cantidad de hidratos de carbono");
        double hidratosCarbono = inp.nextDouble();
        System.out.println("Introduce la cantidad de proteínas");
        double proteinas = inp.nextDouble();
        System.out.println("Introduce si es de origen animal (0 = no 1 = si)");
        boolean origenAnimal = inp.nextBoolean();
        System.out.println("Introduce la cantidad de vitaminas");
        char vitaminasCont = inp.next().charAt(0);
        System.out.println("Introduce la cantidad de minerales");
        char mineralesCont = inp.next().charAt(0);
        System.out.println("Introduce el nombre del alimento");
        String nombre = inp.next();
        System.out.println("Introduce la descripción del alimento");
        String muestraAlimento = inp.next();
        Alimento todosLosAtributos = new Alimento(lipidos,hidratosCarbono,proteinas,origenAnimal,vitaminasCont,mineralesCont,nombre,muestraAlimento);
        System.out.println("¿Es dietético?: " + todosLosAtributos.esDietetico());
        System.out.println("Nombre alimento: " + todosLosAtributos.muestraAlimento());
        System.out.println("Contenido energético: " + todosLosAtributos.calculaContenidoEnergetico());
        System.out.println("¿Es apto para deportistas?: " + todosLosAtributos.esRecomendableParaDeportistas());
        
    }
}