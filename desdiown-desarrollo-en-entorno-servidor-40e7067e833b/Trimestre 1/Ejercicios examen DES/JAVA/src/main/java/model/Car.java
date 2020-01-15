package model;

import java.util.Date;

public class Car {
    private long id;
    private String coche;
    private boolean comprado;
    private Date fecha_compra;
    private int km;
    private int descuento;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getCoche()
    {
        return coche;
    }

    public void setCoche(String coche)
    {
        this.coche = coche;
    }

    public boolean isComprado()
    {
        return comprado;
    }

    public void setComprado(boolean comprado)
    {
        this.comprado = comprado;
    }

    public Date getFecha_compra()
    {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra)
    {
        this.fecha_compra = fecha_compra;
    }

    public int getKm()
    {
        return km;
    }

    public void setKm(int km)
    {
        this.km = km;
    }

    public int getDescuento()
    {
        return descuento;
    }

    public void setDescuento(int descuento)
    {
        this.descuento = descuento;
    }


}
