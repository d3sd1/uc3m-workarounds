
package GarajeVehiculos;

public class Garaje
{
    //ATRIBUTOS
    private int totalPlazas;//Para asignar la longitud del array
    private Vehiculo[]garaje1;//Array
    private int cont;//Contador para saber cuantas posiciones estan ocupadas
    //CONSTRUCTOR
    Garaje(){};
    Garaje(int totalPlazas)
    {
        this.totalPlazas=totalPlazas;
        garaje1=new Vehiculo[totalPlazas];
    }
    //SET
    void setTotalPlazas(int totalPlazas)
    {
        this.totalPlazas=totalPlazas;
    }
    //GET
    int getTotalPlazas()
    {
        return totalPlazas;
    }
    //METODOS
    public void guardarVehiculo(Vehiculo v,int plaza)
    {
        if((cont<garaje1.length)&&(garaje1[plaza]==null))
        {
            garaje1[(plaza-1)]=v;
            cont++;
        }
        else
        {
            System.out.print("Garaje lleno, o plaza ocupada");
        }   
    }
    public int leerCuota(int plaza)
    {
        if(garaje1[plaza-1] instanceof Coche)
        {//Creo un obj tipo Coche de manera auxiliar para entrar al getNumPlazas
            Coche auxCoche=(Coche)garaje1[plaza-1];
            return (garaje1[plaza-1].getPotencia()*auxCoche.getNumPlazas());
        }
        else
        {
            if(garaje1[plaza-1] instanceof Moto)
            {
                return (garaje1[plaza-1].getPotencia()*2);
            }
            else
            {
                return 0;
            }
        }
    }
    public void ver()
    {
        System.out.println("");
        if(cont!=0)
        {
            for(int i=0;i<garaje1.length;i++)
            {
                if(!(garaje1[i]==null))
                {
                    System.out.print(garaje1[i].toString());
                    System.out.println("");
                }                   
            }
        }
        else
        {
            System.out.print("Vacio");
        }        
    }
}
