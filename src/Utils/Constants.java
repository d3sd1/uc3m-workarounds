package Utils;

import GUI.Board;
import Galaga.Board.Enemy;
import Galaga.Board.Item;
import edu.uc3m.game.GameBoardGUI;

import java.util.ArrayList;

// This class shares (and while program is loading stores) information that has to be shared between classes.
public class Constants {
    public static int LAST_ITEM_ID = 1;
    public static final int DEFAULT_BOARD_WIDTH = 17;
    public static final int DEFAULT_BOARD_HEIGHT = 22;
    public static final byte[] DEFAULT_BOARD_COLOR = new byte[]{0,0,0};
    public static final int MAX_ENEMIES_SINGLE_TYPE = 15;
    public static final int ENEMY_MOVE_PROB_BASE = 20;
    public static final int ENEMY_ROCKET_PROB_BASE = 5;
}
