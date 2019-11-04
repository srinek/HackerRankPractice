package design.elevator;

import java.util.List;

public interface ElevatorSystem {
	
	public List<Elevator> getElevators();
	
	public List<Floor> getFloors();
	
	public void configure(int noOfElevators, int noOfFloors);
	
	public void configureFloor(Floor floor);
	
	public void configureElevator(Elevator elevator);

	
}
