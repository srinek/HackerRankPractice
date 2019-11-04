package design.callcenter.impl;

import design.callcenter.Call;
import design.callcenter.CallStatus;

public class CallImpl implements Call{

	private int callPriority = 0;
	
	private CallStatus callStatus = CallStatus.NOT_STARTED;
	
	
	public CallImpl(){
		
	}
	
	@Override
	public int compareTo(Call o) {
		
		return this.getCallPriority() - o.getCallPriority();
	}

	@Override
	public String getCallId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCallPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCallPriority(int priority) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCallStatus(CallStatus status) {
		// TODO Auto-generated method stub
		
	}

}
