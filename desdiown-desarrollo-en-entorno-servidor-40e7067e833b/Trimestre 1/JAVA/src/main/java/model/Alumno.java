package model;

import java.util.Date;

public class Alumno {
    
    private int id;
    private String nombre;
    private Date fecha_nacimiento;
    private Boolean mayor_edad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Boolean getMayor_edad() {
        return mayor_edad;
    }

    public void setMayor_edad(Boolean mayor_edad) {
        this.mayor_edad = mayor_edad;
    }

  
    public Alumno() {
    }

   
    
}
