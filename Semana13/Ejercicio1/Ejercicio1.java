package Semana13.Ejercicio1;

public class Ejercicio1 {
    public static void main(String[] args) {
        EAsalariado javiGomez = new EAsalariado("569587A", "Javier", "Gómez", 2008, 1225);
        EComision evaNieto = new EComision("695235B", "Javier", "Gómez", 2010, 179, 8.10F);
        EComision joseRuiz = new EComision();
        joseRuiz.setNombre("Jose");
        joseRuiz.setApellidos("Ruiz");
        joseRuiz.setDni("741258C");
        joseRuiz.setAnyoIngreso(2012);
        joseRuiz.setClientesCaptados(81);
        joseRuiz.setImportePorCliente(7.9F);
        EAsalariado mariaNuñez = new EAsalariado();
        mariaNuñez.setNombre("María");
        mariaNuñez.setApellidos("Núñez");
        mariaNuñez.setDni("896325D");
        mariaNuñez.setAnyoIngreso(2013);
        mariaNuñez.setSueldoBasico(1155);

        Empleado[] empleados = new Empleado[]{
                javiGomez,
                evaNieto,
                joseRuiz,
                mariaNuñez
        };
        mostrarTodos(empleados);
        System.out.println("");
        System.out.println("Empleado mayor sueldo:");
        sueldoMayor(empleados);
    }
    public static void mostrarTodos(Empleado[] empleados) {
        for(Empleado empleado : empleados) {
            empleado.imprimir();
        }
    }
    public static void sueldoMayor(Empleado[] empleados) {
        Empleado empleadoMayorSueldo = null;
        for(Empleado empleado : empleados) {
            if(empleadoMayorSueldo == null || empleadoMayorSueldo.obtenerSalario() < empleado.obtenerSalario()) {
                empleadoMayorSueldo = empleado;
            }
        }
        empleadoMayorSueldo.imprimir();
    }
}
