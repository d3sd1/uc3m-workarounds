package realizarOperaciones;

public class Producto extends classOperaciones {
    Producto()
    {
        
    }
    Producto(double valor1, double valor2)
    {
        super(valor1,valor2);
    }
    public void producto()
    {
        super.resultado = super.valor1*super.valor2;
    }
}