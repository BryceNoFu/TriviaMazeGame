package MazeAndRoom;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests of the Point class.
 * @author Natalie Nguyen Hong
 * @version Spring 2021
 */
class PointTest {

    /** A point object to test. */
    private Point point;

    /**
     * Initializes the point object.
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        point = new Point();
    }

    /**
     * Test method for {@link Point#setX(int)}.
     */
    @org.junit.jupiter.api.Test
    void setXWith0() {
        point.setX(0);
        assertEquals(0, point.getX());
    }

    /**
     * Test method for {@link Point#setX(int)}.
     */
    @org.junit.jupiter.api.Test
    void setXWithNegativeNumber() {
        point.setX(-1);
        assertEquals(-1, point.getX());
    }

    /**
     * Test method for {@link Point#setX(int)}.
     */
    @org.junit.jupiter.api.Test
    void setXWithPositiveNumber() {
        point.setX(1);
        assertEquals(1, point.getX());
    }

    /**
     * Test method for {@link Point#getX()}.
     */
    @org.junit.jupiter.api.Test
    void getX() {
        point.setX(0);
        assertEquals(0, point.getX());
    }

    /**
     * Test method for {@link Point#setY(int)}.
     */
    @org.junit.jupiter.api.Test
    void setYWith0() {
        point.setY(0);
        assertEquals(0, point.getY());
    }

    /**
     * Test method for {@link Point#setY(int)}.
     */
    @org.junit.jupiter.api.Test
    void setYWithNegativeNumber() {
        point.setY(-1);
        assertEquals(-1, point.getY());
    }

    /**
     * Test method for {@link Point#setY(int)}.
     */
    @org.junit.jupiter.api.Test
    void setYWithPositiveNumber() {
        point.setY(1);
        assertEquals(1, point.getY());
    }

    /**
     * Test method for {@link Point#getY()}.
     */
    @org.junit.jupiter.api.Test
    void getY() {
        point.setY(0);
        assertEquals(0, point.getY());
    }

    /**
     * Test method for {@link Point#toString()}.
     */
    @org.junit.jupiter.api.Test
    void testToString() {
        point = new Point(0,0);
        String pointString = point.toString();
        String expectedString = "[0, 0]";
        assertEquals(expectedString, pointString);
    }
}