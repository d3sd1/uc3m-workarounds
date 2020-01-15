package model;

import java.time.LocalDateTime;

public class User {
    private long ID;
    private String NOMBRE;
    private String PASSWORD;
    private boolean ACTIVO;
    private String CODIGO_ACTIVACION;
    private LocalDateTime FECHA_ACTIVACION;
    private String EMAIL;

    public long getID()
    {
        return ID;
    }

    public void setID(long ID)
    {
        this.ID = ID;
    }

    public String getNOMBRE()
    {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE)
    {
        this.NOMBRE = NOMBRE;
    }

    public String getPASSWORD()
    {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD)
    {
        this.PASSWORD = PASSWORD;
    }

    public boolean isACTIVO()
    {
        return ACTIVO;
    }

    public void setACTIVO(boolean ACTIVO)
    {
        this.ACTIVO = ACTIVO;
    }

    public String getCODIGO_ACTIVACION()
    {
        return CODIGO_ACTIVACION;
    }

    public void setCODIGO_ACTIVACION(String CODIGO_ACTIVACION)
    {
        this.CODIGO_ACTIVACION = CODIGO_ACTIVACION;
    }

    public LocalDateTime getFECHA_ACTIVACION()
    {
        return FECHA_ACTIVACION;
    }

    public void setFECHA_ACTIVACION(LocalDateTime FECHA_ACTIVACION)
    {
        this.FECHA_ACTIVACION = FECHA_ACTIVACION;
    }

    public String getEMAIL()
    {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL)
    {
        this.EMAIL = EMAIL;
    }
    
}
