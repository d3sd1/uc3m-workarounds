package hospital;

public class Paciente implements Comparable<Paciente>
{
    private String nombre;
    private String apellidos;
    private int edad;
    private int numHab;

    Paciente(String nombre, String apellidos, int edad, int numHab)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.numHab = numHab;
    }



    public String getApellidos()
    {
        return apellidos;
    }

    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getNumHab()
    {
        return numHab;
    }

    public void setNumHab(int numHab)
    {
        this.numHab = numHab;
    }

    @Override
    public String toString()
    {
        return "Nombre: "+nombre
                +" Apellido: "+apellidos
                +" Edad: "+edad
                +" Numero de habitacion: "+numHab;
    }
    
    @Override
    public int compareTo(Paciente obj)
    {
        return this.getApellidos().compareTo(obj.getApellidos());
    }

}
