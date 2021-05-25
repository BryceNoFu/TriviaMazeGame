package maze;

/**
 * Creates a Room object containing 2-4 doors.
 * @author Natalie Nguyen Hong
 * @version Spring 2021
 */
public class Room {

    /**
     * Creates a Door enum and its value.
     */
    enum Door {
        NORTH(0),
        SOUTH(1),
        WEST(2),
        EAST(3);

        int value;

        /**
         *  Constructs a door object that takes a value.
         * @param value
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

    /** The position of room. */
    private Point position;

    /** The number of hints in room. */
    private int hints;

    /** The doors of room. */
    private int[] doors;

    /**
     * Constructs an empty room.
     */
    public Room() {
        this(0);
    }

    /**
     * Constructs a room object that takes number of hints.
     * @param hints the number of hints
     */
    public Room(int hints) {
        this(hints, new Point(0,0));
    }

    /**
     * Constructs a room object that takes number of hints and position of room.
     * @param hints
     * @param position
     */
    public Room(int hints, Point position) {
        this.hints = hints;
        position = position;
        this.doors = new int[4];
        this.doors[Door.NORTH.getValue()] = 0;
        this.doors[Door.SOUTH.getValue()] = 0;
        this.doors[Door.WEST.getValue()] = 0;
        this.doors[Door.EAST.getValue()] = 0;
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
            case NORTH:
                this.doors[Door.NORTH.getValue()] = 1;
                break;
            case SOUTH:
                this.doors[Door.SOUTH.getValue()] = 1;
                break;
            case WEST:
                this.doors[Door.WEST.getValue()] = 1;
                break;
            case EAST:
                this.doors[Door.EAST.getValue()] = 1;
                break;
        }
    }

    /**
     * Closes the door.
     * @param door  the door
     */
    public void closeDoor(Door door) {
        switch (door) {
            case NORTH:
                this.doors[Door.NORTH.getValue()] = 0;
                break;
            case SOUTH:
                this.doors[Door.SOUTH.getValue()] = 0;
                break;
            case WEST:
                this.doors[Door.WEST.getValue()] = 0;
                break;
            case EAST:
                this.doors[Door.EAST.getValue()] = 0;
                break;
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

    /**
     * Create a string representative of the room object.
     * @return the string representative of the room object.
     */
    public String currentRoomString() {
        return "Room: " + this.position.getX() + ", " + this.position.getY();
    }
}
