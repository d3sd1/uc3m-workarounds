package Draw;

import java.util.ArrayList;

/**
 * Shape, it is a combination of points.
 */
public class Shape {
    private ArrayList<Point> points;

    /**
     * Instantiates a new Shape.
     */
    public Shape() {
    }

    /**
     * Instantiates a new Shape.
     *
     * @param points the points
     */
    public Shape(ArrayList<Point> points) {
        this.points = points;
    }

    /**
     * Gets points.
     *
     * @return the points
     */
    public ArrayList<Point> getPoints() {
        return points;
    }

    /**
     * Sets points.
     *
     * @param points the points
     */
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
}
