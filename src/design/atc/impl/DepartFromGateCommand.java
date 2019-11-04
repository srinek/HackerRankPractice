package design.atc.impl;

import design.atc.Flight;
import design.atc.FlightRequestCommand;
import design.atc.Gate;
import design.atc.Runway;
import design.atc.factory.FlightFactory;

public class DepartFromGateCommand  implements FlightRequestCommand{

	private Runway runway = null;
	
	private Gate gate = null;
	
	private int flightNumber = 0;
	
	public DepartFromGateCommand(int flightNumber, Runway runway, Gate gate){
		
		this.runway = runway;
		this.gate = gate;
		this.flightNumber = flightNumber;
	}
	
	@Override
	public void invoke() throws Exception {
		Flight flight = FlightFactory.getFlight(this.flightNumber);
		flight.departFromGate(this);
		
	}

	@Override
	public void undo() throws Exception {
		
		
	}

	@Override
	public Runway getRunway() {
		return this.runway;
	}

	@Override
	public Gate getGate() {
		return this.gate;
	}

	@Override
	public int getFlightNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

}
