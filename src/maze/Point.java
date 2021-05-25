package maze;

/**
 * Creates a Point object.
 * @author Natalie Nguyen Hong
 * @version Spring 2021
 */
public class Point {
    /** The x-coordinate of point. */
    private int xCoordinate;

    /** The y-coordinate of point. */
    private int yCoordinate;

    /**
     * Constructs an empty point object.
     */
    public Point() {
        this(0, 0);
    }

    /**
     * Construct a point object that takes x-coordinate and y-coordinate.
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    /**
     * Sets the x-coordinate of the point.
     * @param x the x-coordinate of the point
     */
    public void setX(int x) {
        xCoordinate = x;
    }

    /**
     * Returns the x-coordinate of the point.
     * @return the x-coordinate of the point
     */
    public int getX() {
        return xCoordinate;
    }

    /**
     * Sets the y-coordinate of the point.
     * @param y the y-coordinate of the point
     */
    public void setY(int y) {
        yCoordinate = y;
    }

    /**
     * Returns the y-coordinate of the point.
     * @return the y-coordinate of the point
     */
    public int getY() {
        return yCoordinate;
    }

    /**
     * Returns the string representative of the point object.
     * @return the string representative of the point object
     */
    public String toString() {
        return "[" + xCoordinate + ", " + yCoordinate + "]";
    }
}
