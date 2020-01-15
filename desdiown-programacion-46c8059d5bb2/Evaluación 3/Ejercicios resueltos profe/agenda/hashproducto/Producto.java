/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hashproducto;

/**
 *
 * @author user
 */
public class Producto implements Comparable <Producto>{

    public String nombre;
    public int cantidad;

    public Producto(String s, int i) {
        nombre = s;
        cantidad = i;
    }

    @Override
    public String toString() {
        return ("Nombre: " + nombre + " Cantidad: " + cantidad);
    }

    /*    @Override
       public int hashCode(){
         
           return (nombre.hashCode()+ cantidad);
       }
     */
    

    @Override
    public int compareTo(Producto objeto) {
// Indica en base a que atributos se compara el objeto
// Devuelve +1 si this es > que objeto
// Devuelve -1 si this es < que objeto
// Devuelve 0 si son iguales

        String nombreObjeto = objeto.nombre.toLowerCase();
        String nombreThis = this.nombre.toLowerCase();

        if (nombreThis.compareTo(nombreObjeto) == 0) {
            if (this.cantidad != objeto.cantidad) {
                return 1;
            }else{
                return 0;
            }
        }else{
            return nombreThis.compareTo(nombreObjeto);
        }
    }
}
/* con hascode() no admite objetos repetidos , sino se pone si los repite */
/* si cambio el atributo cantidad, ya considera que los objetos no son iguales y los pone*/
