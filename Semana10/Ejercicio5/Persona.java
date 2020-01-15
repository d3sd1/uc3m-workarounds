package Semana10.Ejercicio5;

class Persona {
    private String nombre;
    private int anyoNacimiento;

    public Persona(String nombre, int anyoNacimiento) {
        this.nombre = nombre;
        this.anyoNacimiento = anyoNacimiento;
    }

    public Persona() {
        this.nombre = "";
        this.anyoNacimiento = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyoNacimiento() {
        return anyoNacimiento;
    }

    public void setAnyoNacimiento(int anyoNacimiento) {
        this.anyoNacimiento = anyoNacimiento;
    }

    public String toString() {
        return this.nombre + ", nacido el " + this.anyoNacimiento;
    }
}