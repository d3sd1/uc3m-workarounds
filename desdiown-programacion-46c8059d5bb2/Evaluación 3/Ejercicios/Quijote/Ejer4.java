package Quijote;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejer4 {
    public String muestraContenido(String fichero) throws FileNotFoundException, IOException {
        String cadena;
        String cadenaFinal = "";
        FileReader f = new FileReader(fichero);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            cadenaFinal += cadena;
        }
        b.close();
        return cadenaFinal;
    }
    public int contarLineas(String fichero) throws FileNotFoundException, IOException {
        String cadena;
        int lineas = 0;
        FileReader f = new FileReader(fichero);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            lineas++;
        }
        b.close();
        return lineas;
    }
    public int contarCaracteres(String fichero) throws FileNotFoundException, IOException 
    {
        String contenido = muestraContenido(fichero);
        return contenido.length();
    }
    public int contarMinusculasPuras(String fichero) throws FileNotFoundException, IOException 
    {
        int minusculasPuras = 0;
        String contenido = this.muestraContenido(fichero);
        String contenidoMinus = this.muestraContenido(fichero).toLowerCase();
        String caracteresValidos = "qwertyuiopñlkjhgfdsazxcvbnm";
        
        for(int i = 0; i < contenido.length(); i++)
        {
            char caracterActual = contenido.charAt(i);
            if(caracterActual == contenidoMinus.charAt(i)) //Verificar que es minúscula.
            {
                if(caracteresValidos.indexOf(caracterActual) != 0)
                {
                    minusculasPuras++;
                }
            }
        }
        return minusculasPuras;
    }
    public int contarLetras(String fichero) throws FileNotFoundException, IOException 
    {
        int letrasPuras = 0;
        String contenido = this.muestraContenido(fichero);
        String caracteresValidos = "qwertyuiopñlkjhgfdsazxcvbnmQWERTYUIOPÑLKJHGFDSAZXCVBNMÁÉÍÚÓáéíúóÌÒÙÀÈàèùìò";
        
        for(int i = 0; i < contenido.length(); i++)
        {
            char caracterActual = contenido.charAt(i);
            if(caracteresValidos.indexOf(caracterActual) != 0)
            {
                    letrasPuras++;
            }
        }
        return letrasPuras;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        String ruta = "C:/quijote.txt";
        Ejer4 ficheros = new Ejer4();
        System.out.println("Abriendo el fichero del señor Quijote...");
        ficheros.muestraContenido(ruta);
        System.out.println("El fichero tiene " + ficheros.contarCaracteres(ruta) + " caracteres.");
        System.out.println("El fichero tiene " + ficheros.contarMinusculasPuras(ruta) + " minúsculas puras.");
        System.out.println("El fichero tiene " + ficheros.contarLetras(ruta) + " letras.");
        System.out.println("El fichero tiene " + ficheros.contarLineas(ruta) + " líneas.");
    }
}
