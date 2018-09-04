package com.sqli.test.entities;

public class Elevator {

	private int id;
	private int currentFloor;
	private String direction = "";
	private int destinationFloor = -1;
	
	public Elevator(String elevator) {
		String[] caracteristics = elevator.split(":");

		this.id = Integer.parseInt(caracteristics[0].substring(2));
		this.currentFloor = Integer.parseInt(caracteristics[1]);
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPrettyId() {
		return "id" + getId();
	}
	
	public static String prettyfyId(int id) {
		return "id" + id;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getDestinationFloor() {
		return destinationFloor;
	}

	public void setDestinationFloor(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}
	
	public boolean hasDestination() {
		return (destinationFloor == -1) ? false : true;
	}

}
