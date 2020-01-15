package Galaga.Board;

import GUI.Board;
import Galaga.Config;
import Utils.Constants;
import Utils.Directions;
import Utils.Movements;

import java.text.DecimalFormat;

public abstract class Item {
    private int x;
    private int y;
    private int id;
    private String image;
    private boolean moveEnabled;
    private int direction;
    private int lifePoints;

    public int getLifePoints() {
        return lifePoints;
    }


    public void setLifePoints(int lifePoints) {

        if(lifePoints > Config.MAX_PLAYER_HP) {
            lifePoints = Config.MAX_PLAYER_HP;
        }
        this.lifePoints = lifePoints;
        this.checkIfHasDied();
    }

    public void removeLifePoint() {
        this.setLifePoints(this.getLifePoints() - 1);
        this.checkIfHasDied();
    }

    protected void checkIfHasDied() {
        if(this.getLifePoints() <= 0) {
            this.die();
        }
    }

    protected abstract void die();

    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    protected Item(int x, int y, String image) {
        this.setX(x);
        this. setY(y);
        this.setId(Constants.LAST_ITEM_ID++);
        this.setImage(image);
        this.setDirection(Directions.DIR_N);
        this.setLifePoints(1); // 1 HP by default

        // Initialize item
        this.register();
    }

    public void setX(int x) {
        if (x >= 0) {
            this.x = x;
        } else {
            this.x = Constants.DEFAULT_BOARD_WIDTH * 10 + 10;
        }
    }

    public void setY(int y) {
        if(y >= 0 && Constants.DEFAULT_BOARD_HEIGHT * 10 < y) {
            this.y = Constants.DEFAULT_BOARD_HEIGHT * 10 - 5;
        }
        else if (y >= 0) {
            this.y = y;
        }
        else {
            this.y = Constants.DEFAULT_BOARD_HEIGHT * 10 - 5;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String im) {
        this.image = im;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    private String getSprite() {
        DecimalFormat formatter = new DecimalFormat("00");
        String parsedDirectionSprite = formatter.format(this.getDirection());
        return parsedDirectionSprite;
    }

    protected void register() {
        Board.getBoard().getGameGUI().gb_addSprite(this.getId(), this.getImage().replace("{dir}", this.getSprite()), true);
        Board.getBoard().getGameGUI().gb_setSpriteVisible(this.getId(), true);
        this.update();
    }

    protected void update() {
        this.updateWithimage(this.getSprite());
    }
    protected void updateWithimage(String img) {
        if(this.isAlive()) {
            Board.getBoard().getGameGUI().gb_setSpriteImage(this.getId(), this.getImage().replace("{dir}", img));
            Board.getBoard().getGameGUI().gb_moveSpriteCoord(this.getId(), this.getX(), this.getY());
        }
    }


    public boolean move(int direction, int steps) {
        if(!this.isAlive()) {
            return false;
        }
        // If parameters are wrong we don't move and return false.
        if (direction < 0 || direction > 16 || steps < 1) {
            return false;
        } else {
            // changing the direction
            this.setDirection(direction);
            // calculating the new x and y
            int nextX = this.getX() + Movements.MOVES[direction][0] * steps, nextY = this.getY() + Movements.MOVES[direction][1] * steps;
            this.setX(nextX);
            this.setY(nextY);
            this.update();
            return true;
        }
    }

    public void hide() {
        Board.getBoard().getGameGUI().gb_setSpriteVisible(this.getId(), false);
    }

    public void show() {
        Board.getBoard().getGameGUI().gb_setSpriteVisible(this.getId(), true);
        this.update();
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isMoveEnabled() {
        return moveEnabled;
    }

    public void setMoveEnabled(boolean moveEnabled) {
        this.moveEnabled = moveEnabled;
    }
}