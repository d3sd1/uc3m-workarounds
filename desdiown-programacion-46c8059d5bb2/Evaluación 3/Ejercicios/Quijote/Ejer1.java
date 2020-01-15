package Quijote;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejer1 {
    public void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(this.filtrarEspacios(cadena));
        }
        b.close();
    }
    public String filtrarEspacios(String cadena)
    {
        String cadenaDepurada = "";
        for(int i = 0; i < cadena.length(); i++)
        {
            char caracterActual = cadena.charAt(i);
            if(caracterActual != ' ')
            {
                cadenaDepurada += caracterActual;
            }
        }
        return cadenaDepurada;
    }
    public static void main(String[] args) throws IOException {
        Ejer1 ficheros = new Ejer1();
        ficheros.muestraContenido("c:/Quijote.txt");
    }
   
}