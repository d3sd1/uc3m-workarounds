package Semana13.Ejercicio4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        Database db = new Database();
        Scanner input = new Scanner(System.in);
        mainMenu: while (true) {
            System.out.println("----- Menú principal - Selecciona una opción -----");
            System.out.println("1. Añadir un producto");
            System.out.println("2. Añadir un cliente");
            System.out.println("3. Añadir una venta");
            System.out.println("4. Listar ventas");
            System.out.println("5. Salir");

            switch (input.nextByte()) {
                case 1:
                    addProducto(db);
                    break;
                case 2:
                    addCliente(db);
                    break;
                case 3:
                    addVenta(db);
                    break;
                case 4:
                    mostrarVentas(db.getVentas());
                    break;
                case 5:
                    System.out.println("Gracias por usar nuestro magnífico gestor de tiendas.");
                    break mainMenu;
                default:
                    System.out.println("Creo que no te he entendido. Esa opción no está disponible.");
            }
        }
        input.close();
    }

    public static void addCliente(Database db) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.getProperty("line.separator"));
        Cliente cliente = new Cliente();
        System.out.println("Introduce el nombre del cliente");
        cliente.setNombre(input.next());
        System.out.println("Introduce la contraseña para " + cliente.getNombre());
        cliente.setContrasena(input.next());
        System.out.println("Introduce el correo electrónico para " + cliente.getNombre());
        cliente.setCorreoElectronico(input.next());
        System.out.println("Introduce el dinero para " + cliente.getNombre());
        cliente.setDinero(input.nextDouble());
        if(db.addCliente(cliente)) {
            System.out.println("Cliente añadido correctamente.");
        }
        else {
            System.out.println("No se pudo añadir el cliente.");
        }
    }
    public static void addProducto(Database db) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.getProperty("line.separator"));
        Producto p = new Producto();
        System.out.println("Introduce el nombre del producto");
        p.setNombre(input.next());
        System.out.println("Introduce el precio de " + p.getNombre());
        p.setPrecio(input.nextFloat());
        System.out.println("Introduce los valores de " + p.getNombre());
        p.setValores(input.nextInt()); //Este campo a mi criterio sobra... pero lo pongo porque lo indica el enunciado.

        if(db.addProducto(p)) {
            System.out.println("Producto añadido correctamente.");
        }
        else {
            System.out.println("No se pudo añadir el cliente.");
        }
    }
    public static void addVenta(Database db) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.getProperty("line.separator"));

        Venta v = new Venta();

        System.out.println("Selecciona el producto vendido (número índice)");
        int pIndex = 0; //Primero utilizada para iterar y luego para seleccionar, asi ahorramos variables y claridad
        for(Producto p : db.getProductos()) {
            System.out.println(pIndex + ". " + p);
            pIndex++;
        }
        pIndex = input.nextInt();
        if(db.getProductos().size() <= pIndex) {
            System.out.println("Índice fuera de rango");
        }
        else {
            v.setProducto(db.getProductos().get(pIndex));
        }

        int cIndex = 0;
        System.out.println("Selecciona el cliente que lo ha comprado (número índice)");
        for(Cliente c : db.getClientes()) {
            System.out.println(cIndex + ". " + c);
            cIndex++;
        }
        cIndex = input.nextInt();
        if(db.getClientes().size() <= cIndex) {
            System.out.println("Índice fuera de rango");
        }
        else {
            v.setCliente(db.getClientes().get(cIndex));
        }



        //Al realizar la venta, le quita el importe del producto al cliente.
        //Si no tiene líquido, no puede realizar la compra.
        if(v.getCliente().getDinero() >= v.getProducto().getPrecio()) {
            v.getCliente().setDinero(
                    v.getCliente().getDinero() - v.getProducto().getPrecio()
            );
            db.addVenta(v);
            System.out.println("Venta realizada correctamente.");
        }
        else {
            System.out.println("El cliente no tiene dinero suficiente para llevar a cabo la compra.");
        }
    }

    public static void mostrarVentas(ArrayList<Venta> ventas) {
        for(Venta venta : ventas) {
            System.out.println(venta);
        }
        if(ventas.size() == 0) {
            System.out.println("Aún no se han realizado ventas.");
        }
    }
}
