/***************************************/
/* Crear una lista que gestione los pacientes de un hospital. 
 * paciente = nombre, apellidos, edad, numeroHabitacion
 * metodo: ingreso (se le asigna una habitacion, tiene que estar libre)
 * 			alta (se borran)
 * 			consultas (buscar pacientes por nombre y apellidos o por habitacion)
 * 			listado (ordenado por nombre, ordenado por numeroHabitacion)
 * 			
 */
package hospital;

import java.util.*;

public class AppHospital
{
    public static void main(String[] args)
    {
        Scanner teclado=new Scanner(System.in);

        int cerrarApp=0;
        
        List<Paciente> listado = new ArrayList<>();

        while (cerrarApp==0)
        {
            menu();
            
            int opcion=teclado.nextInt();
            
            switch(opcion)
            {
                case 1: ingreso(listado);
                break;
                case 2: alta(listado);
                break;
                case 3: if(listado.isEmpty()){
                         System.out.println("NO HAY PACIENTES INGRESADOS");
                        }else{
                          System.out.println("Elige la opcion de busqueda: " +
                          "\n1.- Busqueda por nombre y apellido"
                          +"\n2.- Busqueda por habitacion");
                          int opcion2=teclado.nextInt();
                          switch(opcion2)
                          {
                            case 1: consultaNomAp(listado);
                            break;
                            case 2:consultaHab(listado);
                            break;
                          }
                         } 
                break;
                case 4: if(listado.isEmpty()){
                         System.out.println("NO HAY PACIENTES INGRESADOS");
                        }else{
                           listadoAp(listado);
                         }  
                break;
                case 5: if(listado.isEmpty()){
                         System.out.println("NO HAY PACIENTES INGRESADOS");
                        }else{ 
                          listadoHab(listado);
                        }  
                break;
                case 6: cerrarApp=1;
                break;
            }
        }
    }

    public static void menu()
    {
        System.out.print("\nElige una opcion:" +
                "\n1.- Ingreso paciente" +
                "\n2.- Dar de alta paciente" +
                "\n3.- Consultar paciente" +
                "\n4.- Listado de pacientes ordenados por apellido" +
                "\n5.- Listado de pacientes ordenados por numero de habitacion" +
                "\n6.- Cerrar la aplicacion\n");
    }
    public static void ingreso(List listado)
    {
        Scanner teclado=new Scanner(System.in);
        boolean libre=true;
        int numHab;
        System.out.println("ingreso DE PACIENTE");
        System.out.print("Dime un nombre: ");
        String nombre=teclado.nextLine();
        System.out.print("Dime apellidos: ");
        String apellidos=teclado.nextLine();
        System.out.print("Dime  edad: ");
        int edad=teclado.nextInt();
        do{
        System.out.print("Dime  numero de habitacion: ");
        numHab=teclado.nextInt();
        //teclado.nextLine();
        libre=habitacionLibre(listado,numHab);
        }while (!libre);
        listado.add(new Paciente(nombre,apellidos,edad,numHab));
        //teclado.nextLine();
        System.out.println("INGRESO REALIZADO");
    }
    
    public static void alta(List listado)
    {
        Scanner teclado=new Scanner(System.in);
        if (listado.isEmpty()){
            System.out.println("No tenemos ningun paciente ingresado");
        }
        else{
        Iterator it = listado.iterator();
        int i=1;
        System.out.println("\nELIGE QUE PACIENTE QUIERES BORRAR");
	while(it.hasNext())
        {
	  System.out.print(i+".- "+it.next().toString()+"\n");
          i++;
        }
        
        int pacBaja=teclado.nextInt();

        listado.remove(pacBaja-1);
       }
    }
    public static void consultaNomAp(List listado)
    {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Dime el nombre de la persona: ");
        String nombre=teclado.next();
        System.out.println("Dime el apellido de la persona: ");
        String apellido=teclado.next();
        boolean encontrado=false;

        System.out.println("\nDATOS DEL PACIENTE CONSULTADO");
        for(Object pac1:listado)
        {
            Paciente paciente=(Paciente)pac1;

            if ((paciente.getNombre().equalsIgnoreCase(nombre)) && (paciente.getApellidos().equalsIgnoreCase(apellido)))
            {
                System.out.println(paciente);
                encontrado=true;
            }
        }

        if (encontrado==false)
        {
            System.out.println("No existe ningun paciente con ese nombre y apellido");
        }
    }
    public static void consultaHab(List listado)
    {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Dime el numero de la habitacion: ");
        int hab=teclado.nextInt();
        boolean encontrado=false;

        System.out.println("\nDATOS DEL PACIENTE CONSULTADO");
        for(Object pac1:listado)
        {
            Paciente paciente=(Paciente)pac1;

            if (paciente.getNumHab()==hab)
            {
                System.out.println(paciente);
                encontrado=true;
            }
        }

        if (encontrado==false)
        {
            System.out.println("No hay ningun paciente en esa habitacion");
        }
    }
    public static boolean habitacionLibre(List listado, int hab){
        boolean libre=true;
         for(Object pac1:listado)
        {
            Paciente paciente=(Paciente)pac1;
            if (paciente.getNumHab()==hab)
            {
                System.out.println("habitacion ocupada, elige otra: ");
                libre=false;
            }
        }
         return libre;
    }
    public static void listadoAp(List listado)
    {
        Iterator it = listado.iterator();
        Collections.sort(listado);
        System.out.println("\nLISTADO DE PACIENTES POR APELLIDO");
	while(it.hasNext())
        {
	  System.out.println(it.next().toString());
        }
    }

    public static void listadoHab(List listado)
    {
        Iterator it = listado.iterator();
        Collections.sort(listado,new HabitacionesComparator());
        System.out.println("\nLISTADO DE PACIENTES POR NUMERO DE HABITACION");
	while(it.hasNext())
        {
	  System.out.println(it.next().toString());
        }
    }
}