package door;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Door {
	private final DoorState closedState;
	private final DoorState closingState;
	private final DoorState openState;
	private final DoorState openingState;
	private final DoorState stayOpenState;
	
	private DoorState state;
	private ArrayList<Observer> observers;
    private Timeline timer;

	public Door() {
		closedState = new DoorClosed(this);
		closingState = new DoorClosing(this);
		openState = new DoorOpen(this);
		openingState = new DoorOpening(this);
		stayOpenState = new DoorStayOpen(this);
		observers = new ArrayList<>();
		state = this.closedState;
	}

	public DoorState getClosedState() {
		return closedState;
	}

	public DoorState getClosingState() {
		return closingState;
	}

	public DoorState getOpenState() {
		return openState;
	}

	public DoorState getOpeningState() {
		return openingState;
	}

	public DoorState getStayOpenState() {
		return stayOpenState;
	}

	public DoorState getState() {
		return state;
	}

	public void startTimer(double duration, EventHandler<ActionEvent> event) {
	    if (timer != null) {
	        stopTimer();        
	    }
		timer = new Timeline(new KeyFrame(Duration.millis(duration), event));
		timer.play();
	}
	
	public void stopTimer() {
	    timer.stop();
	}
	
	public void click() {
	    this.state.click();
	}

	public void setState(DoorState state) {
		this.state = state;
		notifyObservers();
	}

	public void addObserver(Observer obs) {
		observers.add(obs);
	}

	private void notifyObservers() {
		for (Observer obs : observers) {
			obs.update(this);
		}
	}
}