package design.atc.impl;

import java.time.LocalDateTime;

import design.atc.AirTrafficController;
import design.atc.AirTrafficControllerCommand;
import design.atc.Flight;
import design.atc.factory.FlightFactory;

public class RequestGateDepartureCommand implements AirTrafficControllerCommand {

	
	private AirTrafficController atc = AirTrafficControllerImpl.getInstance();
	
	private int flightNumber;
	
	public RequestGateDepartureCommand(int flightNumber){
		this.flightNumber = flightNumber;
	}
	
	@Override
	public void invoke()  throws Exception{
		
		atc.requestGateDeparture(this);

	}

	@Override
	public void undo()  throws Exception{
		atc.undoRequestGateDeparture(this);

	}

	@Override
	public LocalDateTime getGateDepartureTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDateTime getTakeOffTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFlightNumber() {
		
		return flightNumber;
	}

}
