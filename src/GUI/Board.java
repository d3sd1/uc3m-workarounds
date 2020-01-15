package GUI;

import Draw.Words.Galaga;
import Draw.Words.Game;
import Draw.Words.Over;
import Draw.Words.Uc3m;
import Galaga.Board.Level;
import Galaga.Items.Allies.Player;
import Draw.Word;
import Utils.Constants;
import Commands.Manager;
import Utils.Sleep;
import edu.uc3m.game.GameBoardGUI;
import Galaga.Config;

/**
 * The board is a singleton that stores current game information
 */
public class Board implements Runnable {
    private Player player;
    private Word galagaLogo;
    private Word uc3mLogo;
    private Word[] gameOverLogo;
    private Word levelLogo;
    private GameBoardGUI gameGUI;
    private Thread t;
    private Level actualLevel;
    private GameManager gameManager;
    private static Board board = null;

    /**
     * Gets board as singleton.
     *
     * @return the board
     */
    public static Board getBoard() {
        if (board == null) {
            board = new Board();
            board.gameGUI = new GameBoardGUI(17, 22);
            board.gameGUI.setVisible(true);
            board.galagaLogo = new Galaga();
            board.uc3mLogo = new Uc3m();
            board.gameOverLogo = new Word[]{new Game(), new Over()};
            board.actualLevel = new Level();

            board.levelLogo = new Draw.Words.Level();
            board.gameManager = new GameManager();
            board.gameManager.init();

            board.t = new Thread(board);
            board.t.start();

            board.loadPregame();
        }
        return board;
    }

    /**
     * Instantiates a new Board (only from singleton)
     */
    private Board() {
    }


    private void commandListener() {
        Sleep sleeper = new Sleep();
        Manager cmdManager = new Manager();
        do {
            String action = Board.getBoard().getGameGUI().gb_getLastAction().trim();

            // If it's a normal command, proccess it
            if (action.length() > 0 && action.contains("command")) {
                cmdManager.handle(action);
            }

            // If user clicked "new game", transform it to command.
            else if (action.length() > 0 && action.contains("new game ")) {
                // Using loop because it game name may have some whitespaces
                String fullname = "";
                String[] fullCommand = action.split(" ");
                for (short i = 0; i < fullCommand.length; i++) {
                    if (i > 1) { //remove new game words
                        fullname += (i > 3 ? " " : "") + fullCommand[i];
                    }
                }
                cmdManager.handle("command player=" + fullname);
            }
            // If user clicked "exit game" buttom, translate it.
            else if (action.length() > 0 && action.contains("exit game")) {
                cmdManager.handle("command exit");
            }

            sleeper.sleepThread(this.t, 5);

        } while (true);
    }

    public void run() {
        this.commandListener();
    }

    /**
     * Load game lobby by setting it up.
     */
    private void loadPregame() {
        this.paintGrid();

        this.gameGUI.gb_setTextPlayerName("GALAGA UC3M");
        this.gameGUI.gb_setTextPointsUp("Puntos");
        this.gameGUI.gb_setTextAbility1("Habilidad 1");
        this.gameGUI.gb_setTextAbility2("Habilidad 2");
        this.gameGUI.gb_setTextLevel("Nivel");
        //Board.getBoard().gb_setTextPointsDown("Puntos restantes");
        // Show welcome message
        this.gameGUI.gb_println("¡Hola! Bienvenido a Galaga UC3M.");
        this.gameGUI.gb_println("");
        this.gameGUI.gb_println("Si necesitas ayuda, escribe help.");
        this.gameGUI.gb_clearCommandBar();
    }

    /**
     * Paint grid. Shows borders on debug mode (only).
     */
    public void paintGrid() {
        if (!Config.DEBUG) { // PROD MODE
            this.getGameGUI().gb_setGridColor(0, 0, 0);
        }
        byte[] boardColor = Constants.DEFAULT_BOARD_COLOR;
        for (int i = 0; i < Constants.DEFAULT_BOARD_WIDTH; i++) {
            for (int j = 0; j < Constants.DEFAULT_BOARD_HEIGHT; j++) {
                this.getGameGUI().gb_setSquareColor(i, j, boardColor[0], boardColor[0], boardColor[0]);
            }
        }
    }

    /**
     * Gets player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets player.
     *
     * @param player the player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets galaga logo.
     *
     * @return the galaga logo
     */
    public Word getGalagaLogo() {
        return galagaLogo;
    }

    /**
     * Gets uc 3 m logo.
     *
     * @return the uc 3 m logo
     */
    public Word getUc3mLogo() {
        return uc3mLogo;
    }

    /**
     * Gets game gui.
     *
     * @return the game gui
     */
    public GameBoardGUI getGameGUI() {
        return gameGUI;
    }

    /**
     * Gets actual level.
     *
     * @return the actual level
     */
    public Level getActualLevel() {
        return actualLevel;
    }

    /**
     * Gets game manager.
     *
     * @return the game manager
     */
    public GameManager getGameManager() {
        return gameManager;
    }

    public void showGameOverLogo() {
        for(Word word : this.gameOverLogo) {
            word.show();
        }
    }

    public void hideGameOverLogo() {
        for(Word word : this.gameOverLogo) {
            word.hide();
        }
    }

    public Word getLevelLogo() {
        return levelLogo;
    }

    public void setLevelLogo(Word levelLogo) {
        this.levelLogo = levelLogo;
    }
}
