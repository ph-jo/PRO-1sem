package door;

public class DoorClosing extends DoorState {
    private Door door;

    public DoorClosing(Door door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "CLOSING";
    }

    @Override
    public void complete() {
        door.startTimer(2000, event -> {
            door.setState(door.getClosedState());
        });
    }

    @Override
    public void click() {
        door.setState(door.getOpeningState());
        door.startTimer(3000, event -> {
            door.setState(door.getOpenState());
            door.getOpenState().timeout();
        });
    }
}
