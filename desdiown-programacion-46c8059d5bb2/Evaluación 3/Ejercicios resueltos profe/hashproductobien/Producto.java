/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hashproducto;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Producto implements Comparable {

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
       public int hashCode(){
        int hash = 1;
        hash = hash * 17 + cantidad;
        hash = hash * 31 + nombre.hashCode();
        return hash;
     }

    @Override  //por defecto nos lo NetBeans
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
	/*
      @Override
    public boolean equals(Object obj) {
        if(obj instanceof Producto){
            Producto otroIgual=(Producto)obj;
            return(otroIgual.nombre.equals(nombre)&& otroIgual.cantidad==cantidad);
        }else{
            return false;
        }
    }
	
	*/
    @Override
    public int compareTo(Object objeto) {
// Indica en base a que atributos se compara el objeto
// Devuelve +1 si this es > que objeto
// Devuelve -1 si this es < que objeto
// Devuelve 0 si son iguales

        Producto producto = (Producto) objeto;
        String nombreObjeto = producto.nombre.toLowerCase();
        String nombreThis = this.nombre.toLowerCase();
        if(nombreThis.compareTo(nombreObjeto)==0){
            if(this.cantidad > producto.cantidad){
                return 1;
            }
        }
        return (nombreThis.compareTo(nombreObjeto));
    }
}
/* con hascode() no admite objetos repetidos , sino se pone si los repite */
/* si cambio el atributo cantidad, ya considera que los objetos no son iguales y los pone*/
/* http://optimizarsinmas.blogspot.com.es/2011/01/manejar-colecciones-ordenadas-treeset-y.html */