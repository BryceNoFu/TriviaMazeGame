package MazeAndRoom;

import java.io.Serial;
import java.io.Serializable;

/**
 * Creates a Room object containing 2-4 doors.
 * @author Natalie Nguyen Hong
 * @version Spring 2021
 */
public class Room implements Serializable {

    @Serial
    private static final long serialVersionUID = 2138616414160799691L;

    /**
     * Creates a Door enum and its value.
     */
    public enum Door {
        NORTH(0),
        SOUTH(1),
        WEST(2),
        EAST(3);

        int value;

        /**
         *  Constructs a door object that takes a value.
         * @param value the value of door
         */
        Door(int value) {
            this.value = value;
        }

        /**
         * Returns the value of Door object.
         * @return the value of Door object.
         */
        public int getValue() {
            return this.value;
        }
    }

    /** The number of hints in room. */
    private int hints;

    /** The doors of room. */
    private final int[] doors;

    /**
     * Constructs an empty room.
     */
    public Room() {
        this(0);
    }


    /**
     * Constructs a room object that takes number of hints and position of room.
     * @param hints the number of hints
     */
    public Room(int hints) {
        this.hints = hints;
        this.doors = new int[4];
        this.doors[Door.NORTH.getValue()] = 1;
        this.doors[Door.SOUTH.getValue()] = 1;
        this.doors[Door.WEST.getValue()] = 1;
        this.doors[Door.EAST.getValue()] = 1;
    }

    /**
     * Sets the number of hints.
     * @param hints the number of hints
     */
    public void setHints(int hints) {
        this.hints = hints;
    }

    /**
     * Gets the number of hints.
     * @return the number of hints
     */
    public int getHints() {
        return this.hints;
    }

    /**
     * Opens the door.
     * @param door the door
     */
    public void openDoor(Door door) {
        switch (door) {
            case NORTH -> this.doors[Door.NORTH.getValue()] = 1;
            case SOUTH -> this.doors[Door.SOUTH.getValue()] = 1;
            case WEST -> this.doors[Door.WEST.getValue()] = 1;
            case EAST -> this.doors[Door.EAST.getValue()] = 1;
        }
    }

    /**
     * Closes the door.
     * @param door  the door
     */
    public void closeDoor(Door door) {
        switch (door) {
            case NORTH -> this.doors[Door.NORTH.getValue()] = 0;
            case SOUTH -> this.doors[Door.SOUTH.getValue()] = 0;
            case WEST -> this.doors[Door.WEST.getValue()] = 0;
            case EAST -> this.doors[Door.EAST.getValue()] = 0;
        }
    }

    /**
     * Return true if the door is open. Otherwise false.
     * @param door the door
     * @return true if the door is open. Otherwise false.
     */
    public boolean isDoorOpen(Door door) {
        switch (door) {
            case NORTH:
                return this.doors[Door.NORTH.getValue()] == 1;
            case SOUTH:
                return this.doors[Door.SOUTH.getValue()] == 1;
            case WEST:
                return this.doors[Door.WEST.getValue()] == 1;
            case EAST:
                return this.doors[Door.EAST.getValue()] == 1;
        }
        return false;
    }

}
