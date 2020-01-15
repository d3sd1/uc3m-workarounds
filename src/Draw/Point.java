package Draw;

import GUI.Board;
import Utils.Constants;

//Punto perteneciente a una forma, NO!! al tablero. NO PERTENECE AL TABLERO.
public class Point {
    private short x;
    private short y;
    private short[] color;

    public Point() {
        this.color = new short[]{0,0,0};
    }

    public Point(short x, short y) {
        this.x = x;
        this.y = y;
        this.color = new short[]{0,0,0};
    }
    public Point(int x, int y) {
        this.x = (short) x;
        this.y = (short) y;
        this.color = new short[]{0,0,0};
    }

    public short getX() {
        return x;
    }

    public void setX(short x) {
        this.x = x;
    }

    public short getY() {
        return y;
    }

    public void setY(short y) {
        this.y = y;
    }

    public short[] getColor() {
        return color;
    }

    public void setColor(short[] color) {
        this.color = color;
        Board.getBoard().getGameGUI().gb_setSquareColor(this.getX(), this.getY(), this.getColor()[0], this.getColor()[1], this.getColor()[2]);
    }

}
