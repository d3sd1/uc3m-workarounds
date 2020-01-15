package Semana12.Ejercicio1;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ejercicio1 {
    public static void main(String[] args) {
        Partida match = new Partida();
        Scanner input = new Scanner(System.in);
        int jugadasTotales = 25; //TOTAL DE JUGADAS
        int numeroJugadores = 2; //funciona con 2


        Jugador[] jugadores = new Jugador[numeroJugadores];
        for(int i = 1; i <= numeroJugadores; i++) {
            Jugador jugador = new Jugador();
            System.out.println("Introduce el nombre del jugador " + i);
            jugador.setNombre(input.next());
            System.out.println("Introduce la estrategia (AZAR, CICLICA o COPIA) del jugador " + i);
            jugador.setEstrategia(input.next());
            jugadores[i-1] = jugador;
        }
        match.setJugadores(jugadores);


        for(int i = 1; i <= jugadasTotales; i++) {
            System.out.println("--- RONDA " + i + " ---");
            match.hacerJugada();
            try {
                //Esperar 2 segundos entre cada jugada para darle emocion
                TimeUnit.SECONDS.sleep(2);
            }
            catch(Exception e) {

            }
            System.out.println("------------------");
        }

        System.out.println("Marcador final:");

        Jugador ganadorFinal = null;
        int jugadasGanadas = 0;
        for(Jugador jugador:jugadores) {
            if(ganadorFinal == null || ganadorFinal.getPuntuacion() < jugador.getPuntuacion()) {
                ganadorFinal = jugador;
            }
            System.out.println(jugador.getNombre() + ", con una puntuación de : " + jugador.getPuntuacion());
            jugadasGanadas += jugador.getPuntuacion();
        }
        System.out.println("Jugadas empatadas: " + (jugadasTotales - jugadasGanadas));

        System.out.println("Ganador final indiscutible... ¡" + ganadorFinal.getNombre() + "! Con una puntuación de " + ganadorFinal.getPuntuacion());

        input.close();
    }
}
