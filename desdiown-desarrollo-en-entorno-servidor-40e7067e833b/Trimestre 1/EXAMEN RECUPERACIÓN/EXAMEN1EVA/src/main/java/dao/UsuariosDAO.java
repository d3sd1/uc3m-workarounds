package dao;

import model.Cliente;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UsuariosDAO {
    private final String SQL_LOGIN = "SELECT * FROM clientes WHERE nombre=?";
    private final String SQL_ADD_CLIENTE = "INSERT INTO clientes (nombre,contrasena,saldo) VALUES (?,?,?)";
    private final String SQL_UPD_CLIENTE_SALDO = "UPDATE clientes SET saldo=saldo-? WHERE nombre=?";
    public Cliente getCliente(Cliente cliente)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        cliente = (Cliente) jdbcTemplateObject.queryForObject(
                SQL_LOGIN, new Object[]
                {
                    cliente.getNombre()
                },
                new BeanPropertyRowMapper(Cliente.class));
        return cliente;
    }
    public boolean addCliente(Cliente cliente)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        int updatedRows = 0;
        try
        {
            updatedRows = jdbcTemplateObject.update(SQL_ADD_CLIENTE, cliente.getNombre(), cliente.getContrasena(), cliente.getSaldo());
        }
        catch(Exception ex)
        {
            updatedRows = 0;
        }
        return updatedRows > 0;
    }
    public boolean reducirSaldoCliente(Cliente cliente, double importe)
    {
        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(DBConnection.getInstance().getDataSource());
        int updatedRows = 0;
        try
        {
            updatedRows = jdbcTemplateObject.update(SQL_UPD_CLIENTE_SALDO, importe, cliente.getNombre());
        }
        catch(Exception ex)
        {
            updatedRows = 0;
        }
        return updatedRows > 0;
    }
}
