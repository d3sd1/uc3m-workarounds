package Galaga.Board;

import Draw.Word;
import GUI.Board;
import Galaga.Items.Enemies.GalagaCommannder;
import Galaga.Items.Enemies.Goei;
import Galaga.Items.Enemies.Zako;
import Utils.Constants;
import Utils.Sleep;

import java.util.ArrayList;

public class Level {
    private int number;
    private ArrayList<Enemy> enemies;

    public Level() {
        this.number = 0;


    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void showAnimation() {
        Sleep sleeper = new Sleep();
        Board.getBoard().getLevelLogo().show();
        Word actualLevelLogo = new Draw.Words.Number(Integer.toString(this.getNumber()));
        actualLevelLogo.show();
        sleeper.sleep(3000);
        actualLevelLogo.hide();
        Board.getBoard().getLevelLogo().hide();
    }

    public void hideAnimation() {
        Board.getBoard().getLevelLogo().hide();
    }


    public void calculateEnemies() {
        /* Spawn same Zako's that the level we are in, with limits */
        this.enemies = new ArrayList<>();
        int zakoNumber = (int) Math.floor(this.number < Constants.MAX_ENEMIES_SINGLE_TYPE ? this.number:Constants.MAX_ENEMIES_SINGLE_TYPE);
        System.out.println("ENEMIES a " + zakoNumber);
        for(int i = 0; i < zakoNumber; i++) {
            System.out.println("Spawn zako");
            this.enemies.add(
                    new Zako((int) ((Constants.DEFAULT_BOARD_WIDTH - zakoNumber) / 2 * 10) + (i * 10),50)
            );
        }
        System.out.println("ENEMIES b " + this.enemies.size());

        int goeiNumber = (int) Math.floor(this.number < Constants.MAX_ENEMIES_SINGLE_TYPE ? this.number/2:Constants.MAX_ENEMIES_SINGLE_TYPE);
        /* Spawn 1/2 Goei's that the level we are in, with limits */
        for(int i = 0; i < goeiNumber; i++) {
            System.out.println("Spawn Goei");
            this.enemies.add(new Goei((int) ((Constants.DEFAULT_BOARD_WIDTH - zakoNumber) / 2 * 10) + (i * 10),60));
        }

        int galComNumber = (int) Math.floor(this.number< Constants.MAX_ENEMIES_SINGLE_TYPE ? this.number/3:Constants.MAX_ENEMIES_SINGLE_TYPE);
        System.out.println("GAL " + galComNumber);
        /* Spawn 1/3 Galaga commander's that the level we are in, with limits */
        for(int i = 0; i < galComNumber; i++) {
            System.out.println("Spawn Galaga commander");
            this.enemies.add(new GalagaCommannder((int) ((Constants.DEFAULT_BOARD_WIDTH - zakoNumber) / 2 * 10) + (i * 10),70));
        }
        System.out.println("ENEMIES c " + this.enemies.size());
    }

    public void loadNext() {
        this.setNumber(this.getNumber() + 1);
        Board.getBoard().getGameGUI().gb_setValueLevel(this.getNumber());
        this.showAnimation();
        Board.getBoard().getGameGUI().gb_println("Cargando nivel: " + this.getNumber());
        Board.getBoard().getPlayer().setMoveEnabled(false);
        Board.getBoard().getActualLevel().showAnimation();
        Board.getBoard().getPlayer().setMoveEnabled(true);
        this.calculateEnemies();
    }

    public boolean isCompleted() {
        return this.enemies.size() == 0;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }
}