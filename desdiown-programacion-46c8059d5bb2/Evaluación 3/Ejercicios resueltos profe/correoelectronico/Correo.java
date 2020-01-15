
package profe.correoelectronico;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Correo {
    
    private String origen;
    private String destino;
    private String asunto;
    private String mensaje;
    private Date fecha;
    
    public Correo() {
        this.origen = "";
        this.destino = "";
        this.asunto = "";
        this.mensaje = "";
        // La Fecha y Hora se añaden automaticamente al añadir un nuevo correo
        Calendar cal = Calendar.getInstance();
        this.fecha = cal.getTime();
    }

    
    public Correo(String origen, String destino, String asunto, String mensaje) {        
        this.origen = origen;
        this.destino = destino;
        this.asunto = asunto;
        this.mensaje = mensaje;
        // La Fecha y Hora se añaden automaticamente al añadir un nuevo correo
        Calendar cal = Calendar.getInstance();
        this.fecha = cal.getTime();
    }
    
    // ORIGEN
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
 
    // DESTINO
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    // ASUNTO
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
 
    // MENSAJE
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
    // FECHA
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
    
    // Retornamos el AÑO de FECHA como String
    public String getAnnio() {
        SimpleDateFormat ver = new SimpleDateFormat("dd.MM.yyyy");
        
        return ver.format(fecha);
    }

    // Retornamos la HORA de FECHA como String
    public String getHora() {
        SimpleDateFormat ver = new SimpleDateFormat("H:mm:ss");
        
        return ver.format(fecha);
    }

    
    @Override
    public String toString() {
        return this.origen + " "
               + this.destino + " "
               + this.asunto + " "
               + this.mensaje + " "               
               + "*"+ this.getAnnio() + "* "
               + "*"+ this.getHora() + "*";
    }

    
    
    @Override
    public int hashCode() {
        return origen.hashCode();
    }

    
    
    @Override
    public boolean equals(Object obj) {
         if (obj instanceof Correo) {
            Correo c = (Correo) obj;
            return c.getOrigen().equals(origen);
        } else {
            return false;
        }
    }
    
    
}
