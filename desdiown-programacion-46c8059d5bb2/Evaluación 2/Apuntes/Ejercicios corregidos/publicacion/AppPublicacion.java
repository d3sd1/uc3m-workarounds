
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publicacion;

/**
 *
 * @author user
 */
public class AppPublicacion {
    public static void main(String args[]){
        Libro libro1=new Libro();
        System.out.println("libro1\n"+libro1);
        libro1.setPrecio(15);
        libro1.setNumPaginas(180);
        libro1.setAutor("Calderon");
        libro1.setEditorial("anaya");
        libro1.setTitulo("La vida es sueño");
        System.out.println("libro1\n"+libro1);
        Libro libro2=new Libro();
        System.out.println("libro2\n"+libro2);
        Libro libro3=new Libro("El camino","Miguel Delibes","alianza");
        System.out.println("libro3\n"+libro3);
        Libro libro4=new Libro(150,17,"El camino","Miguel Delibes","alianza");
        System.out.println("libro4\n"+libro4);
        libro4.probar();//cambio el precio del libro
        System.out.println("libro4\n"+libro4);
        
        
        
    }   
}
    
