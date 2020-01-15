package Semana13.Ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.getProperty("line.separator"));

        //Se hace con un único cliente para clarificar
        Cliente cliente = new Cliente();
        System.out.println("Introduce el nombre del titular de los depósitos normal y estructuraddo");
        cliente.setNombre(input.next());

        System.out.println("----- Depósito normal: -----");
        Deposito deposito = new Deposito();
        deposito.setTitular(cliente);
        System.out.println("Introduce el plazo en días del depósito");
        deposito.setPlazoDias(input.nextInt());
        System.out.println("Introduce el capital del depósito");
        deposito.setCapital(input.nextFloat());
        System.out.println("Introduce el tipo de interés del depósito");
        deposito.setTipoInteres(input.nextFloat());

        System.out.println("Una vez finalizado el plazo, la liquidación será de: " + deposito.liquidarDeposito() + "€");
        System.out.println("Intereses de la operación: " + deposito.consultarIntereses() + "€");

        System.out.println("----- Depósito estructurado: -----");
        DepositoEstructurado depositoEstructurado = new DepositoEstructurado();
        depositoEstructurado.setTitular(cliente);
        System.out.println("Introduce el plazo en días del depósito estructurado");
        depositoEstructurado.setPlazoDias(input.nextInt());
        System.out.println("Introduce el tramo fijo del depósito estructurado");
        depositoEstructurado.setTramoFijo(input.nextInt());
        System.out.println("Introduce el tramo variable del depósito estructurado");
        depositoEstructurado.setTramoVariable(input.nextInt());
        System.out.println("Introduce el capital del depósito estructurado");
        depositoEstructurado.setCapital(input.nextFloat());
        System.out.println("Introduce el tipo de interés del depósito estructurado");
        depositoEstructurado.setTipoInteres(input.nextFloat());

        System.out.println("Una vez finalizado el plazo, la liquidación será de: " + depositoEstructurado.liquidarDeposito() + "€");
        System.out.println("Intereses de la operación: " + depositoEstructurado.consultarIntereses() + "€");
    }
}
