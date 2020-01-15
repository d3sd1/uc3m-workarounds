package POO.Ejer1;

public class Coches {
    public String modelo;
    public String color;
    public boolean esMetalizada;
    public String matricula;
    public char tipoCoche;
    private int añofabric;
    public String tipoSeguroStr()
    {
        String tipoSeguroFinal = null;
        switch(this.tipoCoche)
        {
            case 'M':
                tipoSeguroFinal = "MINI";
            break;
            case 'U':
                tipoSeguroFinal = "UTILITARIO";
            break;
            case 'F':
                tipoSeguroFinal = "FAMILIAR";
            break;
            case 'D':
                tipoSeguroFinal = "DEPORTIVO";
            break;
            default: tipoSeguroFinal = "MINI";
        }
        return tipoSeguroFinal;
    }
    public String tipoSeguroChar(char tipoSeguroChar)
    {
        String tipoSeguroFinal = null;
        switch(this.tipoCoche)
        {
            case 'T':
                tipoSeguroFinal = "TERCEROS";
            break;
            case 'R':
                tipoSeguroFinal = "TODORIESGO";
            break;
            default: tipoSeguroFinal = "TERCEROS";
        }
        return tipoSeguroFinal;
    }
    public String tipoCocheStr()
    {
        String tipoCocheFinal = null;
        switch(this.tipoCoche)
        {
            case 'M':
                tipoCocheFinal = "MINI";
            break;
            case 'U':
                tipoCocheFinal = "UTILITARIO";
            break;
            case 'F':
                tipoCocheFinal = "FAMILIAR";
            break;
            case 'D':
                tipoCocheFinal = "DEPORTIVO";
            break;
            default: tipoCocheFinal = "MINI";
        }
        return tipoCocheFinal;
    }
    public String tipoCocheStr(char tipoCocheChar)
    {
        String tipoCocheFinal = null;
        switch(tipoCocheChar)
        {
            case 'M':
                tipoCocheFinal = "MINI";
            break;
            case 'U':
                tipoCocheFinal = "UTILITARIO";
            break;
            case 'F':
                tipoCocheFinal = "FAMILIAR";
            break;
            case 'D':
                tipoCocheFinal = "DEPORTIVO";
            break;
            default: tipoCocheFinal = "MINI";
        }
        return tipoCocheFinal;
    }
    public String nom(Coches tipoCoche)
    {
        this.modelo;
        return "null";
    }
}