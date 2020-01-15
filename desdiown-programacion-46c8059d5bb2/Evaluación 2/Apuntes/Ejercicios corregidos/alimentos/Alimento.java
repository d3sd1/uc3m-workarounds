package alimentos;
public class Alimento
{
    protected String nombre;
    protected double lipidos;
    protected double hidratos;
    protected double proteinas;
    protected Boolean origen;
    protected char vitaminas;
    protected char minerales;

    public Alimento()
    {

    }

    public Alimento(String nombre)
    {
        this.nombre=nombre;
    }

    public Alimento(String nombre, double lipidos, double hidratos, double proteinas, Boolean origen, char vitaminas, char minerales)
    {
        this.nombre=nombre;
        this.lipidos=lipidos;
        this.hidratos=hidratos;
        this.proteinas=proteinas;
        this.origen=origen;
        this.vitaminas=vitaminas;
        this.minerales=minerales;
    }

    public Boolean esDietetico()
    {
        if(lipidos<20&&vitaminas!='B'){
            return(true);
        }    
        else{
            return(false);
        }    
    }

    public String muestraAlimento()
    {
        return("Nombre: " +nombre+ "; Lipidos: " +lipidos+ "%; Hidratos: " +hidratos+ "%; Proteinas: "
                +proteinas+ "; Origen: " +origen+ "; Vitamina: " +vitaminas+ "; Mineral: " +minerales);
    }

    public double calculaConenidoEnergetico()
    {
        return((lipidos/100)*9.4+(proteinas/100)*5.3+(hidratos/100)*4.1);
    }

    public Boolean esRecomendableParaDeportistas()
    {
        if(proteinas>=10&&proteinas<=15&&lipidos>=30&&lipidos<=35&&hidratos>=55&&hidratos<=65){
            return(true);
        }    
        else{
            return(false);
        }    
    }
}