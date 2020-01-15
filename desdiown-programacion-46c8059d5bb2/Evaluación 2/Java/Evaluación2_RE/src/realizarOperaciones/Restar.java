package realizarOperaciones;

public class Restar extends classOperaciones {
    Restar()
    {
        
    }
    Restar(double valor1, double valor2)
    {
        super(valor1,valor2);
    }
    public void restar()
    {
        super.resultado = super.valor1-super.valor2;
    }
}