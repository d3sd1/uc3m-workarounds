package Semana10;

class Isla {
    private String nombre;
    private float[] coordenadas;
    private String pais;
    private boolean permitidaVidaHumana;

    public Isla(String nombre, float[] coordenadas, String pais, boolean permitidaVidaHumana) {
        this.nombre = nombre;
        this.coordenadas = coordenadas;
        this.pais = pais;
        this.permitidaVidaHumana = permitidaVidaHumana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(float[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean isPermitidaVidaHumana() {
        return permitidaVidaHumana;
    }

    public void setPermitidaVidaHumana(boolean permitidaVidaHumana) {
        this.permitidaVidaHumana = permitidaVidaHumana;
    }
}

class Avion {
    private long idVuelo;
    private Isla origen;
    private Isla destino;
    private int asientos;
    private String estado;
    private String compañia;

    public Avion(long idVuelo, Isla origen, Isla destino, int asientos, String estado, String compañia) {
        this.idVuelo = idVuelo;
        this.origen = origen;
        this.destino = destino;
        this.asientos = asientos;
        this.estado = estado;
        this.compañia = compañia;
    }

    public long getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(long idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Isla getOrigen() {
        return origen;
    }

    public void setOrigen(Isla origen) {
        this.origen = origen;
    }

    public Isla getDestino() {
        return destino;
    }

    public void setDestino(Isla destino) {
        this.destino = destino;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public String getEstado() {
        return estado;
    }

    private boolean isEstadoValido(String estado) {
        String[] estados = new String[]{
                "Normal",
                "Restrasado",
                "Cancelado"
        };
        for(String itEstado : estados) {
            if(itEstado.toLowerCase().equals(estado.toLowerCase())) { //El tolowercase es importante por eso de la comparacion binaria :)
                return true;
            }
        }
        return false;
    }

    public void setEstado(String estado) {
        if(this.isEstadoValido(estado)) {
            this.estado = estado;
        }
        else {
            this.estado = "Cancelado";
        }
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }
}

class Pasajero {
    private long id;
    private String nombre;
    private String apellido;
    private Avion vuelo;

    public Pasajero(long id, String nombre, String apellido, Avion vuelo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.vuelo = vuelo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Avion getVuelo() {
        return vuelo;
    }

    public void setVuelo(Avion vuelo) {
        this.vuelo = vuelo;
    }
}

public class Ejercicio4 {
    public static void main(String[] args) {
        Isla amazonia = new Isla("Amazonia", new float[]{50.098739F, 70.090979F}, "Ribadejo", false);
        Isla atlantis = new Isla("Atlantis", new float[]{12.098739F, 05.090979F}, "Ribadejo", false); //No se admite vida humana, sólo pseudo-marina

        Avion aviador = new Avion(1, amazonia, atlantis, 30, "Volando", "RyanNotEvenAir");

        Pasajero keops = new Pasajero(1, "Keops", "El grande", aviador);
        Pasajero kefren = new Pasajero(1, "kefren", "El mediano", aviador);
        Pasajero micerinos = new Pasajero(1, "micerinos", "El pequeño", aviador);
    }
}
