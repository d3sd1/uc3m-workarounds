package Commands;

import GUI.Board;
import Galaga.Items.Allies.Player;
import Utils.Constants;

public class PlayerInfoCommand extends Command {
    public void execute() {

        Board.getBoard().getGameGUI().gb_println("Tu nombre es: " + this.getValue());
        Player player = new Player();
        player.setNickName(this.getValue());
        Board.getBoard().setPlayer(player);
        Board.getBoard().getGameGUI().gb_setTextPlayerName(player.getNickName());
        Board.getBoard().getPlayer().setMoveEnabled(true);
        Board.getBoard().getPlayer().hide();
        Board.getBoard().getGameManager().start();
    }
}
