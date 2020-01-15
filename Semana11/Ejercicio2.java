package Semana11;

import java.text.Normalizer;

class Alumno {
    private String nombre;
    private String apellidos;

    public Alumno(String nombre, String apellidos) {
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
    public String nombreFormulario() {
        String upperNoAccents = Normalizer.normalize(this.nombre.toUpperCase() + " " +  this.apellidos.toUpperCase(), Normalizer.Form.NFD);
        //Eliminar segundo apellido si procede
        if(upperNoAccents.length() > 15) {
            String[] removeSecondSurname = upperNoAccents.split(" ");
            upperNoAccents = removeSecondSurname[0] + " " + removeSecondSurname[1];
        }

        //Truncar a 15 si sigue excediendo
        if(upperNoAccents.length() > 15) {
            upperNoAccents.substring(0,14);
        }
        return upperNoAccents;
    }
}
public class Ejercicio2 {
    public static void main(String[] args) {
        Alumno[] alumnos = new Alumno[]{
                new Alumno("Andrei", "García Cuadra"),
                new Alumno("Silvia", "Noemi Santalla Arribas"),
                new Alumno("Julio", "Sesale Deltodo"),
                new Alumno("Klaus", "Meine"),
                new Alumno("Miguel", "Hernández"),
        };
        for(Alumno alumno:alumnos) {
            System.out.println(alumno.nombreFormulario());
        }
        buscarAlumno(alumnos,"ANdRei");
    }
    public static void buscarAlumno(Alumno[] alumnos, String nombreBuscado) {
        for(Alumno alumno:alumnos) {
            if(alumno.getNombre().toLowerCase().equals(nombreBuscado.toLowerCase())) {
                System.out.println("Alumno encontrado! " + nombreBuscado);
            }
        }
    }
}
