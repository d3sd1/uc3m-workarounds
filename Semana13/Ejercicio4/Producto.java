package Semana13.Ejercicio4;

import java.util.Objects;

public class Producto {
    private String nombre;
    private float precio;
    private int valores;

    public Producto() {
    }

    public Producto(String nombre, float precio, int valores) {
        this.nombre = nombre;
        this.precio = precio;
        this.valores = valores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getValores() {
        return valores;
    }

    public void setValores(int valores) {
        this.valores = valores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre.toLowerCase(), producto.nombre.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", valores=" + valores +
                '}';
    }
}
