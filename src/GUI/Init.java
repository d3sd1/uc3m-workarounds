package GUI;

import Galaga.Config;
import Utils.Interceptor;

import java.io.PrintStream;

/**
 * The main class of the program. It just starts the required stuff.
 */
public class Init {


    /**
     * The entry point of application.
     * It also determines if debug should be enabled and console log shown.
     *
     * @param args the input arguments:
     *             debug (starts on debug mode)
     */
    public static void main(String[] args) {

        // Pass arguments and check them
        for(String arg : args) {
            switch(arg.toUpperCase()) {
                case "DEBUG":
                    Config.DEBUG = true;
                    break;
            }
        }

        // Define if we want to show something or not (debug mode) by capturing sout's and showing it (or not).
        PrintStream interceptor = new Interceptor();
        System.setOut(interceptor);

        // Create game board
        Board.getBoard();
    }
}
