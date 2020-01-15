package Semana12.Ejercicio1;

import java.util.concurrent.ThreadLocalRandom;

public class Jugador implements Estrategia {
    private String nombre;
    private int puntuacion = 0;
    private String estrategia;
    private String eleccion;
    private String lastElection;

    public Jugador() {
        this.eleccion = "";
        this.lastElection = "";
    }

    public Jugador(String nombre, int puntuacion, String estrategia) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.estrategia = estrategia;
        this.eleccion = "";
        this.lastElection = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = "AZAR"; //Opcion por defecto
        for(String mode:ENABLED_ESTRATEGIES) {
            if(mode.toUpperCase().equals(estrategia.toUpperCase())) {
                this.estrategia = estrategia.toUpperCase();
            }
        }
    }

    public void sumarPunto() {
        this.puntuacion++;
    }

    public String getEleccion() {
        return eleccion != null ? eleccion.toUpperCase():eleccion;
    }

    public void detEleccion(String ultimaOpcionGanadora) {
        String eleccion = "";
        //Opcion pasada, antes de poner la actual
        this.lastElection = this.eleccion;

        //Determinar nueva elección
        switch(this.estrategia.toUpperCase()) {
            default:
            case "AZAR":
                switch(ThreadLocalRandom.current().nextInt(0, 2 + 1)) {
                    default:
                    case 0:
                        eleccion = "PIEDRA";
                        break;
                    case 1:
                        eleccion = "PAPEL";
                        break;
                    case 2:
                        eleccion = "TIJERA";
                        break;
                }

                break;
            case "CICLICA":
                if(this.lastElection == null || this.lastElection == "TIJERA") {
                    eleccion = "PIEDRA";
                }
                else if(this.lastElection == "PIEDRA") {
                    eleccion = "PAPEL";
                }
                else if(this.lastElection == "PAPEL") {
                    eleccion = "TIJERA";
                }
                else { //JIC
                    eleccion = "PIEDRA";
                }
                break;
            case "COPIA":
                if(ultimaOpcionGanadora == null) {
                    ultimaOpcionGanadora = "TIJERA"; //Por defecto dejamos tijeras como jugada ganadora.
                }
                eleccion = ultimaOpcionGanadora;
                break;
        }
        this.eleccion = eleccion;
    }
}
