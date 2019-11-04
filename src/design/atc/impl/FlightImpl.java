package design.atc.impl;

import design.atc.Flight;
import design.atc.FlightRequestCommand;

public class FlightImpl implements Flight {

	public int flightId;
	
	public FlightImpl(int flightId){
		this.flightId = flightId;
	}
	
	@Override
	public int getFilghtId() {
		
		return this.flightId;
	}

	@Override
	public int getPriority() {
		return 0;
	}

	@Override
	public void departFromGate(FlightRequestCommand command) {
		
		System.out.println("( ATC -> Flight Request) (Flight" + command.getFlightNumber() +" departing to Runway "+ command.getRunway().getRunwayNumber()+")");
	}

}
