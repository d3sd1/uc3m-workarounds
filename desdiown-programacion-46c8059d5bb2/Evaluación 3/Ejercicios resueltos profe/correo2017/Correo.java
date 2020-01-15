
package profe.correo2017;


public class Correo {
    private String origen;
    private String destino;    
    private String asunto;
    private String cuerpo;
    
    public Correo(String origen, String destino, String asunto, String cuerpo)
    {
        this.origen=origen;
        this.destino=destino;
        this.asunto=asunto;
        this.cuerpo=cuerpo;
        
    }    
  
    public void setOrigen(String origen)
    {
        this.origen=origen;
    }
    
    public void setDestino(String destino)
    {
        this.destino=destino;
    }
    
    public void setAsunto(String asunto)
    {
        this.asunto=asunto;
    }
    public void setCuerpo(String cuerpo)
    {
        this.cuerpo=cuerpo;
    }
    
   
    public String getOrigen()
    {
        return origen;
    }
    public String getDestino()
    {
        return destino;
    }
    public String getAsunto()
    {
        return asunto;
    }
    public String getCuerpo()
    {
        return cuerpo;
    }
    
  
    @Override
    public String toString()
    {
        return "\nDe :\n\t"+origen+"\nPara :\n\t"+destino+"\nAsunto: \n\t"+asunto+"\nMensaje: \n\t"+cuerpo;
    }
            
}
