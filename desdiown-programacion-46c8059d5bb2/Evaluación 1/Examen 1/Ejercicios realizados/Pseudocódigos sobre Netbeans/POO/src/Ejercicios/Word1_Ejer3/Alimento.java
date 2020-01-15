package Ejercicios.Word1_Ejer3;

public class Alimento {
    double lipidos;
    double hidratosCarbono;
    double proteinas;
    boolean origenAnimal;
    char vitaminasCont;
    char mineralesCont;
    String nombre;
    String muestraAlimento;
    public Alimento(String nombre)
    {
        this.nombre = nombre;
    }
    public Alimento(double lipidos,double hidratosCarbono,double proteinas,boolean origenAnimal,char vitaminasCont,char mineralesCont,String nombre,String muestraAlimento)
    {
        this.lipidos = lipidos;
        this.hidratosCarbono = hidratosCarbono;
        this.proteinas = proteinas;
        this.origenAnimal = origenAnimal;
        this.vitaminasCont = vitaminasCont;
        this.mineralesCont = mineralesCont;
        this.nombre = nombre;
        this.muestraAlimento = muestraAlimento;
    }
    public boolean esDietetico()
    {
        if(this.lipidos < 20 && this.vitaminasCont > 50)
        {
            return true;
        }
        return false;
    }
    public String muestraAlimento()
    {
        return this.muestraAlimento;
    }
    public double calculaContenidoEnergetico()
    {
        return (this.lipidos*9.4 + this.proteinas * 5.3 + this.hidratosCarbono*4.1);
    }
    public boolean esRecomendableParaDeportistas()
    {
        if((this.proteinas >= 10 && this.proteinas <= 15) && (this.lipidos >= 30 && this.lipidos <= 35) && (this.hidratosCarbono >= 55 && this.hidratosCarbono <= 65))
        {
            return true;
        }
        return false;
    }
}