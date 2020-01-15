package Semana13.Ejercicio4;

import java.util.Objects;

public class Venta {
    private Producto producto;
    private Cliente cliente;

    public Venta() {
    }

    public Venta(Producto producto, Cliente cliente) {
        this.producto = producto;
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return Objects.equals(producto, venta.producto) &&
                Objects.equals(cliente, venta.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto, cliente);
    }

    @Override
    public String toString() {
        return "Venta de un " + this.producto.getNombre() + " (" + this.producto.getPrecio() + "€) al comprador " +
                this.cliente.getNombre() + " ( " + this.cliente.getCorreoElectronico() + ")";
    }
}
