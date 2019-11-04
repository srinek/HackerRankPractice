package design.callcenter;

public interface Call extends Comparable<Call>{
	
	public String getCallId();
	
	public int getCallPriority();
	
	public void setCallPriority(int priority);
	
	public void setCallStatus(CallStatus status);

}
