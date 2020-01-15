package Quijote;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class Ejer3 {
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
    public void mezclarFicheros(String ruta1, String ruta2, String rutaFinal) throws FileNotFoundException, IOException
    {
        boolean error = false;
        File fichero = new File(ruta1);
        if(!fichero.exists())
        {
            error = true;
            System.out.println("El fichero " + ruta1 + " no existe.");
        }
        File fichero2 = new File(ruta2);
        if(!fichero2.exists())
        {
            error = true;
            System.out.println("El fichero " + ruta1 + " no existe.");
        }
        if(!error)
        {
            String contenidoFinal = this.muestraContenido(ruta1) + this.muestraContenido(ruta2);
            this.escribeContenido(contenidoFinal, rutaFinal + "/FicheroMezclado.txt");
        }
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero 1: ");
        String ruta1 = input.next();
        input.nextLine();
        System.out.println("Introduce la ruta del fichero 2: ");
        String ruta2 = input.next();
        input.nextLine();
        System.out.println("Introduce la ruta para guardar la mezcla de los ficheros: ");
        String rutaFinal = input.next();
        input.nextLine();
    }
}
