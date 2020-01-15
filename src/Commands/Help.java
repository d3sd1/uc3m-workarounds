package Commands;

import GUI.Board;
import Utils.Constants;

public class Help extends Command {
    public void execute() {

        Board.getBoard().getGameGUI().gb_println("Bienvenido al menú de ayuda.");
    }
}
