package personas;

public class personasClass {
    int[] numeros = {67574736,68574837,65975855};
    String[] personas = {"Erasto","Eduardo","Rafiña"};
    String abecedario = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public void insertar(int numero, String persona)
    {
        boolean numRepetido = false;
        boolean nombreRepetido = false;
        for(int i = 0; i < numeros.length; i++)
        {
            if(numeros[i] == numero)
            {
                numRepetido = true;
            }
            if(personas[i].equals(persona))
            {
                nombreRepetido = true;
            }
        }
        if(!numRepetido && !nombreRepetido)
        {
            int[] numerosNuevos = new int[(numeros.length+1)];
            String[] personasNuevas = new String[(personas.length+1)];
            for(int i = 0; i < (numeros.length+1); i++)
            {
                if(i < numeros.length)
                {
                    numerosNuevos[i] = numeros[i];
                    personasNuevas[i] = personas[i];
                }
                else
                {
                    numerosNuevos[i] = numero;
                    personasNuevas[i] = persona;
                }
            }
            numeros = numerosNuevos;
            personas = personasNuevas;
            System.out.println("Añadido correctamente.");
            this.ver();
        }
        else
        {
            if(nombreRepetido)
            {
                System.out.println("El nuevo registro no se añadió: Ya existe un contacto con el nombre especificado.");
            }
            if(numRepetido)
            {
                System.out.println("El nuevo registro no se añadió: Ya existe un contacto con el número especificado.");
            }
        }
    }
    public void ver()
    {
        System.out.println("---------AGENDA---------");
        for(int i = 0; i < personas.length; i++)
        {
            System.out.println(personas[i] + ": " + numeros[i]);
        }
        System.out.println("------------------------");
    }
    public void ayuda()
    {
        System.out.println(ANSI_RED + "----------------------------------------------" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "¡Bienvenid@ al panel de ayuda!" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Comandos disponibles:" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "ayuda" + ANSI_RESET + ANSI_GREEN + ": Muestra este panel.");
        System.out.println(ANSI_BLUE + "ver" + ANSI_RESET + ANSI_GREEN + ": Muestra la agenda.");
        System.out.println(ANSI_BLUE + "insertar " + ANSI_RESET + ANSI_PURPLE + "[nombre] [telefono]" + ANSI_RESET + ANSI_GREEN + ": Inserta un nuevo registro a la agenda.");
        System.out.println(ANSI_BLUE + "eliminar " + ANSI_RESET + ANSI_PURPLE + "[telefono]" + ANSI_RESET + ANSI_GREEN + ": Elimina un registro de la agenda.");
        System.out.println(ANSI_BLUE + "eliminar " + ANSI_RESET + ANSI_PURPLE + "[nombre]" + ANSI_RESET + ANSI_GREEN + ": Elimina un registro de la agenda.");
        System.out.println(ANSI_BLUE + "buscar " + ANSI_RESET + ANSI_PURPLE + "[telefono]" + ANSI_RESET + ANSI_GREEN + ": Busca un registro por nombre.");
        System.out.println(ANSI_BLUE + "buscar " + ANSI_RESET + ANSI_PURPLE + "[nombre]" + ANSI_RESET + ANSI_GREEN + ": Busca un registro por teléfono.");
        System.out.println(ANSI_BLUE + "ordenar " + ANSI_RESET + ANSI_PURPLE + "[telefono/nombre] [ascendente/descendente]" + ANSI_RESET + ANSI_GREEN + ": Ordena y muestra los registros en el orden introducido.");
        System.out.println(ANSI_RED + "----------------------------------------------" + ANSI_RESET);
    }
    public void eliminar(String toDelete)
    {
        boolean isName = true;
        for(int i = 0; i < toDelete.length(); i++)
        {
            if(toDelete.charAt(i) == '0' || toDelete.charAt(i) == '9' || toDelete.charAt(i) == '8' || toDelete.charAt(i) == '7' || toDelete.charAt(i) == '6' || toDelete.charAt(i) == '5' || toDelete.charAt(i) == '4' || toDelete.charAt(i) == '3' || toDelete.charAt(i) == '2' || toDelete.charAt(i) == '1')
            {
                isName = false;
            }
        }
        if(isName == false)
        {
            int numberToDelete = Integer.parseInt(toDelete);
            int positionToDelete = -1;
            for(int i = 0; i < numeros.length; i++)
            {
                if(numeros[i] == numberToDelete)
                {
                    positionToDelete = i;
                }
            }
            if(positionToDelete != -1)
            {
                int[] newNumbers = new int[(numeros.length-1)];
                String[] newNames = new String[(personas.length-1)];
                int posicionActual = 0;
                int i = 0;
                while(i < numeros.length)
                {
                    if(i != positionToDelete)
                    {
                        newNumbers[posicionActual] = numeros[i];
                        newNames[posicionActual] = personas[i];
                        posicionActual++;
                    }
                    i++;
                }
                this.numeros = newNumbers;
                this.personas = newNames;
                System.out.println(ANSI_GREEN + "El número " + numberToDelete + " fue eliminado correctamente de la agenda." + ANSI_RESET);
                this.ver();
            }
            else
            {
                System.out.println(ANSI_GREEN + "El número " + numberToDelete + " no fue eliminado ya que no existe en la agenda." + ANSI_RESET);
            }
        }
        else
        {
            String nameToDelete = toDelete;
            int positionToDelete = -1;
            for(int i = 0; i < numeros.length; i++)
            {
                if(personas[i].toLowerCase().equals(nameToDelete.toLowerCase()))
                {
                    positionToDelete = i;
                }
            }
            System.out.println("Posicion a eliminar: " + positionToDelete);
            if(positionToDelete != -1)
            {
                int[] newNumbers = new int[(numeros.length-1)];
                String[] newNames = new String[(personas.length-1)];
                int posicionActual = 0;
                int i = 0;
                while(i < personas.length)
                {
                    if(i != positionToDelete)
                    {
                        newNumbers[posicionActual] = numeros[i];
                        newNames[posicionActual] = personas[i];
                        posicionActual++;
                    }
                    i++;
                }
                this.numeros = newNumbers;
                this.personas = newNames;
                System.out.println(ANSI_GREEN + "El contacto " + nameToDelete + " fue eliminado correctamente de la agenda." + ANSI_RESET);
                this.ver();
            }
            else
            {
                System.out.println(ANSI_GREEN + "El contacto " + nameToDelete + " no fue eliminado ya que no existe en la agenda." + ANSI_RESET);
            }
        }
    }
    public void buscar(String toSearch)
    {
        boolean isName = true;
        for(int i = 0; i < toSearch.length(); i++)
        {
            if(toSearch.charAt(i) == '0' || toSearch.charAt(i) == '9' || toSearch.charAt(i) == '8' || toSearch.charAt(i) == '7' || toSearch.charAt(i) == '6' || toSearch.charAt(i) == '5' || toSearch.charAt(i) == '4' || toSearch.charAt(i) == '3' || toSearch.charAt(i) == '2' || toSearch.charAt(i) == '1')
            {
                isName = false;
            }
        }
        if(isName == false)
        {
            int posicionEncontrado = -1;
            int numberToSearch = Integer.parseInt(toSearch);
            for(int i = 0; i < numeros.length; i++)
            {
                if(numeros[i] == numberToSearch)
                {
                    posicionEncontrado = i;
                }
            }
            if(posicionEncontrado == -1)
            {
                System.out.println("No se ha encontrado el teléfono especificado.");
            }
            else
            {
                System.out.println("El teléfono se ha encontrado en la posición " + posicionEncontrado + ".");
            }
        }
        else
        {
            int posicionEncontrado = -1;
            String nameToSearch = toSearch;
            for(int i = 0; i < numeros.length; i++)
            {
                if(personas[i].equals(nameToSearch))
                {
                    posicionEncontrado = i;
                }
            }
            if(posicionEncontrado == -1)
            {
                System.out.println("No se ha encontrado el contacto especificado.");
            }
            else
            {
                System.out.println("El contacto se ha encontrado en la posición " + posicionEncontrado + ".");
            }
        }
    }
    public void ordenar(String toOrder, String way)
    {
        boolean isName = true;
        if(toOrder.equals("telefono"))
        {
            int i, j, aux;
            if(way.equals("ascendente"))
            {
                for(i=0;i<numeros.length-1;i++)
                {
                     for(j=0;j<numeros.length-i-1;j++)
                     {
                        if(numeros[j+1]<numeros[j])
                        {
                            aux=numeros[j+1];
                            numeros[j+1]=numeros[j];
                            numeros[j]=aux;
                        }
                     }
                }
            }
            else if(way.equals("descendente"))
            {
                int temp=0;
                for(int index= 0; index < numeros.length-1; index++)
                {
                    for(int compare = 0; compare< numeros.length-1; compare++)
                    {
                        if(numeros[compare]<numeros[compare+1])
                        {
                        temp = numeros[compare];
                        numeros[compare]=numeros[compare+1];
                        numeros[compare+1]=temp;
                        }
                    }
                }
            }
            else
            {
                System.out.println("Método de ordenación no encontrado.");
            }
            ver();
        }
        else if(toOrder.equals("nombre"))
        {
            int i, j;
            String aux;
            if(way.equals("ascendente"))
            {
                for(i=0;i<personas.length-1;i++)
                {
                     for(j=0;j<personas.length-i-1;j++)
                     {
                        if(personas[j+1].compareTo(personas[j]) < 0)
                        {
                            aux=personas[j+1];
                            personas[j+1]=personas[j];
                            personas[j]=aux;
                        }
                     }
                }
            }
            else if(way.equals("descendente"))
            {
                String temp;
                for(int index= 0; index < personas.length-1; index++)
                {
                    for(int compare = 0; compare< personas.length-1; compare++)
                    {
                        if(personas[compare].compareTo(personas[compare+1]) < 0)
                        {
                        temp = personas[compare];
                        personas[compare]=personas[compare+1];
                        personas[compare+1]=temp;
                        }
                    }
                }
            }
            else
            {
                System.out.println("Método de ordenación no encontrado.");
            }
            ver();
        }
        else
        {
            System.out.println("¡Vaya! Parece que querías ordenar algo que no existe.");  
        }
    }
    public void acciones(String accion)
    {
        String[] accionBase = accion.split("\\s+");
        switch(accionBase[0])
        {
            case "ayuda":
                this.ayuda();
            break;
            case "ver":
                this.ver();
            break;
            case "insertar":
                if(accionBase.length == 3 && accionBase[2] != null && accionBase[1] != null)
                {
                    this.insertar(Integer.parseInt(accionBase[2]),accionBase[1]);
                }
                else
                {
                    System.out.println(ANSI_BLUE + "insertar" + ANSI_RESET + ANSI_RED + " requiere dos parámetros. Para más información escribe " + ANSI_BLUE + "ayuda" + ANSI_RESET + "." + ANSI_RESET);
                }
            break;
            case "eliminar":
                if(accionBase.length == 2 && accionBase[1] != null)
                {
                    this.eliminar(accionBase[1]);
                }
                else
                {
                    System.out.println(ANSI_BLUE + "eliminar" + ANSI_RESET + ANSI_RED + " requiere un parámetro. Para más información escribe " + ANSI_BLUE + "ayuda" + ANSI_RESET + "." + ANSI_RESET);
                }
            break;
            case "buscar":
                if(accionBase.length == 2 && accionBase[1] != null)
                {
                    this.buscar(accionBase[1]);
                }
                else
                {
                    System.out.println(ANSI_BLUE + "buscar" + ANSI_RESET + ANSI_RED + " requiere un parámetro. Para más información escribe " + ANSI_BLUE + "ayuda" + ANSI_RESET + "." + ANSI_RESET);
                }
            break;
            case "ordenar":
                if(accionBase.length == 3 && accionBase[1] != null && accionBase[2] != null)
                {
                    this.ordenar(accionBase[1],accionBase[2]);
                }
                else
                {
                    System.out.println(ANSI_BLUE + "ordenar" + ANSI_RESET + ANSI_RED + " requiere dos parámetros. Para más información escribe " + ANSI_BLUE + "ayuda" + ANSI_RESET + "." + ANSI_RESET);
                }
            break;
        }
    }
}