package com.sqli.test.elevators;

import java.util.ArrayList;

import com.sqli.test.entities.Elevator;
import com.sqli.test.metier.ElevatorHandling;
import com.sqli.test.metier.IElevatorHandling;

public class Building {

	private int numberOfFloors;
	private ArrayList<Elevator> elevators = new ArrayList<>();
	private IElevatorHandling elevatorHandling = new ElevatorHandling(this);
    
    /**
     * @param numberOfFloors: the number of floors in the building
     * @param elevators: an array of descriptions of the elevators of the building. 
     *                   A description has the following format "[elevator_id]:[elevator_current_floor]".
     */
    public Building(int numberOfFloors, String... elevators) {
        this.numberOfFloors = numberOfFloors;
    	for (String elevator : elevators)
    		this.elevators.add(new Elevator(elevator));
    }

    /**
     * Request an elevator at floor zero.
     * @return the id of the elevator that should serve the request.
     */
    public String requestElevator() {
    	return elevatorHandling.requestElevator();
    }

    /**
     * Request an elevator at floor indicate by the {@code floor} param.
     * @param floor : the floor where the request is made.
     * @return the id of the elevator that should serve the request.
     */
    public String requestElevator(int floor) {
    	return elevatorHandling.requestElevator(floor);
    }

    /**
     * Request the elevator with the id {@code elevatorId} to stop at the floor indicated by the {@code floor} param.
     * @param elevatorId : the id of the elevator to whom give the order.
     * @param floor : the floor at which the elevator should stop
     */
    public void stopAt(String elevatorId, int floor) {
    	elevatorHandling.stopAt(elevatorId, floor);
    }

    /**
     * Move the elevator with the id {@code elevatorId} in the direction indicated by the {@code direction} param.
     * @param elevatorId : the id of the elevator to move.
     * @param direction : the direction to go. Can be "UP" or "DOWN".
     */
    public void move(String elevatorId, String direction) {
    	elevatorHandling.move(elevatorId, direction);
    }

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public ArrayList<Elevator> getElevators() {
		return elevators;
	}

	public void setElevators(ArrayList<Elevator> elevators) {
		this.elevators = elevators;
	}
    

}
