package Semana10.Ejercicio5;

class Cancion {
    private String titulo;
    private int duracion; //en segundos, sin milesimas.
    private Persona autor;

    public Cancion() {}
    public Cancion(String titulo, int duracion, Persona autor) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }
    public String toString() {
        return this.titulo + ", con una duración de " + this.duracion + " segundos. Autor (" + this.autor + ")";
    }
}