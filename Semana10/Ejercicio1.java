package Semana10;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class JugadorFutbol {
    private String nombre;
    private String apellido;
    private int anyos;
    private String posicion;
    private String equipo;

    public JugadorFutbol(String nombre, String apellido, int anyos, String posicion, String equipo) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setAnyos(anyos);
        this.setPosicion(posicion);
        this.setEquipo(equipo);
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

    public int getAnyos() {
        return anyos;
    }

    public void setAnyos(int anyos) {
        if(anyos >= 16 && anyos <= 50) {
            this.anyos = anyos;
        }
        else {
            System.out.println("Ajustada edad (fuera de rango 16-50) a 25.");
            this.anyos = 25;
        }
    }

    public String getPosicion() {
        return posicion;
    }

    private String[] getAvailablePositions() {
        return new String[]{"portero", "defensa", "centrocampista", "delantero"};
    }

    private void setRandomPosition() {
        int randomPosition = ThreadLocalRandom.current().nextInt(0, this.getAvailablePositions().length + 1);
        this.posicion = this.getAvailablePositions()[randomPosition];
    }

    private boolean isAvailablePosition(String position) {
        for(String itPosition: this.getAvailablePositions()){
            if(itPosition.equals(position))
                return true;
        }
        return false;
    }

    public void setPosicion(String posicion) {

        if(this.isAvailablePosition(posicion)) {
            this.posicion = posicion;
        }
        else {
            this.setRandomPosition();
        }
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    public String toString() {
        return this.nombre + " " + this.apellido + " tiene " + this.anyos + " años. Él es " + this.posicion + " del " + this.equipo;
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el nombre del jugador");
        String nombre = input.next();
        System.out.println("Introduce el apellido del jugador");
        String apellido = input.next();
        System.out.println("Introduce los años del jugador");
        int anyos = input.nextInt();
        System.out.println("Introduce la posición del jugador");
        String posicion = input.next();
        System.out.println("Introduce el equipo del jugador");
        String equipo = input.next();
        JugadorFutbol jugador = new JugadorFutbol(nombre, apellido, anyos, posicion, equipo);
        System.out.println(jugador);
        input.close();
    }
}
