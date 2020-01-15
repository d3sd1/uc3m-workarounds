package Semana13.Ejercicio3;

public class Programacion {
    private Estudiante[] estudiantes;

    public Programacion() {
        this.estudiantes = new Estudiante[5];
    }

    public boolean anadirEstudiante(Estudiante t) {
        boolean added = false;

        for(int i = 0; i < estudiantes.length; i++) {
            if(this.estudiantes[i] == null) {
                this.estudiantes[i] = t;
                added = true;
                break;
            }
        }

        return added;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        for(Estudiante t:this.estudiantes) {
            sb.append(t).append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }

    public byte searchEstudiante(Estudiante t) {
        for(byte i = 0; i < this.estudiantes.length; i++) {
            if(t.toString().toLowerCase().equals(this.estudiantes[i].toString().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

}
