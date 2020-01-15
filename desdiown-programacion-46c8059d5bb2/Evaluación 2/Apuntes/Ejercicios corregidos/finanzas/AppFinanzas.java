package finanzas;
import java.util.*;

public class AppFinanzas {
    public static void main(String [] args){
        Scanner teclado=new Scanner(System.in);
        Finanzas obj1=new Finanzas();
        System.out.println("Introduce las monedas de dolar que quieras cambiar");
        double monedolar=teclado.nextDouble();
        System.out.println("Tu cambio:"+obj1.dolaresToEuros(monedolar)+" euros");
        System.out.println("Introduce las monedas de euro que quieras cambiar");
        double moneEuro=teclado.nextDouble();
        System.out.println("Tu cambio:"+obj1.eurosToDolares(moneEuro)+ " dolares");
        System.out.println("a como esta el dolar?");
        double dolar=teclado.nextDouble(); 
        Finanzas obj2=new Finanzas(dolar);
        System.out.println("Introduce monedas de dolar");
        monedolar=teclado.nextDouble();
        System.out.println("Tu cambio:"+obj2.dolaresToEuros(monedolar)+ " euros");
        System.out.println("Introduce monedas de euro");
        moneEuro=teclado.nextDouble();
        System.out.println("Tu cambio:"+obj2.eurosToDolares(moneEuro)+ " dolares");
               
        
    }
    
}
