package design.atc;

import java.time.LocalDateTime;

public class AddFlightToScheduleCommand implements AirTrafficControllerCommand {

	private LocalDateTime gateDepartureTime; 
	private LocalDateTime takeoffTime;
	private int flightId = 0;
	
	public AddFlightToScheduleCommand(int flightId, LocalDateTime gateDepartureTime, LocalDateTime takeoffTime){
		
		this.gateDepartureTime = gateDepartureTime;
		this.takeoffTime = takeoffTime;
		this.flightId = flightId;
	}
	
	@Override
	public void invoke() throws Exception {
	

	}

	@Override
	public void undo() throws Exception {
	

	}

	@Override
	public LocalDateTime getGateDepartureTime() {
		
		return this.gateDepartureTime;
	}

	@Override
	public LocalDateTime getTakeOffTime() {
		return takeoffTime;
	}

	@Override
	public int getFlightNumber() {
		
		return this.flightId;
	}

}
