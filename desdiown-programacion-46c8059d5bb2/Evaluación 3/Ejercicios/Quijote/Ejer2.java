package Quijote;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejer2 {
    public void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }
    public void escribeContenido(String ruta, String texto)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);

            pw.println(texto);
            fichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void intercambiarLetras(String ruta, String texto) throws FileNotFoundException, IOException 
    {
        FileReader f = new FileReader(ruta);
        BufferedReader b = new BufferedReader(f);
        while((texto = b.readLine())!=null) {
            System.out.println();
            for(int i = 0; i < texto.length(); i++)
            {
                char caracterActual = texto.charAt(i);
                char caracterActualMinus = texto.toLowerCase().charAt(i);
                char caracterActualMayus = texto.toUpperCase().charAt(i);
                if(caracterActual == caracterActualMinus)
                {
                    System.out.print(caracterActualMayus);
                }
                else
                {
                    System.out.print(caracterActualMinus);
                }
            }
        }
        b.close();
    }
    public static void main(String[] args) throws IOException {
        Ejer2 ficheros = new Ejer2();
        Scanner input = new Scanner(System.in);
        System.out.println("Escribe el texto que quieras alternar: ");
        String texto = input.next();
        input.nextLine();
        System.out.println("Escribe la ruta del archivo para guardarlo: ");
        String ruta = input.next();
        input.nextLine();
        ficheros.escribeContenido(ruta,texto);
        ficheros.muestraContenido(ruta);
        System.out.println("Fichero con letras alternadas: ");
        ficheros.intercambiarLetras(ruta,texto);
    }
   
}