package Semana13.Ejercicio2;

public class DepositoEstructurado extends Deposito implements Interes {
    private int tramoFijo; //Días de duración del tramo fijo
    private int tramoVariable; //Días de duración del tramo variable

    public DepositoEstructurado() {
    }

    public DepositoEstructurado(Cliente titular, float capital, int plazoDias, float tipoInteres, int tramoFijo, int tramoVariable) {
        super(titular, capital, plazoDias, tipoInteres);
        this.tramoFijo = tramoFijo;
        this.tramoVariable = tramoVariable;
    }

    public int getTramoFijo() {
        return tramoFijo;
    }

    public void setTramoFijo(int tramoFijo) {
        if(this.tramoFijo >= this.plazoDias) {
            System.out.println("EL tramo fijo ha excedido el plazo en días... Se ha puesto por defecto a la mitad del plazo.");
            this.tramoFijo = (int) (this.plazoDias / 2);
        }
        else {
            this.tramoFijo = tramoFijo;
        }
    }

    public int getTramoVariable() {
        return tramoVariable;
    }

    public void setTramoVariable(int tramoVariable) {
        if(this.tramoVariable >= this.plazoDias) {
            System.out.println("El tramo variable ha excedido el plazo en días... Se ha puesto por defecto a la mitad del plazo.");
            this.tramoVariable = (int) (this.plazoDias / 2);
        }
        else {
            this.tramoVariable = tramoVariable;
        }
    }

    public float consultarIntereses() {
        if(this.tramoFijo + this.tramoVariable != this.plazoDias) {
            System.out.println("Los tramos no coinciden con el plazo. Se pone por defecto para evitar malas rentabilidades.");
            this.setTramoVariable(this.plazoDias); //Al poner los días excede lo permitido y se pone por defecto.
            this.setTramoFijo(this.plazoDias);
        }
        //Para estas formulas se extrae el capital porcentual a cada periodo y después se calcula con su fórmula
        //Se extrae la parte proporcional del dinero en días y luego en base a eso se calcula con la fórmula equivalente.
        float plazoVariable = (this.capital * ( (float) this.tramoVariable/this.plazoDias) * this.tipoInteres) + this.tramoVariable;
        float plazoFijo = (this.capital * ( (float) this.tramoFijo/this.plazoDias) * this.INTERES_FIJO) + this.tramoFijo;
        return plazoVariable + plazoFijo; //Se ha añadido una rentabilidad por el plazo en días para que tenga sentido el ejercicio
    }
}
