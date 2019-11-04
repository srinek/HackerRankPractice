package design.atc.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import design.atc.AirTrafficController;
import design.atc.AirTrafficControllerCommand;
import design.atc.Flight;
import design.atc.FlightRequestCommand;
import design.atc.FlightState;
import design.atc.factory.FlightFactory;

public class AirTrafficControllerImpl implements AirTrafficController {

	
	private Queue<Flight> requestedGateDepartureQueue = new PriorityQueue<>();
	
	private Map<Integer, FlightState> flightStateMap = new HashMap<>();
	
	private static AirTrafficController _INSTANCE = new AirTrafficControllerImpl();
	
	
	
	private AirTrafficControllerImpl(){
		
	}
	
	public static AirTrafficController getInstance(){
		return _INSTANCE;
	}
	
	@Override
	public boolean addFlightToSchedule(AirTrafficControllerCommand command) throws Exception {
		System.out.println("(SchedulerService -> ATC request) (Flight "+command.getFlightNumber() +" is added to schedule)");
		flightStateMap.put(command.getFlightNumber(), FlightState.FlightScheduledState);
		return true;
	}
	
	@Override
	public boolean requestGateDeparture(AirTrafficControllerCommand command) throws Exception{
		
		int flightNumber = command.getFlightNumber();
		 // exception is thrown if queue is full 
		if(!flightStateMap.containsKey(flightNumber)) {
			throw new Exception("Flight is not scheduled for departure");
		}
		FlightState existingStatte = flightStateMap.get(flightNumber);
		if(!existingStatte.isStateAllowed(FlightState.RequestGateDepartureState)){
			throw new Exception("Flight is not in statte to request gate departure");
		}
		Flight flight = FlightFactory.getFlight(flightNumber);
		System.out.println( "(Flight -> ATC request)  (flight "+ flightNumber +" is added to departure Queue)");
		requestedGateDepartureQueue.add(flight);
		flightStateMap.put(flight.getFilghtId(), FlightState.RequestGateDepartureState);
		return true;
	}

	@Override
	public boolean removeFlightFromSchedule(AirTrafficControllerCommand flight) throws Exception {
		return false;
	}

	@Override
	public boolean undoRequestGateDeparture(AirTrafficControllerCommand command) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void run() throws Exception {

		System.out.println( "waiting ... ");
		Thread.currentThread().sleep(5000); // pretend like waiting for other flights
		sendGateDepartureRequest();
	}

	
	private void sendGateDepartureRequest() throws Exception{
		
		// consider available runways 
		if(!isRunwayAvilable()){
			Thread.currentThread().sleep(1000);
		}
		
		Flight flight = requestedGateDepartureQueue.peek();  // don't remove from queue yet. wait for flight to confirm 
		flightStateMap.put(flight.getFilghtId(), FlightState.DEPART_FROM_GATE);
		FlightRequestCommand departFromGateRequestToFlight = new DepartFromGateCommand(flight.getFilghtId(), new StandardRunway(), new StandardGateImpl()); // use inversion of control
		departFromGateRequestToFlight.invoke();
		
	}
	
	private boolean isRunwayAvilable(){
		 // add runway availability logic based on other flight deparuture status
		return true;
	}

	@Override
	public void confirmDepartingFromGate(Flight flight) {
		
	 // remove from 
		
	}


	
	
	
	
	

}
