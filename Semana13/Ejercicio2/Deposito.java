package Semana13.Ejercicio2;

public class Deposito {
    protected Cliente titular;
    protected float capital;
    protected int plazoDias;
    protected float tipoInteres;

    public Deposito() {
    }

    public Deposito(Cliente titular, float capital, int plazoDias, float tipoInteres) {
        this.titular = titular;
        this.capital = capital;
        this.plazoDias = plazoDias;
        this.tipoInteres = tipoInteres;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public float getCapital() {
        return capital;
    }

    public void setCapital(float capital) {
        this.capital = capital;
    }

    public int getPlazoDias() {
        return plazoDias;
    }

    public void setPlazoDias(int plazoDias) {
        this.plazoDias = plazoDias;
    }

    public float getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(float tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public float liquidarDeposito() {
        return this.capital + this.consultarIntereses();
    }
    public float consultarIntereses() {
        return (this.capital * this.tipoInteres) + this.plazoDias; //Se ha añadido una rentabilidad por el plazo en días para que tenga sentido el ejercicio
    }
}
