package design.atc;

public interface Flight {
	
	public int getFilghtId();
	
	
	public int getPriority();
	
	public void departFromGate(FlightRequestCommand invokeCommand);

}
