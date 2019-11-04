package design.atc;

import java.time.LocalDateTime;

public interface AirTrafficControllerCommand {
	
	public void invoke() throws Exception;
	
	public void undo()  throws Exception;
	
	public LocalDateTime getGateDepartureTime();
	
	public LocalDateTime getTakeOffTime();
		
	public int getFlightNumber();

}
