package door;

public class DoorOpening extends DoorState {
    private Door door;

    public DoorOpening(Door door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "OPENING";
    }

    @Override
    public void complete() {
        door.startTimer(3000, event -> {
            door.setState(door.getOpenState());
            door.getOpenState().timeout();
        });
    }

    @Override
    public void click() {
        door.setState(door.getClosingState());
        door.startTimer(4000, event -> {
            door.setState(door.getClosedState());
        });
    }
}
