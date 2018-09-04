package com.sqli.test.metier;

import com.sqli.test.entities.Elevator;

public interface IElevatorHandling {
	
	/**
	 * we'll just use {@code requestElevator(int)} inside and pass floor zero
	 * 
	 * @return {@code String} the is of the available elevator
	 */
	String requestElevator();
	
	/**
	 * gives the user the appropriate elevator requested from a given floor.
	 * 
	 * @param requestFloor	the floor which requests the floor
	 * @return {@code String}	the id of the available elevator
	 */
	String requestElevator(int floor);

	/**
	 * returns the elevator with the given id
	 * 
	 * @param	id					the elevators's id
	 * @return	{@code Elevator}	the elevator with the id: {@code id}
	 */
	Elevator getElevatorById(String id);
	
	/**
	 * tells the elevator given his id to stop at given floor
	 * 
	 * @param elevatorId	elevator's id
	 * @param foor			the floor the elevator should stop at
	 */
	void stopAt(String elevatorId, int floor);

	/**
	 * tell an elevator which direction to move
	 * 
	 * @param elevatorId	elevator's id
	 * @param direction		the direction the elevator moves,
	 * 						can be either {@code UP} or {@code DOWN}
	 */
	void move(String elevatorId, String direction);

}
