
package profe.correoelectronico;

import java.util.Scanner;


public class PruebaGestorCorreo {
    public static void main(String[] args) {
        
        ListaCorreos lista = new ListaCorreos();
                
        // CORREO INICIAL para PRUEBAS
        Correo a = new Correo("aa@mail.com", "daa@gmail.com", "Desvanecimiento", "Tengo una sensacion de desvanecimiento, ¿sera el calor?");
        Correo b = new Correo("bb@gmail.net", "dbb@telefonica.net", "Noticion ", "Pues como te decia, ayer paso que ,. . ..  .... y eso fue.");
        Correo c = new Correo("aa@hotmail.com", "caa@yahoo.es", "Trabajo", "Estimado Frank, queremos contar con usted en un importante proyecto,...... envienos su CV actualizado.");
        
        // AÑADIR CORREOS A LA LISTACORREOS
        lista.anadirCorreo(a);
        lista.anadirCorreo(b);
        lista.anadirCorreo(c);
                
        

        System.out.println("\n---------- BANDEJA DE ENTRADA------------\n");
        lista.verBandejaEntrada();
        
        
        // LEER
        Scanner leer = new Scanner(System.in);
       
        // Array con las frases del MENU
        String[] texto = {
            "Bandeja de entrada",
            "Añadir correo",
            "Eliminar correo",
            "Mostrar un correo",
            "Mostrar todos los correos",
            "Mostrar un correo a partir de su origen",
            "Salir del Programa"
        };

        

        int opcion;
        int indice;

        
        do {       
            System.out.println("\n---------- MENU con las OPCIONES ------------\n");
            
            // Visualizamos el Array del texto con las Opciones
            for (int i = 0; i < texto.length; i++) {
                String cadena = "\t\t" + i + ".- " + texto[i];
                System.out.println(cadena);
            }

            // Numero de opcion
            System.out.println("Introduce Opcion:");
            opcion = leer.nextInt();

            
            // SWITCH de las OPCIONES CASE introducidas por numero
            switch(opcion) {
                case 0:
                    System.out.println("\n---------- BANDEJA DE ENTRADA------------\n");
                    lista.verBandejaEntrada();
                    break;
                    
                    
                case 1:
                    System.out.println("\n---------- Añadir correo ------------\n");
                    System.out.println("Introduce Origen:");                  
                    String origen = leer.next();
                    
                    System.out.println("Introduce Destino:");                  
                    String destino = leer.next();
                                        
                    leer.nextLine();    // esto es para limpiar el buffer,... por el antes usado -->  opcion = leer.nextInt(); ..... al leer.next(); no le afecta este problema
                    
                    System.out.println("Introduce Asunto:");                  
                    String asunto = leer.nextLine();

                    System.out.println("Introduce Mensaje:");                  
                    String mensaje = leer.nextLine();

                    Correo nuevoCorreo = new Correo(origen, destino, asunto, mensaje);
                    lista.anadirCorreo(nuevoCorreo);
                    break;
                    
                    
                case 2:
                    System.out.println("\n---------- Eliminar correo ------------\n");
                    System.out.println("Cual desea eliminar?");
                    
                    indice = leer.nextInt();
                    lista.eliminarCorreo(indice);
                    break;

                    
                case 3:
                    System.out.println("\n---------- Mostrar un correo ------------\n");
                    System.out.println("Cual deseas ver?");
                    
                    indice = leer.nextInt();
                    lista.verMensaje(indice);
                    break;
                    
                    
                case 4:
                    System.out.println("\n---------- Mostrar todos los correos ------------\n");
                    lista.verTodosMensajes();
                    break;
                    
                    
                case 5:
                    System.out.println("\n---------- Mostrar un correo a partir de su origen ------------\n");
                    System.out.println("Introduce Origen:");                  
                   
                    String cualOrigen = leer.next();
                    lista.verMensajesOrigen(cualOrigen);                    
                    break;
                    
                    
                case 6:
                    System.out.println("\n  FIN DEL PROGRAMA");
                    break;
                    
            }//end switch
        }while (opcion != 6);
     
        
        
        
    }
    
     
}
