package design.atc.test;

import design.atc.AddFlightToScheduleCommand;
import design.atc.AirTrafficController;
import design.atc.Flight;
import design.atc.factory.FlightFactory;
import design.atc.impl.AirTrafficControllerImpl;
import design.atc.impl.DepartFromGateCommand;
import design.atc.impl.RequestGateDepartureCommand;
import design.atc.impl.StandardGateImpl;
import design.atc.impl.StandardRunway;

public class AirTrafficControllerTest {
	
	
	public static void main(String[] args) throws Exception {
		
		AirTrafficController atc = AirTrafficControllerImpl.getInstance();
		// add flight to schedule from some scheduler service
		atc.addFlightToSchedule(new AddFlightToScheduleCommand(1, null, null));
		
		Flight flight = FlightFactory.getFlight(1);
		
		// when boarding is done request for gate departure
		atc.requestGateDeparture(new RequestGateDepartureCommand(1));
		
		// when runway is free , request flight to depart
		
		flight.departFromGate(new DepartFromGateCommand(1, new StandardRunway(), new StandardGateImpl()));
	}

}
