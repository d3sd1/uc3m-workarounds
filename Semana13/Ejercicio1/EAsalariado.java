package Semana13.Ejercicio1;

import java.util.Calendar;

public class EAsalariado extends Empleado {
    private float sueldoBasico;

    public EAsalariado() {

    }

    public EAsalariado(String dni, String nombre, String apellidos, int anyoIngreso, float sueldoBasico) {
        super(dni, nombre, apellidos, anyoIngreso);
        this.sueldoBasico = sueldoBasico;
    }

    public float getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(float sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }
    public float obtenerSalario() {
        int anyosAntiguedad = Calendar.getInstance().get(Calendar.YEAR) - this.getAnyoIngreso();
        if(anyosAntiguedad < 2) {
            return this.sueldoBasico;
        }
        else if(anyosAntiguedad > 2 && anyosAntiguedad < 3) {
            return this.sueldoBasico + (this.sueldoBasico * 5/100);
        }
        else if(anyosAntiguedad > 4 && anyosAntiguedad < 7) {
            return this.sueldoBasico + (this.sueldoBasico * 10/100);
        }
        else if(anyosAntiguedad > 8 && anyosAntiguedad < 15) {
            return this.sueldoBasico + (this.sueldoBasico * 15/100);
        }
        else {
            return this.sueldoBasico + (this.sueldoBasico * 20/100);
        }
    }
}
