
package profe.correoelectronico;

import java.util.Iterator;
import java.util.ArrayList;


public class ListaCorreos {
    
    private ArrayList lista;
    
    
    
    
    /**
     * Constructor para inicializar lista como elemento ArrayList
     * donde añadiremos los atributos de la clase Correos
     * 
     */      
    public ListaCorreos() {
        lista = new ArrayList();
    }
    
    
    
    /**
     *  Añadimos el objeto Correo a la Lista ArrayList
     */
    public void anadirCorreo(Correo correo) {
        lista.add(correo);
    }
    
    
    
    /**
     *  VISUALIZAR BANDEJA de ENTRADA
     */
    public void verBandejaEntrada() {
        int indice = 0;
        // Recorremos la lista con Iterator
        Iterator it = lista.iterator();
        while ( it.hasNext()) {
            // Hacemos CASTING del Objeto de lista, para convertirlo a objeto Correo
            Correo correo = (Correo)it.next();
            System.out.println(
                    + indice++ +" "
                    + "Origen: " + correo.getOrigen() + "\t"
                    + "Asunto: " + correo.getAsunto() + "\t"
                    + "Fecha: "  + correo.getHora()   + "  " + correo.getAnnio()
                    );            
        }
    }
    
    
    
    /**
     *  VER 1 MENSAJE, segun la POSICION introducida
     */
    public void verMensaje(int posicion) {
        int sw=0;
        for (int i = 0; i < lista.size() && sw==0; i++){
            if (i == posicion) {
                Correo correo = (Correo)lista.get(i); //obtiene el correo almacenado en la posicion i
                System.out.println( correo.getMensaje() );
                sw=1;
            }
        }    
    }

    
    /**
     *  VER MENSAJES, segun el ORIGEN
     */
    public void verMensajesOrigen(String origen) {
        // Instanciamos 'origenIntroducido' para añadirle el 'String origen' que queremos buscar
        Correo origenIntroducido = new Correo();
        origenIntroducido.setOrigen(origen);
        
        // Recorremos la lista, usando .size() y .get(),.. por que creo se ve más claro,.... saber que con Iterator tambien se podia.
        for (int i = 0; i < lista.size(); i++) {
            // Hacemos CASTING del Objeto de lista, para convertirlo a objeto Correo a la instancia de 'correoGet'
            Correo correoGet = (Correo)lista.get(i);
            // Este es el 'equals' y hashCode que hemos '@Override' necesario en la 'Clase Correo'
            // para que pregunte si true/false solo por el 'origen'.
            if (correoGet.equals(origenIntroducido)) {
                System.out.println( i + " " + correoGet.getMensaje() );
            }
        }
    }

        
    
    /**
     *  VER * TODOS los MENSAJES
     */
    public void verTodosMensajes() {
        int indice = 0;
        // Recorremos la lista con Iterator
        for (Iterator it = lista.iterator(); it.hasNext();) {
            // Hacemos CASTING del Objeto de lista, para convertirlo a objeto Correo
            Correo correo = (Correo)it.next();
            // Visualizados el mensaje situado en esa parte de la lista
            System.out.println( indice++ + " " + correo.getMensaje() );
        }
    }
       
    
    
    /**
     *  ELIMINAR CORREO
     */
    public void eliminarCorreo(int posicion) {
        lista.remove(posicion);
    }
    
}
