
package GarajeVehiculos;

import java.util.Scanner;

public class Aplicacion
{
    static Scanner teclado=new Scanner(System.in);
    public static void main(String[]args)
    {
        Coche c1=new Coche(150,"Audi",5);
        Moto m1=new Moto(300,"Honda");
        System.out.print("Numero de plazas maximas en el garaje: ");
        int a=teclado.nextInt();
        Garaje gara1=new Garaje(a);
        gara1.guardarVehiculo(c1, 1);
        gara1.guardarVehiculo(m1, 2);
        System.out.print("\nCuota plaza 1: "+gara1.leerCuota(1)+" €");
        System.out.print("\nCuota plaza 2: "+gara1.leerCuota(2)+" €");
        System.out.println("");
        gara1.ver();
    }
}