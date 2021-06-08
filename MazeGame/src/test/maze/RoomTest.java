package test.maze;

import maze.Room;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests of the Room class.
 * @author Natalie Nguyen Hong
 * @version Spring 2021
 */
class RoomTest {

    /** A Room object to test. */
    private Room room;

    /**
     * Initializes the room object.
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        room = new Room();
    }

    /**
     * A test method for {@link Room#setHints(int)}.
     */
    @org.junit.jupiter.api.Test
    void setHints() {
        room.setHints(0);
        assertEquals(0, room.getHints());
    }

    /**
     * A test method for {@link Room#setHints(int)}.
     */
    @org.junit.jupiter.api.Test
    void setHintsWithPositiveNumber() {
        room.setHints(3);
        assertEquals(3, room.getHints());
    }

    /**
     * A test method for {@link Room#getHints()}.
     */
    @org.junit.jupiter.api.Test
    void getHints() {
        room.setHints(0);
        assertEquals(0, room.getHints());
    }

    /**
     * A test method for {@link Room#openDoor(Room.Door)}.
     */
    @org.junit.jupiter.api.Test
    void openDoorNorth() {
        room.openDoor(Room.Door.NORTH);
        assertEquals(true, room.isDoorOpen(Room.Door.NORTH));
    }

    /**
     * A test method for {@link Room#openDoor(Room.Door)}.
     */
    @org.junit.jupiter.api.Test
    void openDoorSouth() {
        room.openDoor(Room.Door.SOUTH);
        assertEquals(true, room.isDoorOpen(Room.Door.SOUTH));
    }

    /**
     * A test method for {@link Room#openDoor(Room.Door)}.
     */
    @org.junit.jupiter.api.Test
    void openDoorEast() {
        room.openDoor(Room.Door.EAST);
        assertEquals(true, room.isDoorOpen(Room.Door.EAST));
    }

    /**
     * A test method for {@link Room#openDoor(Room.Door)}.
     */
    @org.junit.jupiter.api.Test
    void openDoorWest() {
        room.openDoor(Room.Door.WEST);
        assertEquals(true, room.isDoorOpen(Room.Door.WEST));
    }

    /**
     * A test method for {@link Room#closeDoor(Room.Door)}.
     */
    @org.junit.jupiter.api.Test
    void closeDoorNorth() {
        room.closeDoor(Room.Door.NORTH);
        assertEquals(false, room.isDoorOpen(Room.Door.NORTH));
    }

    /**
     * A test method for {@link Room#closeDoor(Room.Door)}.
     */
    @org.junit.jupiter.api.Test
    void closeDoorSouth() {
        room.closeDoor(Room.Door.SOUTH);
        assertEquals(false, room.isDoorOpen(Room.Door.SOUTH));
    }

    /**
     * A test method for {@link Room#closeDoor(Room.Door)}.
     */
    @org.junit.jupiter.api.Test
    void closeDoorEast() {
        room.closeDoor(Room.Door.EAST);
        assertEquals(false, room.isDoorOpen(Room.Door.EAST));
    }

    /**
     * A test method for {@link Room#closeDoor(Room.Door)}.
     */
    @org.junit.jupiter.api.Test
    void closeDoorWest() {
        room.closeDoor(Room.Door.WEST);
        assertEquals(false, room.isDoorOpen(Room.Door.WEST));
    }

    /**
     * A test method for {@link Room#isDoorOpen(Room.Door)}.
     */
    @org.junit.jupiter.api.Test
    void isDoorOpenWithDoorOpen() {
        room.openDoor(Room.Door.NORTH);
        assertEquals(true, room.isDoorOpen(Room.Door.NORTH));
    }

    /**
     * A test method for {@link Room#isDoorOpen(Room.Door)}.
     */
    @org.junit.jupiter.api.Test
    void isDoorOpenWithDoorClose() {
        room.closeDoor(Room.Door.NORTH);
        assertEquals(false, room.isDoorOpen(Room.Door.NORTH));
    }
}