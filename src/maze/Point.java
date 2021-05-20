package maze;

public class Point {
    private int xCoordinate;
    private int yCoordinate;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    public void setX(int x) {
        xCoordinate = x;
    }

    public int getX() {
        return xCoordinate;
    }

    public void setY(int y) {
        yCoordinate = y;
    }

    public int getY() {
        return yCoordinate;
    }

    public String toString() {
        return "[" + xCoordinate + ", " + yCoordinate + "]";
    }
}
