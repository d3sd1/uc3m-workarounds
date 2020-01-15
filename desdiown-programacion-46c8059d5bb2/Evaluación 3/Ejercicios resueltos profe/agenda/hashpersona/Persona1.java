/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hashpersona;

/**
 *
 * @author carmen
 */
public class Persona1 implements Comparable<Persona1> {

    private String nombre;
    private String telefono;

    public Persona1(String nombre, String telefono) {
        this.telefono = telefono;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public int compareTo(Persona1 obj) {
        if (this.nombre.compareTo(obj.nombre) == 0) {
            return (this.telefono.compareTo(obj.telefono));
        } else {
            return this.nombre.compareTo(obj.nombre);
        }
    }
    //metodo equals que junto con hasCode nos va a permitir qe una coleccion Set
    //no tenga elementos repetidos

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Persona1) {
            Persona1 otroIgual = (Persona1) obj;
            return (otroIgual.nombre.equals(nombre) && otroIgual.telefono.equals(telefono));
            //return (otroIgual.telefono.equals(telefono)&& otroIgual.nombre.equals(nombre));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return nombre.hashCode() + telefono.hashCode();
    }

    @Override
    public String toString() {
        return (nombre + " " + telefono);
    }

}
