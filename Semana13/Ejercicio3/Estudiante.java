package Semana13.Ejercicio3;

import java.text.Normalizer;

public class Estudiante {
    private String nombre;
    private String apellidos;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean mismoNombre(Estudiante otroEstudiante) {
        return this.nombre.toLowerCase().equals(otroEstudiante.getNombre().toLowerCase());
    }

    public String toString() {
        // Convertir a un String sin tildes con noimbre y apellidos
        String upperNoAccents = Normalizer.normalize(this.nombre.toUpperCase() + " " +  this.apellidos.toUpperCase(), Normalizer.Form.NFD);
        //Eliminar segundo apellido si procede
        if(upperNoAccents.length() > 15) {
            String[] removeSecondSurname = upperNoAccents.split(" ");
            upperNoAccents = removeSecondSurname[0] + " " + removeSecondSurname[1];
        }

        return upperNoAccents;
    }
}
