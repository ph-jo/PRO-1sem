package door;

public class DoorOpen extends DoorState {
    private Door door;

    public DoorOpen(Door door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "OPEN";
    }

    @Override
    public void timeout() {
        door.startTimer(2000, event -> {
            door.setState(door.getClosingState());
            door.getClosingState().complete();
        });
    }

    @Override
    public void click() {
        door.stopTimer();
        door.setState(door.getStayOpenState());
    }
}
