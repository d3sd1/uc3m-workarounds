package Semana10;

import java.util.AbstractMap.SimpleEntry;
import java.util.Scanner;
/*
* En este caso he optado por la clase SimpleEntry para la modificación requerida.
* ¿Por qué SimpleEntry y no una lista o un map común? Ya que permite editar el valor, pero no la clave (ni eliminarla).
* Del mismo modo ha simplificado el ejercicio, si hubiera creado una clase "nota" no habría tenido esta integració, pero habría sido otra solución.
 */


class Estudiante2 {
    private String nombre;
    private String apellido;
    private SimpleEntry<String, Float>[] notas;

    public Estudiante2(String nombre, String apellido, float notaProgramacion, float notaAlgebra, float notaCalculo,
                      float notaFisica, float notaEscritura, float notaInformacion) {
        this.setNombre(nombre);
        this.setApellido(apellido);

        /* Create object matrix pair */

        this.notas = new SimpleEntry[] {
                new SimpleEntry<>("programacion", 0F),
                new SimpleEntry<>("algebra", 0F),
                new SimpleEntry<>("calculo", 0F),
                new SimpleEntry<>("fisica", 0F),
                new SimpleEntry<>("escritura", 0F),
                new SimpleEntry<>("informacion", 0F)
        };

        this.setNotaProgramacion(notaProgramacion);
        this.setNotaAlgebra(notaAlgebra);
        this.setNotaCalculo(notaCalculo);
        this.setNotaFisica(notaFisica);
        this.setNotaEscritura(notaEscritura);
        this.setNotaInformacion(notaInformacion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getNotaProgramacion() {
        return this.getNota("programacion");
    }

    private void setNota(String asignatura, float nota) {
        for(int i = 0; i < this.notas.length ; i++) {
            SimpleEntry<String, Float> asig = this.notas[i];
            //revisar si es ésta la asignatura a actualizar
            if(asig.getKey().equals(asignatura)) {
                //nota válida o no
                if(this.validarNota(nota)) {
                    this.notas[i].setValue(nota);
                }
                else {
                    this.notas[i].setValue(0F);
                }
                //Detener bucle, ya asignamos la nota.
                break;
            }
        }
    }

    private float getNota(String asignatura) {
        for(SimpleEntry<String, Float> nota : this.notas) {
            if(nota.getKey().equals(asignatura)) {
                return nota.getValue();
            }
        }
        System.out.println("Asignatura no encontrada: " + asignatura);
        return -1F;
    }

    public void setNotaProgramacion(float notaProgramacion) {
        this.setNota("programacion", notaProgramacion);
    }

    public float getNotaAlgebra() {
        return this.getNota("algebra");
    }

    public void setNotaAlgebra(float notaAlgebra) {
        this.setNota("algebra", notaAlgebra);
    }

    public float getNotaCalculo() {
        return this.getNota("calculo");
    }

    public void setNotaCalculo(float notaCalculo) {
        this.setNota("calculo", notaCalculo);
    }

    public float getNotaFisica() {
        return this.getNota("fisica");
    }

    public void setNotaFisica(float notaFisica) {
        this.setNota("fisica", notaFisica);
    }

    public float getNotaEscritura() {
        return this.getNota("escritura");
    }

    public void setNotaEscritura(float notaEscritura) {
        this.setNota("escritura", notaEscritura);
    }

    public float getNotaInformacion() {
        return this.getNota("informacion");
    }

    public void setNotaInformacion(float notaInformacion) {
        this.setNota("informacion", notaInformacion);
    }

    private boolean validarNota(float nota)
    {
        return nota <= 10 && nota >= 0;
    }
    public String toString() {
        return this.getNombre() + ", " + this.getApellido() + ". NOTAS: "
                + "Programación -> " + this.getNotaProgramacion()
                + " Álgebra -> " + this.getNotaAlgebra()
                + " Cálculo -> " + this.getNotaCalculo()
                + " Física -> " + this.getNotaFisica()
                + " Técnicas de expresión oral y escrita -> " + this.getNotaEscritura()
                + " Técnicas de búsqueda y uso de la información -> " + this.getNotaInformacion();
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nombre, apellidos;
        float notaProgramacion, notaAlgebra, notaCalculo, notaFisica, notaEscritura, notaInformacion;

        System.out.println("Introduce el nombre del estudiante: ");
        nombre = input.nextLine();

        System.out.println("Introduce los apellidos del estudiante: ");
        apellidos = input.nextLine();

        System.out.println("Introduce la nota en programación del estudiante: ");
        notaProgramacion = input.nextFloat();

        System.out.println("Introduce la nota en álgebra del estudiante: ");
        notaAlgebra = input.nextFloat();

        System.out.println("Introduce la nota en cálculo del estudiante: ");
        notaCalculo = input.nextFloat();

        System.out.println("Introduce la nota en física del estudiante: ");
        notaFisica = input.nextFloat();

        System.out.println("Introduce la nota en técnicas de expresión oral y escrita del estudiante: ");
        notaEscritura = input.nextFloat();

        System.out.println("Introduce la nota en técnicas de búsqueda y uso de la información del estudiante: ");
        notaInformacion = input.nextFloat();

        Estudiante estudiante = new Estudiante(nombre, apellidos, notaProgramacion, notaAlgebra, notaCalculo, notaFisica, notaEscritura, notaInformacion);

        System.out.println(estudiante);

        input.close();
    }
}
