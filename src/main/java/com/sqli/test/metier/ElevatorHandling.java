package com.sqli.test.metier;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.sqli.test.elevators.Building;
import com.sqli.test.entities.Elevator;

public class ElevatorHandling implements IElevatorHandling {

	private Building building;

	public ElevatorHandling(Building building) {
		this.building = building;
	}

	@Override
	public String requestElevator() {
		/**
		 * pass floor zero as the wanted floor
		 */
		return requestElevator(0);
	}

	@Override
	public String requestElevator(int requestFloor) {

		/**
		 * calculate the trip of every elevator to the user.
		 */
		Map<Integer, Integer> trips = new HashMap<>();
		for (Elevator elevator : building.getElevators())
			trips.put(elevator.getId(), getElevatorTrip(elevator, requestFloor));
		
		/**
		 * return the elevator with the smallest trip.
		 * 
		 * if the smallest trip is the one with
		 */
		return theClosestElevator(trips).getPrettyId();

	}

	/**
	 * returns the smallest trip of all available elevators
	 * 
	 * @param trips
	 * @return
	 */
	private Elevator theClosestElevator(Map<Integer, Integer> trips) {
		int smallestTrip = 2 * building.getNumberOfFloors();
		Integer smallestTripElevatorId = -1;
		
		for (Entry<Integer, Integer> entry : trips.entrySet()) {
			if (entry.getValue() < smallestTrip) {
				smallestTrip = entry.getValue();
				smallestTripElevatorId= entry.getKey();
			}
		}
		
		return getElevatorById(Elevator.prettyfyId(smallestTripElevatorId));
	}

	/**
	 * this will calculate the trip each elevator will take in order to get to the user.
	 * 
	 * @param elevator
	 * @param requestFloor
	 * @return
	 */
	private Integer getElevatorTrip(Elevator elevator, int requestFloor) {
		if (elevator.hasDestination())
			return 2 * building.getNumberOfFloors(); // the elevators with stops are the last to ever come
		else {
			if (elevator.getDirection().isEmpty()
					|| (elevator.getCurrentFloor() < requestFloor && elevator.getDirection().equals("UP"))
					|| (elevator.getCurrentFloor() > requestFloor && elevator.getDirection().equals("DOWN")))
			{
				return distance(elevator.getCurrentFloor(), requestFloor);
			}
			else {
				if (elevator.getCurrentFloor() < requestFloor && elevator.getDirection().equals("DOWN"))
					return 2 * elevator.getCurrentFloor() + requestFloor - elevator.getCurrentFloor();
				else 
					return 2 * (building.getNumberOfFloors() - elevator.getCurrentFloor()) + elevator.getCurrentFloor()
							- requestFloor;
			}
		}
	}

	private Integer distance(int currentFloor, int requestFloor) {
		return Math.abs(currentFloor - requestFloor);
	}

	@Override
	public Elevator getElevatorById(String id) {
		int elevatorId = Integer.parseInt(id.substring(2));
		for (Elevator elevator : building.getElevators())
			if (elevator.getId() == elevatorId)
				return elevator;
		return null;
	}

	@Override
	public void stopAt(String elevatorId, int floor) {
		getElevatorById(elevatorId).setDestinationFloor(floor);
	}

	@Override
	public void move(String elevatorId, String direction) {
		getElevatorById(elevatorId).setDirection(direction);
	}

}
