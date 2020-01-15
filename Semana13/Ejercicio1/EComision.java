package Semana13.Ejercicio1;

public class EComision extends Empleado implements Constants {
    private int clientesCaptados;
    private float importePorCliente;

    public EComision() {
    }

    public EComision(String dni, String nombre, String apellidos, int anyoIngreso, int clientesCaptados, float importePorCliente) {
        super(dni, nombre, apellidos, anyoIngreso);
        this.clientesCaptados = clientesCaptados;
        this.importePorCliente = importePorCliente;
    }

    public float obtenerSalario() {
        float salarioCalculado = this.clientesCaptados * this.importePorCliente;
        if(salarioCalculado < this.SALARIO_MINIMO_COMISION) {
            return this.SALARIO_MINIMO_COMISION;
        }
        else {
            return salarioCalculado;
        }
    }

    public int getClientesCaptados() {
        return clientesCaptados;
    }

    public void setClientesCaptados(int clientesCaptados) {
        this.clientesCaptados = clientesCaptados;
    }

    public float getImportePorCliente() {
        return importePorCliente;
    }

    public void setImportePorCliente(float importePorCliente) {
        this.importePorCliente = importePorCliente;
    }
}
