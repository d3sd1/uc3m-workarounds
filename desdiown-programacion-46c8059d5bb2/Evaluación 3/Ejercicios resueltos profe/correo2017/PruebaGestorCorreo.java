
package profe.correo2017;


import java.util.*;
public class PruebaGestorCorreo {
    public static Scanner leer = new Scanner(System.in);
    public static ArrayList<Correo> correos = new ArrayList();
    public static void main(String args[])
    {
        
        
        int opc;
        do
        {
            menu();
            System.out.print("\tSelecciona una opcion: ");
            opc=leer.nextInt();
            switch(opc)
            {
                case 1:
                    añadirCorreo();
                    break;
                case 2:
                    eliminarCorreo();
                    break;
                case 3:
                    bandejaEntrada();
                    break;
                case 4:
                    verMensaje();
                    break;
                            
                case 5:
                    verTodos();
                    break;
                case 6 :
                    verOrigen();
                    break;
                case 7:
                    System.out.println("Final del programa");
                    break;
                default:
                    System.out.println("\t¡Opcion incorrecta!");
            }
            
        } while(opc!=7);
        
    }
    public static  void menu()
    {
        System.out.println("\n\t1.-Añadir Correo");
        System.out.println("\t2.-Eliminar Correo");
        System.out.println("\t3.-Bandeja de entrada");
        System.out.println("\t4.-Ver mensaje");
        System.out.println("\t5.-Ver todos los mensajes");
        System.out.println("\t6.-Ver mensaje a partir de origen");
        System.out.println("\t7.-Salir");
    }
    public static void añadirCorreo()
    {
        Correo correo;
        String de, para, asunto, mensaje;
        System.out.print("\nIntroduce tu nombre: ");
        de=leer.next();
        System.out.print("introduce el nombre del destinatario: ");
        para=leer.next();
        System.out.print("Asunto: ");
        asunto=leer.next();
        leer.nextLine();
        System.out.print("Mensaje: ");
        mensaje=leer.nextLine();
        correo= new Correo(de,para,asunto,mensaje);
        correos.add(correo);
        
    }
    public static void eliminarCorreo()
    {
        int pos;
        System.out.print("\nIntroduce el numero del objeto que quieres eliminar: ");
        pos=leer.nextInt();
        if(correos.size()>=pos){
          correos.remove(pos);
        }
        else{
            System.out.println("Ese correo no existe");
        }
    }
    public static void bandejaEntrada()
    {
        if(correos.size()>=1)
        {            
            System.out.println("\n\tBANDEJA DE ENTRADA");
            for(int i=0;i<correos.size();i++)
            {
                System.out.println("\nMENSAJE NUMERO "+i+"-> De: "+correos.get(i).getOrigen()+" Asunto: "+correos.get(i).getAsunto());
            }
        }
        else
        {
            System.out.println("\tBANDEJA VACIA");
        }
    }
    public static void verMensaje()
    {
        int pos;
        System.out.print("Introduce el numero de mensaje que quieres ver: ");
        pos=leer.nextInt();
        System.out.println("\nMENSAJE "+pos);
        if(correos.size()>=pos){
            System.out.println(correos.get(pos).toString());
        }
        else{
            System.out.println("Ese correo no existe, hay "+correos.size()+" correos");
        }
    }
    public static void verTodos()
    {
        System.out.println();
        if(correos.size()>=1)
        {            
            
            for(int i=0;i<correos.size();i++)
            {
                System.out.println("MENSAJE NUMERO "+i+" "+correos.get(i).toString());
                System.out.println("---------------------------------------------");
            }
        }
        else
        {
            System.out.println("\tBANDEJA VACIA");
        }
    }
    public static void verOrigen()
    {
        System.out.println("Introduce origen:");
        String cadena=leer.next();
        int sw=0;
        if(!correos.isEmpty()){
            for (int i = 0; i < correos.size(); i++) {
            // Hacemos CASTING del Objeto de lista, para convertirlo a objeto Correo a la instancia de 'correoGet'
            Correo correoGet = (Correo)correos.get(i);
            // Este es el 'equals' y hashCode que hemos '@Override' necesario en la 'Clase Correo'
            // para que pregunte si true/false solo por el 'origen'.
            if (correoGet.getOrigen().equalsIgnoreCase(cadena) ){
                System.out.println( i + " " + correoGet.getCuerpo() );
                sw=1;
            }
            
        }
            if(sw==0){
                System.out.println("No existe ningun correo con ese origen"); 
            }
        }
        else{
            System.out.println("no hay correos!!!!!!");
        }
    }
}
