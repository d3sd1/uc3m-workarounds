package Semana13.Ejercicio4;

import java.util.Objects;

public class Cliente {
    private String nombre;
    private String correoElectronico;
    private String contrasena;
    private double dinero;

    public Cliente() {
    }

    public Cliente(String nombre, String correoElectronico, String contrasena, double dinero) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(correoElectronico.toLowerCase(), cliente.correoElectronico.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, correoElectronico, contrasena, dinero);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", dinero=" + dinero +
                '}';
    }
}
