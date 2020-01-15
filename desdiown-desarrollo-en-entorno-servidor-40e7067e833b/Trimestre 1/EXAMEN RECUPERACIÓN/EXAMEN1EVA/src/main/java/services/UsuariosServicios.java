package services;

import dao.UsuariosDAO;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import utils.AdminUser;
import utils.PasswordHash;

public class UsuariosServicios
{

    public boolean doLogin(String nombre, String contrasena)
    {
        UsuariosDAO udao = new UsuariosDAO();
        boolean loginOK = false;
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setContrasena(contrasena);
        /* Comprobar si es admin */
        if (cliente.getNombre().equals(AdminUser.NOMBRE) && cliente.getContrasena().equals(AdminUser.CONTRASENA))
        {
            loginOK = true;
        }
        else
        {
            /* Intentar conexión como cliente */
            Cliente clienteEncontrado = udao.getCliente(cliente);
            boolean contrasenaValida = false;
            try
            {
                contrasenaValida = PasswordHash.getInstance().validatePassword(cliente.getContrasena(), clienteEncontrado.getContrasena());
            } catch (Exception ex)
            {
                contrasenaValida = false;
            }
            if (contrasenaValida)
            {
                loginOK = true;
            }
        }
        return loginOK;
    }
    public boolean addCliente(String nombre, String contrasena, double saldo)
    {
        UsuariosDAO udao = new UsuariosDAO();
        boolean success = false;
         String contrasenaHash = "";
        try
        {
           contrasenaHash = PasswordHash.getInstance().createHash(contrasena);
        } catch (Exception ex)
        {
            contrasenaHash = "";
        }
        
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setContrasena(contrasenaHash);
        cliente.setSaldo(saldo);
        success = udao.addCliente(cliente);
        return success;
    }
}
