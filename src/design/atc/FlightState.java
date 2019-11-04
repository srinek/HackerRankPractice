package design.atc;

public enum FlightState {
	
	FlightScheduledState {
		@Override
		public boolean isStateAllowed(FlightState requestedState) throws Exception {
			if(requestedState == RequestGateDepartureState){
				return true;
			}
			return false;
		}
	},
	RequestGateDepartureState {
		@Override
		public boolean isStateAllowed(FlightState requestedState) throws Exception {
			if(requestedState == DEPART_FROM_GATE){
				return true;
			}
			return false;
		}
	},
	DEPART_FROM_GATE {
		@Override
		public boolean isStateAllowed(FlightState requestedState) throws Exception {
			
			return false;
		}
	};
	
	public abstract boolean isStateAllowed(FlightState requestedState) throws Exception;

}
