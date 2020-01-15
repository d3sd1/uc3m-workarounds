package dao;

import java.sql.ResultSet;
import java.util.List;
import model.Cliente;
import model.Producto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProductosDAO
{
    private final String SQL_ADD_PRODUCTO = "INSERT INTO productos (nombre,precio,unidades,categoria) VALUES (?,?,?,?)";
    private final String SQL_UPD_PRODUCTO = "UPDATE productos SET precio=?,unidades=?,categoria=? WHERE nombre=?";
    private final String SQL_UPD_PRODUCTO_STOCK = "UPDATE productos SET unidades=unidades-? WHERE nombre=?";
    private final String SQL_GET_PRODUCTOS = "SELECT * FROM productos WHERE categoria=?";
    private final String SQL_GET_STOCK = "SELECT unidades FROM productos WHERE nombre=?";
    private final String SQL_GET_PRODUCTO = "SELECT * FROM productos WHERE nombre=?";
    
    public boolean addProducto(Producto producto)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        int updatedRows = 0;
        try
        {
            updatedRows = jdbcTemplateObject.update(SQL_ADD_PRODUCTO, producto.getNombre(),
                    producto.getPrecio(), producto.getUnidades(), producto.getCategoria());
        } catch (Exception ex)
        {
            updatedRows = 0;
        }
        return updatedRows > 0;
    }
    public boolean updateProducto(Producto producto)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        int updatedRows = 0;
        try
        {
            updatedRows = jdbcTemplateObject.update(SQL_UPD_PRODUCTO,
                    producto.getPrecio(), producto.getUnidades(), producto.getCategoria(), producto.getNombre());
        } catch (Exception ex)
        {
            updatedRows = 0;
        }
        return updatedRows > 0;
    }
    /* Buscar productos de la misma categoria que el dado */
    public List<Producto> buscarProductos(Producto producto)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        List<Producto> productos = jdbcTemplateObject.query(SQL_GET_PRODUCTOS, new BeanPropertyRowMapper(Producto.class), producto.getCategoria());
        return productos;
    }
    
    public int getStock(Producto producto)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        int cantidad = jdbcTemplateObject.queryForObject(SQL_GET_STOCK, Integer.class, producto.getNombre());
        return cantidad;
    }
    public boolean reducirStock(Producto producto)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        int updatedRows = 0;
        try
        {
            updatedRows = jdbcTemplateObject.update(SQL_UPD_PRODUCTO_STOCK,
                    producto.getUnidades(), producto.getNombre());
        } catch (Exception ex)
        {
            updatedRows = 0;
        }
        return updatedRows > 0;
    }
    public Producto getProducto(Producto producto)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        producto = (Producto) jdbcTemplateObject.queryForObject(
                SQL_GET_PRODUCTO, new Object[]
                {
                    producto.getNombre()
                },
                new BeanPropertyRowMapper(Producto.class));
        return producto;
    }
}
