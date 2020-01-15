package Semana12.Ejercicio1;

public class Partida {
    private String ultimaOpcionGanadora;
    private Jugador[] jugadores;

    public Partida() {
    }

    public Partida(String ultimaOpcionGanadora, Jugador[] jugadores) {
        this.ultimaOpcionGanadora = ultimaOpcionGanadora;
        this.jugadores = jugadores;
    }

    public String getUltimaOpcionGanadora() {
        return ultimaOpcionGanadora;
    }

    public void setUltimaOpcionGanadora(String ultimaOpcionGanadora) {
        this.ultimaOpcionGanadora = ultimaOpcionGanadora;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadoores) {
        this.jugadores = jugadoores;
    }

    //Función que comprueba si es jugada ganadora para el jugador1
    private boolean esJugadaGanadora(Jugador jugador1, Jugador jugador2) {
        if(
                (jugador1.getEleccion().equals("PIEDRA") && jugador2.getEleccion().equals("TIJERA")) ||
                (jugador1.getEleccion().equals("TIJERA") && jugador2.getEleccion().equals("PAPEL")) ||
                (jugador1.getEleccion().equals("PAPEL") && jugador2.getEleccion().equals("PIEDRA"))
        ) {
            return true;
        }
        //No hace falta comprobar más ya que el resto de opciones son perdedoras
        return false;
    }

    private boolean esJugadaEmpate(Jugador jugador1, Jugador jugador2) {
        if(jugador1.getEleccion().equals(jugador2.getEleccion())) {
            return true;
        }
        return false;
    }

    public void hacerJugada() {
        Jugador ganador = null;
        boolean empate = false;
        for(Jugador jugador:this.jugadores) {
            jugador.detEleccion(this.ultimaOpcionGanadora);
            System.out.println(jugador.getNombre() + " saca " + jugador.getEleccion());
            if(ganador == null ) {
                ganador = jugador;
            } else if(this.esJugadaEmpate(jugador, ganador)) {
                empate = true;
            } else if(this.esJugadaGanadora(jugador, ganador)) {
                ganador = jugador;
            }
        }
        if(!empate) {
            System.out.println("El ganador es: " + ganador.getNombre());
            ganador.sumarPunto();
        }
        else {
            System.out.println("Jugada empatada.");
        }
    }
}
