package design.atc;

public interface AirTrafficController {
	
	
	public boolean addFlightToSchedule(AirTrafficControllerCommand invokeCommand) throws Exception;
	
	public boolean removeFlightFromSchedule(AirTrafficControllerCommand undoCommand) throws Exception;
	
	public boolean requestGateDeparture(AirTrafficControllerCommand invokeCommand) throws Exception;
	
	public boolean undoRequestGateDeparture(AirTrafficControllerCommand undoCommand) throws Exception;
	
	public void run() throws Exception;
	
	public void confirmDepartingFromGate(Flight flight);
	
	
	

}
