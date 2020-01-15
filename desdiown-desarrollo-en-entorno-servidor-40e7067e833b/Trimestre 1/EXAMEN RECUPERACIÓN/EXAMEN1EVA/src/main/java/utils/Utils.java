package utils;

import java.util.List;
import model.Producto;

public class Utils {
    public double calcularCosteCarrito(List<Producto> carrito)
    {
        double costeTotal = 0;
        if(null != carrito)
        {
            for (Producto producto : carrito)
            {
                costeTotal += producto.getPrecio() * producto.getUnidades();
            }
        }
        return costeTotal;
    }
}
