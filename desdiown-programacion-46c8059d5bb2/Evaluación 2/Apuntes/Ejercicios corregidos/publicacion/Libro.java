/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publicacion;

/**
 *
 * @author user
 */
public class Libro extends Publicacion{
    private String titulo;
    private String autor;
    private String editorial;
    
    Libro(){}
   /* Libro(){
       titulo="";
       autor="";
       editorial="";
    }*/
    Libro(String tit, String aut, String edi) {
        //super();//opcional
        titulo = tit;
        autor = aut;
        editorial = edi;
    }

    Libro(int npag, float pvp, String tit, String aut, String edi) {
        super(npag, pvp);//en este caso es obligatorio
        titulo = tit;
        autor = aut;
        editorial = edi;
    }
    void setTitulo(String t){
        titulo=t;
    }
    void setAutor(String a){
        autor=a;
    }
    void setEditorial(String e){
        editorial=e;
    }
    void probar(){
        super.setPrecio(80);
    }
    
    @Override
    public String toString(){
        String s=super.toString();
        return(s+" titulo:"+titulo+" autor:"+autor+"  editorial:"+editorial);
    }
}
