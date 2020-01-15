/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist2ComparatorComparable;

/**
 *
 * @author user
 */
import java.text.*;
import java.util.*;
public class Persona implements Comparable{
        private String nombre;
    private String apellidos;
    private String dni;
    private int edad;

    public Persona(String nombre, String apellidos, String dni, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad= edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@Override
public int compareTo(Object o) {
        Persona persona = (Persona)o;

        if(this.apellidos.compareToIgnoreCase(persona.apellidos) == 0) {
            if(this.nombre.compareToIgnoreCase(persona.nombre) == 0) {
                return this.dni.compareTo(persona.dni);
            } 
        else {
                return this.nombre.compareToIgnoreCase(persona.nombre);
            }
        } else {
            return this.apellidos.compareToIgnoreCase(persona.apellidos);
        }

    }
   @Override
    public String toString() {
        return this.apellidos + " " + this.nombre + " " + this.dni + " "
        + this.edad;
    }

}

    

