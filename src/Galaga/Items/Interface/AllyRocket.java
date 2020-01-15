package Galaga.Items.Interface;

import GUI.Board;
import Galaga.Board.Enemy;
import Galaga.Board.Item;
import Utils.Constants;
import Utils.Directions;
import Utils.Movements;

// Se implementa runnable para que cada cohete tenga su propio manager y el bucle no sea sincrono
public class AllyRocket extends Item  implements Runnable  {
    private boolean isSuccess;
    private Thread t;
    public AllyRocket(int x, int y) {
        super(x, y, "torpedo100.png");
        // Implementar como tarea la invocacion.
        this.t = new Thread(this);
        this.t.start();
    }


    public boolean rocketCollision(Item item) {
        // imagen +-5 ya que el pixel central tiene +-5 de tamaño (total imagen: 10x10)
        if(
                item.getX() - 5 < this.getX() &&
                        item.getX() + 5 > this.getX() &&
                        item.getY() - 5 < this.getY() &&
                        item.getY() + 5 > this.getY()
        ) {
            return true;
        }
        return false;
    }

    protected void die() {
        this.hide();
    }

    public void run() {

        hideTopAnim:
        while (true) {
            if(this.getY() == 0) {
                this.hide();
                break hideTopAnim;
            }
            System.out.println("MOVE ROCKET");
            this.move(Directions.DIR_N, 1);
            for(int i = 0; i < Board.getBoard().getActualLevel().getEnemies().size(); i++) {
                Enemy item = Board.getBoard().getActualLevel().getEnemies().get(i);
                if(this.rocketCollision(item)) {
                    this.setLifePoints(0);
                    item.removeLifePoint();
                    if(Board.getBoard().getActualLevel().getEnemies().size() > i) {
                        Board.getBoard().getActualLevel().getEnemies().remove(i);
                    }

                    System.out.println("Colision");
                    item.die();

                    // Check if next level is availale
                    if(Board.getBoard().getActualLevel().isCompleted()) {
                        Board.getBoard().getActualLevel().loadNext();
                    }
                    break hideTopAnim;
                }
            }

            synchronized(this.t) {
                // how to put to bed the same thread ?
                try {
                    this.t.wait(15L);
                }
                catch(Exception e) {

                }
            }
        }
    }


    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

}

