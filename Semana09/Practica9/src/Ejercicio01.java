/*
 * No se han realizado diagramas de flujo para ningún ejercicio ya que se consideran elementales.
 */
class JugadorFutbol {
	private String nombre;
	private String apellidos;
	private String posicion;
	private int edad;
	private String equipo;

	public JugadorFutbol(String nombre, String apellidos, String posicion, int edad, String equipo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.posicion = posicion;
		this.edad = edad;
		this.equipo = equipo;
	}
	
	public JugadorFutbol() {
		this.nombre = "";
		this.apellidos = "";
		this.posicion = "";
		this.edad = 0;
		this.equipo = "";
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
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String toString() {
		return this.nombre + " " + this.apellidos + ", " + this.edad + " años. Juega de " + this.posicion + " en " + this.equipo + ".";
	}
	
	/* Método para clonar el objeto y sus valores, no las referencias */
	public JugadorFutbol clone() {
		JugadorFutbol jf = new JugadorFutbol();
		jf.nombre = this.nombre;
		jf.apellidos = this.apellidos;
		jf.edad = this.edad;
		jf.equipo = this.equipo;
		jf.posicion = this.posicion;
		return jf;
	}
	
}

public class Ejercicio01 {
	public static void main(String[] args) {
		JugadorFutbol jugador1 = new JugadorFutbol("Kultama", "Sánchez", "Banquillo Izquierda", 20, "UC3M");
		JugadorFutbol jugador2 = new JugadorFutbol();
		jugador2 = jugador1.clone();
		JugadorFutbol jugador3 = jugador1.clone();
		jugador3.setEdad(50);
		jugador3.setEquipo("HISPANIA RACING TEAM");
		System.out.println(jugador1);
		System.out.println(jugador2);
		System.out.println(jugador3);
	}
}
