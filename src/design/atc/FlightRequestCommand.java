package design.atc;

public interface FlightRequestCommand {

	public Runway getRunway();
	
	public Gate getGate();
	
	public void invoke() throws Exception;
	
	public void undo() throws Exception;
	
	
	public int getFlightNumber();
}
