package design.elevator;

public interface Elevator {

	
	public void move(Floor floor);
	
	public boolean stop();
	
	public boolean openDoors();
	
	public boolean closeDoors();
	
	public void callHelp();
}
