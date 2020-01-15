package model;

public class Nota {
    
    private int ID_ALUMNO;
    private int ID_ASIGNATURA;
    private int NOTA;

    public int getID_ALUMNO()
    {
        return ID_ALUMNO;
    }

    public void setID_ALUMNO(int ID_ALUMNO)
    {
        this.ID_ALUMNO = ID_ALUMNO;
    }

    public int getID_ASIGNATURA()
    {
        return ID_ASIGNATURA;
    }

    public void setID_ASIGNATURA(int ID_ASIGNATURA)
    {
        this.ID_ASIGNATURA = ID_ASIGNATURA;
    }

    public int getNOTA()
    {
        return NOTA;
    }

    public void setNOTA(int NOTA)
    {
        this.NOTA = NOTA;
    }
}