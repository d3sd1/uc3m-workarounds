/*
 Ejemplo de herencia
 * contiene todos los constructores posibles
 
 */


package publicacion;


public class Publicacion {
   private int numPaginas;
   private float precio;
   
   Publicacion(){}
 

    Publicacion(int numpag) {
        this.numPaginas = numpag;

    }
 /*otra forma   
    Publicacion(int numpag) {
        setNumPaginas(numpag);

    }
*/
    Publicacion(float pvp) {
        this.precio = pvp;
    }

    Publicacion(int numpag, float pvp) {
        this.numPaginas = numpag;
        this.precio = pvp;
    }
   Publicacion(float pvp,int numpag) {
        this(numpag,pvp); //llama al constructor anterior
    }
    
   void setNumPaginas(int n){
       this.numPaginas=n;
   }
   void setPrecio(float p){
       this.precio=p;
   }
    @Override
    public String toString(){
       return("num paginas:"+numPaginas+"  precio:"+precio); 
    }
}
