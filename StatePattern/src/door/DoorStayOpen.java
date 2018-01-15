package door;

public class DoorStayOpen extends DoorState {

    private Door door;

    public DoorStayOpen(Door door) {
        this.door = door;
    }

    @Override
    public void click() {
        door.setState(door.getClosingState());
        door.startTimer(4000, event -> {
            door.setState(door.getClosedState());
        });
    }

    @Override
    public String toString() {
        return "STAY OPEN";
    }
}