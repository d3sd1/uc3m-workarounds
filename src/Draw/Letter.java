package Draw;

import GUI.Board;
import Utils.Constants;

/**
 * A letter that forms a word.
 */
public abstract class Letter {
    /**
     * The Init x.
     */
    protected short initX;
    /**
     * The Init y.
     */
    protected short initY;
    /**
     * The Length x.
     */
    protected short lengthX;
    /**
     * The Length y.
     */
    protected short lengthY;
    /**
     * The Shape.
     */
    protected Shape shape;

    /**
     * Instantiates a new Letter by it's childrens (a letter like A).
     */
    protected Letter(){

    }

    /**
     * Instantiates a new Letter.
     *
     * @param initX   the init x
     * @param initY   the init y
     * @param lengthX the length x
     * @param lengthY the length y
     */
    public Letter(short initX, short initY, short lengthX, short lengthY) {
        this.initX = initX;
        this.initY = initY;
        this.lengthX = lengthX;
        this.lengthY = lengthY;
    }

    /**
     * Draw.
     */
    public void draw() {
        for(Point point : this.getShape().getPoints()) {
            if(this.initX + this.lengthX > Constants.DEFAULT_BOARD_WIDTH ||
                    this.initY + this.lengthY > Constants.DEFAULT_BOARD_HEIGHT) {
                System.out.println("A point of a letter got out of bounds: " + this.getClass().getName());
            }
            else {
                Board.getBoard().getGameGUI().gb_setSquareColor(point.getX(), point.getY(), point.getColor()[0], point.getColor()[1], point.getColor()[2]);
            }
        }
    }

    /**
     * Hide.
     */
    public void hide() {
        for(Point point : this.getShape().getPoints()) {
            if(this.initX + this.lengthX > Constants.DEFAULT_BOARD_WIDTH ||
                    this.initY + this.lengthY > Constants.DEFAULT_BOARD_HEIGHT) {
                System.out.println("A point of a letter got out of bounds: " + this.getClass().getName());
            }
            else {
                byte[] boardColor = Constants.DEFAULT_BOARD_COLOR;
                Board.getBoard().getGameGUI().gb_setSquareColor(point.getX(), point.getY(), boardColor[0], boardColor[0], boardColor[0]);
            }
        }
    }

    /**
     * Generate shape.
     */
    protected abstract void generateShape();

    /**
     * Gets init x.
     *
     * @return the init x
     */
    public short getInitX() {
        return initX;
    }

    /**
     * Sets init x.
     *
     * @param initX the init x
     */
    public void setInitX(short initX) {
        this.initX = initX;
    }

    /**
     * Gets init y.
     *
     * @return the init y
     */
    public short getInitY() {
        return initY;
    }

    /**
     * Sets init y.
     *
     * @param initY the init y
     */
    public void setInitY(short initY) {
        this.initY = initY;
    }

    /**
     * Gets length x.
     *
     * @return the length x
     */
    public short getLengthX() {
        return lengthX;
    }

    /**
     * Sets length x.
     *
     * @param lengthX the length x
     */
    public void setLengthX(short lengthX) {
        this.lengthX = lengthX;
    }

    /**
     * Gets length y.
     *
     * @return the length y
     */
    public short getLengthY() {
        return lengthY;
    }

    /**
     * Sets length y.
     *
     * @param lengthY the length y
     */
    public void setLengthY(short lengthY) {
        this.lengthY = lengthY;
    }

    /**
     * Sets shape.
     *
     * @param shape the shape
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * Gets shape.
     *
     * @return the shape
     */
    public Shape getShape() {
        return shape;
    }

}
