public class Room {

    enum Door {
        NORTH(0),
        SOUTH(1),
        WEST(2),
        EAST(3);

        int value;
        Door(int value) {
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }
    }

    private Question question;
    private int hints;
    private int[] doors;

    public Room() {
        this(0);
    }

    public Room(int hints) {
        this(hints, null);
    }

    public Room(int hints, Question question) {
        this.hints = hints;
        this.doors = new int[4];
        this.doors[Door.NORTH.getValue()] = 0;
        this.doors[Door.SOUTH.getValue()] = 0;
        this.doors[Door.WEST.getValue()] = 0;
        this.doors[Door.EAST.getValue()] = 0;
        this.question = question;
    }

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
    
    public void setQuestion(final Question theQuestion) {
        this.question = theQuestion;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void increaseHint()
    {
        this.hints++;
    }

    public void decreaesHint()
    {
        this.hints--;
    }
}
