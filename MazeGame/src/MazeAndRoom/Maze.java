package MazeAndRoom;

import java.io.Serial;
import java.io.Serializable;

/**
 * Creates a Maze object containing nxn rooms.
 * @author Natalie Nguyen Hong
 * @version Spring 2021
 */
public class Maze implements Serializable {

    @Serial
    private static final long serialVersionUID = 1992197704689681978L;
    /** An array of rooms in the maze. */
    private Room[][] rooms;

    /** The width of the maze. */
    private int width;

    /** The height of the maze. */
    private int height;

    /** The current position of user in the maze. */
    private Point currentPosition;

    /** The number of hints of the maze. */
    private int hints;

    public Maze() {
        this(0,0,0);
    }

    /**
     * Construct a maze object that takes width, height and number of hints.
     * @param width the width of maze
     * @param height the height of maze
     * @param hints the number of hints
     */
    public Maze(int width, int height, int hints)
    {
        this.currentPosition = null;
        this.rooms = new Room[height][width];
        this.hints = hints;
        this.width = width;
        this.height = height;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rooms[i][j] = new Room();
            }
        }
    }

    /**
     * Construct a maze object that takes width, height, number of hints
     * and current position.
     * @param width the width of maze
     * @param height the height of maze
     * @param hints the number of hints
     * @param position the position of current room
     */
    public Maze(int width, int height, int hints, Point position)
    {
        this.currentPosition = position;
        this.rooms = new Room[height][width];
        this.hints = hints;
        this.width = width;
        this.height = height;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rooms[i][j] = new Room();
            }
        }
    }

    /**
     * Sets the width of the maze.
     * @param width the width of the maze
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Returns the width of maze.
     * @return the width of maze
     */
    public int getWidth() {
        return  this.width;
    }

    /**
     * Sets the height of the maze.
     * @param height the height of the maze
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Returns the height of maze.
     * @return the height of maze
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Return the room at current position.
     * @return The room at current position
     */
    public Room getRoom() {
        return this.rooms[this.currentPosition.getY()][this.currentPosition.getY()];
    }

    /**
     * Return the current position.
     * @return the current position.
     */
    public Point getCurrentPosition() {
        return this.currentPosition;
    }

    /**
     * Set current position.
     * @param x the x-coordinate
     * @param y th y-coordinate
     */
    public void setPosition (int x , int y){
        this.currentPosition.setX(x);
        this.currentPosition.setY(y);
    }

    /**
     * Set number of hints in the maze.
     * @param hints the number of hints
     */
    public void setHints(int hints)
    {
        this.hints = hints;
    }

    /**
     * Get the number of hints in the maze.
     * @return the number of hints in the maze
     */
    public int getHints() {
        return this.hints;
    }

    /**
     * Increase the number of hints.
     */
    public void increaseHint()
    {
        this.hints++;
    }

    /**
     * Decrease the number of hints.
     */
    public void decreaseHint()
    {
        this.hints--;
    }

    /**
     * The current position of user move up.
     */
    public void goUp() {
        currentPosition.setX(currentPosition.getX()-1);
    }

    /**
     * The current position of user move down.
     */
    public void goDown() {
        currentPosition.setX(currentPosition.getX()+1);
    }

    /**
     * The current position of user move to the left.
     */
    public void goLeft() {
        currentPosition.setY(currentPosition.getY()-1);
    }

    /**
     * The current position of user move to the right.
     */
    public void goRight() {
        currentPosition.setY(currentPosition.getY()+1);
    }

    /**
     * Returns true if the current position is out of bound. Otherwise, false.
     * @param string the direction
     * @return true if the current position is out of bound. Otherwise, false.
     */
    public boolean canMove (String string){
        if (string.equals("WEST")){
            return this.currentPosition.getY()-1>=0;
        }
        else if(string.equals("NORTH")){
            return this.currentPosition.getX()-1 >=0;
        }
        else if(string.equals("SOUTH")){
            return this.currentPosition.getX()+1<this.height;
        }
        else if(string.equals("EAST")){
            return this.currentPosition.getY()+1<this.width;
        }
        else return false;
    }

    /**
     * Returns true if the current position is at the exit. Otherwise, false.
     * @return true if the current position is at the exit. Otherwise, false.
     */
    public boolean checkWin (){
        return this.currentPosition.getX() == this.getHeight()-1 && this.currentPosition.getY() == getWidth()-2;
    }

    /**
     * Returns true if all doors are closed and canMove() is false. Otherwise, false.
     * @return true if all doors are closed and canMove() is false. Otherwise, false.
     */
    public boolean checkLose (){
        return ((!canMove("WEST")||!this.getRoom().isDoorOpen(Room.Door.WEST))
                &&(!canMove("NORTH")||!this.getRoom().isDoorOpen(Room.Door.NORTH))
                &&(!canMove("EAST")||!this.getRoom().isDoorOpen(Room.Door.EAST))
                &&(!canMove("SOUTH")||!this.getRoom().isDoorOpen(Room.Door.SOUTH)));
    }

    /**
     * Create a string representative of the maze object.
     * @return the string representative of the maze object
     */
    public String toString() {
        return "Maze by " + width + "x" + height;
    }
}
