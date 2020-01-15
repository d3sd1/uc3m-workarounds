package InterfazSet.agenda;

public class Persona implements Comparable<Persona> {

    private String nombre;
    private String telefono;

    public Persona(String nombre, String telefono) {
        this.telefono = telefono;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public int compareTo(Persona obj) {
        return this.nombre.compareTo(obj.nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Persona) {
            Persona otroIgual = (Persona) obj;
            return otroIgual.nombre.equals(nombre) && otroIgual.telefono.equals(telefono);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return nombre.hashCode() + telefono.hashCode();
    }

    @Override
    public String toString() {
        return (nombre + " " + telefono);
    }

}
