package Galaga.Items.Interface;

import GUI.Board;
import Galaga.Board.Enemy;
import Galaga.Board.Item;
import Utils.Constants;
import Utils.Directions;

// Se implementa runnable para que cada cohete tenga su propio manager y el bucle no sea sincrono
public class EnemyRocket extends Item  implements Runnable  {
    private boolean isSuccess;
    private Thread t;
    public EnemyRocket(int x, int y) {
        super(x, y, "torpedo200.png");
        // Implementar como tarea la invocacion.
        this.t = new Thread(this);
        this.t.start();
    }


    public boolean rocketCollision(Item item) {
        // imagen +-5 ya que el pixel central tiene +-5 de tamaño (total imagen: 10x10)
        if(
                item.getX() - 10 < this.getX() &&
                        item.getX() + 10 > this.getX() &&
                        item.getY() - 10 < this.getY() &&
                        item.getY() + 10 > this.getY()
        ) {
            return true;
        }
        return false;
    }

    protected void die() {
        this.hide();
    }

    public void run() {

        hideBotAnim:
        while (true) {
            if(this.getY() + 5 >= 10 * Constants.DEFAULT_BOARD_HEIGHT) {
                this.hide();
                break hideBotAnim;
            }
            this.move(Directions.DIR_S, 1);

            if(this.rocketCollision(Board.getBoard().getPlayer())) {
                System.out.println("JUGADOR DISPARADO Y ACERTADO CON COHETE");
                this.setLifePoints(0);
                Board.getBoard().getPlayer().removeLifePoint();
                break hideBotAnim;
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

