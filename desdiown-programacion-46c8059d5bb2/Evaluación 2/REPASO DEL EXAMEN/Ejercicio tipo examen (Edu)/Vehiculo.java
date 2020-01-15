
package GarajeVehiculos;

public class Vehiculo
{
    //ATRIBUTOS
    private int potencia;
    private String marca;
    //CONSTRUCTOR
    Vehiculo(){};
    Vehiculo(int potencia, String marca)
    {
        this.potencia=potencia;
        this.marca=marca;
    }
    //SET
    void setPotencia(int potencia)
    {
        this.potencia=potencia;
    }
    void setMarca(String marca)
    {
        this.marca=marca;
    }
    //GET
    int getPotencia()
    {
        return potencia;
    }
    String getMarca()
    {
        return marca;
    }
    //METODOS
    @Override
    public String toString()
    {
        return("Potencia: "+potencia+" - Marca: "+marca);
    }
}
