/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoAhorcados;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Andrei
 */
public class classes {
    public String secretWord;
    public String secretWordHidden;
    public void startWindows(boolean debug)
    {
        new v1Welcome(debug).setVisible(true);
    }
    public void generarPalabra(int theme)
    {
        String secretWordGen = "";
        String[] marchasCoches = {"Ferrari", "Seat", "Volkswagen", "Volvo", "BMW", "Kia", "Honda", "Lamborghini", "Ford", "Citroen"};
        String[] disneyPersonajes = {"Campanilla", "Cenicienta","Mickey", "Simba", "Bella", "Ariel", "Dory", "Woody"};
        String[] paises = {"España", "Portugal", "Venezuela", "Francia", "Bolivia"};
        switch(theme)
        {
            case 1:
            secretWordGen = marchasCoches[ThreadLocalRandom.current().nextInt(0,marchasCoches.length)];
            break;
            case 2:
            secretWordGen = disneyPersonajes[ThreadLocalRandom.current().nextInt(0,disneyPersonajes.length)];
            break;
            case 3:
            secretWordGen = paises[ThreadLocalRandom.current().nextInt(0,paises.length)];
            break;
        }
        this.secretWord = secretWordGen;
        String secretWordHiddenGen = "";
        for(int i = 0; i < secretWordGen.length(); i++)
        {
            if(secretWordGen.charAt(i) != ' ')
            {
                secretWordHiddenGen += '_';
            }
            else
            {
                secretWordHiddenGen += ' ';
            }
        }
        this.secretWordHidden = secretWordHiddenGen;
    }
    public static void replay()
    {
        classes caller = new classes();
        boolean debug = true;
        caller.startWindows(debug);
    }
}
