
package GarajeVehiculos;

public class Coche extends Vehiculo
{
    //ATRIBUTOS
    public int numPlazas;
    //CONSTRUCTOR
    Coche(){};
    Coche(int potencia,String marca,int numPlazas)
    {
        super(potencia,marca);
        this.numPlazas=numPlazas;
    }
    //SET
    void setNumPlazas(int numPlazas)
    {
        this.numPlazas=numPlazas;
    }
    //GET
    public int getNumPlazas()
    {
        return numPlazas;
    }
    //METODOS
    public String toString()
    {
        return(super.toString()+" - Numero de plazas: "+numPlazas);
    }
}
