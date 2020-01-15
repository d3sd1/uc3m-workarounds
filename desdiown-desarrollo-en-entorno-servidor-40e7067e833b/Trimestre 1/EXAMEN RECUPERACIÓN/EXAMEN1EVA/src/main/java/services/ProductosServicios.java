package services;

import exceptions.ClienteSinFondosException;
import dao.ProductosDAO;
import dao.UsuariosDAO;
import java.util.List;
import model.Cliente;
import model.Producto;
import utils.Utils;

public class ProductosServicios
{

    public boolean addProducto(String nombre, double precio, int unidades, String categoria)
    {
        boolean success;
        ProductosDAO dao = new ProductosDAO();
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setUnidades(unidades);
        producto.setCategoria(categoria);
        success = dao.addProducto(producto);
        return success;
    }

    public boolean updateProducto(String nombre, double precio, int unidades, String categoria)
    {
        boolean success;
        ProductosDAO dao = new ProductosDAO();
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setUnidades(unidades);
        producto.setCategoria(categoria);
        success = dao.updateProducto(producto);
        return success;
    }

    public List<Producto> buscarProductos(String categoria)
    {
        List<Producto> productos = null;
        ProductosDAO dao = new ProductosDAO();
        Producto producto = new Producto();
        producto.setCategoria(categoria);
        productos = dao.buscarProductos(producto);
        return productos;
    }

    public int getStock(String nombre)
    {
        ProductosDAO dao = new ProductosDAO();
        Producto producto = new Producto();
        producto.setNombre(nombre);
        return dao.getStock(producto);
    }

    public Producto getProducto(String nombre, int cantidad)
    {
        ProductosDAO dao = new ProductosDAO();
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto = dao.getProducto(producto);
        /* Resetear cantidades a las que el usuario quiere, no a las totales. */
        producto.setUnidades(cantidad);
        return producto;
    }

    public boolean finalizarCompra(String clienteNombre, List<Producto> carrito) throws ClienteSinFondosException
    {
        boolean success = true;
        UsuariosDAO uDao = new UsuariosDAO();
        ProductosDAO pDao = new ProductosDAO();
        /* Recuperar información del cliente */
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteNombre);
        cliente = uDao.getCliente(cliente);

        /* Coste total del pedido */
        Utils utils = new Utils();
        double costePedido = utils.calcularCosteCarrito(carrito);

        /* Quitar saldo al usuario */
        if (cliente.getSaldo() < costePedido)
        {
            throw new ClienteSinFondosException();
        } else
        {
            success = uDao.reducirSaldoCliente(cliente, costePedido);
        }

        /* Quitar stock de productos, pero comprobando primero que todo vaya bien para evitar errores */
        for (Producto producto : carrito)
        {
            if (success)
            {
                success = pDao.reducirStock(producto);
            }
            else
            {
                break;
            }
        }

        return success;
    }
}
