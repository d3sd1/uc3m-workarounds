package rectangulo;
public class Rectangulo {
    int x,y,ancho,alto;
    int calcularArea()
    {
     return (ancho*alto);   
    }
    //Constructores
    Rectangulo(int x, int y, int ancho, int alto)
    {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }
    boolean estaDentro(int x1, int y1)
    {
        if((x1>x)&&(x1<x+ancho)&&(y1>y)&&(y1<y+ancho))
        {
            return true;
        }
        return false;
    }
    void desplazar(int dx, int dy)
    {
        x+=dx;
        y+=dy;
    }
}