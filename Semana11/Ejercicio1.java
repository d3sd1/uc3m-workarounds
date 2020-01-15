package Semana11;

import java.util.Scanner;

class Hora {
    private byte horas;
    private byte minutos;
    private boolean formato24H;

    public Hora(boolean formato24H) {
        this.formato24H = formato24H;
        this.horas = 12;
        this.minutos = 00;
    }

    public byte getHoras() {
        return horas;
    }

    public void setHoras(byte horas) {

        if(horas < 24) {
            this.horas = horas;
        }
    }
    public void setHoras(int horas) {

        if(horas < 24) {
            this.horas = (byte) horas;
        }
    }

    public byte getMinutos() {
        return minutos;
    }

    public void setMinutos(byte minutos) {
        if(minutos < 60) {
            this.minutos = minutos;
        }
    }
    public void setMinutos(int minutos) {
        if(minutos < 60) {
            this.minutos = (byte) minutos;
        }
    }
    public String getFormato24H() {
        return this.horas + ":" + this.minutos;
    }

    public boolean isFormato24H() {
        return formato24H;
    }

    public void setFormato24H(boolean formato24H) {
        this.formato24H = formato24H;
    }
    public void ponerHora(String horaTexto) {
        String[] desglose = horaTexto.split(":");
        this.horas = Byte.parseByte(desglose[0]);
        this.minutos = Byte.parseByte(desglose[1]);
    }
    public String toString() {
        if(this.formato24H) {
            return this.horas + ":" + this.minutos;
        }
        else {
            String dayPart = "AM";
            byte horas = this.horas;
            if(this.horas > 12) {
                horas = (byte) (horas -  12);
                dayPart = "PM";
            }
            return horas + ":" + this.minutos + " " + dayPart;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Hora))
            return false;
        if (obj == this)
            return true;
        Hora comparativa = (Hora) obj;
        return this.getHoras() == comparativa.getHoras() && this.getMinutos() == comparativa.getMinutos();
    }
}
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Hora hora1 = new Hora(true);
        System.out.println("Introduce las horas (1)");
        hora1.setHoras(input.nextByte());
        System.out.println("Introduce los minutos (1)");
        hora1.setMinutos(input.nextByte());

        Hora hora2 = new Hora(false);
        System.out.println("Introduce las horas (2)");
        hora2.setHoras(input.nextByte());
        System.out.println("Introduce los minutos (2)");
        hora2.setMinutos(input.nextByte());

        System.out.println("Hora 1: " + hora1);
        System.out.println("Hora 2: " + hora2);

        if(hora1.equals(hora2)) {
            System.out.println("Las horas son iguales.");
        }
        else {
            System.out.println("Las horas no son iguales.");
        }
        input.close();
    }
}
