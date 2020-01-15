package Ejercicios.Word1_Ejer2;

public class Campo {
    int kilosOlivas = 0;
    int edadOlivo = 0;
    int cantidadOlivos = 0;
    private double precioPorKg = 0.5;
    public void setNewValues(int kilosOlivasSum, int edadOlivoSum)
    {
        kilosOlivas += kilosOlivasSum;
        edadOlivo += edadOlivoSum;
        cantidadOlivos++;
    }
    public double beneficio()
    {
        return kilosOlivas*precioPorKg;
    }
}