package design.atc.factory;

import java.util.HashMap;
import java.util.Map;

import design.atc.Flight;
import design.atc.impl.FlightImpl;

public class FlightFactory {
	
	
	private static Map<Integer, Flight> flightsMap = new HashMap<>();
	
	public static Flight getFlight(int flightNumber){
		
		if(flightsMap.containsKey(flightNumber)){
			return flightsMap.get(flightNumber);
		}
		
		Flight flight = new FlightImpl(flightNumber);
		flightsMap.put(flightNumber, flight);
		
		return flight;
	}

}
