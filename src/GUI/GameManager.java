package GUI;

import Galaga.Board.Enemy;
import Utils.Constants;
import Utils.Sleep;

public class GameManager {

    public void init() {
        Board.getBoard().getGalagaLogo().show();
        Board.getBoard().getUc3mLogo().show();
    }

    public void start() {
        this.stop();

        Board.getBoard().getPlayer().show();
        Board.getBoard().getPlayer().setMoveEnabled(true);
        Board.getBoard().getActualLevel().setNumber(0);
        Board.getBoard().getActualLevel().loadNext();

    }

    public void stop() {
        Board.getBoard().getGalagaLogo().hide();
        Board.getBoard().getUc3mLogo().hide();
        Board.getBoard().hideGameOverLogo();
    }

    public void gameOver() {
        this.stop();
        Board.getBoard().getPlayer().hide();
        Board.getBoard().showGameOverLogo();
    }

    public void pause() {

    }

    public void removeEnemies() {
        for(Enemy enemy : Board.getBoard().getActualLevel().getEnemies()) {
            enemy.setLifePoints(0);
        }
    }
}
