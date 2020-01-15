package Semana10.Ejercicio5;

import java.util.ArrayList;

class Album {
    private String titulo;
    private int anyoPublicacion;
    private ArrayList<Cancion> canciones;
    private float pvp;

    public Album() {
    }

    public Album(String titulo, int anyoPublicacion, ArrayList<Cancion> canciones, float pvp) {
        this.titulo = titulo;
        this.anyoPublicacion = anyoPublicacion;
        this.canciones = canciones;
        this.pvp = pvp;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnyoPublicacion() {
        return anyoPublicacion;
    }

    public void setAnyoPublicacion(int anyoPublicacion) {
        this.anyoPublicacion = anyoPublicacion;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

    public String toString() {
        return this.titulo + ", del año " + this.anyoPublicacion;
    }
}