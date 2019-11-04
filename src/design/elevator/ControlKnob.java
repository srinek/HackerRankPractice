package design.elevator;

public interface ControlKnob {

	public Floor getFloor();
	
	public boolean canGoUp();
	
	public boolean canGoDown();
	
	public void goDown();
	
	 
	
}
