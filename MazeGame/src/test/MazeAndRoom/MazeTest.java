package MazeAndRoom;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests of the Maze class.
 * @author Natalie Nguyen Hong
 * @version Spring 2021
 */
class MazeTest {

    /** A maze object to test. */
    private Maze maze;

    /**
     * Initializes the maze object.
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        maze = new Maze();
    }

    /**
     * Test method for {@link Maze#setWidth(int)}.
     */
    @org.junit.jupiter.api.Test
    void setWidth() {
        maze.setWidth(5);
        assertEquals(5, maze.getWidth());
    }

    /**
     * Test method for {@link Maze#getWidth()}.
     */
    @org.junit.jupiter.api.Test
    void getWidth() {
        maze.setWidth(5);
        assertEquals(5, maze.getWidth());
    }

    /**
     * Test method for {@link Maze#setHeight(int)}.
     */
    @org.junit.jupiter.api.Test
    void setHeight() {
        maze.setHeight(5);
        assertEquals(5, maze.getHeight());
    }

    /**
     * Test method for {@link Maze#getHeight()}.
     */
    @org.junit.jupiter.api.Test
    void getHeight() {
        maze.setHeight(5);
        assertEquals(5, maze.getHeight());
    }

    /**
     * Test method for {@link Maze#getRoom()}.
     */
    @org.junit.jupiter.api.Test
    void getRoom() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(0,0);
        maze.getRoom().closeDoor(Room.Door.EAST);
        assertFalse(maze.getRoom().isDoorOpen(Room.Door.EAST));
    }

    /**
     * Test method for {@link Maze#getCurrentPosition()}.
     */
    @org.junit.jupiter.api.Test
    void getCurrentPosition() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(0,0);
        assertEquals("[0, 0]", maze.getCurrentPosition().toString());
    }

    /**
     * Test method for {@link Maze#setPosition(int, int)}.
     */
    @org.junit.jupiter.api.Test
    void setPosition() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(1,1);
        assertEquals("[1, 1]", maze.getCurrentPosition().toString());
    }

    /**
     * Test method for {@link Maze#setHints(int)}.
     */
    @org.junit.jupiter.api.Test
    void setHints() {
        maze.setHints(0);
        assertEquals(0, maze.getHints());
    }

    /**
     * Test method for {@link Maze#getHints()}.
     */
    @org.junit.jupiter.api.Test
    void getHints() {
        maze.setHints(4);
        assertEquals(4, maze.getHints());
    }

    /**
     * Test method for {@link Maze#increaseHint()}.
     */
    @org.junit.jupiter.api.Test
    void increaseHint() {
        maze.setHints(0);
        maze.increaseHint();
        assertEquals(1, maze.getHints());
    }

    /**
     * Test method for {@link Maze#decreaseHint()}.
     */
    @org.junit.jupiter.api.Test
    void decreaseHint() {
        maze.setHints(4);
        maze.decreaseHint();
        assertEquals(3, maze.getHints());
    }

    /**
     * Test method for {@link Maze#goUp()}.
     */
    @org.junit.jupiter.api.Test
    void goUp() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(1,1);
        maze.goUp();
        assertEquals("[0, 1]", maze.getCurrentPosition().toString());
    }

    /**
     * Test method for {@link Maze#goDown()}.
     */
    @org.junit.jupiter.api.Test
    void goDown() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(1,1);
        maze.goDown();
        assertEquals("[2, 1]", maze.getCurrentPosition().toString());
    }

    /**
     * Test method for {@link Maze#goLeft()}.
     */
    @org.junit.jupiter.api.Test
    void goLeft() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(1,1);
        maze.goLeft();
        assertEquals("[1, 0]", maze.getCurrentPosition().toString());
    }

    /**
     * Test method for {@link Maze#goRight()}.
     */
    @org.junit.jupiter.api.Test
    void goRight() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(1,1);
        maze.goRight();
        assertEquals("[1, 2]", maze.getCurrentPosition().toString());
    }

    /**
     * Test method for {@link Maze#canMove(String)}.
     */
    @org.junit.jupiter.api.Test
    void canMoveGoNorthFalse() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(0,0);
        assertFalse(maze.canMove("NORTH"));
    }

    /**
     * Test method for {@link Maze#canMove(String)}.
     */
    @org.junit.jupiter.api.Test
    void canMoveGoSouthFalse() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(4,4);
        assertFalse(maze.canMove("SOUTH"));
    }

    /**
     * Test method for {@link Maze#canMove(String)}.
     */
    @org.junit.jupiter.api.Test
    void canMoveGoWestFalse() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(0,0);
        assertFalse(maze.canMove("WEST"));
    }

    /**
     * Test method for {@link Maze#canMove(String)}.
     */
    @org.junit.jupiter.api.Test
    void canMoveGoEastFalse() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(0,4);
        assertFalse(maze.canMove("EAST"));
    }

    /**
     * Test method for {@link Maze#canMove(String)}.
     */
    @org.junit.jupiter.api.Test
    void canMoveGoNorthTrue() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(1,0);
        assertTrue(maze.canMove("NORTH"));
    }

    /**
     * Test method for {@link Maze#canMove(String)}.
     */
    @org.junit.jupiter.api.Test
    void canMoveGoSouthTrue() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(1,0);
        assertTrue(maze.canMove("SOUTH"));
    }

    /**
     * Test method for {@link Maze#canMove(String)}.
     */
    @org.junit.jupiter.api.Test
    void canMoveGoWestTrue() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(1,1);
        assertTrue(maze.canMove("WEST"));
    }

    /**
     * Test method for {@link Maze#canMove(String)}.
     */
    @org.junit.jupiter.api.Test
    void canMoveGoEastTrue() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(1,0);
        assertTrue(maze.canMove("EAST"));
    }

    /**
     * Test method for {@link Maze#checkWin()}.
     */
    @org.junit.jupiter.api.Test
    void checkWinFalse() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setHeight(5);
        maze.setWidth(5);
        maze.setPosition(4,4);
        assertFalse(maze.checkWin());
    }

    /**
     * Test method for {@link Maze#checkWin()}.
     */
    @org.junit.jupiter.api.Test
    void checkWinTrue() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setHeight(5);
        maze.setWidth(5);
        maze.setPosition(4,3);
        assertTrue(maze.checkWin());
    }

    /**
     * Test method for {@link Maze#checkLose()}.
     */
    @org.junit.jupiter.api.Test
    void checkLoseAllDoorsClose() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(1,1);
        maze.getRoom().closeDoor(Room.Door.NORTH);
        maze.getRoom().closeDoor(Room.Door.SOUTH);
        maze.getRoom().closeDoor(Room.Door.WEST);
        maze.getRoom().closeDoor(Room.Door.EAST);
        assertTrue(maze.checkLose());
    }

    /**
     * Test method for {@link Maze#checkLose()}.
     */
    @org.junit.jupiter.api.Test
    void checkLoseThreeDoorsClose() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(1,1);
        maze.getRoom().closeDoor(Room.Door.NORTH);
        maze.getRoom().closeDoor(Room.Door.SOUTH);
        maze.getRoom().closeDoor(Room.Door.WEST);
        assertFalse(maze.checkLose());
    }

    /**
     * Test method for {@link Maze#checkLose()}.
     */
    @org.junit.jupiter.api.Test
    void checkLoseTwoDoorsClose() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(1,1);
        maze.getRoom().closeDoor(Room.Door.NORTH);
        maze.getRoom().closeDoor(Room.Door.SOUTH);
        assertFalse(maze.checkLose());
    }

    /**
     * Test method for {@link Maze#checkLose()}.
     */
    @org.junit.jupiter.api.Test
    void checkLoseOneDoorsClose() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(1,1);
        maze.getRoom().closeDoor(Room.Door.NORTH);
        assertFalse(maze.checkLose());
    }

    /**
     * Test method for {@link Maze#checkLose()}.
     */
    @org.junit.jupiter.api.Test
    void checkLoseThreeDoorsCloseAndCannotMove() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(0,1);
        maze.getRoom().closeDoor(Room.Door.EAST);
        maze.getRoom().closeDoor(Room.Door.SOUTH);
        maze.getRoom().closeDoor(Room.Door.WEST);
        assertTrue(maze.checkLose());
    }

    /**
     * Test method for {@link Maze#checkLose()}.
     */
    @org.junit.jupiter.api.Test
    void checkLoseTwoDoorsCloseAndCannotMove() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setPosition(0,0);
        maze.getRoom().closeDoor(Room.Door.EAST);
        maze.getRoom().closeDoor(Room.Door.SOUTH);
        assertTrue(maze.checkLose());
    }

    /**
     * Test method for {@link Maze#toString()}.
     */
    @org.junit.jupiter.api.Test
    void testToString() {
        maze = new Maze(5,5, 0, new Point(0,0));
        maze.setWidth(5);
        maze.setHeight(5);
        assertEquals("Maze by 5x5", maze.toString());
    }
}