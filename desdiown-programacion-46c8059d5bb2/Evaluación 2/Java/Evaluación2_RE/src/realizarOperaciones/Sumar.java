package realizarOperaciones;

public class Sumar extends classOperaciones {
    Sumar()
    {
        
    }
    Sumar(double valor1, double valor2)
    {
        super(valor1,valor2);
    }
    public void sumar()
    {
        super.resultado=super.valor1+this.valor2;
    }
}
