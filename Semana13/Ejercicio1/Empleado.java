package Semana13.Ejercicio1;

public abstract class Empleado {
    private String dni;
    private String nombre;
    private String apellidos;
    private int anyoIngreso;

    protected Empleado() {}

    protected Empleado(String dni, String nombre, String apellidos, int anyoIngreso) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anyoIngreso = anyoIngreso;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getAnyoIngreso() {
        return anyoIngreso;
    }

    public void setAnyoIngreso(int anyoIngreso) {
        this.anyoIngreso = anyoIngreso;
    }

    public void imprimir() {
        System.out.println("DNI: " + dni + ", Nombre: " + this.nombre + ", Apellidos: " + this.apellidos + ". Año ingreso: " + this.anyoIngreso + " con salario final de " + this.obtenerSalario());
    }

     abstract float obtenerSalario();
}
