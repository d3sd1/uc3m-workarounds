package Semana13.Ejercicio4;

import java.util.ArrayList;

public class Database {
    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private ArrayList<Venta> ventas;

    public Database() {
        this.clientes = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public Database(ArrayList<Cliente> clientes, ArrayList<Producto> productos, ArrayList<Venta> ventas) {
        this.clientes = clientes;
        this.productos = productos;
        this.ventas = ventas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public int buscarCliente(Cliente cliente) {
        for(int i = 0; i < this.clientes.size(); i++) {
            if(this.clientes.get(i).equals(cliente)) {
                return i;
            }
        }
        return -1;
    }

    public int buscarProducto(Producto producto) {
        for(int i = 0; i < this.productos.size(); i++) {
            if(this.productos.get(i).equals(producto)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addCliente(Cliente c) {
        boolean success = false;
        if(this.buscarCliente(c) == -1) {
            this.clientes.add(c);
            success = true;
        }
        return success;
    }

    public boolean addProducto(Producto p) {
        boolean success = false;
        if(this.buscarProducto(p) == -1) {
            this.productos.add(p);
            success = true;
        }
        return success;
    }
    public void addVenta(Venta v) {
        this.ventas.add(v);
    }
}
