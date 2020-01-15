package Galaga.Items.Allies;

import GUI.Board;
import Galaga.Config;
import Galaga.Items.Interface.AllyRocket;
import Galaga.Board.Item;
import Utils.Constants;
import Utils.Directions;

import java.util.*;

public class Player extends Item implements Runnable  {
    private int points;
    private ArrayList<AllyRocket> shootsDone;
    private String nickName;
    private Thread t;
    private int[] visualLifePointsSprites;


    public void run() {
        System.out.println("RUNNING PLAYER THREAD");
        do {
            String action = Board.getBoard().getGameGUI().gb_getLastAction().trim();
            if (action.length() > 0) {
                System.out.println("ACTION:  " + action);
                this.manageMovements(action);
            }
            synchronized(this.t) {
                // how to put to bed the same thread ?
                try {
                    this.t.wait(5L);
                }
                catch(Exception e) {

                }
            }

        } while (true);
    }

    public Player() {
        // Instanciate Item with the player image (it's the same for all players).
        super(85, 204, "player.png");
        this.setMoveEnabled(false);
        this.shootsDone = new ArrayList<>();
        this.setLifePoints(3);
        Board.getBoard().getGameGUI().gb_setValueHealthMax(Config.MAX_PLAYER_HP);
        Board.getBoard().getGameGUI().gb_setValueHealthCurrent(Config.MAX_PLAYER_HP);
        // Start player movement manager
        this.t = new Thread(this);
        this.t.start();



        this.visualLifePointsSprites = new int[Config.MAX_PLAYER_HP];
        for(int i = 0; i < this.visualLifePointsSprites.length; i++) {
            int spriteId = Constants.LAST_ITEM_ID++;
            Board.getBoard().getGameGUI().gb_addSprite(spriteId, "player.png", true);
            Board.getBoard().getGameGUI().gb_moveSpriteCoord(spriteId, 5 + 10 * i, 215);
            Board.getBoard().getGameGUI().gb_setSpriteVisible(spriteId, true);
            System.out.println("SPR" + spriteId);
            this.visualLifePointsSprites[i] = spriteId;
        }
    }

    // Overriden method because we don't want the player image to be pixel's out of the screen. Without this, it could be.
    // So last point to move left is 6 (0 + 5 half image x pixels), and on 165 (170 total - 5 half x image pixels) right, addeing 1 padding.
    public void setX(int x) {
        if (x >= 6 && x <= 165) {
            super.setX(x);
        }
        // This is for preventing blocks with some stuff (like steps)
        else if (x < 6) {
            super.setX(6);
        } else if (x > 165) {
            super.setX(165);
        }
    }

    // This is private and just on player since the only item that cna move by keyboard is the player.
    // Since we want to give the best user-experience, we won't use an infinite loop. We are using event-oriented instead which is highly more effective, fast and lovely.

    // Since we would only get 1 movement, we cant move and shoot at same time. sadly...
    public void manageMovements(String dir) {
        if(this.isMoveEnabled()) {

            // Checking its value. We are not controlling the borders.
            switch (dir) {
                case "right":
                    this.move(Directions.DIR_E, 1);
                    break;
                case "left":
                    this.move(Directions.DIR_W, 1);
                    break;
                case "space":
                    this.shoot();
                    break;
                case "tab":
                    //pausar partida
            }
        }
    }

    public void setLifePoints(int lifePoints) {
        super.setLifePoints(lifePoints);
    }


    protected void checkIfHasDied() {
        if(this.getLifePoints() <= 0) {
            this.die();
            Board.getBoard().getGameManager().gameOver();
            Board.getBoard().getGameManager().removeEnemies();
        }
    }

    public void removeLifePoint() {
        for(int i = this.visualLifePointsSprites.length - 1; i >= 0; i--) {
            int actLPSprite = this.visualLifePointsSprites[i];
            if(actLPSprite != 0) {
                Board.getBoard().getGameGUI().gb_setSpriteVisible(actLPSprite, false);
                this.visualLifePointsSprites[i] = 0;
                break;
            }
        }
        super.removeLifePoint();
        Board.getBoard().getGameGUI().gb_setValueHealthCurrent(this.getLifePoints());
        this.die();
        if(this.getLifePoints() > 0) {
            this.show();
            this.setMoveEnabled(true);
        }
    }

    public void shoot() {
        this.shootsDone.add(new AllyRocket(this.getX(),this.getY()));
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int amount) {
        this.setPoints(this.getPoints() + amount);
        Board.getBoard().getGameGUI().gb_setValuePointsUp(this.getPoints());
    }

    public void die() {
        this.setMoveEnabled(false);
        for(int i = 1; i < 4; i++) {
            Board.getBoard().getGameGUI().gb_setSpriteImage(this.getId(), "explosion1" + i + ".png");

            synchronized(this.t) {
                // how to put to bed the same thread ?
                try {
                    this.t.wait(200L);
                }
                catch(Exception e) {

                }
            }
        }
        this.hide();
    }

}
