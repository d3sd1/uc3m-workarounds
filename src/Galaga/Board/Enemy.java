package Galaga.Board;


import GUI.Board;
import Galaga.Items.Interface.EnemyRocket;
import Galaga.Items.Interface.Path;
import Utils.Constants;
import Utils.Directions;
import Utils.Random;
import Utils.Sleep;

public class Enemy extends Item implements Runnable {
    private byte shootsToKill;
    private int pointsGiven;
    Thread t;

    public Enemy(int x, int y, String image, int pointsGiven, int shootsToKill) {
        super(x, y, image);
        this.pointsGiven = pointsGiven;
        this.shootsToKill = (byte) shootsToKill;
        // Implementar como tarea la invocacion.
        this.t = new Thread(this);
        this.t.start();
    }

    public byte getShootsToKill() {
        return shootsToKill;
    }

    public void setShootsToKill(byte shootsToKill) {
        this.shootsToKill = shootsToKill;
    }


    public int getPointsGiven() {
        return pointsGiven;
    }

    public void setPointsGiven(int pointsGiven) {
        this.pointsGiven = pointsGiven;
    }


    public boolean collisionWithPlayer() {
        // imagen +-5 ya que el pixel central tiene +-5 de tamaño (total imagen: 10x10)
        if(
                Board.getBoard().getPlayer().getX() - 10 < this.getX() &&
                        Board.getBoard().getPlayer().getX() + 10 > this.getX() &&
                        Board.getBoard().getPlayer().getY() - 10 < this.getY() &&
                        Board.getBoard().getPlayer().getY() + 10 > this.getY()
        ) {
            return true;
        }
        return false;
    }

    public void die() {
        Sleep sleeper = new Sleep();
        for(int i = 0; i < 5; i++) {
            Board.getBoard().getGameGUI().gb_setSpriteImage(this.getId(), "explosion2" + i + ".png");

            sleeper.sleepThread(this.t, 200);
        }
        this.hide();
    }

    public void determineToSendRocket() {
        Random rand = new Random();
        boolean sendRocket = rand.generateRandomInPercentage(Constants.ENEMY_ROCKET_PROB_BASE, Board.getBoard().getActualLevel().getNumber());

        if(sendRocket && this.isAlive()) {
            new EnemyRocket(this.getX(), this.getY());
        }
    }

    public void run() {
        Sleep sleeper = new Sleep();
        Random rand = new Random();
        boolean enemyOnMove = rand.generateRandomInPercentage(Constants.ENEMY_MOVE_PROB_BASE, Board.getBoard().getActualLevel().getNumber());
        while (this.isAlive()) {
            System.out.println("rompe formacion: " + enemyOnMove);
            if(!enemyOnMove) {
                enemyOnMove = rand.generateRandomInPercentage(Constants.ENEMY_MOVE_PROB_BASE, Board.getBoard().getActualLevel().getNumber());

                int lastDownStep = 0;
                for(int i = 0; i < 50; i++) {
                    if(lastDownStep + 10 <= i) {
                        this.move(Directions.DIR_S, 1);
                        lastDownStep = i;
                    }
                    if(i % 2 == 0) {
                        this.move(Directions.DIR_E, 1);
                        this.updateWithimage("G0");
                    }
                    else {
                        this.move(Directions.DIR_W, 1);
                        this.updateWithimage("G1");
                    }

                    this.determineToSendRocket();
                    sleeper.sleepThread(this.t, 300);
                }
            }
            else {
                // Get random path
                Path paths = new Path();

                int[] path = paths.getRandomPath();

                for (int move = 0; move < path.length; move++) {

                    if(Board.getBoard().getPlayer().isAlive() && this.isAlive()) {
                        this.move(path[move], 1);
                        if(this.collisionWithPlayer()) {
                            System.out.println("Jugador muerto por impacto de enemigo");
                            Board.getBoard().getPlayer().setLifePoints(0);

                            for(Enemy enemy : Board.getBoard().getActualLevel().getEnemies()) {
                                enemy.die();
                            }
                        }
                        this.determineToSendRocket();

                        sleeper.sleepThread(this.t, 100);
                    }
                    else if(!Board.getBoard().getPlayer().isAlive()) {
                        this.die();
                        Board.getBoard().getGameManager().gameOver();
                    }
                }
            }
        }
    }
}
