package Semana10.Ejercicio5;

import java.util.ArrayList;

class Banda {
    private String nombre;
    private int anyoCreacion;
    private ArrayList<Persona> miembros;
    private ArrayList<Album> albumes;

    public Banda() {
    }

    public Banda(String nombre, int anyoCreacion, ArrayList<Persona> miembros, ArrayList<Album> albumes) {
        this.nombre = nombre;
        this.anyoCreacion = anyoCreacion;
        this.miembros = miembros;
        this.albumes = albumes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyoCreacion() {
        return anyoCreacion;
    }

    public void setAnyoCreacion(int anyoCreacion) {
        this.anyoCreacion = anyoCreacion;
    }

    public String toString() {
        return this.nombre + ", fundada en " + this.anyoCreacion;
    }


    public ArrayList<Persona> getMiembros() {
        return miembros;
    }

    public void setMiembros(ArrayList<Persona> miembros) {
        this.miembros = miembros;
    }

    public ArrayList<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(ArrayList<Album> albumes) {
        this.albumes = albumes;
    }
}