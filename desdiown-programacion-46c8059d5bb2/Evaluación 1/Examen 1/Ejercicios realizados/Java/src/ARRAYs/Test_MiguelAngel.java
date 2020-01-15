package ARRAYs;

public class Test_MiguelAngel {
    
    public static void main(String[]args){
    
        int array[]; //Declaración del array   
        array = new int [5]; //Declaración de longitud del array y tipo
        
        for(int i=0; i<array.length; i++){
        
            array[i]=(int)(Math.random()*10); //Clase math (siempre *10 al ser decimal)
        }
        for(int j=0; j<array.length; j++){
        
            System.out.println("array["+j+"]= "+array[j]);
        }
        
        System.out.println("ver con for-each");
        
        int s=0;
        for(int elemento:array){ //FOREACH
        
            System.out.println(elemento);
            s=s+elemento;
        }
        System.out.println("la suma es: "+s);
        
        /* Búsqueda del array */
        char caracterbusqueda = 'N';
        boolean encontrado = false;
        for(int i = 0; i<array.length ;i++)
        {
            if(array[i] == caracterbusqueda)
            {
                System.out.println("Encontrado en posición 0"+ i);
                encontrado = true;
            }
        }
        if(encontrado == false)
        {
            System.out.println("No se ha encontrado el caracter "+caracterbusqueda);
        }
        /* Búsqueda sólo del primer elemento del array */
        char caracterbusqueda_solo1 = 'N';
        boolean encontrado_solo1 = false;
        for(int i = 0; i<array.length ;i++)
        {
            if(array[i] == caracterbusqueda_solo1)
            {
                System.out.println("Encontrado en posición 0"+ i);
                encontrado_solo1 = true;
                break;
            }
        }
        if(encontrado_solo1 == false)
        {
            System.out.println("No se ha encontrado el caracter "+caracterbusqueda_solo1);
        }
        /* TEST */
        boolean encontradotest = false;
        int numbusqueda = 1;
        int i = 0;
        while(encontradotest = false && i < array.length)
        {
            if(array[i] == numbusqueda)
            {
                System.out.println("Encontrado en posición "+ i);
                encontradotest = true;
            }
            i++;
        }
        if(!encontradotest)
        {
            System.out.println("No encontrado: " + numbusqueda);
        }
    }
    
}